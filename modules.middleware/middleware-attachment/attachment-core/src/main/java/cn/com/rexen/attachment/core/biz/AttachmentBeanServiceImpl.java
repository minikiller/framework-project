package cn.com.rexen.attachment.core.biz;

import cn.com.rexen.core.security.impl.ShiroGenericBizServiceImpl;
import cn.com.rexen.attachment.api.biz.IAttachmentBeanService;
import cn.com.rexen.attachment.api.dao.IAttachmentBeanDao;
import cn.com.rexen.attachment.entities.AttachmentBean;

/**
 * Created by lenovo on 2015/11/23.
 */
public class AttachmentBeanServiceImpl extends ShiroGenericBizServiceImpl<IAttachmentBeanDao, AttachmentBean> implements IAttachmentBeanService {
    public AttachmentBeanServiceImpl() {
        super.init(AttachmentBean.class.getName());
    }
}
