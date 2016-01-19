package cn.com.rexen.bean.core.biz;

import cn.com.rexen.bean.api.biz.IStudentBeanService;
import cn.com.rexen.bean.api.dao.IStudentBeanDao;
import cn.com.rexen.bean.entities.StudentBean;
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
public class StudentBeanServiceImpl extends GenericBizServiceImpl<IStudentBeanDao, StudentBean> implements IStudentBeanService {
    private JsonStatus jsonStatus = new JsonStatus();

    public StudentBeanServiceImpl() {
        super.init(StudentBean.class.getName());
    }
}
