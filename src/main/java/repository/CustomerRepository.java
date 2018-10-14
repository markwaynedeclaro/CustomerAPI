package repository;

import java.util.List;

import model.Customer;

/**
 * @author Mark.Wayne.de.Claro
 *
 */
public interface CustomerRepository {

	List<Customer> getAllCustomers();
	
	Customer getCustomer(String number);	
		
}
