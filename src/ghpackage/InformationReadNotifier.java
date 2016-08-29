package ghpackage;

import java.util.ArrayList;
import java.util.List;

import ghInterface.InformationDao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InformationReadNotifier implements ApplicationListener{
  public void onApplicationEvent(ApplicationEvent evt){
	  if(evt instanceof InformationReadEvent){
		  Information inf=new Information();
		  
		  inf.setInformationID(((InformationReadEvent) evt).getInformationId());
		  ApplicationContext ctx=new ClassPathXmlApplicationContext("bean.xml");
		  InformationDao informationDaoImpl=ctx.getBean("InformationDao",InformationDaoImpl.class);
		  List<String> isRead=new ArrayList<String>();
		  isRead=informationDaoImpl.get(((InformationReadEvent) evt).getInformationId()).getIsRead();
		  isRead.add(((InformationReadEvent) evt).getMenberRead());
		  inf.setIsRead(isRead);
		  inf.setCommunityID(informationDaoImpl.get(((InformationReadEvent) evt).getInformationId()).getCommunityID());
		  inf.setContent(informationDaoImpl.get(((InformationReadEvent) evt).getInformationId()).getContent());
		  inf.setTitile(informationDaoImpl.get(((InformationReadEvent) evt).getInformationId()).getTitile());
		  inf.setUsrID(informationDaoImpl.get(((InformationReadEvent) evt).getInformationId()).getUsrID());
		  informationDaoImpl.update(inf);
		  System.out.println("It touch the event");
	  }
	  else{
		  System.out.println("容器本身事件： "+evt);
	  }
  }
}
