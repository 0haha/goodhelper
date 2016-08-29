package ghpackage;

import java.util.List;

import ghInterface.*;



public class InformationServiceImpl implements InformationService{
    private InformationDao informationDao;
    private CommunityDao communityDao;
    public void setInformationDao(InformationDao informationDao){
    	this.informationDao=informationDao;
    }
    public void  setCommunityDao(CommunityDao communityDao){
    	this.communityDao=communityDao;
    }
   public String  provideTitle(Integer Infid){
	   return informationDao.get(Infid).getTitile();
   }
   public String provideContent(Integer Infid){
	   return informationDao.get(Infid).getContent();
   }
   public List<String> provideMenbers(Integer Comid){
	   return communityDao.get(Comid).getMenbers();
   }
   public List<String> provideReader(Integer Infid){
	   return informationDao.get(Infid).getIsRead();
   }
   public List<Information> provideInformation(String usrname){
	   return informationDao.findByUsrname(usrname);
   }
}
