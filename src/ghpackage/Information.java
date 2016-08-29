package ghpackage;

import java.util.ArrayList;
import java.util.List;

public class Information {
  private  String usrID;
  private  Integer informationID;
  private  String titile;
  private  String content;
  private  Integer communityID;
  private  List<String>isRead=new ArrayList<String>();//记录看过信息的人的名字
  public Information(){
	  
  }
public String getUsrID() {
	return usrID;
}
public void setUsrID(String usrID) {
	this.usrID = usrID;
}
public Integer getInformationID() {
	return informationID;
}
public void setInformationID(Integer informationID) {
	this.informationID = informationID;
}
public String getTitile() {
	return titile;
}
public void setTitile(String titile) {
	this.titile = titile;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public Integer getCommunityID() {
	return communityID;
}
public void setCommunityID(Integer communityID) {
	this.communityID = communityID;
}
public List<String> getIsRead() {
	return isRead;
}
public void setIsRead(List<String> isRead) {
	this.isRead = isRead;
}
  
}
