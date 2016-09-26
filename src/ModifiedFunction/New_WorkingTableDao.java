package ModifiedFunction;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class New_WorkingTableDao extends HibernateDaoSupport{
	public New_WorkingTable get(Integer id) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().get(New_WorkingTable.class, id);
	}

	
	public Integer save(New_WorkingTable New_WorkingTable) {
		// TODO Auto-generated method stub
		return (Integer)getHibernateTemplate().save(New_WorkingTable);
	}

	
	public void update(New_WorkingTable New_WorkingTable) {
		// TODO Auto-generated method stub
        getHibernateTemplate().update(New_WorkingTable);
	}

	
	public void delete(New_WorkingTable New_WorkingTable) {
		// TODO Auto-generated method stub
        getHibernateTemplate().delete(New_WorkingTable);
	}

	
	public void delete(Integer id) {
		// TODO Auto-generated method stub
        getHibernateTemplate().delete(get(id));
	}

	
	public List<New_WorkingTable> findAll() {
		// TODO Auto-generated method stub
		return (List<New_WorkingTable>)getHibernateTemplate().find("from New_WorkingTable");
	}
	public List<New_WorkingTable> findByUsrId(String usrId){
		return (List<New_WorkingTable>)getHibernateTemplate().find("from New_WorkingTable w where w.usrId=?",usrId);
	}
}
