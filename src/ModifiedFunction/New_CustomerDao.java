package ModifiedFunction;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;



public class New_CustomerDao extends HibernateDaoSupport{
	public New_Customer get(Integer id) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().get(New_Customer.class, id);
	}

	
	public Integer save(New_Customer New_Customer) {
		// TODO Auto-generated method stub
		return (Integer)getHibernateTemplate().save(New_Customer);
	}

	
	public void update(New_Customer New_Customer) {
		// TODO Auto-generated method stub
        getHibernateTemplate().update(New_Customer);
	}

	
	public void delete(New_Customer New_Customer) {
		// TODO Auto-generated method stub
        getHibernateTemplate().delete(New_Customer);
	}

	
	public void delete(Integer id) {
		// TODO Auto-generated method stub
        getHibernateTemplate().delete(get(id));
	}

	
	public List<New_Customer> findAll() {
		// TODO Auto-generated method stub
		return (List<New_Customer>)getHibernateTemplate().find("from New_Customer");
	}

	
}
