package com.action;

import com.entity.User;
import com.opensymphony.xwork2.ActionSupport;
import com.service.IUserService;

/**
 * 
 * @author hpp
 *
 */

public class DeleteUserAction extends ActionSupport {
	private IUserService userService;
	private User user;
	private Integer userId;
	public String msg;
	
	
	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public Integer getUserId() {
		return userId;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getUser(){
	
		return this.user = userService.getUser(userId);
	}
	
	public String deleteUser(){
		System.out.println(userId);
	    userService.deleteUser(getUser());
	    msg="delete";
		return SUCCESS;
	}
}
