package com.hand.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.hand.model.Address;

@Component
public interface AddressDao {
	public List<Address> select();
   
   public Address findById(int addressId);

}
