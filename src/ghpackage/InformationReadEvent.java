package ghpackage;

import java.util.List;

import org.springframework.context.ApplicationEvent;

public class InformationReadEvent extends ApplicationEvent{
   public InformationReadEvent(Object source) {
		super(source);
		// TODO Auto-generated constructor stub
	}

public InformationReadEvent(Object source,String menberRead,
		Integer informationId) {
	super(source);
	this.menberRead = menberRead;
	InformationId = informationId;
}

private String menberRead;//the menbers who have read the information.
private Integer InformationId;


public Integer getInformationId() {
	return InformationId;
}

public void setInformationId(Integer informationId) {
	InformationId = informationId;
}

public String getMenberRead() {
	return menberRead;
}

public void setMenberRead(String menberRead) {
	this.menberRead = menberRead;
}


   
}
