package ghstruts;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import com.opensymphony.xwork2.Action;

public class BuildCommunityAction implements Action{
  private String numOfMenber;
  private String numOfCommunity;
  private String control;
  private InputStream inputStream;
public String getNumOfMenber() {
	return numOfMenber;
}
public void setNumOfMenber(String numOfMenber) {
	this.numOfMenber = numOfMenber;
}
public String getNumOfCommunity() {
	return numOfCommunity;
}
public void setNumOfCommunity(String numOfCommunity) {
	this.numOfCommunity = numOfCommunity;
}
  public InputStream getResult(){
	  return inputStream;
  }
  public String execute() throws Exception{
	  
	  return SUCCESS;
  }
}
