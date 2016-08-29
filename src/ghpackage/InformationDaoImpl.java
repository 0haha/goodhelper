package ghpackage;

import ghInterface.InformationDao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;





public class InformationDaoImpl extends HibernateDaoSupport implements InformationDao{
	public Information get(Integer id){
		return getHibernateTemplate().get(Information.class, id);
	}
	  public  Integer save(Information information){
		 return  (Integer)getHibernateTemplate().save(information);
	  }
	  public void update(Information information){
		  getHibernateTemplate().update(information);
	  }
	  public void delete(Information information){
		  getHibernateTemplate().delete(information);
	  }
	  public void delete(Integer id){
		  getHibernateTemplate().delete(get(id));
	  }
	  public List<Information> findAll(){
		  return (List<Information>)getHibernateTemplate().find("from Information");
	  }
	  public List<Information> findByUsrname(String usrname){
		  return (List<Information>)getHibernateTemplate().find("from Information as i where i.usrID=?",usrname);
	  }
}

