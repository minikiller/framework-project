package cn.com.rexen.couchdb.api.biz;

import cn.com.rexen.core.api.biz.IBizService;
import cn.com.rexen.couchdb.entities.CouchdbAttachBean;
import org.apache.commons.fileupload.FileItem;

import java.io.InputStream;
import java.util.List;

/**
 * @类描述：主表和附件关联couchdb业务服务接口类
 * @创建人：xukexin
 * @创建时间：2014/10/29
 * @修改人：
 * @修改时间：
 * @修改备注：
 */
public interface ICouchdbAttachBeanService extends IBizService {

    /**
     * 保存附件
     *
     * @return
     */
    public long saveAttach(long mainId, FileItem fileItem);

    /**
     * 删除附件
     *
     * @return
     */
    public void deleteAttach(long id);

    /**
     * 获取附件文件地址
     */
    public String getAttachUrl(long mainId);

    /**
     * 根据主表id获取关联对象集合
     *
     * @param mainId
     * @return
     */
    public List<CouchdbAttachBean> getEntityByMainId(long mainId);

    /**
     * 根据主键id获取唯一的对象
     *
     * @param mainId
     * @return
     */
    public CouchdbAttachBean getUniqueEntityByMainId(long mainId);

    /**
     * 保存生成的资源excel
     *
     * @return
     */
    public String saveExcelToCouchdb(String name, InputStream is);

}
