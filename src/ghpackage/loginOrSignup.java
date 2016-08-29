package ghpackage;
import java.sql.*;

public class loginOrSignup {
  private String usrID;
  private String password;
  private String phoneNumber;
public loginOrSignup(){
	this.usrID="";
	this.password="";
	this.phoneNumber="";
}
public String getUsrID() {
	return usrID;
}
public void setUsrID(String usrID) {
	this.usrID = usrID;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getPhoneNumber() {
	return phoneNumber;
}
public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
}
public void save(){
	try{
		String driverName="com.mysql.jdbc.Driver";
		String dbid="jdbc:mysql://localhost:3306/goodhelper";
		Class.forName(driverName);
		Connection conn=DriverManager.getConnection(dbid,"root","110");
		Statement stmt=conn.createStatement();
		
		try{
	    
		stmt.executeUpdate("insert into usr values("+getUsrID()+",'"+getPassword()+"',"+getPhoneNumber()+");");	
		
		}catch(SQLException sqle){
			System.out.println("Could not insert tupe"+sqle);
		}
		ResultSet rset=stmt.executeQuery("select usr_ID "+"from usr; ");
		while(rset.next()){
			System.out.println(rset.getString("usr_ID"));
		}
		stmt.close();
		conn.close();
		}
		catch(Exception sqle){
			System.out.println("Exception:"+sqle);
		}
}
  public boolean isCorresponed(String usrID,String password){
	  try{
			String driverName="com.mysql.jdbc.Driver";
			String dbid="jdbc:mysql://localhost:3306/goodhelper";
			Class.forName(driverName);
			Connection conn=DriverManager.getConnection(dbid,"root","110");
			Statement stmt=conn.createStatement();
			
			ResultSet rset=stmt.executeQuery("select password "+"from usr "+"where usr_ID="+usrID+";");
			
			if(!rset.next()){
				stmt.close();
				conn.close();
				return false;
			}
		   if(rset.getString("password").equals(password)){
				stmt.close();
				conn.close();
				return true;
			}
		   else{
				stmt.close();
				conn.close();
				return false;
		   }
			
			}
			catch(Exception sqle){
				System.out.println("Exception:"+sqle);
				return false;
			}
  }
}
