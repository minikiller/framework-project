package cn.com.rexen.admin.core;

import cn.com.rexen.admin.api.biz.IAboutBeanService;
import cn.com.rexen.admin.api.dao.IAboutBeanDao;
import cn.com.rexen.admin.entities.AboutBean;
import cn.com.rexen.core.impl.biz.GenericBizServiceImpl;

/**
 * 项目名称:  urgent-project
 * 类描述:    系统版本服务实现类
 * 创建人:    sunlf
 * 创建时间:  2014/8/7 16:02
 * 修改人:    sunlf
 * 修改时间:  2014/8/7 16:02
 * 修改备注:  [说明本次修改内容]
 */
public class AboutBeanServiceImpl extends GenericBizServiceImpl implements IAboutBeanService {

    private IAboutBeanDao aboutBeanDao;

    public void setAboutBeanDao(IAboutBeanDao aboutBeanDao) {
        this.aboutBeanDao = aboutBeanDao;
        super.init(aboutBeanDao, AboutBean.class.getName());
    }

    @Override
    public AboutBean getSysInfo() {
        return null;
    }

}
