package ghpackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;

public class statisticsQuestionare {
   private String questionareID;
   private String name;
   private String answer;
   public statisticsQuestionare(){
	   questionareID=null;
	   name=null;
	   answer=null;
   }
public String getQuestionareID() {
	return questionareID;
}
public void setQuestionareID(String questionareID) {
	this.questionareID = questionareID;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public void addAnswer(String answers){
	if(answer==null){
		answer=answers;
	}
	else{
	answer=answer.concat("&"+answers);
	}
}
public void addAnswer(String [] answers){
	String tmp=null;
	for(int i=0;i<answers.length;i++){
	  if(tmp==null){
		  tmp=answers[i];
	  }
	  else{
	  tmp=tmp.concat(";"+answers[i]);
	  }
	}
	if(answer==null){
		answer=tmp;
	}
	else{
	answer=answer.concat("&"+tmp);
	}
}
public String getAnswer(){
	return answer;
}
public void save(){
	try{
		String driverName="com.mysql.jdbc.Driver";
		String dbid="jdbc:mysql://localhost:3306/goodhelper";
		Class.forName(driverName);
		Connection conn=DriverManager.getConnection(dbid,"root","110");
		Statement stmt=conn.createStatement();
		
		try{
	    
		stmt.executeUpdate("insert into question_answer values("+getQuestionareID()+",'"+getName()+"','"+getAnswer()+"');");	
		
		}catch(SQLException sqle){
			System.out.println("Could not insert tupe"+sqle);
		}
		
		stmt.close();
		conn.close();
		}
		catch(Exception sqle){
			System.out.println("Exception:"+sqle);
		}
}

}

