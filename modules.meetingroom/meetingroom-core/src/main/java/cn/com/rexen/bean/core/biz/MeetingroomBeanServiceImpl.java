package cn.com.rexen.bean.core.biz;

import cn.com.rexen.bean.api.biz.IMeetingroomBeanService;
import cn.com.rexen.bean.api.dao.IMeetingroomBeanDao;
import cn.com.rexen.bean.entities.MeetingroomBean;
import cn.com.rexen.core.api.biz.JsonStatus;
import cn.com.rexen.core.impl.biz.ShiroGenericBizServiceImpl;

/**
 * @类描述：
 * @创建人：
 * @创建时间：
 * @修改人：
 * @修改时间：
 * @修改备注：
 */
public class MeetingroomBeanServiceImpl extends ShiroGenericBizServiceImpl<IMeetingroomBeanDao, MeetingroomBean> implements IMeetingroomBeanService {
    private JsonStatus jsonStatus = new JsonStatus();

    public MeetingroomBeanServiceImpl() {
        super.init(MeetingroomBean.class.getName());
    }
}
