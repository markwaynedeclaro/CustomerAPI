package controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import exception.CustomerNotFoundException;
import model.Customer;
import repository.CustomerRepository;

/**
 * @author Mark.Wayne.de.Claro
 *
 */
@RestController
@RequestMapping(value = "/v1/customers", produces = { "application/json", "application/xml" })
public class CustomerController {

	protected Logger logger = Logger.getLogger(CustomerController.class.getName());
	
	@Autowired
	CustomerRepository customerRepository;
	
    @GetMapping
	public List<Resource<Customer>> getAllCustomers() {
		
		logger.info("Get all Customers ");
		
	    List<Customer> allCustomers = customerRepository.getAllCustomers();
	 
	    List<Resource<Customer>> resources = new ArrayList<Resource<Customer>>();
	    for (Customer customer : allCustomers) {
	    	resources.add(getCustomerResource(customer));
	    }
	    
	    logger.info("Customers found: " + allCustomers.size());
	    
	    return resources;
	}	
	
    
    // Get a Single Customer
	@GetMapping(path = "/{id}")
    public Resource<Customer> getCustomerById(@PathVariable(value = "id") String customerId) {
		
		logger.info("Get a single Customer by ID ");
		
		Optional<Customer> customer_ = Optional.ofNullable(customerRepository.getCustomer(customerId));
		
		if (!customer_.isPresent())
		      throw new CustomerNotFoundException("Customer with ID " + customerId + " not found! ");
		
		Customer customer = customer_.get();
		Resource<Customer> resource = new Resource<Customer>(customer);
		resource.add(linkTo(methodOn(CustomerController.class).getAllCustomers()).withRel("customers"));
		resource.add(linkTo(methodOn(CustomerController.class).getCustomerById(customer.getCustomerId())).slash(customer.getCustomerId()).withSelfRel());
		
		logger.info("Customer by ID found: " + customerId);

		return resource;
    }   
    
	 private Resource<Customer> getCustomerResource(Customer customer) {
		 Resource<Customer> resource = new Resource<Customer>(customer);
		 resource.add(linkTo(methodOn(CustomerController.class).getCustomerById(customer.getCustomerId())).slash(customer.getCustomerId()).withSelfRel());
		 return resource;
	 }  
}