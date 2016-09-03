package ModifiedFunction;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class New_Making_WorkingTableAction extends ActionSupport{
  private String row;
  private String column;
  private String workingTableName;
  private String limitNumOfWorkingTable;
  private String workingTableId;
  private String usrId;
  private String formId;
  private String errorcode;
  private String errormsg;

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

public void setUsrId(String usrId) {
	this.usrId = usrId;
}
public String getFormId() {
	return formId;
}
public void setFormId(String formId) {
	this.formId = formId;
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
	 
	 setWorkingTableId("1024");
	 return Action.SUCCESS;
 }
 public String execute(){
	 System.out.println("success");
	 return "success";
 }
}
