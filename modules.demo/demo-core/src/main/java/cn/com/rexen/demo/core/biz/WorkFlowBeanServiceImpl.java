package cn.com.rexen.demo.core.biz;

import cn.com.rexen.core.api.persistence.JsonData;
import cn.com.rexen.core.api.persistence.PersistentEntity;
import cn.com.rexen.core.impl.biz.ShiroGenericBizServiceImpl;
import cn.com.rexen.demo.api.biz.IWorkFlowBeanService;
import cn.com.rexen.demo.api.dao.IWorkFlowBeanDao;
import cn.com.rexen.demo.entities.WorkFlowBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenyanxu
 */
public class WorkFlowBeanServiceImpl extends ShiroGenericBizServiceImpl<IWorkFlowBeanDao, WorkFlowBean> implements IWorkFlowBeanService {
    @Override
    public List<WorkFlowBean> getCategories() {
        List<WorkFlowBean> dicts = dao.findByNativeSql("select value as id,label as title from sys_dict where type='workflow_category'", WorkFlowBean.class, null);
        List<WorkFlowBean> flows = dao.findByNativeSql("select b.value as id,b.label as title,count(*) as cnt from act_re_procdef a, sys_dict b where a.category_ like '%/'||b.value and b.type = 'workflow_category' group by id,title order by cnt desc", WorkFlowBean.class, null);

        List<WorkFlowBean> persistentEntities = new ArrayList<WorkFlowBean>();
        if (flows != null && flows.size() > 0) {
            for (WorkFlowBean flow : flows) {
                if (flow != null) {
                    persistentEntities.add(flow);
                }
            }
        }
        if (dicts != null && dicts.size() > 0) {
            for (WorkFlowBean dict : dicts) {
                boolean find = false;
                if (dict != null) {
                    if (flows != null && flows.size() > 0) {
                        for (WorkFlowBean flow : flows) {
                            if (dict.getId() == flow.getId()) {
                                find = true;
                                break;
                            }
                        }
                    }
                }
                if (!find) {
                    persistentEntities.add(dict);
                }
            }
        }

        return persistentEntities;
    }

    @Override
    public JsonData getAllWorkFlow(String category) {
        JsonData jsonData = new JsonData();
        List<WorkFlowBean> flows = dao.findByNativeSql("select b.id_ as id,a.category_ as category, a.name_ as title," +
                " 3 as imgurl,a.description_ as description, 5 as flowurl from act_re_procdef a, act_ge_bytearray b " +
                "where a.version_ = b.rev_ and a.resource_name_ = b.name_ and a.category_ like '%/" + category + "'", WorkFlowBean.class, null);
        List<PersistentEntity> persistentEntities = new ArrayList<PersistentEntity>();
        if (flows != null && flows.size() > 0) {
            for (WorkFlowBean flow : flows) {
                if (flow != null) {
                    //String category_ = flow.getCategory();
                    //if(category_.substring(category_.lastIndexOf('/')+1,category_.length()).equals(category)) {
                    //flow.setImgurl("https://d1ldz4te4covpm.cloudfront.net/sites/default/files/imagecache/ppv4_main_book_cover/5443EXP_Sencha%20Touch%20Cookbook.jpg");
                    if (flow.getTitle().indexOf("车") >= 0) {
                        flow.setImgurl("http://127.0.0.1:5984/kalix/b0fc35d8f06c44b89b1ac85029c30354/3.png");
                    } else if (flow.getTitle().indexOf("章") >= 0) {
                        flow.setImgurl("http://127.0.0.1:5984/kalix/b2343925712740119a4feb80c401ed6b/1.png");
                    } else if (flow.getTitle().indexOf("会议") >= 0) {
                        flow.setImgurl("http://127.0.0.1:5984/kalix/d76b7da0979b4816917bf9bd36e7f007/2.png");
                    } else {
                        flow.setImgurl("https://d1ldz4te4covpm.cloudfront.net/sites/default/files/imagecache/ppv4_main_book_cover/5443EXP_Sencha%20Touch%20Cookbook.jpg");
                    }
                    persistentEntities.add(flow);
                    //}
                }
            }
        } else {
            WorkFlowBean workFlowBean = new WorkFlowBean();
            workFlowBean.setId(1);
            workFlowBean.setTitle("暂无数据");
            workFlowBean.setDescription("还没有定义工作流。");
            workFlowBean.setImgurl("https://d1ldz4te4covpm.cloudfront.net/sites/default/files/imagecache/ppv4_main_book_cover/5443EXP_Sencha%20Touch%20Cookbook.jpg");

            persistentEntities.add(workFlowBean);
        }
        jsonData.setData(persistentEntities);
        jsonData.setTotalCount((long) flows.size());
        return jsonData;
    }
}
