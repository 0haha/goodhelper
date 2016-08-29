package ghpackage;

import java.util.List;

import ghInterface.blockDao;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class blockDaoImpl extends HibernateDaoSupport implements blockDao{
  public block get(Integer id){
	  return getHibernateTemplate().get(block.class, id);
  }
  public Integer save(block block){
	  return (Integer)getHibernateTemplate().save(block);
  }
  public void update(block block){
	  getHibernateTemplate().update(block);
  }
  public void delete(block block){
	  getHibernateTemplate().delete(block);
  }
  public void delete(Integer id){
	  getHibernateTemplate().delete(get(id));
  }
  public List<block> findAll(){
	  return (List<block>)getHibernateTemplate().find("from block");
  }
}
