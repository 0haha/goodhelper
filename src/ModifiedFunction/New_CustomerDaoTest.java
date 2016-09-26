package ModifiedFunction;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class New_CustomerDaoTest {

	@Before
	public void setUp() throws Exception {
		
		
	}

	@Test
	public void testFindByWorkingTableId() {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("bean.xml");
		New_CustomerDao New_CustomerDao=ctx.getBean(New_CustomerDao.class);
		List<New_Customer> lists=New_CustomerDao.findByWorkingTableId(15);
		assertEquals(2,lists.size());
	}

}
