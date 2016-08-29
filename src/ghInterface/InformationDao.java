package ghInterface;

import java.util.List;

import ghpackage.*;



public interface InformationDao {
	Information get(Integer id);//根据标识属性来加载Information实例
	  Integer save(Information information);//持久化指定的Information实例
	  void update(Information information);
	  void delete(Information information);
	  void delete(Integer id);
	  List<Information> findAll();
	  List<Information> findByUsrname(String usrname);
}
