package com.service;

import java.util.List;

import com.entity.User;

/**
 * 
 * @author hpp
 *
 */


public interface IUserService extends IBaseService{

	public User getLoginUser(String userName,String pwd);
	public void addUser(User user);
	public List<User> getUserList();
	public User getUser(Integer userId);
	public void deleteUser(User user);
	public void saveOrUpdate(User user);
}
