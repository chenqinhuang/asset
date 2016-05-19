package com.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.entity.Dept;
import com.entity.PurchaseOrder;
import com.entity.User;
import com.opensymphony.xwork2.ActionSupport;
import com.service.IPurchaseService;
/**
 * 
 * @author hpp
 *
 */
public class PurchaseAction extends ActionSupport{
	
	private IPurchaseService purchaseService;
	private List<PurchaseOrder> purchaseOrderList;
	private static final long serialVersionUID = 1L;  
	private Map<String,Object> dataMap;  
	private Map<String,Object> purchaseOrderMap;  

	private Integer purchaseOrderId;
	
	private User user;
	private Integer  userId;
	private Dept dept;
	private Integer  deptId;
	
	private Date purchaseDate;
	private String purchaseUse;
	private Integer status;

	private PurchaseOrder purchaseOrder;
	public String msg;

	private int start; 
	private int length;
	
	
	//增加采购单
		public String addPurchaseOrder(){
			try {	

				PurchaseOrder purchaseOrder = new PurchaseOrder();
				User user = new User();
	        	Dept dept = new Dept();
	        	
	        	user.setUserId(userId);
	        	dept.setDeptId(deptId);

//				purchaseOrder.setPurchaseOrderId(purchaseOrderId);
				purchaseOrder.setUser(user);
				purchaseOrder.setDept(dept);
				purchaseOrder.setPurchaseDate(purchaseDate);
				purchaseOrder.setStatus(status);
				purchaseOrder.setPurchaseUse(purchaseUse);

				purchaseService.create(purchaseOrder);
                System.out.println("添加采购单成功！");
				msg="success";

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return SUCCESS;

		}




		//删除采购单
		public String deletePurchaseOrder(){
			try {
				//			deptService.deleteDept(getDept());
				purchaseService.delete(getPurchaseOrder());
				msg="delete";

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return SUCCESS;

		}

		



		//保存或更新采购单
		public String saveOrUpdatePurchaseOrder(){

			try {	

				PurchaseOrder purchaseOrder = new PurchaseOrder();
				User user = new User();
	        	Dept dept = new Dept();

				//        assType.setAsTypeId(asTypeId);

				if(purchaseOrderId!=null){

					user.setUserId(userId);
		        	dept.setDeptId(deptId);

					purchaseOrder.setPurchaseOrderId(purchaseOrderId);
					purchaseOrder.setUser(user);
					purchaseOrder.setDept(dept);
					purchaseOrder.setPurchaseDate(purchaseDate);
					purchaseOrder.setStatus(status);
					purchaseOrder.setPurchaseUse(purchaseUse);

					purchaseService.saveOrUpdate(purchaseOrder);
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




		//获取采购单列表
		public String getPurchaseList(){    

			this.purchaseOrderList = purchaseService.getList(PurchaseOrder.class);

			List<Object> aaData = new ArrayList<Object>();

			for(int i=0;i<this.purchaseOrderList.size();i++)
			{    
				PurchaseOrder purchaseOrder = new PurchaseOrder();
				
				User user = new User();
	        	Dept dept = new Dept();

	        	purchaseOrder.setPurchaseOrderId(this.purchaseOrderList.get(i).getPurchaseOrderId());
	        	
	        	user.setUserId(this.purchaseOrderList.get(i).getUser().getUserId());
	        	purchaseOrder.setUser(user);
	        	dept.setDeptId(this.purchaseOrderList.get(i).getDept().getDeptId());
	        	purchaseOrder.setDept(dept);
	        	
	        	purchaseOrder.setPurchaseDate(this.purchaseOrderList.get(i).getPurchaseDate());
	        	purchaseOrder.setPurchaseUse(this.purchaseOrderList.get(i).getPurchaseUse());
	        	purchaseOrder.setStatus(this.purchaseOrderList.get(i).getStatus());
	       
				aaData.add(purchaseOrder);  	
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
		public String getPurchaseOrderById(){

			purchaseOrderMap = new HashMap<String, Object>(); 
		
			PurchaseOrder purchaseOrder = new PurchaseOrder();
			User user = new User();
        	Dept dept = new Dept();

			try {

				if(purchaseOrderId!=null){


					purchaseOrder.setPurchaseOrderId(purchaseService.findById(PurchaseOrder.class, purchaseOrderId).getPurchaseOrderId());
					
					user.setUserId(purchaseService.findById(PurchaseOrder.class, purchaseOrderId).getUser().getUserId());
					purchaseOrder.setUser(user);
					dept.setDeptId(purchaseService.findById(PurchaseOrder.class, purchaseOrderId).getDept().getDeptId());
					purchaseOrder.setDept(dept);
					
					purchaseOrder.setPurchaseDate(purchaseService.findById(PurchaseOrder.class, purchaseOrderId).getPurchaseDate());
					purchaseOrder.setPurchaseUse(purchaseService.findById(PurchaseOrder.class, purchaseOrderId).getPurchaseUse());
					purchaseOrder.setStatus(purchaseService.findById(PurchaseOrder.class, purchaseOrderId).getStatus());
					
					
					purchaseOrderMap.put("purchaseOrderInfo",purchaseOrder);
					purchaseOrderMap.put("msg","get");

				}else {

					purchaseOrderMap.put("msg","no");		

				}


			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}

			return SUCCESS;

		}

		public IPurchaseService getPurchaseService() {
			return purchaseService;
		}




		public void setPurchaseService(IPurchaseService purchaseService) {
			this.purchaseService = purchaseService;
		}




		public List<PurchaseOrder> getPurchaseOrderList() {
			return purchaseOrderList;
		}




		public void setPurchaseOrderList(List<PurchaseOrder> purchaseOrderList) {
			this.purchaseOrderList = purchaseOrderList;
		}




		public Map<String, Object> getDataMap() {
			return dataMap;
		}




		public void setDataMap(Map<String, Object> dataMap) {
			this.dataMap = dataMap;
		}




		public Map<String, Object> getPurchaseOrderMap() {
			return purchaseOrderMap;
		}




		public void setPurchaseOrderMap(Map<String, Object> purchaseOrderMap) {
			this.purchaseOrderMap = purchaseOrderMap;
		}




		public Integer getPurchaseOrderId() {
			return purchaseOrderId;
		}




		public void setPurchaseOrderId(Integer purchaseOrderId) {
			this.purchaseOrderId = purchaseOrderId;
		}




		public User getUser() {
			return user;
		}




		public void setUser(User user) {
			this.user = user;
		}




		public Integer getUserId() {
			return userId;
		}




		public void setUserId(Integer userId) {
			this.userId = userId;
		}




		public Dept getDept() {
			return dept;
		}




		public void setDept(Dept dept) {
			this.dept = dept;
		}




		public Integer getDeptId() {
			return deptId;
		}




		public void setDeptId(Integer deptId) {
			this.deptId = deptId;
		}




		public Date getPurchaseDate() {
			return purchaseDate;
		}




		public void setPurchaseDate(Date purchaseDate) {
			this.purchaseDate = purchaseDate;
		}




		public String getPurchaseUse() {
			return purchaseUse;
		}




		public void setPurchaseUse(String purchaseUse) {
			this.purchaseUse = purchaseUse;
		}




		public Integer getStatus() {
			return status;
		}




		public void setStatus(Integer status) {
			this.status = status;
		}




		public PurchaseOrder getPurchaseOrder() {
			try {
				return this.purchaseOrder = purchaseService.findById(PurchaseOrder.class, purchaseOrderId);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return purchaseOrder;
		}




		public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
			this.purchaseOrder = purchaseOrder;
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
