package ghpackage;

import java.util.List;

import ghInterface.workingTableDao;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class workingTableDaoImpl extends HibernateDaoSupport implements workingTableDao{
  public workingTable get(Integer id){
	  return getHibernateTemplate().get(workingTable.class, id);
  }
  public Integer save(workingTable workingTable){
	  return (Integer)getHibernateTemplate().save(workingTable);
  }
  public void update(workingTable workingTable){
	  getHibernateTemplate().update(workingTable);
  }
  public void delete(workingTable workingTable){
	  getHibernateTemplate().delete(workingTable);
  }
  public void delete(Integer id){
	  getHibernateTemplate().delete(get(id));
  }
  public List<workingTable> findAll(){
	  return (List<workingTable>)getHibernateTemplate().find("from workingTable");
  }
  public List<workingTable> findByUsrname(String usrname){
	  return (List<workingTable>)getHibernateTemplate().find("from workingTable as i where i.usrId=?",usrname);
  }
}