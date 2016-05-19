package com.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
public class UserListAction extends ActionSupport{
	private IUserService userService;
	private List<User> users;
	private static final long serialVersionUID = 1L;  
	private Map<String,Object> dataMap;  
    private String key = "Just see see";
    private int start; 
    private int length; 
    
    public String msg;
    private Integer roleId2;
    private Integer deptId2;
    private Integer sex2;
    private Integer status2;
    private String userName2;
    private String pwd;
    




	public Integer getRoleId2() {
		return roleId2;
	}


	public void setRoleId2(Integer roleId2) {
		this.roleId2 = roleId2;
	}


	public Integer getDeptId2() {
		return deptId2;
	}


	public void setDeptId2(Integer deptId2) {
		this.deptId2 = deptId2;
	}


	public Integer getSex2() {
		return sex2;
	}


	public void setSex2(Integer sex2) {
		this.sex2 = sex2;
	}


	public Integer getStatus2() {
		return status2;
	}


	public void setStatus2(Integer status2) {
		this.status2 = status2;
	}


	public String getUserName2() {
		return userName2;
	}


	public void setUserName2(String userName2) {
		this.userName2 = userName2;
	}


	public String getPwd() {
		return pwd;
	}


	public void setPwd(String pwd) {
		this.pwd = pwd;
	}


	//添加用户
  	public String addUser(){
  		try {	

  			User User = new User();
  			Dept deptment = new Dept();
        	ParamInfo paraminfoId=new ParamInfo();
        	
        	System.out.print(roleId2);
        	
        	paraminfoId.setParamInfoId(roleId2);
        	deptment.setDeptId(deptId2);
        	User.setSex(sex2);
        	User.setStatus(status2);
        	User.setUserName(userName2);
        	User.setPwd(pwd);

        	User.setDept(deptment);
        	User.setParamInfo(paraminfoId);
  			
        	System.out.print(User);

  			userService.create(User);
  			msg="success";

  		} catch (Exception e) {
  			// TODO: handle exception
  			e.printStackTrace();
  		}
  		return SUCCESS;
  	    
  	}
  	

    public String getMsg() {
		return msg;
	}


	public void setMsg(String msg) {
		this.msg = msg;
	}


	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

	public String userList(){     
        this.users = userService.getUserList();
        List<Object> aaData = new ArrayList<Object>();
    
        for(int i=0;i<this.users.size();i++)
        {    
        	User user = new User();
        	Dept deptId = new Dept();
        	ParamInfo paraminfoId=new ParamInfo();
          
//          System.out.println(this.users.get(i).getParamInfo());
        
        	deptId.setDeptId(this.users.get(i).getDept().getDeptId());
        	paraminfoId.setParamInfoId(this.users.get(i).getParamInfo().getParamInfoId());
        	
        	user.setUserId(this.users.get(i).getUserId());
        	user.setDept(deptId);
        	user.setParamInfo(paraminfoId);
            user.setUserName(this.users.get(i).getUserName());
            user.setSex(this.users.get(i).getSex());
            user.setStatus(this.users.get(i).getStatus());
        	aaData.add(user);  	
        }
        int recordsTotal;
        int recordsFiltered;
        // dataMap中的数据将会被Struts2转换成JSON字符串，所以这里要先清空其中的数据  
                dataMap = new HashMap<String, Object>(); 
                recordsTotal = aaData.size();
                recordsFiltered = recordsTotal;
                if(start+length>recordsTotal){
                    dataMap.put("aaData", aaData.subList(start,recordsTotal)); 
                }
                else{
                	dataMap.put("aaData", aaData.subList(start,length)); 
                }
          
   
                dataMap.put("recordsTotal", recordsTotal); 
                dataMap.put("recordsFiltered", recordsFiltered); 
           	    // 返回结果  
                return SUCCESS;  
        }

}
