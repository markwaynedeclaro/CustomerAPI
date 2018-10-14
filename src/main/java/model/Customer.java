package model;

import java.io.Serializable;

/**
 * @author Mark.Wayne.de.Claro
 *
 */
public class Customer implements Serializable {
	
	private static final long serialVersionUID = -1636059505842044868L;
	
	private String customerId;
	private String firstName;
	private String lastName;
	private String address;
	
	public Customer(final String customerId, final String firstName, final String lastName, final String address) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
	}
	

	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}