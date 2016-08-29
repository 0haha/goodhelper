package ghInterface;


import ghpackage.community;

import java.util.List;

public interface CommunityDao {
	  community get(Integer id);//根据标识属性来加载Information实例
	  Integer save(community community);//持久化指定的Information实例
	  void update(community community);
	  void delete(community community);
	  void delete(Integer id);
	  List<community> findAll();
}
