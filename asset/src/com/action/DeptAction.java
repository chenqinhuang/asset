package com.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.entity.Dept;
import com.entity.ParamInfo;
import com.entity.User;
import com.opensymphony.xwork2.ActionSupport;
import com.service.IDeptService;

/**
 * 
 * @author hpp
 *
 */
public class DeptAction extends ActionSupport{
	
	private IDeptService deptService;
	private List<Dept> deptList;
	private static final long serialVersionUID = 1L;  
	private Map<String,Object> dataMap;  
	private Integer deptId;
	private String deptName;
	public String msg;
	
	private Dept dept;
	
	private Map<String,Object> deptMap;  
	
	


	public void setDept(Dept dept) {
		this.dept = dept;
	}



	public void setDeptList(List<Dept> deptList) {
		this.deptList = deptList;
	}

    
    public Integer getDeptId() {
		return deptId;
	}


	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}


	public String getDeptName() {
		return deptName;
	}


	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}


	public String getMsg() {
		return msg;
	}


	public void setMsg(String msg) {
		this.msg = msg;
	}


	public IDeptService getDeptService() {
		return deptService;
	}


	public void setDeptService(IDeptService deptService) {
		this.deptService = deptService;
	}



	public Dept getDept() {
		return this.dept = deptService.getDept(deptId);
	}


	public Map<String, Object> getDataMap() {
		return dataMap;
	}


	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}


	public int getStart() {
		return start;
	}


	public void setStart(int start) {
		this.start = start;
	}


	public int getLength() {
		return length;
	}


	public void setLength(int length) {
		this.length = length;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	private int start; 
    private int length;  
	
	//获取部门列表（部门ID，部门名称）
	public String getDeptList(){    
		
        this.deptList = deptService.getDeptList();
        
        List<Object> aaData = new ArrayList<Object>();
    
        for(int i=0;i<this.deptList.size();i++)
        {    
        	Dept deptInfo =new Dept();
        	
//          System.out.println(this.users.get(i).getParamInfo());
        
        	deptInfo.setDeptId(this.deptList.get(i).getDeptId());
        	deptInfo.setDeptName(this.deptList.get(i).getDeptName());
        	
        	aaData.add(deptInfo);  	
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
	

	//添加用户
  	public String addDept(){
  		try {	

  			Dept deptment = new Dept();
  			deptment.setDeptName(deptName);
        	
  			System.out.println(deptName);
  			
  			deptService.create(deptment);
  			msg="success";

  		} catch (Exception e) {
  			// TODO: handle exception
  			e.printStackTrace();
  		}
  		return SUCCESS;
  	    
  	}
  	
	
	//删除部门
	public String deleteDept(){
		try {
			deptService.deleteDept(getDept());
			msg="delete";
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return SUCCESS;
	    
	}
	
	//保存或更新部门
	public String saveOrUpdateDept(){

		try {	
			Dept dept = new Dept();

			dept.setDeptId(deptId);
			dept.setDeptName(deptName);
		
			deptService.saveOrUpdateDept(dept);

			msg="success";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	//获取单条记录
	public String getDeptById(){
		
    	deptMap = new HashMap<String, Object>(); 
    	Dept dept = new Dept();
    	
    	try {
    		
        	if(deptId!=null){
        		
        	    dept.setDeptId(deptService.getDept(deptId).getDeptId());
        	    dept.setDeptName(deptService.getDept(deptId).getDeptName());
        		System.out.println(deptService.getDept(deptId).getDeptName());
        		deptMap.put("deptInfo",dept);
        		deptMap.put("msg","get");
        		
        	}else {
        		
        		deptMap.put(msg,"no");		
        		
    		}
    		
    		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    	
		return SUCCESS;
		
	}







	public Map<String, Object> getDeptMap() {
		return deptMap;
	}







	public void setDeptMap(Map<String, Object> deptMap) {
		this.deptMap = deptMap;
	}
}
