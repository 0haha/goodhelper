package ghInterface;

import java.util.List;

import ghpackage.*;

public interface InformationService {
	 
	 String  provideTitle(Integer infid);
	 String  provideContent(Integer infid);
	 List<String> provideMenbers(Integer Comid);
	 List<String> provideReader(Integer infid);
	 List<Information> provideInformation(String usrname);
}
