package ghpackage;

import java.util.ArrayList;
import java.util.List;

public class community {
   public community(){
	   
   }
   private String usrID;
   private Integer community_ID;
   private String nameOfCommunity;
   private List<String> menbers=new ArrayList<String>();
public String getUsrID() {
	return usrID;
}
public void setUsrID(String usrID) {
	this.usrID = usrID;
}
public Integer getCommunity_ID() {
	return community_ID;
}
public void setCommunity_ID(Integer community_ID) {
	this.community_ID = community_ID;
}
public String getNameOfCommunity() {
	return nameOfCommunity;
}
public void setNameOfCommunity(String nameOfCommunity) {
	this.nameOfCommunity = nameOfCommunity;
}
public List<String> getMenbers() {
	return menbers;
}
public void setMenbers(List<String> menbers) {
	this.menbers = menbers;
}
   
}