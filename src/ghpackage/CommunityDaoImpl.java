package ghpackage;

import java.util.List;

import ghInterface.CommunityDao;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class CommunityDaoImpl extends HibernateDaoSupport implements CommunityDao{
	public community get(Integer id){
		return getHibernateTemplate().get(community.class, id);
	}
	  public  Integer save(community community){
		 return  (Integer)getHibernateTemplate().save(community);
	  }
	  public void update(community community){
		  getHibernateTemplate().update(community);
	  }
	  public void delete(community community){
		  getHibernateTemplate().delete(community);
	  }
	  public void delete(Integer id){
		  getHibernateTemplate().delete(get(id));
	  }
	  public List<community> findAll(){
		  return (List<community>)getHibernateTemplate().find("from community");
	  }
}
