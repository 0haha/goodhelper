package ghpackage;

import java.util.List;

import ghInterface.customerDao;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class customerDaoImpl extends HibernateDaoSupport implements customerDao{
  public customer get(Integer id){
	  return getHibernateTemplate().get(customer.class, id);
  }
  public Integer save(customer customer){
	  return (Integer)getHibernateTemplate().save(customer);
  }
  public void update(customer customer){
	  getHibernateTemplate().update(customer);
  }
  public void delete(customer customer){
	  getHibernateTemplate().delete(customer);
  }
  public void delete(Integer id){
	  getHibernateTemplate().delete(get(id));
  }
  public List<customer> findAll(){
	  return (List<customer>)getHibernateTemplate().find("from customer");
  }
}
