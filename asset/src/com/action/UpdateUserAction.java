package com.action;

import com.entity.Dept;
import com.entity.ParamInfo;
import com.entity.User;
import com.opensymphony.xwork2.ActionSupport;
import com.service.IUserService;
/**
 * 
 * @author hpp
 *
 */
public class UpdateUserAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private IUserService userService;
	
	private Integer userId;
	private String userName;
	private String pwd;
	private Integer sex;
	private Integer status;
	private Integer deptId;
	private Integer roleId;
	public String  msg;

	private User user;
	
	
	public void setUser(User user) {
		this.user = user;
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


	public Integer getSex() {
		return sex;
	}


	public void setSex(Integer sex) {
		this.sex = sex;
	}


	public Integer getStatus() {
		return status;
	}


	public void setStatus(Integer status) {
		this.status = status;
	}


	public Integer getDeptId() {
		return deptId;
	}


	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}


	public Integer getRoleId() {
		return roleId;
	}


	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}


	public String getMsg() {
		return msg;
	}


	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
	public User getUser(){
		
		return this.user = userService.getUser(userId);
		
	}

	public String updateUser(){


		try {

			User user = new User();
			Dept dept = new Dept();
			ParamInfo paramInfo=new ParamInfo();

			System.out.println(userId);
			System.out.println(userName);
			
			user.setUserId(userId);
			user.setUserName(userName);
			
			if(pwd==null){
				user.setPwd(userService.getUser(userId).getPwd());
			}else {
				user.setPwd(pwd);
			}
			
			user.setSex(sex);
			user.setStatus(status);

			dept.setDeptId(deptId);
			paramInfo.setParamInfoId(roleId);

			user.setDept(dept);
			user.setParamInfo(paramInfo);

			userService.saveOrUpdate(user);
			msg="success";

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return SUCCESS;

	}


	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	
	

}
