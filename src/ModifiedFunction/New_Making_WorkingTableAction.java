package ModifiedFunction;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class New_Making_WorkingTableAction extends ActionSupport{
  private String row;
  private String column;
  private String workingTableName;
  private String limitNumOfWorkingTable;
  private String workingTableId;
  public String getRow() {
	return row;
}

public String getColumn() {
	return column;
}

public String getWorkingTableName() {
	return workingTableName;
}

public String getLimitNumOfWorkingTable() {
	return limitNumOfWorkingTable;
}

public String getDates() {
	return dates;
}

public String getTimes() {
	return times;
}
private String errorcode;
  private String errormsg;
  private String dates;//各个date之间以&组合
  private String times;//各个time之间以&组合
public void setRow(String row) {
	this.row = row;
}

public void setColumn(String column) {
	this.column = column;
}

public void setWorkingTableName(String workingTableName) {
	this.workingTableName = workingTableName;
}

public void setLimitNumOfWorkingTable(String limitNumOfWorkingTable) {
	this.limitNumOfWorkingTable = limitNumOfWorkingTable;
}
public String getWorkingTableId() {
	return workingTableId;
}
public void setWorkingTableId(String workingTableId) {
	this.workingTableId = workingTableId;
}

public void setDates(String dates) {
	this.dates = dates;
}

public void setTimes(String times) {
	this.times = times;
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
 public String add() {
	 System.out.println("heh");
	 ApplicationContext ctx= new ClassPathXmlApplicationContext("bean.xml");
	 New_WorkingTableDao New_workingTableDao=ctx.getBean(New_WorkingTableDao.class);
	//Here don't forget to get back the session ablout the usename
	// ActionContext ctx2=ActionContext.getContext();
	
	// String UsrIdTmp=(String) ctx2.getSession().get("username");
	 
	 String UsrIdTmp="201430620121";
	 New_WorkingTable New_WorkingTable=new New_WorkingTable();
	 New_WorkingTable.setColumn(Integer.parseInt(column));
	 New_WorkingTable.setRow(Integer.parseInt(row));
	 New_WorkingTable.setLimitNumOfBlock(Integer.parseInt(limitNumOfWorkingTable));
	 New_WorkingTable.setNameOfWorkingTable(workingTableName);
	 New_WorkingTable.setDates(dates);
	 New_WorkingTable.setTimes(times);
	 New_WorkingTable.setUsrId(UsrIdTmp);
	 String tempWokingTableId=String.valueOf(New_workingTableDao.save(New_WorkingTable));
	 setWorkingTableId(tempWokingTableId);
	 System.out.println("gg");
	 return Action.SUCCESS;
 }
 public String get(){
	 System.out.println("hehe");
	 ApplicationContext ctx=new ClassPathXmlApplicationContext("bean.xml");
	 New_WorkingTableDao New_workingTableDao=ctx.getBean(New_WorkingTableDao.class);
	 New_WorkingTable New_WorkingTable=New_workingTableDao.get(Integer.parseInt(workingTableId));
	 setRow(String.valueOf(New_WorkingTable.getRow()));
	 setColumn(String.valueOf(New_WorkingTable.getColumn()));
	 setWorkingTableName(New_WorkingTable.getNameOfWorkingTable());
	 setDates(New_WorkingTable.getDates());
	 setTimes(New_WorkingTable.getTimes());
	 return Action.SUCCESS;
 }
 public String execute(){
	 System.out.println("success");
	 return "success";
 }
}
