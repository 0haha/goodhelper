package ghInterface;


import ghpackage.community;

import java.util.List;

public interface CommunityDao {
	  community get(Integer id);//���ݱ�ʶ����������Informationʵ��
	  Integer save(community community);//�־û�ָ����Informationʵ��
	  void update(community community);
	  void delete(community community);
	  void delete(Integer id);
	  List<community> findAll();
}
