package ghInterface;

import java.util.List;

import ghpackage.block;

public interface blockDao {
block get(Integer Id);
Integer save(block block);
void update(block block);
void delete(block block);
void delete(Integer Id);
List<block> findAll();

}
