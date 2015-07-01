package cn.com.rexen.admin.core;

import cn.com.rexen.admin.api.biz.IDictBeanService;
import cn.com.rexen.admin.api.dao.IDictBeanDao;
import cn.com.rexen.admin.entities.DictBean;
import cn.com.rexen.core.impl.biz.GenericBizServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @类描述：字典服务实现类
 * @创建人：sunlf
 * @创建时间：2014-05-14 下午1:59
 * @修改人：
 * @修改时间：
 * @修改备注：
 */

public class DictBeanServiceImpl extends GenericBizServiceImpl implements IDictBeanService {
    private IDictBeanDao dictBeanDao;

    @Override
    public HashMap getExpertGroupListData(HttpServletRequest request, HttpServletResponse response) {
        boolean success = false;
        int count = 0;
        HashMap resultmap = new HashMap();
        List<DictBean> dictBeanList;
        String name = request.getParameter("name");
        if (name != null) {
            dictBeanList = getLikeExpertGroupByName(name);
        } else {
            dictBeanList = getExpertGroupList();
        }
        if (dictBeanList != null) {
            success = true;
            count = dictBeanList.size();
        }
        resultmap.put("success", success);
        resultmap.put("data", dictBeanList != null ? dictBeanList : "");
        resultmap.put("TotoRecord", count);
        return resultmap;
    }

    public void setDictBeanDao(IDictBeanDao dictBeanDao) {
        this.dictBeanDao = dictBeanDao;
        super.init(dictBeanDao, DictBean.class.getName());
    }

    @Override
    public List<DictBean> getDictList(String type) {
        return dictBeanDao.getDictList(type);
    }

    @Override
    public Map<String, String> getDictMap(String type) {
        List<DictBean> dictBeanList = getDictList(type);
        Map map = new HashMap();
        if (dictBeanList.size() > 0) {
            for (DictBean dictBean : dictBeanList)
                map.put(dictBean.getValue(), dictBean.getLabel());
        }
        return map;
    }

    @Override
    public List<DictBean> query(DictBean dictBean) {
        return dictBeanDao.find("select a from DictBean a where a.type like ?1", "%" + dictBean.getType() + "%");
    }

    @Override
    public List<DictBean> getExpertGroupList() {
        return dictBeanDao.find("select t from DictBean t where t.type=?1", "EXPERT_TYPE");
    }

    public List<DictBean> getLikeExpertGroupByName(String name) {
        return dictBeanDao.find("select t from DictBean t where t.type=?1 and t.label like ?2", "EXPERT_TYPE", "%" + name + "%");
    }
}
