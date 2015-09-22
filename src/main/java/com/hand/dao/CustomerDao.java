package com.hand.dao;

import java.util.List;
import org.springframework.stereotype.Component;
import com.hand.model.Address;
import com.hand.model.Customer;



@Component
public interface CustomerDao {
	public void create(Customer customer);
	public void delete(int customer_id);
	public Customer find(int id);
	public List<Customer> select(int pagesize,int pagenum);
	public void update(int id,String first_name,String last_name,String email,Address address);
	public boolean check(Customer customer);
	
}
