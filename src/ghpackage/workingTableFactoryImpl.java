package ghpackage;



import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import ghInterface.*;

public class workingTableFactoryImpl implements workingTableFactory{
	private blockDao blockDao;
	private customerDao customerDao;
	private workingTableDao workingTableDao;
	
	public blockDao getBlockDao() {
		return blockDao;
	}

	public void setBlockDao(blockDao blockDao) {
		this.blockDao = blockDao;
	}

	public customerDao getCustomerDao() {
		return customerDao;
	}

	public void setCustomerDao(customerDao customerDao) {
		this.customerDao = customerDao;
	}

	public workingTableDao getWorkingTableDao() {
		return workingTableDao;
	}

	public void setWorkingTableDao(workingTableDao workingTableDao) {
		this.workingTableDao = workingTableDao;
	}
	public void provideFreeTimeTable(Integer Id){
		
	}
	public void produceWorkingTable(String usename){
		List<workingTable> workingTables=workingTableDao.findByUsrname(usename);
		
		
		//List<workingTable> workingTables=workingTableDao.findAll();
		for(workingTable tmp:workingTables)
		{
		Set<customer>customersSet=tmp.getCustomers();
		if(customersSet.size()==0)continue;
		List<customer>customers=new ArrayList<customer>();
		Iterator it=customersSet.iterator();
		while(it.hasNext()){
			customer c=(customer) it.next();
			customers.add(c);
		}
		quickSortCustomer(customers,0,customers.size()-1);
		List<block> blocks=new ArrayList();
		int column=tmp.getTableColumn();
		int row=tmp.getTableRow();
		for(int i=0;i<column;i++){
			for(int j=0;j<row;j++){
				block block=new block();
				block.setColumn(i);
				block.setRow(j);
				block.setTotalNumOfWorker(customers.size());
				System.out.println(tmp.getNameOfWorkingTable()+"the customer size:"+customers.size());
				block.setCustomerList(customers);
			//	block.setLimitNumOfWorker(0);//here to be modified
			//	block.setTempNumOfWorker(0);//here to be modified
				blocks.add(block);
			}
		}
		quickSortBlock( blocks, 0,blocks.size()-1);
		int numOfBlock=blocks.size();
		int numOfCustomer=customers.size();
		for(int i=0;i<numOfBlock;i++){
			int Column=blocks.get(i).getColumn();
			int Row=blocks.get(i).getRow();
			for(int j=0;j<numOfCustomer;j++){
				int [][]Tmp=customers.get(j).translateTwoDimension(column, row);
				if(Tmp[Row][Column]==1){
					blocks.get(i).getCustomerList().add(customers.get(j));
				//	customers.get(j).setBlock(blocks.get(i));//here
					customers.get(j).addTime();
				}
				if(blocks.get(j).isFull()){
					quickSortCustomer(customers,0,customers.size()-1);
					break;
				}
			}
		}
		
		Set<block> BlockSet=new HashSet<block>();  
		for(block tmpblock:blocks){
			BlockSet.add(tmpblock);
		//	System.out.println("Test on 8/11:"+tmpblock.getColumn()+" "+tmpblock.getLimitNumOfWorker()+" "+tmpblock.getRow()+" "+tmpblock.getTempNumOfWorker()+" "+tmpblock.getTotalNumOfWorker());
		//	tmpblock.setWorkingTable(tmp);//here
		//	blockDao.save(tmpblock);//here
		}
		tmp.setBlocks(BlockSet);
		
		
		Set<customer> CustomerSet=new HashSet<customer>();
		for(customer tmpcustomer:customers){
			CustomerSet.add(tmpcustomer);
			System.out.println("Test on 8/11 15:47:"+tmpcustomer.getName()+" "/*+tmpcustomer.getBlock().getColumn()*/);
			tmpcustomer.setWorkingTable(tmp);
			customerDao.update(tmpcustomer);
			
		}
		tmp.setCustomers(CustomerSet);
		workingTableDao.update(tmp);
		}
		
	}
	public void quickSortCustomer(List<customer>customers,int i,int j){
		  if(j<=i)return;
		  int pivotindex=(i+j)/2;
		  swapCustomer(pivotindex,j,customers);
		  int k=partitionCustomers(customers,i-1,j,j);
		  swapCustomer(k,j,customers);
		  quickSortCustomer(customers,i,k-1);
		  quickSortCustomer(customers,k+1,j);
		}
		public  int partitionCustomers(List<customer>customers,int l,int r,int index){
			do{
				while(customers.get(++l).getTime()<customers.get(index).getTime());
				while((l<r)&&(customers.get(index).getTime()>customers.get(--r).getTime()));
				swapCustomer(l,r,customers);
			}while(l<r);
				return l;
		}
		public  void swapCustomer(int a,int b,List<customer> customers){
			customer Customer=customers.get(a);
			customers.set(a, customers.get(b));
			customers.set(b, Customer);
		}
		public static void quickSortBlock(List<block> blocks,int i,int j){
			if(i>=j)return;
			int pivotindex=(i+j)/2;
			swapBlock(pivotindex,j,blocks);
			int  k=partitionBlocks(blocks,i-1,j,j);
			swapBlock(k,j,blocks);
			quickSortBlock(blocks,i,k-1);
			quickSortBlock(blocks,k+1,j);
		}
		public static int partitionBlocks(List<block> blocks,int l,int r,int index){
			do{
				while(blocks.get(++l).getTotalNumOfWorker()<blocks.get(index).getTotalNumOfWorker());
				while((l<r)&&(blocks.get(index).getTotalNumOfWorker()>blocks.get(--r).getTotalNumOfWorker()));
				swapBlock(l,r,blocks);
			}while(l<r);
				return l;
		}
		public static void swapBlock(int a,int b,List<block> blocks){
			block Block=blocks.get(a);
			blocks.set(a, blocks.get(b));
			blocks.set(b, Block);
		}
}
