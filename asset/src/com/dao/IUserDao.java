package com.dao;

import java.util.List;

import com.entity.User;

/**
 * 
 * @author hpp
 *
 */

public interface IUserDao extends IBaseDao{
	public List getLoginUser(String userName,String pwd);
//	public String register(String userName,String pwd);
	public boolean register(Object o);
	public List<User> getUserList();
	boolean deleteUser(Object o);
	public User getUser(Integer userId);
	public boolean saveOrUpdate(Object o);
}
