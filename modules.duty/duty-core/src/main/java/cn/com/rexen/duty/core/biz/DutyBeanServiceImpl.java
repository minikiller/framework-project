package cn.com.rexen.duty.core.biz;

import cn.com.rexen.duty.api.biz.IDutyBeanService;
import cn.com.rexen.duty.api.dao.IDutyBeanDao;
import cn.com.rexen.duty.entities.DutyBean;
import cn.com.rexen.core.api.biz.JsonStatus;
import cn.com.rexen.core.impl.biz.GenericBizServiceImpl;

import java.util.List;

/**
 * @类描述： 
 * @创建人：  
 * @创建时间： 
 * @修改人：
 * @修改时间：
 * @修改备注：
 */
public class DutyBeanServiceImpl extends GenericBizServiceImpl<IDutyBeanDao, DutyBean> implements IDutyBeanService {
    private JsonStatus jsonStatus = new JsonStatus();

    public DutyBeanServiceImpl() {
        super.init(DutyBean.class.getName());
    }
}
