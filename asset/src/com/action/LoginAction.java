package com.action;

import com.opensymphony.xwork2.ActionSupport;
import com.service.IUserService;

/**
 * 
 * @author hpp
 *
 */

public class LoginAction extends ActionSupport {
	
	private IUserService userService;
	private String userName;
	private String pwd;
	public String msg;
	
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	
	
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String userLogin() {
		
		System.out.println("=======");
		try {
			
			if(userService.getLoginUser(userName, pwd)!=null){
				
				System.out.println("==登陆成功==");
				msg="loginsuccess";
				return SUCCESS;
			}
				
			else{
				
				System.out.println("===登陆失败==");
				msg="loginfail";
				return SUCCESS;
			}
				
			
		} catch (Exception e) {
			// TODO: handle exceptio
			System.out.println("======="+e);

		}
		return null;
		
	}
		
	
}



