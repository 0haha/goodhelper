package ghpackage;
import java.util.*;
public class workingTable {
	private String usrId;
	private Integer workingTableId;
	private String nameOfWorkingTable;
	private List<String> dates;
	private List<String> times;
	private Set<block> blocks;
	private Set<customer> customers;
	private int TableRow;
	private int TableColumn;
	//private int dateSign;
	//private int timeSign;
	//private int blockSign;
	//private int customerSign;
	private int numOfCustomer;
	private int limitNumOfEachBlock;
	public workingTable(){
		
	}
	public workingTable(String nameOfWorkingTable,int TableRow,int TableColumn,int numOfCustomer){
		//dateSign=0;timeSign=0;
		this.nameOfWorkingTable=nameOfWorkingTable;
		this.TableColumn=TableColumn;
		this.TableRow=TableRow;
		dates=new ArrayList<String>();
		times=new ArrayList<String>();
		//blocks=new ArrayList<block>();
		//customers=new ArrayList<customer>();
		//this.blockSign=0;
		this.numOfCustomer=numOfCustomer;
	}

	public String getUsrId() {
		return usrId;
	}

	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}

	public Integer getWorkingTableId() {
		return workingTableId;
	}

	public void setWorkingTableId(Integer workingTableId) {
		this.workingTableId = workingTableId;
	}

	public String getNameOfWorkingTable() {
		return nameOfWorkingTable;
	}

	public void setNameOfWorkingTable(String nameOfWorkingTable) {
		this.nameOfWorkingTable = nameOfWorkingTable;
	}

	public List<String> getDates() {
		return dates;
	}

	public void setDates(List<String> dates) {
		this.dates = dates;
	}

	public List<String> getTimes() {
		return times;
	}

	public void setTimes(List<String> times) {
		this.times = times;
	}

	public Set<block> getBlocks() {
		return blocks;
	}

	public void setBlocks(Set<block> blocks) {
		this.blocks = blocks;
	}

	public Set<customer> getCustomers() {
		return customers;
	}

	public void setCustomers(Set<customer> customers) {
		this.customers = customers;
	}

	public int getTableRow() {
		return TableRow;
	}

	public void setTableRow(int tableRow) {
		TableRow = tableRow;
	}

	public int getTableColumn() {
		return TableColumn;
	}

	public void setTableColumn(int tableColumn) {
		TableColumn = tableColumn;
	}

	public int getNumOfCustomer() {
		return numOfCustomer;
	}

	public void setNumOfCustomer(int numOfCustomer) {
		this.numOfCustomer = numOfCustomer;
	}
	public int getLimitNumOfEachBlock() {
		return limitNumOfEachBlock;
	}
	public void setLimitNumOfEachBlock(int limitNumOfEachBlock) {
		this.limitNumOfEachBlock = limitNumOfEachBlock;
	}
	
}
