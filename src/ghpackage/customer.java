package ghpackage;

public class customer {
	  private Integer customerId;
	  private String name;
	  private int time;
	  private String[] Ttable;
	  private block block;
	  private workingTable workingTable;
	  public customer(String name){
		  this.name=name;
	  }
	  public customer(){
		  
	  }
	  public customer(String name,int row,int column,String []table){
		  this.name=name;
		  this.Ttable=table;
		  this.time=0;
		  for(int i=0;i<table.length;i++){
			  time+=Integer.valueOf(table[i]);
		  }
	  }
	public int  getTime(){
		return time;
	}
	public int addTime(){
		time++;
		return time;
	}
	public void setTime(int time){
		this.time=time;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String[] getTtable() {
		return Ttable;
	}
	public void setTtable(String[] table) {
		this.Ttable = table;
	}
	public block getBlock() {
		return block;
	}
	public void setBlock(block block) {
		this.block = block;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	
	public workingTable getWorkingTable() {
		return workingTable;
	}
	public void setWorkingTable(workingTable workingTable) {
		this.workingTable = workingTable;
	}
	public int[][] translateTwoDimension(int column,int row){
		int [][] tmpTable =new int[row][column];
		System.out.println("the column:"+column+" the row:"+row);
		for(int i=0;i<column*row;i++){
			System.out.print("table: "+Ttable[i]);
		}
		for(int i=0;i<Ttable.length;i++){
			tmpTable[i/column][i%column]=Integer.valueOf(Ttable[i]);
		}
		return tmpTable;
	}
	
	
	}
