package com.action;

import com.entity.User;
import com.opensymphony.xwork2.ActionSupport;
import com.service.IUserService;
/**
 * 
 * @author hpp
 *
 */
public class RegisterAction extends ActionSupport{
	
	private IUserService userService;
	
	private String userName;
	private String pwd;
	private String repwd;
	
	
	public String getRepwd() {
		return repwd;
	}


	public void setRepwd(String repwd) {
		this.repwd = repwd;
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


	public String register(){
	    User user = new User();
	    System.out.println(userName);
	    System.out.println(pwd);
	    System.out.println(repwd);
	    user.setUserName(userName);
	    user.setPwd(pwd);
	    
	    if(pwd.equals(repwd)){
	    	userService.addUser(user);
	    	System.out.println(user.getUserName());
		    System.out.println(user.getPwd());
		    System.out.println("注册成功action.impl");
	    }else {
	    	System.out.println("两次密码不一致！");
		}
	    
	    
	    return "register";
		}

}
