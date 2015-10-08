package cn.com.rexen.couchdb.core.biz;

import cn.com.rexen.core.impl.biz.GenericBizServiceImpl;
import cn.com.rexen.core.util.ConfigUtil;
import cn.com.rexen.couchdb.api.biz.ICouchdbAttachBeanService;
import cn.com.rexen.couchdb.api.biz.ICouchdbService;
import cn.com.rexen.couchdb.api.dao.ICouchdbAttachBeanDao;
import cn.com.rexen.couchdb.entities.CouchdbAttachBean;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.fileupload.FileItem;
import org.lightcouch.Response;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * @类描述：主表和附件关联couchdb业务服务实现类
 * @创建人：xukexin
 * @创建时间：2014/9/10
 * @修改人：
 * @修改时间：
 * @修改备注：
 */
public class CouchdbAttachBeanServiceImpl extends GenericBizServiceImpl implements ICouchdbAttachBeanService {

    private ICouchdbAttachBeanDao couchdbAttachBeanDao;
    private ICouchdbService couchdbService;

    private String couchdb_url = (String) ConfigUtil.getConfigProp("COUCHDB_URL", "CouchDBConfig");

    public CouchdbAttachBeanServiceImpl() {
        /*try {
            couchdbService = JNDIHelper.getJNDIServiceForName(ICouchdbService.class.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }

    public void setCouchdbAttachBeanDao(ICouchdbAttachBeanDao couchdbAttachBeanDao) {
        this.couchdbAttachBeanDao = couchdbAttachBeanDao;
        super.init(couchdbAttachBeanDao, CouchdbAttachBean.class.getName());
    }

    public void setCouchdbService(ICouchdbService couchdbService) {
        this.couchdbService = couchdbService;
    }

    @Override
    public long saveAttach(long mainId, FileItem fileItem) {
        if (fileItem != null) {
            CouchdbAttachBean couchdbAttachBean = getUniqueEntityByMainId(mainId); //new CouchdbAttachBean();
            try {
                String fileName = fileItem.getName();
                String otherName = System.currentTimeMillis() + System.currentTimeMillis() +
                        fileName.substring(fileName.lastIndexOf("."), fileName.length());
                //注意：获取内容转换成字符串的时候，必须用这种方式
                Response response = couchdbService.addAttachment(Base64.encodeBase64String(fileItem.get()),
                        otherName, fileItem.getContentType());
                couchdbAttachBean.setAttachName(fileName);
                couchdbAttachBean.setAttachPath(response.getId() + "/" + fileItem.getName());
                couchdbAttachBean.setAttachSize(fileItem.getSize());
                couchdbAttachBean.setAttachType(fileItem.getContentType());
                couchdbAttachBean.setCouchdbAttachId(response.getId());
                couchdbAttachBean.setCouchdbAttachRev(response.getRev());
                couchdbAttachBean.setMainId(mainId);
                couchdbAttachBean.setOtherName(otherName);
                couchdbAttachBean = couchdbAttachBeanDao.save(couchdbAttachBean);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return couchdbAttachBean.getId();
        } else {
            return 0l;
        }
    }

    @Override
    public void deleteAttach(long id) {
        CouchdbAttachBean couchdbAttachBean = couchdbAttachBeanDao.get(CouchdbAttachBean.class.getName(), id);
        String couchdbAttachId = couchdbAttachBean.getCouchdbAttachId();
        if (couchdbAttachId != null && !"".equals(couchdbAttachId) && !"0".equals(couchdbAttachId)) {
            couchdbService.deleteAttach(couchdbAttachBean);
        }
        couchdbAttachBeanDao.remove(CouchdbAttachBean.class.getName(), id);
    }

    @Override
    public String getAttachUrl(long mainId) {
        CouchdbAttachBean couchdbAttachBean = getUniqueEntityByMainId(mainId);
        return couchdb_url + couchdbAttachBean.getCouchdbAttachId() + "/" + couchdbAttachBean.getOtherName();
    }


    @Override
    public List<CouchdbAttachBean> getEntityByMainId(long mainId) {
        return couchdbAttachBeanDao.find("select t from CouchdbAttachBean t where t.mainId=?1 order by t.creationDate desc", mainId);
    }

    @Override
    public CouchdbAttachBean getUniqueEntityByMainId(long mainId) {
        CouchdbAttachBean couchdbAttachBean = new CouchdbAttachBean();
        if (getEntityByMainId(mainId) != null && getEntityByMainId(mainId).size() > 0) {
            couchdbAttachBean = getEntityByMainId(mainId).get(0);
        }
        return couchdbAttachBean;
    }

    @Override
    public String saveExcelToCouchdb(String name, InputStream is) {
        Response response = new Response();
        try {
            response = couchdbService.addAttachment(Base64.encodeBase64String(getBytes(is)),
                    name, "xls");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return couchdb_url + response.getId() + "/" + name;
    }

    private byte[] getBytes(InputStream is) throws Exception {
        byte[] data = null;
        Collection chunks = new ArrayList();
        byte[] buffer = new byte[1024 * 1000];
        int read = -1;
        int size = 0;
        while ((read = is.read(buffer)) != -1) {
            if (read > 0) {
                byte[] chunk = new byte[read];
                System.arraycopy(buffer, 0, chunk, 0, read);
                chunks.add(chunk);
                size += chunk.length;
            }
        }
        if (size > 0) {
            ByteArrayOutputStream bos = null;
            try {
                bos = new ByteArrayOutputStream(size);
                for (Iterator itr = chunks.iterator(); itr.hasNext(); ) {
                    byte[] chunk = (byte[]) itr.next();
                    bos.write(chunk);
                }
                data = bos.toByteArray();
            } finally {
                if (bos != null) {
                    bos.close();
                }
            }
        }
        return data;
    }
}
