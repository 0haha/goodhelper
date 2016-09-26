package ModifiedFunction;

import static org.junit.Assert.*;

import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class New_WorkingTableDaoTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testSave() {
		ApplicationContext ctx= new ClassPathXmlApplicationContext("bean.xml");
		 New_WorkingTableDao New_workingTableDao=ctx.getBean(New_WorkingTableDao.class);
		//Here don't forget to get back the session ablout the usename
		// ActionContext ctx2=ActionContext.getContext();
		
		// String UsrIdTmp=(String) ctx2.getSession().get("username");
		 
		 String UsrIdTmp="201430620121";
		 New_WorkingTable New_WorkingTable=new New_WorkingTable();
		 New_WorkingTable.setColumn(1);
		 New_WorkingTable.setRow(1);
		 New_WorkingTable.setLimitNumOfBlock(1);
		 New_WorkingTable.setNameOfWorkingTable("gg");
		 New_WorkingTable.setDates("aa");
		 New_WorkingTable.setTimes("bb");
		 New_WorkingTable.setUsrId("2");
		 String tempWokingTableId=String.valueOf(New_workingTableDao.save(New_WorkingTable));
		 assertEquals(17, tempWokingTableId);
	}
	@Test
	public void testFindByUsrId(){
		 ApplicationContext ctx= new ClassPathXmlApplicationContext("bean.xml");
		 New_WorkingTableDao New_workingTableDao=ctx.getBean(New_WorkingTableDao.class);
		 List<New_WorkingTable> lists=New_workingTableDao.findByUsrId("201430620121");
		 assertEquals(3,lists.size());
	}

}
