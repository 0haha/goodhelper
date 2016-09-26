package ModifiedFunction;





import java.util.ArrayList;
import java.util.List;

public class NewTableFactory {
  private New_CustomerDao New_CustomerDao;
  
  public New_CustomerDao getNew_CustomerDao() {
	return New_CustomerDao;
}

public void setNew_CustomerDao(New_CustomerDao new_CustomerDao) {
	New_CustomerDao = new_CustomerDao;
}

public List<New_Result_WorkingTable> productResultTables(List<New_WorkingTable> New_WorkingTables){
	  List<New_Result_WorkingTable> New_Result_WorkingTables=new ArrayList<New_Result_WorkingTable>();
	  for(New_WorkingTable tmpNew_WorkingTable:New_WorkingTables){
		  List<New_Customer> New_Customers=New_CustomerDao.findByWorkingTableId(tmpNew_WorkingTable.getNew_WorkingTableId());
		  this.sortCustomer(New_Customers,tmpNew_WorkingTable,0,(New_Customers.size()-1));
		  int tempNumofCustomerFortheBlock;
		  List<New_block> New_blocks=new ArrayList<New_block>();
		  for(int i=0;i<tmpNew_WorkingTable.getRow();i++){
			  for(int j=0;j<tmpNew_WorkingTable.getColumn();j++){
				  tempNumofCustomerFortheBlock=0;
				  for(New_Customer tmpNew_Customer:New_Customers){
				    int [][]array=this.getTable(tmpNew_Customer, tmpNew_WorkingTable);
				    tempNumofCustomerFortheBlock+=array[i][j];
				  }
				  New_block New_block=new New_block(i,j,tempNumofCustomerFortheBlock);
				  New_blocks.add(New_block);
			  }
		  }//end for(i ; j)
		  sortBlock(New_blocks,0,(New_blocks.size()-1));
		  
		  //the following is for the function to distribute the appropriate customer for the block;
		  for(int i=0;i<New_blocks.size();i++){
			  int row=New_blocks.get(i).getRow();
			  int column=New_blocks.get(i).getColumn();
			  for(int j=0;j<New_Customers.size();j++){
				  int [][]array=this.getTable(New_Customers.get(j), tmpNew_WorkingTable);
				  New_Customer tmp=New_Customers.get(j);
				  
				  if(array[row][column]==1){
					  New_blocks.get(i).addNew_Customer(tmp);
					  setCforCustomer(New_Customers.get(j),row,column);
				  }
				  if((New_blocks.get(i)).isFull(tmpNew_WorkingTable)){//在安排结束时重新排序，并且跳出该层循环
					  this.sortCustomer(New_Customers,tmpNew_WorkingTable,0,(New_Customers.size()-1));
						break;}
			  }
		  }
		  
		  //product the New_Result_WorkingTable and add to the list
		  New_Result_WorkingTable New_Result_WorkingTable=new New_Result_WorkingTable();
		  New_Result_WorkingTable.setColumn(String.valueOf(tmpNew_WorkingTable.getColumn()));
		  New_Result_WorkingTable.setDatesToken(tmpNew_WorkingTable.getDates());
		  New_Result_WorkingTable.setNamesToken(this.getRusultName(New_blocks, tmpNew_WorkingTable));
		  New_Result_WorkingTable.setRow(String.valueOf(tmpNew_WorkingTable.getRow()));
		  New_Result_WorkingTable.setTimesToken(tmpNew_WorkingTable.getTimes());
		  New_Result_WorkingTable.setWorkingTableId(String.valueOf(tmpNew_WorkingTable.getNew_WorkingTableId()));
		  New_Result_WorkingTables.add(New_Result_WorkingTable);
	  }//end for each workingtable
	  return New_Result_WorkingTables;
  }
public int[][] getTable(New_Customer New_Customer,New_WorkingTable New_WorkingTable){
	String tokentmp=New_Customer.getToken();
	String[] tokenarray=tokentmp.split("&");
	
	int rowtmp=New_WorkingTable.getRow();
	int columntmp=New_WorkingTable.getColumn();
	int [][] arraytmp=new int[rowtmp][columntmp];
	for(int i=0;i<rowtmp;i++){
		char[] chararray=tokenarray[i].toCharArray();
		for(int j=0;j<columntmp;j++){
			if(chararray[j]=='a')
				arraytmp[i][j]=1;
			else if(chararray[j]=='b')
				arraytmp[i][j]=0;
			else
				arraytmp[i][j]=2;
		}
	}
	return arraytmp;
}
public int getTime(New_Customer New_Customer,New_WorkingTable New_WorkingTable){
	int rowtmp=New_WorkingTable.getRow();
	int columntmp=New_WorkingTable.getColumn();
	int [][] arraytmp=new int[rowtmp][columntmp];
	arraytmp=this.getTable(New_Customer, New_WorkingTable);
	int time=0;
	for(int i=0;i<rowtmp;i++){
		for(int j=0;j<columntmp;j++){
			time+=arraytmp[i][j];
		}
	}
	return time;
}
public  void sortCustomer(List<New_Customer> New_Customers,New_WorkingTable New_WorkingTable,int i,int j){
	 if(j<=i)return;
	 int pivotindex=(i+j)/2;
	 this.swapCustomer(pivotindex,j,New_Customers);
	 int k=partitionCustomers(New_Customers,New_WorkingTable,i-1,j,j);
	 swapCustomer(k,j,New_Customers);
	 sortCustomer(New_Customers,New_WorkingTable,i,k-1);
	 sortCustomer(New_Customers,New_WorkingTable,k+1,j);
}
public  void swapCustomer(int a,int b,List<New_Customer> customers){
	New_Customer Customer=customers.get(a);
	customers.set(a, customers.get(b));
	customers.set(b, Customer);
}
public  int partitionCustomers(List<New_Customer>customers,New_WorkingTable New_WorkingTable,int l,int r,int index){
	do{
		while(getTime(customers.get(++l),New_WorkingTable)<getTime(customers.get(index),New_WorkingTable));
		while((l<r)&&(getTime(customers.get(index),New_WorkingTable)>getTime(customers.get(--r),New_WorkingTable)));
		swapCustomer(l,r,customers);
	}while(l<r);
		return l;
}
public void sortBlock(List<New_block> New_blocks,int i,int j){
	if(i>=j)return;
	int pivotindex=(i+j)/2;
	swapBlock(pivotindex,j,New_blocks);
	int  k=partitionBlocks(New_blocks,i-1,j,j);
	swapBlock(k,j,New_blocks);
	sortBlock(New_blocks,i,k-1);
	sortBlock(New_blocks,k+1,j);
}
public  void swapBlock(int a,int b,List<New_block> New_blocks){
	New_block Block=New_blocks.get(a);
	New_blocks.set(a, New_blocks.get(b));
	New_blocks.set(b, Block);
}
public int partitionBlocks(List<New_block> blocks,int l,int r,int index){
	do{
		while(blocks.get(++l).getTotalNumOfNew_Customer()<blocks.get(index).getTotalNumOfNew_Customer());
		while((l<r)&&(blocks.get(index).getTotalNumOfNew_Customer()>blocks.get(--r).getTotalNumOfNew_Customer()));
		swapBlock(l,r,blocks);
	}while(l<r);
		return l;
}
//test 1
public void  setCforCustomer(New_Customer New_Customer,int i,int j){
	String token=New_Customer.getToken();
	String[] tokenArray=token.split("&");
	char[] charArray=tokenArray[i].toCharArray();
	charArray[j]='c';
	//compose the char array
	String tmp="";
	for(int t=0;t<charArray.length;t++){
		tmp+=charArray[t];
	}
	tokenArray[i]=tmp;
	String tmp2="",tmp3="";
	for(int p=0;p<tokenArray.length;p++){
		tmp2=tokenArray[p]+"&";
		tmp3+=tmp2;
	}
	New_Customer.setToken(tmp3);
}
public String getBlockNames(List<New_block>New_blocks,New_WorkingTable New_WorkingTable,int i,int j){
	String names="";
	for(New_block tmp:New_blocks){
		if(tmp.getRow()!=i)continue;
		if(tmp.getColumn()!=j)continue;
		List<New_Customer> New_customers=tmp.getNew_Customers();
		
		for(int k=0;k<New_WorkingTable.getLimitNumOfBlock();k++){
			if(New_customers!=null){
			if(k<New_customers.size())
				names+=(New_customers.get(k).getName()+";");
			else
				names+="n;";
			}
			else{
				names+="n;";
			}
		}
		
		
	}
	return names;
}
public String getRusultName(List<New_block>New_blocks,New_WorkingTable New_WorkingTable){
	String names="";
	for(int i=0;i<New_WorkingTable.getRow();i++){
		for(int j=0;j<New_WorkingTable.getColumn();j++){
			names+=(getBlockNames(New_blocks,New_WorkingTable,i,j)+"&");
		}
	}
	return names;
}
}
