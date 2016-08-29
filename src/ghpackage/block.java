package ghpackage;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
public class block implements Serializable{
private Integer blockId;
private int row;//当前该小块的横排位置
private int column;//当前该小块的列排位置
private int tempNumOfWorker=0;//标志当前该时间段的人数
private int limitNumOfWorker=0;//当前该小块所能允许上班人数
private int totalNumOfWorker;//当前该小块不受人数限制情况下能上班人数
private List<customer> allCustomerList;//给出所有员工的数组集合
private List<customer> CustomerList;//允许安排到该小块中的员工
//private customer nullCustomer=new customer("null");//方便该block没有人时填入
private workingTable workingTable;
public block(){
	this.tempNumOfWorker=0;
}
public block(int row,int column,int limitNumOfWorker,List<customer> allCustomerList,workingTable workingTable){
	this.row=row;
	this.column=column;
	this.tempNumOfWorker=0;
	this.limitNumOfWorker=limitNumOfWorker;
	this.allCustomerList=allCustomerList;//在外部将所有员工数组集合加入
	CustomerList=new ArrayList<customer>();
	for(customer tmp:allCustomerList){
		int [][]tmpTable=tmp.translateTwoDimension(workingTable.getTableColumn(), workingTable.getTableRow());
		this.totalNumOfWorker+=tmpTable[row][column];//计算上该班次的总人数
	}
}
//！！！！！！！！！以下是重要的参考代码：！！！！！！！！！！！！！
public boolean isFull(){
	return (tempNumOfWorker>=limitNumOfWorker);
}//判断该时间是否已经安排完毕
/*public int getTotalNumOfWorker(){
	return totalNumOfWorker;
}
public void addCustomer(customer Customer){
	CustomerList.add(Customer);
	tempNumOfWorker++;
}//把符合要求的customer加入该符合要求数组中
public customer getCustomer(int index){
	if(tempNumOfWorker>index)
	return CustomerList.get(index);
	else
	return nullCustomer;
}//给出下标就能对给出该时间段下对应customer对象*/
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
public int getTempNumOfWorker() {
	return tempNumOfWorker;
}
public void setTempNumOfWorker(int tempNumOfWorker) {
	this.tempNumOfWorker = tempNumOfWorker;
}
public int getLimitNumOfWorker() {
	return limitNumOfWorker;
}
public void setLimitNumOfWorker(int limitNumOfWorker) {
	this.limitNumOfWorker = limitNumOfWorker;
}
public int getTotalNumOfWorker() {
	return totalNumOfWorker;
}
public void setTotalNumOfWorker(int totalNumOfWorker) {
	this.totalNumOfWorker = totalNumOfWorker;
}

public List<customer> getCustomerList() {
	return CustomerList;
}
public void setCustomerList(List<customer> customerList) {
	CustomerList = customerList;
}
public workingTable getWorkingTable() {
	return workingTable;
}
public void setWorkingTable(workingTable workingTable) {
	this.workingTable = workingTable;
}
public Integer getBlockId() {
	return blockId;
}
public void setBlockId(Integer blockId) {
	this.blockId = blockId;
}

}