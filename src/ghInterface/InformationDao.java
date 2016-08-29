package ghInterface;

import java.util.List;

import ghpackage.*;



public interface InformationDao {
	Information get(Integer id);//���ݱ�ʶ����������Informationʵ��
	  Integer save(Information information);//�־û�ָ����Informationʵ��
	  void update(Information information);
	  void delete(Information information);
	  void delete(Integer id);
	  List<Information> findAll();
	  List<Information> findByUsrname(String usrname);
}
