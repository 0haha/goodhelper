package ghpackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;


public class questionare {

	private int radioSign;//标记当前单选题数组位置
	private int checkboxSign;//标记当前多选题数组位置
	private int textSign;//标记当前问答题数组位置
	private  List<String> sequence;//标记题目出现顺序的数组
	private int sequenceSign;//标记题目数组当前对应的题号
	private List<radio> radio;
	private List<checkbox> checkbox;
	private List<text> text;
	private String nameOfQuestionare;//问卷名字
	private int numOfQuestion;
	private String usr;
	private String questionareID;


	public questionare(){
		radio=new ArrayList<radio>();
		checkbox=new ArrayList<checkbox>();
		text=new ArrayList<text>();
		radioSign=0;
		checkboxSign=0;
		textSign=0;
		sequence= new ArrayList<String>();
		sequenceSign=0;
		nameOfQuestionare=null;
		numOfQuestion=0;
		usr=null;
		questionareID=null;
	}
	public void initSign(){
		radioSign=0;
		checkboxSign=0;
		textSign=0;
	}//重新将各个下标置0

	public void addRadio(radio Radio){
		numOfQuestion++;
		radio.add(Radio);
		
	}
	public void addcheckbox(checkbox Checkbox){
		numOfQuestion++;
		checkbox.add(Checkbox);
		
	}
	public void addText(text Text){
		numOfQuestion++;
		text.add(Text);
		
	}
	public int getRadioSign() {
		return radioSign;
	}
	public void increseRadioSign(){
		radioSign++;
	}
	public int getcheckboxSign() {
		return checkboxSign;
	}
	public void increseCheckboxSign(){
		checkboxSign++;
	}
	public int getTextSign() {
		
		return textSign;
	}
	public void increseTextSign(){
		textSign++;
	}
	public radio getRadio() {
		//radioSign++;
		return radio.get(getRadioSign());
		
	}

	public checkbox getcheckbox() {
		//checkboxSign++;
		return checkbox.get(getcheckboxSign());
	}

	public text getText() {
		//textSign++;
		return text.get(getTextSign());
	}

	public int getSequenceSign(){
		return sequenceSign;
	}
	public void addSequence(String s){
		sequence.add(s);
	}
	public String getSequence(){
		sequenceSign++;
		return sequence.get(getSequenceSign()-1);
	}

	public String getNameOfQuestionare() {
		return nameOfQuestionare;
	}

