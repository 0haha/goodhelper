package ModifiedFunction;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionSupport;

public class New_SetCustomerAction extends ActionSupport{
 private String workingTableId;
 private String name;
 private String token;
 private String errorcode;
 private String errormsg;
public String getWorkingTableId() {
	return workingTableId;
}
public void setWorkingTableId(String workingTableId) {
	this.workingTableId = workingTableId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getToken() {
	return token;
}
public void setToken(String token) {
	this.token = token;
}
public String getErrorcode() {
	return errorcode;
}
public void setErrorcode(String errorcode) {
	this.errorcode = errorcode;
}
public String getErrormsg() {
	return errormsg;
}
public void setErrormsg(String errormsg) {
	this.errormsg = errormsg;
}
public String setCustomer(){
	try{
	ApplicationContext ctx=new ClassPathXmlApplicationContext("bean.xml");
	New_CustomerDao New_customerDao=ctx.getBean(New_CustomerDao.class);
	New_WorkingTableDao New_WorkingTableDao=ctx.getBean(New_WorkingTableDao.class);
	//Here don't forget to get back the session ablout the usename, and we just test use as follow
	// ActionContext ctx2=ActionContext.getContext();
	// String UsrIdTmp=(String) ctx2.getSession().get("username");
	
	New_Customer New_Customer=new New_Customer();
	New_Customer.setUsrId("201430620121");//you have to delete this statement after the test
	New_Customer.setName(name);
	New_Customer.setNew_WorkingTable(New_WorkingTableDao.get(Integer.parseInt(workingTableId)));
    New_Customer.setToken(token);
    New_customerDao.save(New_Customer);
    setErrorcode("200");
	setErrormsg("Accept!");
	return "success";
	}catch(Exception e){
		System.out.println("The setCustomer exception:"+e);
		setErrorcode("500");
		setErrormsg("something wrong!");
		return "error";
	}
}
}
