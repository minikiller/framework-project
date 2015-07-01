package cn.com.rexen.admin.core;

import com.daren.admin.api.biz.IAreaBeanService;
import com.daren.admin.api.dao.IAboutBeanDao;
import com.daren.admin.api.dao.IAreaBeanDao;
import com.daren.admin.entities.AboutBean;
import com.daren.admin.entities.AreaBean;
import com.daren.core.impl.biz.GenericBizServiceImpl;

import java.util.List;

/**
 * 项目名称:  urgent-project
 * 类描述:    区域服务实现类
 * 创建人:    sunlf
 * 创建时间:  2014/8/7 16:02
 * 修改人:    sunlf
 * 修改时间:  2014/8/7 16:02
 * 修改备注:  [说明本次修改内容]
 */
public class AreaBeanServiceImpl extends GenericBizServiceImpl implements IAreaBeanService {

    private IAreaBeanDao areaBeanDao;
    private IAboutBeanDao aboutBeanDao;

    public void setAreaBeanDao(IAreaBeanDao dictBeanDao) {
        this.areaBeanDao = dictBeanDao;
        super.init(dictBeanDao, AreaBean.class.getName());
    }

    public void setAboutBeanDao(IAboutBeanDao aboutBeanDao) {
        this.aboutBeanDao = aboutBeanDao;
    }

    @Override
    public List<AreaBean> query(AreaBean areaBean) {
        return areaBeanDao.find("select a from AreaBean a where a.name like ?1", "%" + areaBean.getName() + "%");
    }

    @Override
    public List<AreaBean> getRootBeanList() {
        return areaBeanDao.find("select u from AreaBean u where u.parent is null");
    }

    @Override
    public List<AreaBean> getRootBeanListByQhdm() {
        AboutBean aboutBean = aboutBeanDao.get(AboutBean.class.getName(), 1L);
        String qhdm = "";
        if (aboutBean != null) {
            qhdm = aboutBean.getXzqh_dm();
        }
        return areaBeanDao.find("select u from AreaBean u where u.code = ?1", qhdm);
    }

    @Override
    public List<AreaBean> getChildBeanList(AreaBean node) {
        return areaBeanDao.find("select u from AreaBean u where u.parent= ?1", node);
    }
}
