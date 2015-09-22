package com.hand.dao;

import org.springframework.stereotype.Component;

import com.hand.model.User;


@Component
public interface UserDao {
	public boolean check(User user);
	public String findRole(String name);
	public String findCh_Name(String name);
	public void createUser(User user);
}
