package com.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.entity.AssType;
import com.entity.Dept;
import com.opensymphony.xwork2.ActionSupport;
import com.service.IAssetTypeService;
/**
 * 
 * @author hpp
 *
 */

public class AssetTypeAction extends ActionSupport{
	
	private IAssetTypeService assetTypeService;
	private List<AssType> assTypeList;
	private static final long serialVersionUID = 1L;  
	private Map<String,Object> dataMap;  
	private Map<String,Object> assTypeMap;  
	
	private Integer asTypeId;
    private String asTypeCode;
    private String asTypeName;
    private Integer pdAsTypeId;
    private String pdAdTypeName;
    
    private AssType assType;
	public String msg;
	
	
	//增加资产类型
			public String addAssType(){
				try {	

					AssType assType = new AssType();

					assType.setAsTypeCode(asTypeCode);
					assType.setAsTypeName(asTypeName);
					assType.setPdAsTypeId(pdAsTypeId);
					assType.setPdAdTypeName(pdAdTypeName);

					assetTypeService.create(assType);
					msg="success";

				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				return SUCCESS;
			    
			}
	
	
	
	
	
	
	//删除资产类型
			public String deleteAssType(){
				try {
//					deptService.deleteDept(getDept());
					assetTypeService.delete(getAssType());
					msg="delete";
					
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				return SUCCESS;
			    
			}
	
	//保存或更新资产类型
		public String saveOrUpdateAssType(){

			try {	
				
                AssType assType = new AssType();
                
//                assType.setAsTypeId(asTypeId);
                
                if(asTypeId!=null){
                	
                	assType.setAsTypeId(asTypeId);
                	assType.setAsTypeCode(asTypeCode);
                    assType.setAsTypeName(asTypeName);
                    assType.setPdAsTypeId(pdAsTypeId);
                    assType.setPdAdTypeName(pdAdTypeName);
                    
                    assetTypeService.saveOrUpdate(assType);
                    msg="success";
                }else {
                	
                    msg="fail";
				}
                
                		
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return SUCCESS;
		}
		
		
		private int start; 
	    private int length;
			
	    
	 
	    
	    
		//获取资产类型列表
		public String getAssTypeList(){    
			
	        this.assTypeList = assetTypeService.getList(AssType.class);
	        
	        List<Object> aaData = new ArrayList<Object>();
	    
	        for(int i=0;i<this.assTypeList.size();i++)
	        {    
	        	AssType assTypeInfo = new AssType();
	        	
	        	assTypeInfo.setAsTypeId(this.assTypeList.get(i).getAsTypeId());
	        	System.out.println("资产类型Id"+this.assTypeList.get(i).getAsTypeId());
	        	assTypeInfo.setAsTypeCode(this.assTypeList.get(i).getAsTypeCode());
	        	assTypeInfo.setAsTypeName(this.assTypeList.get(i).getAsTypeName());
	        	assTypeInfo.setPdAsTypeId(this.assTypeList.get(i).getPdAsTypeId());
	        	assTypeInfo.setPdAdTypeName(this.assTypeList.get(i).getPdAdTypeName());
	        	
	        	aaData.add(assTypeInfo);  	
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
		

		
		
		
		
		//获取单条记录
		public String getAssetTypeById(){
			
	    	assTypeMap = new HashMap<String, Object>(); 
	    	AssType assType = new AssType();
	    	
	    	try {
	    		
	        	if(asTypeId!=null){
	        		
	        		assType.setAsTypeId(assetTypeService.findById(AssType.class, asTypeId).getAsTypeId());
	        		System.out.println("获取单条记录的Id"+assetTypeService.findById(AssType.class, asTypeId).getAsTypeId());
	        		assType.setAsTypeName(assetTypeService.findById(AssType.class, asTypeId).getAsTypeName());
	        		assType.setAsTypeCode(assetTypeService.findById(AssType.class, asTypeId).getAsTypeCode());
	        		assType.setPdAsTypeId(assetTypeService.findById(AssType.class, asTypeId).getPdAsTypeId());
	        		assType.setPdAdTypeName(assetTypeService.findById(AssType.class, asTypeId).getPdAdTypeName());
	        		
	        		assTypeMap.put("assTypeInfo",assType);
	        		assTypeMap.put("msg","get");
	        		
	        	}else {
	        		
	        		assTypeMap.put("msg","no");		
	        		
	    		}
	    		
	    		
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
	    	
			return SUCCESS;
			
		}
		
		
		
		
		


		public IAssetTypeService getAssetTypeService() {
			return assetTypeService;
		}


		public void setAssetTypeService(IAssetTypeService assetTypeService) {
			this.assetTypeService = assetTypeService;
		}


		public Map<String, Object> getDataMap() {
			return dataMap;
		}


		public void setDataMap(Map<String, Object> dataMap) {
			this.dataMap = dataMap;
		}


		public Map<String, Object> getAssTypeMap() {
			return assTypeMap;
		}


		public void setAssTypeMap(Map<String, Object> assTypeMap) {
			this.assTypeMap = assTypeMap;
		}


		public Integer getAsTypeId() {
			return asTypeId;
		}


		public void setAsTypeId(Integer asTypeId) {
			this.asTypeId = asTypeId;
		}


		public String getAsTypeCode() {
			return asTypeCode;
		}


		public void setAsTypeCode(String asTypeCode) {
			this.asTypeCode = asTypeCode;
		}


		public String getAsTypeName() {
			return asTypeName;
		}


		public void setAsTypeName(String asTypeName) {
			this.asTypeName = asTypeName;
		}


		public Integer getPdAsTypeId() {
			return pdAsTypeId;
		}


		public void setPdAsTypeId(Integer pdAsTypeId) {
			this.pdAsTypeId = pdAsTypeId;
		}


		public String getPdAdTypeName() {
			return pdAdTypeName;
		}


		public void setPdAdTypeName(String pdAdTypeName) {
			this.pdAdTypeName = pdAdTypeName;
		}

//       获取asstype
		public AssType getAssType() {
			try {
				return this.assType = assetTypeService.findById(AssType.class, asTypeId);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return assType;
		}


		public void setAssType(AssType assType) {
			this.assType = assType;
		}


		public String getMsg() {
			return msg;
		}


		public void setMsg(String msg) {
			this.msg = msg;
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


		public void setAssTypeList(List<AssType> assTypeList) {
			this.assTypeList = assTypeList;
		}
	
	

}
