package com.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.entity.ParamInfo;
import com.opensymphony.xwork2.ActionSupport;
import com.service.IParamInfoService;
/**
 * 
 * @author hpp
 *
 */
public class ParamInfoAction extends ActionSupport{

	private IParamInfoService paramInfoService;
	private List<ParamInfo> paramInfoList;
	private static final long serialVersionUID = 1L;  
	private Map<String,Object> dataMap;  
	private Map<String,Object> paraInfoMap;  

	private Integer paramInfoId;
	private String paramName;
	private String paramValue;
	private Integer pdParamId;
	private String pdParamName;

	private ParamInfo paramInfo;
	public String msg;

	private int start; 
	private int length;


	//增加参数信息配置
	public String addParaInfo(){
		try {	

			ParamInfo paramInfo = new ParamInfo();

			paramInfo.setParamInfoId(paramInfoId);
			paramInfo.setParamName(paramName);
			paramInfo.setParamValue(paramValue);
			paramInfo.setPdParamId(pdParamId);
			paramInfo.setPdParamName(pdParamName);

			paramInfoService.create(paramInfo);

			msg="success";

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return SUCCESS;

	}






	//删除参数信息配置
	public String deleteParaInfo(){
		try {
			//			deptService.deleteDept(getDept());
			paramInfoService.delete(getParamInfo());
			msg="delete";

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return SUCCESS;

	}

	//保存或更新参数信息配置
	public String saveOrUpdateParaInfo(){

		try {	

			ParamInfo paramInfo = new ParamInfo();

			//        assType.setAsTypeId(asTypeId);

			if(paramInfoId!=null){

				paramInfo.setParamInfoId(paramInfoId);
				paramInfo.setParamName(paramName);
				paramInfo.setParamValue(paramValue);
				paramInfo.setPdParamId(pdParamId);
				paramInfo.setPdParamName(pdParamName);

				paramInfoService.saveOrUpdate(paramInfo);
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






	//获取资产类型列表
	public String getParaInfoList(){    

		this.paramInfoList = paramInfoService.getList(ParamInfo.class);

		List<Object> aaData = new ArrayList<Object>();

		for(int i=0;i<this.paramInfoList.size();i++)
		{    
			ParamInfo paramInfo = new ParamInfo();

			
			paramInfo.setParamInfoId(this.paramInfoList.get(i).getParamInfoId());
			paramInfo.setParamName(this.paramInfoList.get(i).getParamName());
			paramInfo.setParamValue(this.paramInfoList.get(i).getParamValue());
			paramInfo.setPdParamId(this.paramInfoList.get(i).getPdParamId());
			paramInfo.setPdParamName(this.paramInfoList.get(i).getPdParamName());

			aaData.add(paramInfo);  	
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
	public String getParaInfoById(){

		paraInfoMap = new HashMap<String, Object>(); 
	
		ParamInfo paramInfo = new ParamInfo();

		try {

			if(paramInfoId!=null){


				paramInfo.setParamInfoId(paramInfoService.findById(ParamInfo.class, paramInfoId).getParamInfoId());
				paramInfo.setParamName(paramInfoService.findById(ParamInfo.class, paramInfoId).getParamName());
				paramInfo.setParamValue(paramInfoService.findById(ParamInfo.class, paramInfoId).getParamValue());
				paramInfo.setPdParamId(paramInfoService.findById(ParamInfo.class, paramInfoId).getPdParamId());
				paramInfo.setPdParamName(paramInfoService.findById(ParamInfo.class, paramInfoId).getPdParamName());

				paraInfoMap.put("paramInfo",paramInfo);
				paraInfoMap.put("msg","get");

			}else {

				paraInfoMap.put("msg","no");		

			}


		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return SUCCESS;

	}



	public IParamInfoService getParamInfoService() {
		return paramInfoService;
	}






	public void setParamInfoService(IParamInfoService paramInfoService) {
		this.paramInfoService = paramInfoService;
	}






	public List<ParamInfo> getParamInfoList() {
		return paramInfoList;
	}






	public void setParamInfoList(List<ParamInfo> paramInfoList) {
		this.paramInfoList = paramInfoList;
	}






	public Map<String, Object> getDataMap() {
		return dataMap;
	}






	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}






	public Map<String, Object> getParaInfoMap() {
		return paraInfoMap;
	}






	public void setParaInfoMap(Map<String, Object> paraInfoMap) {
		this.paraInfoMap = paraInfoMap;
	}






	public Integer getParamInfoId() {
		return paramInfoId;
	}






	public void setParamInfoId(Integer paramInfoId) {
		this.paramInfoId = paramInfoId;
	}






	public String getParamName() {
		return paramName;
	}






	public void setParamName(String paramName) {
		this.paramName = paramName;
	}






	public String getParamValue() {
		return paramValue;
	}






	public void setParamValue(String paramValue) {
		this.paramValue = paramValue;
	}






	public Integer getPdParamId() {
		return pdParamId;
	}






	public void setPdParamId(Integer pdParamId) {
		this.pdParamId = pdParamId;
	}






	public String getPdParamName() {
		return pdParamName;
	}






	public void setPdParamName(String pdParamName) {
		this.pdParamName = pdParamName;
	}





    //获取ParamInfo对象
	public ParamInfo getParamInfo() {
		try {
			return this.paramInfo = paramInfoService.findById(ParamInfo.class, paramInfoId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return paramInfo;
	}






	public void setParamInfo(ParamInfo paramInfo) {
		this.paramInfo = paramInfo;
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



}
