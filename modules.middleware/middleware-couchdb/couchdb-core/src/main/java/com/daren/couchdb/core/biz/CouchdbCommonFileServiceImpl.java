package cn.com.rexen.couchdb.core.biz;

import cn.com.rexen.common.api.ICommonFileService;
import cn.com.rexen.common.api.model.FileBean;
import cn.com.rexen.core.api.IConst;
import cn.com.rexen.couchdb.api.biz.ICouchdbAttachBeanService;
import cn.com.rexen.couchdb.entities.CouchdbAttachBean;
import org.apache.wicket.markup.html.form.upload.FileUpload;
import org.apache.wicket.util.file.Files;

import java.io.DataInputStream;
import java.io.File;
import java.io.InputStream;
import java.net.URL;

/**
 * Created by xukexin on 2014/12/17.
 */
public class CouchdbCommonFileServiceImpl implements ICommonFileService {

    private ICouchdbAttachBeanService couchdbAttachBeanService;

    public void setCouchdbAttachBeanService(ICouchdbAttachBeanService couchdbAttachBeanService) {
        this.couchdbAttachBeanService = couchdbAttachBeanService;
    }

    @Override
    public String getFileUrl(long id) {
        String url = couchdbAttachBeanService.getAttachUrl(id);
        try {
            File tempFile = new File(IConst.OFFICE_WEB_PATH_TEMP + System.currentTimeMillis() + url.substring(url.lastIndexOf("."), url.length()));
            URL newUrl = new URL(url);
            InputStream is = newUrl.openStream();
            DataInputStream data = new DataInputStream(is);
            Files.writeTo(tempFile, data);
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return url;
    }

    @Override
    public long saveAttach(long id, FileUpload fileUpload) {
        return couchdbAttachBeanService.saveAttach(id, fileUpload);
    }

    @Override
    public FileBean getFileInfo(long id) {
        CouchdbAttachBean couchdbAttachBean = couchdbAttachBeanService.getUniqueEntityByMainId(id);
        FileBean fileBean = new FileBean();
        if (couchdbAttachBean != null) {
            fileBean.setName(couchdbAttachBean.getAttachName());
            fileBean.setDescription("");
            fileBean.setFilePath(couchdbAttachBeanService.getAttachUrl(id));
        } else {
            fileBean = null;
        }
        return fileBean;
    }

    @Override
    public FileBean getReserveFileInfo(long id) {
        CouchdbAttachBean couchdbAttachBean = (CouchdbAttachBean) couchdbAttachBeanService.getUniqueEntityByMainId(id);
        FileBean fileBean = new FileBean();
        if (couchdbAttachBean != null) {
            fileBean.setName(couchdbAttachBean.getAttachName());
            fileBean.setDescription("");
            fileBean.setFilePath(couchdbAttachBeanService.getAttachUrl(id));
        } else {
            fileBean = null;
        }
        return fileBean;
    }

    @Override
    public String geneExcelFile(InputStream is) {
        String otherName = System.currentTimeMillis() + ".xls";
        //注意：获取内容转换成字符串的时候，必须用这种方式
        return couchdbAttachBeanService.saveExcelToCouchdb(otherName, is);
    }

}