	public void setNameOfQuestionare(String nameOfQuestionare) {
		this.nameOfQuestionare = nameOfQuestionare;
	}
	public int getNumOfQuestion(){
		return numOfQuestion;
	}
	public String getUsr(){
		return usr;
	}
	public String getQuestionareID(){
		return questionareID;
	}
	//获取问卷ID同时存储进入数据库
	public void setQuestionareId(String id){
		try{
			
			String driverName="com.mysql.jdbc.Driver";
			String dbid="jdbc:mysql://localhost:3306/goodhelper";
			Class.forName(driverName);
			Connection conn=DriverManager.getConnection(dbid,"root","110");
			Statement stmt=conn.createStatement();
			
			usr=id;
			
			ResultSet rset=stmt.executeQuery("select questionare "+"from usr_questionare "+"where usr_ID="+id+";");
			
			if(!rset.next()){
				String qid=id.concat("0");
				stmt.executeUpdate("insert into usr_questionare  values ('"+id+"','"+qid+"');");
				stmt.close();
				conn.close();
				questionareID=qid;	
			}
		  
		   else{
			   String qid="";
			   int t=1;
			   qid=id.concat(String.valueOf(t));
			   while(rset.next()){
			   t++;
			   qid=id.concat(String.valueOf(t));
			   
			  
			   if(t>9)
			  	   break;
			   }//数据库中只允许存储十张问卷
			   stmt.executeUpdate("insert into usr_questionare  values ('"+id+"','"+qid+"');");
				stmt.close();
				conn.close();
				questionareID=qid;
		   }
			
			}
			catch(Exception sqle){
				System.out.println("Exception:"+sqle);
				
			}
	}
	//该函数用于辅助存储题目表单时提供questionID
	public String getQuestionID(){
		try{
			
			String driverName="com.mysql.jdbc.Driver";
			String dbid="jdbc:mysql://localhost:3306/goodhelper";
			Class.forName(driverName);
			Connection conn=DriverManager.getConnection(dbid,"root","110");
			Statement stmt=conn.createStatement();
			
			//questionareId=id;
			
			ResultSet rset=stmt.executeQuery("select question_ID "+"from questionare "+"where questionare_ID="+questionareID+";");
			String id=questionareID;
			if(!rset.next()){
				String qid=id.concat("00");
				stmt.close();
				conn.close();
				
				return qid;
			}
		  
		   else{
			   //char pp=questionareId.charAt(12);
			   //if(pp=='0'){
			   String qid="";
			   int t=1;
			   qid=id.concat("0").concat(String.valueOf(t));
			   while(rset.next()){
			   t++;
			   qid=id.concat("0").concat(String.valueOf(t));
			   if(t>=9)
				   break;
			   }//数据库中只允许存储十张问卷
			   while(rset.next()){
				   t++;
				   qid=id.concat(String.valueOf(t));
				   if(t>=99)
					   break;
			   }
			   
			 
				stmt.close();
				conn.close();
				
				return qid;
				
		   }
			
			}
			catch(Exception sqle){
				System.out.println("Exception:"+sqle);
				return null;
				
			}
	}
	public void save(){
		try{
			String driverName="com.mysql.jdbc.Driver";
			String dbid="jdbc:mysql://localhost:3306/goodhelper";
			Class.forName(driverName);
			Connection conn=DriverManager.getConnection(dbid,"root","110");
			PreparedStatement stmt=conn.prepareStatement("insert into question values(?,?,?,?,?,?,?,?,?)");
			PreparedStatement stmt2=conn.prepareStatement("insert into questionare values(?,?,?)");
			
			try{
			initSign();
		    for(int i=0;i<getNumOfQuestion();i++){
		    	switch(getSequence()){
		    	case "r":
		    		String tmp=getQuestionID();
		    		//完成对数据关系questionare的数据存储
		    		stmt2.setString(1,getQuestionareID());
		    		stmt2.setString(2, tmp);
		    		stmt2.setString(3, "r");
		    		stmt2.executeUpdate();
		    		//完成对数据关系question的数据存储
		    		stmt.setString(1,  tmp);
		    		stmt.setString(2,getRadio().getQuestion());
		    		for(int j=0;j<7;j++){
		    			if(j<getRadio().getNumOfAnswers())
		    			stmt.setString(j+3,getRadio().getAnswer());
		    			else
		    			stmt.setString(j+3, null);
		    		}
		    		stmt.executeUpdate();
		    		increseRadioSign();
		    		break;
		    	case "c":
		    		String tmp2=getQuestionID();
		    		//完成对数据关系questionare的数据存储
		    		stmt2.setString(1,getQuestionareID());
		    		stmt2.setString(2, tmp2);
		    		stmt2.setString(3, "c");
		    		stmt2.executeUpdate();
		    		//完成对数据关系question的数据存储
		    		stmt.setString(1,  tmp2);
		    		stmt.setString(2,getcheckbox().getQuestion());
		    		for(int j=0;j<7;j++){
		    			if(j<getcheckbox().getNumOfAnswers())
		    			stmt.setString(j+3,getcheckbox().getAnswer());
		    			else
		    			stmt.setString(j+3,null);
		    		}
		    		stmt.executeUpdate();
		    		increseCheckboxSign();
		    		break;
		    	case "t":
		    		String tmp3=getQuestionID();
		    		//完成对数据关系questionare的数据存储
		    		stmt2.setString(1,getQuestionareID());
		    		stmt2.setString(2, tmp3);
		    		stmt2.setString(3, "t");
		    		stmt2.executeUpdate();
		    		//完成对数据关系question的数据存储
		    		stmt.setString(1,  tmp3);
		    		stmt.setString(2,getText().getQuestion());
		    		stmt.executeUpdate();
		    		increseTextSign();
		    		break;
		    	default:
		    		break;
		    		
		    	}
		    	
		    }
			
			}catch(SQLException sqle){
				System.out.println("Could not insert questionare:"+sqle);
			}
			
			stmt.close();
			conn.close();
			}
			catch(Exception sqle){
				System.out.println("Exception:"+sqle);
			}
		}
}





