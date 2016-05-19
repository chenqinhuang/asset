package com.service.impl;

import java.util.List;

import com.dao.IUserDao;
import com.entity.User;
 
import com.service.IUserService;

/**
 * 
 * @author hpp
 *
 */

public class UserService extends BaseService implements IUserService {
	
	private IUserDao userDao;
	public IUserDao getUserDao() {
		return userDao;
	}
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}
	@Override
	public User getLoginUser(String userName, String pwd) {
		// TODO Auto-generated method stub
		
		List list=userDao.getLoginUser(userName,pwd);
		if(list!=null&&list.size()>=1){
			return (User)list.get(0);
		}
		else{
			
			return null;
		}
			
			
	}
	
	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
//		if(){
//			
//		}
		System.out.println("注册成功service.impl");
		System.out.println(user.getUserName());
	    System.out.println(user.getPwd());
		
		this.userDao.register(user);
	}
	
	
	@Override
	public List<User> getUserList() {
		// TODO Auto-generated method stub
		
		return this.userDao.getUserList();
		
	}
	@Override
	public User getUser(Integer userId) {
		// TODO Auto-generated method stub
		return userDao.getUser(userId);
		
	}
	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		userDao.deleteUser(user);
		
	}
	@Override
	public void saveOrUpdate(User user) {
		// TODO Auto-generated method stub
		this.userDao.saveOrUpdate(user);
	}
	
}
