package <packageName>.dao;

import <packageName>.api.dao.I<beanName>BeanDao;
import <packageName>.entities.<beanName>Bean;
import cn.com.rexen.core.impl.persistence.GenericDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
/**
 * @类描述：
 * @创建人：
 * @创建时间：
 * @修改人：
 * @修改时间：
 * @修改备注：
 */
public class <beanName>BeanDaoImpl extends GenericDao\<<beanName>Bean, Long> implements I<beanName>BeanDao {
    @Override
    @PersistenceContext(unitName = "<pomName>-cm")
    public void setEntityManager(EntityManager em) {
        super.setEntityManager(em);
    }
    //todo add custom query 
    @Override
        public CriteriaQuery buildCriteriaQuery(QueryDTO queryDTO) {
            <beanName>DTO <pomName>Dto = (<beanName>DTO) queryDTO;
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery\<<beanName>Bean> criteriaQuery = criteriaBuilder.createQuery(<beanName>Bean.class);
            Root\<<beanName>Bean> from = criteriaQuery.from(<beanName>Bean.class);
            EntityType\<<beanName>Bean> bean_ = from.getModel(); //实体元数据
            List<Predicate> predicatesList = new ArrayList<Predicate>();
    
            if (<pomName>Dto.getName() != null && !<pomName>Dto.getName().trim().isEmpty()) {
                SingularAttribute<<beanName>Bean, String> name = (SingularAttribute<<beanName>Bean, String>) bean_.getSingularAttribute("name");
                predicatesList.add(criteriaBuilder.like(from.get(name), "%" + <pomName>Dto.getName() + "%"));
            }
            criteriaQuery.where(predicatesList.toArray(new Predicate[predicatesList.size()]));
            CriteriaQuery select = criteriaQuery.select(from);
            return select;
        }
}
