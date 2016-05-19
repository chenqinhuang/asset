package com.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.entity.AssType;
import com.opensymphony.xwork2.ActionSupport;
import com.service.IAssetTypeService;

public class CommonAction extends ActionSupport{
	
	private IAssetTypeService assetTypeService;
	private List<AssType> assTypeList;
	private Map<String,Object> assTypeMap;  
	
	//获取资产类型列表
			public String getAssTypeList(){    
				
		        this.assTypeList = assetTypeService.getList(AssType.class);
		        
		        List<Object> aaData = new ArrayList<Object>();
		    
		        for(int i=0;i<this.assTypeList.size();i++)
		        {    
		        	AssType assTypeInfo = new AssType();
		        	
		        	assTypeInfo.setAsTypeId(this.assTypeList.get(i).getAsTypeId());
		        	assTypeInfo.setAsTypeCode(this.assTypeList.get(i).getAsTypeCode());
		        	assTypeInfo.setAsTypeName(this.assTypeList.get(i).getAsTypeName());
		        	assTypeInfo.setPdAsTypeId(this.assTypeList.get(i).getPdAsTypeId());
		        	assTypeInfo.setPdAdTypeName(this.assTypeList.get(i).getPdAdTypeName());
		        	
		        	aaData.add(assTypeInfo);  	
		        }
		        assTypeMap.put("assTypeList", aaData);
		          
		        // 返回结果  
		        return SUCCESS;  
		        }
}
