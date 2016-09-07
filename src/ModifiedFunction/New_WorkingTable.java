package ModifiedFunction;

import java.util.List;
import java.util.Set;

public class New_WorkingTable {
  private Integer New_WorkingTableId;
  private int row;
  private int column;
  private String dates;
  private String times;
  private int limitNumOfBlock;
  private String nameOfWorkingTable;
  private String usrId;
  private Set<New_Customer> New_Customers;
  
public String getUsrId() {
	return usrId;
}
public void setUsrId(String usrId) {
	this.usrId = usrId;
}
public Integer getNew_WorkingTableId() {
	return New_WorkingTableId;
}
public void setNew_WorkingTableId(Integer new_WorkingTableId) {
	New_WorkingTableId = new_WorkingTableId;
}
public int getRow() {
	return row;
}
public void setRow(int row) {
	this.row = row;
}
public int getColumn() {
	return column;
}
public void setColumn(int column) {
	this.column = column;
}
public String getDates() {
	return dates;
}
public void setDates(String dates) {
	this.dates = dates;
}
public String getTimes() {
	return times;
}
public void setTimes(String times) {
	this.times = times;
}
public int getLimitNumOfBlock() {
	return limitNumOfBlock;
}
public void setLimitNumOfBlock(int limitNumOfBlock) {
	this.limitNumOfBlock = limitNumOfBlock;
}
public String getNameOfWorkingTable() {
	return nameOfWorkingTable;
}
public void setNameOfWorkingTable(String nameOfWorkingTable) {
	this.nameOfWorkingTable = nameOfWorkingTable;
}
public Set<New_Customer> getNew_Customers() {
	return New_Customers;
}
public void setNew_Customers(Set<New_Customer> new_Customers) {
	New_Customers = new_Customers;
}
  
}
