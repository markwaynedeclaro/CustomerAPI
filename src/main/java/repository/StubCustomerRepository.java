package repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import model.Customer;

/**
 * @author Mark.Wayne.de.Claro
 *
 */
@Repository
public class StubCustomerRepository implements CustomerRepository{

	private List<Customer> customers = new ArrayList<Customer>();
	
	public StubCustomerRepository() {
		customers.add(new Customer("C1","First Name 1","Last Name 1","Address 1"));
		customers.add(new Customer("C2","First Name 2","Last Name 2","Address 2"));
		customers.add(new Customer("C3","First Name 3","Last Name 3","Address 3"));
		customers.add(new Customer("C4","First Name 4","Last Name 4","Address 4"));
		customers.add(new Customer("C5","First Name 5","Last Name 5","Address 5"));		
	}
	
	@Override
	public List<Customer> getAllCustomers() {
		return customers;
	}

	@Override
	public Customer getCustomer(String id) {
		return customers.stream()
				.filter(customer -> customer.getCustomerId().equals(id))
				.findAny()                                      // If 'findAny' then return found
                .orElse(null);                                  // If not found, return null
	}
	
}
