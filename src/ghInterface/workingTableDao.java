package ghInterface;

import java.util.List;

import ghpackage.Information;
import ghpackage.workingTable;

public interface workingTableDao {
workingTable get(Integer Id);
Integer save(workingTable workingTable);
void update(workingTable workingTable);
void delete(workingTable workingTable);
void delete(Integer Id);
List<workingTable> findAll();
List<workingTable> findByUsrname(String usrname);
}
