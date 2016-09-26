package ModifiedFunction;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class NewTableFactoryTest {
    private NewTableFactory NewTableFactory;
    private New_CustomerDao New_customerDao;
    private New_WorkingTableDao  New_WorkingTableDao;
    private New_Result_WorkingTable New_Result_WorkingTable;
	@Before
	public void setUp() throws Exception {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("bean.xml");
		NewTableFactory=ctx.getBean(NewTableFactory.class);
		New_customerDao=ctx.getBean(New_CustomerDao.class);
		New_WorkingTableDao=ctx.getBean(New_WorkingTableDao.class);
	}

	@Test
	public void testProductResultTables() {
		List<New_Result_WorkingTable> New_Result_WorkingTables=new ArrayList<New_Result_WorkingTable>();
		New_Result_WorkingTables=NewTableFactory.productResultTables(New_WorkingTableDao.findByUsrId("201430620121"));
	    System.out.println(New_Result_WorkingTables.get(0).getNamesToken());
		assertEquals("lala",New_Result_WorkingTables.get(0).getNamesToken());
	} 

	@Test
	public void testGetTable() {
		
	}

	@Test
	public void testGetTime() {
		
	}

	@Test
	public void testSortCustomer() {
		
	}

	@Test
	public void testSortBlock() {
		
	}

	@Test
	public void testSetCforCustomer() {
		
	}

	@Test
	public void testGetRusultName() {
		
	}

}
