package ModifiedFunction;

import java.util.ArrayList;
import java.util.List;

public class New_block {
 private int row;
 private int column;
 private int tempNumOfBlock;//用于记录当前block中已有多少个customer
 private List<New_Customer> New_Customers;
 private New_Customer nullNew_Custoemr=null;
 private int totalNumOfNew_Customer;
 public New_block(int row,int column,int totalNumOfNew_Customer){
	 tempNumOfBlock=0;
	 setTotalNumOfNew_Customer(totalNumOfNew_Customer);
	 setRow(row);
	 setColumn(column);
 }
public int getTotalNumOfNew_Customer() {
	return totalNumOfNew_Customer;
}
public void setTotalNumOfNew_Customer(int totalNumOfNew_Customer) {
	this.totalNumOfNew_Customer = totalNumOfNew_Customer;
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
public int getTempNumOfBlock() {
	return tempNumOfBlock;
}
public void setTempNumOfBlock(int tempNumOfBlock) {
	this.tempNumOfBlock = tempNumOfBlock;
}
public List<New_Customer> getNew_Customers() {
	return New_Customers;
}
public void setNew_Customers(List<New_Customer> new_Customers) {
	New_Customers = new_Customers;
}
public void addNew_Customer(New_Customer New_Customer){
	if(this.getNew_Customers()==null){
		New_Customers=new ArrayList<New_Customer>();
	}
	New_Customers.add(New_Customer);
	this.setNew_Customers(New_Customers);
	tempNumOfBlock++;
}
public boolean isFull(New_WorkingTable New_WorkingTable){
	return tempNumOfBlock>New_WorkingTable.getLimitNumOfBlock();
}
}
