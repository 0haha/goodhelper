package ModifiedFunction;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class New_Result_WorkingTableAction extends ActionSupport{
 private String usrId;
 private List<New_Result_WorkingTable> N;

public void setUsrId(String usrId) {
	this.usrId = usrId;
}
public List<New_Result_WorkingTable> getN() {
	return N;
}
public void setN(
		List<New_Result_WorkingTable> new_Result_WorkingTables) {
	    N = new_Result_WorkingTables;
}
 public String list(){
	 System.out.println("OK!");
	 ApplicationContext ctx=new ClassPathXmlApplicationContext("bean.xml");
	 New_WorkingTableDao New_WorkingTableDao=ctx.getBean(New_WorkingTableDao.class);
	 List<New_WorkingTable> New_WorkingTables=New_WorkingTableDao.findByUsrId(usrId);
	 NewTableFactory NewTableFactory=ctx.getBean(NewTableFactory.class);
	 setN(NewTableFactory.productResultTables(New_WorkingTables));
	 return Action.SUCCESS;
 }
}
