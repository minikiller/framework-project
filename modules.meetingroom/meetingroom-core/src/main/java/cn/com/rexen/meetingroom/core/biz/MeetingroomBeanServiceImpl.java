package cn.com.rexen.meetingroom.core.biz;

import cn.com.rexen.core.api.biz.JsonStatus;
import cn.com.rexen.core.impl.biz.ShiroGenericBizServiceImpl;
import cn.com.rexen.meetingroom.api.biz.IMeetingroomBeanService;
import cn.com.rexen.meetingroom.api.dao.IMeetingroomBeanDao;
import cn.com.rexen.meetingroom.entities.MeetingroomBean;

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
