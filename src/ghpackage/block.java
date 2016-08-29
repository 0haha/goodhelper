package ghpackage;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
public class block implements Serializable{
private Integer blockId;
private int row;//��ǰ��С��ĺ���λ��
private int column;//��ǰ��С�������λ��
private int tempNumOfWorker=0;//��־��ǰ��ʱ��ε�����
private int limitNumOfWorker=0;//��ǰ��С�����������ϰ�����
private int totalNumOfWorker;//��ǰ��С�鲻������������������ϰ�����
private List<customer> allCustomerList;//��������Ա�������鼯��
private List<customer> CustomerList;//�����ŵ���С���е�Ա��
//private customer nullCustomer=new customer("null");//�����blockû����ʱ����
private workingTable workingTable;
public block(){
	this.tempNumOfWorker=0;
}
public block(int row,int column,int limitNumOfWorker,List<customer> allCustomerList,workingTable workingTable){
	this.row=row;
	this.column=column;
	this.tempNumOfWorker=0;
	this.limitNumOfWorker=limitNumOfWorker;
	this.allCustomerList=allCustomerList;//���ⲿ������Ա�����鼯�ϼ���
	CustomerList=new ArrayList<customer>();
	for(customer tmp:allCustomerList){
		int [][]tmpTable=tmp.translateTwoDimension(workingTable.getTableColumn(), workingTable.getTableRow());
		this.totalNumOfWorker+=tmpTable[row][column];//�����ϸð�ε�������
	}
}
//��������������������������Ҫ�Ĳο����룺��������������������������
public boolean isFull(){
	return (tempNumOfWorker>=limitNumOfWorker);
}//�жϸ�ʱ���Ƿ��Ѿ��������
/*public int getTotalNumOfWorker(){
	return totalNumOfWorker;
}
public void addCustomer(customer Customer){
	CustomerList.add(Customer);
	tempNumOfWorker++;
}//�ѷ���Ҫ���customer����÷���Ҫ��������
public customer getCustomer(int index){
	if(tempNumOfWorker>index)
	return CustomerList.get(index);
	else
	return nullCustomer;
}//�����±���ܶԸ�����ʱ����¶�Ӧcustomer����*/
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