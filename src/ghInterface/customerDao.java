package ghInterface;

import java.util.List;

import ghpackage.customer;

public interface customerDao {
 customer get(Integer Id);
 Integer save(customer customer);
 void update(customer customer);
 void delete(customer customer);
 void delete(Integer Id);
 List<customer> findAll();
 
}
