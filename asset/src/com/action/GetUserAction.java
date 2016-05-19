package com.action;

import java.util.HashMap;
import java.util.Map;

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

public class GetUserAction extends ActionSupport {
	
	private IUserService userService;
	private Map<String,Object> userMap;  
	private Integer userId;
	private User user;
    public  String msg;
    
	

	public void setUser(User user) {
		this.user = user;
	}


	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public IUserService getUserService() {
		return userService;
	}


	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public String getMsg() {
		return msg;
	}


	public void setMsg(String msg) {
		this.msg = msg;
	}


	public Map<String, Object> getUserMap() {
		return userMap;
	}


	public void setUserMap(Map<String, Object> userMap) {
		this.userMap = userMap;
	}
	
    public String getUser(){

    	userMap = new HashMap<String, Object>(); 
    	User myUser = new User();
    	Dept deptId = new Dept();
    	ParamInfo paraminfoId=new ParamInfo();
    	
    	try {
    		
        	
        	if(userId!=null){
        		
                System.out.println("当前用户Id是："+userId);
        		
        		myUser.setUserId(userService.getUser(userId).getUserId());
        		myUser.setUserName(userService.getUser(userId).getUserName());
        		myUser.setSex(userService.getUser(userId).getSex());
        		myUser.setStatus(userService.getUser(userId).getStatus());
        		//外键获取方法
        		deptId.setDeptId(userService.getUser(userId).getDept().getDeptId());
            	paraminfoId.setParamInfoId(userService.getUser(userId).getParamInfo().getParamInfoId());
        		
            	myUser.setDept(deptId);
            	myUser.setParamInfo(paraminfoId);
            	
            	userMap.put("userInfo",myUser);
        		userMap.put("msg","get");
        		
        	}else {
        		
        		userMap.put(msg,"no");		
        		
    		}
    		
    		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    	
		return SUCCESS;
		
	}
	
	
}
