package cn.com.rexen.admin.core;

import cn.com.rexen.admin.api.biz.IOfficeBeanService;
import cn.com.rexen.admin.api.dao.IOfficeBeanDao;
import cn.com.rexen.admin.entities.OfficeBean;
import cn.com.rexen.core.impl.biz.GenericBizServiceImpl;

/**
 * @类描述：机构服务实现类
 * @创建人：sunlf
 * @创建时间：2014-05-14 下午1:59
 * @修改人：
 * @修改时间：
 * @修改备注：
 */

public class OfficeBeanServiceImpl extends GenericBizServiceImpl implements IOfficeBeanService {
    private IOfficeBeanDao officeBeanDao;

    public void setOfficeBeanDao(IOfficeBeanDao officeBeanDao) {
        this.officeBeanDao = officeBeanDao;
        super.init(officeBeanDao, OfficeBean.class.getName());
    }
}
