package com.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import com.entity.AssType;
import com.entity.Dept;
import com.entity.PurchaseOrder;
import com.entity.PurchaseOrderDetail;
import com.entity.User;
import com.opensymphony.xwork2.ActionSupport;
import com.service.IPurchaseDetailService;

public class PurchaseDetailAction extends ActionSupport{

	private IPurchaseDetailService purchaseDetailService;
	private List<PurchaseOrderDetail> purchaseOrderDetailList;
	private static final long serialVersionUID = 1L;  
	private Map<String,Object> dataMap;  
	private Map<String,Object> purchaseOrderDetailMap;  
	
	private Integer purchaseOrderDetailId;
	//fk1
	private AssType assTypeByAsTypeId;
	private Integer asTypeId;
	//fk2
	private PurchaseOrder purchaseOrder;
	private Integer purchaseOrderId;
	//fk3
	private AssType assTypeByPdAsTypeId;
//	private Integer pdAsTypeId;
	//fk4
	private User user;
	private Integer userId;
	
	private String unit;
	private String assType;
	

	private String assName;
	private Integer amount;
	private String remark;
	private String manufacturer;
	private String supplier;
	private long price;
	
	
	private PurchaseOrderDetail purchaseOrderDetail;
	public String msg;

	private int start; 
	private int length;
	
	
	
	//增加采购单详情
			public String addPurchaseOrderDetail(){
				try {	

					PurchaseOrderDetail purchaseOrderDetail = new PurchaseOrderDetail();
					AssType assTypeInfo = new AssType();
					PurchaseOrder purchaseOrder = new PurchaseOrder();
					User user = new User();
		        	
		        	
		        	purchaseOrderDetail.setPurchaseOrderDetailId(purchaseOrderDetailId);
		        	
		        	assTypeInfo.setAsTypeId(asTypeId);
//		        	assTypeInfo.setPdAsTypeId(pdAsTypeId);
		        	
		        	purchaseOrder.setPurchaseOrderId(purchaseOrderId);
		        	user.setUserId(userId);
		        	// 有点问题！！
		        	purchaseOrderDetail.setAssTypeByAsTypeId(assTypeInfo);
		        	purchaseOrderDetail.setAssTypeByPdAsTypeId(assTypeInfo);
		        	
		        	purchaseOrderDetail.setUser(user);
		        	purchaseOrderDetail.setPurchaseOrder(purchaseOrder);
		      
		        	purchaseOrderDetail.setUnit(unit);
		        	purchaseOrderDetail.setAssType(assType);
		        	purchaseOrderDetail.setAssName(assName);
		        	purchaseOrderDetail.setAmount(amount);
		        	purchaseOrderDetail.setRemark(remark);
		        	purchaseOrderDetail.setManufacturer(manufacturer);
		        	purchaseOrderDetail.setSupplier(supplier);
		        	purchaseOrderDetail.setPrice(price);
		        	
		        	
					purchaseDetailService.create(purchaseOrderDetail);

					msg="success";

				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				return SUCCESS;

			}




			//删除采购单详情
			public String deletePurchaseOrderDetail(){
				try {
					//			deptService.deleteDept(getDept());
					purchaseDetailService.delete(getPurchaseOrderDetail());
					msg="delete";

				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				return SUCCESS;

			}

			



			//保存或更新采购单详情
			public String saveOrUpdatePurchaseOrderDetail(){

				try {	

					PurchaseOrderDetail purchaseOrderDetail = new PurchaseOrderDetail();
					AssType assTypeInfo = new AssType();
					PurchaseOrder purchaseOrder = new PurchaseOrder();
					User user = new User();
		        	

					if(purchaseOrderDetailId!=null){

						purchaseOrderDetail.setPurchaseOrderDetailId(purchaseOrderDetailId);
						
						purchaseOrder.setPurchaseOrderId(purchaseOrderId);
						purchaseOrderDetail.setPurchaseOrder(purchaseOrder);
						
						assTypeInfo.setAsTypeId(asTypeId);
						purchaseOrderDetail.setAssTypeByAsTypeId(assTypeInfo);
						
//						assTypeInfo.setPdAsTypeId(pdAsTypeId);
						purchaseOrderDetail.setAssTypeByPdAsTypeId(assTypeInfo);
						
						user.setUserId(userId);
						purchaseOrderDetail.setUser(user);
			        	
						purchaseOrderDetail.setUnit(unit);
						purchaseOrderDetail.setAssType(assType);
						purchaseOrderDetail.setAssName(assName);
						purchaseOrderDetail.setAmount(amount);
						purchaseOrderDetail.setRemark(remark);
						purchaseOrderDetail.setManufacturer(manufacturer);
						purchaseOrderDetail.setSupplier(supplier);
						purchaseOrderDetail.setPrice(price);

						purchaseDetailService.saveOrUpdate(purchaseOrderDetail);
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




			//获取采购单详情列表(根据采购单Id)
			@JSON(serialize=false)
			public String getPurchaseOrderDetailList(){    

				this.purchaseOrderDetailList = purchaseDetailService.getList(PurchaseOrderDetail.class);

				List<Object> aaData = new ArrayList<Object>();

				for(int i=0;i<this.purchaseOrderDetailList.size();i++)
				{    
					
					if(purchaseOrderId!=null&&purchaseOrderId.equals(this.purchaseOrderDetailList.get(i).getPurchaseOrder().getPurchaseOrderId())){
						
						PurchaseOrderDetail purchaseOrderDetail = new PurchaseOrderDetail();
						AssType assTypeInfo = new AssType();
						AssType assTypeInfo2 = new AssType();
						PurchaseOrder purchaseOrder = new PurchaseOrder();
						User user = new User();

						purchaseOrderDetail.setPurchaseOrderDetailId(this.purchaseOrderDetailList.get(i).getPurchaseOrderDetailId());
						
						purchaseOrder.setPurchaseOrderId(this.purchaseOrderDetailList.get(i).getPurchaseOrder().getPurchaseOrderId());
						purchaseOrderDetail.setPurchaseOrder(purchaseOrder);
						
			        	user.setUserId(this.purchaseOrderDetailList.get(i).getUser().getUserId());
			        	purchaseOrderDetail.setUser(user);
			        	
			        	assTypeInfo.setAsTypeId(this.purchaseOrderDetailList.get(i).getAssTypeByAsTypeId().getAsTypeId()); 
			        	assTypeInfo.setPdAsTypeId(this.purchaseOrderDetailList.get(i).getAssTypeByPdAsTypeId().getPdAsTypeId());
			        	
			        	purchaseOrderDetail.setAssTypeByAsTypeId(assTypeInfo);
//			        	purchaseOrderDetail.setAssTypeByAsTypeId(assTypeInfo);
			        	
			        	
			        	
			        	purchaseOrderDetail.setAssTypeByPdAsTypeId(assTypeInfo);
			        	
			        	purchaseOrderDetail.setUnit(this.purchaseOrderDetailList.get(i).getUnit());
			        	purchaseOrderDetail.setAssType(this.purchaseOrderDetailList.get(i).getAssType());
			        	purchaseOrderDetail.setAssName(this.purchaseOrderDetailList.get(i).getAssName());
			        	purchaseOrderDetail.setAmount(this.purchaseOrderDetailList.get(i).getAmount());
			        	purchaseOrderDetail.setRemark(this.purchaseOrderDetailList.get(i).getRemark());
			        	purchaseOrderDetail.setManufacturer(this.purchaseOrderDetailList.get(i).getManufacturer());
			        	purchaseOrderDetail.setSupplier(this.purchaseOrderDetailList.get(i).getSupplier());
			        	purchaseOrderDetail.setPrice(this.purchaseOrderDetailList.get(i).getPrice());
			        	
						aaData.add(purchaseOrderDetail);  
						msg="success";
					}else {
						msg="fail";
					}
					
					
					
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
				dataMap.put("msg", msg); 
				dataMap.put("recordsTotal", recordsTotal); 
				dataMap.put("recordsFiltered", recordsFiltered); 
				// 返回结果  
				return SUCCESS;  
			}



			//获取单条记录
			public String getPurchaseOrderDetailById(){

				purchaseOrderDetailMap = new HashMap<String, Object>(); 
			
				PurchaseOrderDetail purchaseOrderDetail = new PurchaseOrderDetail();
				AssType assTypeInfo = new AssType();
				PurchaseOrder purchaseOrder = new PurchaseOrder();
				User user = new User();

				try {

					if(purchaseOrderDetailId!=null){

						purchaseOrderDetail.setPurchaseOrderDetailId(purchaseDetailService.findById(PurchaseOrderDetail.class, purchaseOrderDetailId).getPurchaseOrderDetailId());
						
						purchaseOrder.setPurchaseOrderId(purchaseDetailService.findById(PurchaseOrderDetail.class, purchaseOrderDetailId).getPurchaseOrder().getPurchaseOrderId());
						purchaseOrderDetail.setPurchaseOrder(purchaseOrder);
						
//						assTypeInfo.setAsTypeId(purchaseDetailService.findById(PurchaseOrderDetail.class, purchaseOrderDetailId).getAssType());
						
						user.setUserId(purchaseDetailService.findById(PurchaseOrderDetail.class, purchaseOrderId).getUser().getUserId());
						purchaseOrderDetail.setUser(user);
						
						purchaseOrderDetail.setAssTypeByAsTypeId(purchaseDetailService.findById(PurchaseOrderDetail.class, purchaseOrderId).getAssTypeByAsTypeId());
						purchaseOrderDetail.setAssTypeByPdAsTypeId(purchaseDetailService.findById(PurchaseOrderDetail.class, purchaseOrderId).getAssTypeByPdAsTypeId());
						
						purchaseOrderDetail.setUnit(purchaseDetailService.findById(PurchaseOrderDetail.class, purchaseOrderId).getUnit());
						purchaseOrderDetail.setAssType(purchaseDetailService.findById(PurchaseOrderDetail.class, purchaseOrderId).getAssType());
						purchaseOrderDetail.setAssName(purchaseDetailService.findById(PurchaseOrderDetail.class, purchaseOrderId).getAssName());
						purchaseOrderDetail.setAmount(purchaseDetailService.findById(PurchaseOrderDetail.class, purchaseOrderId).getAmount());
						purchaseOrderDetail.setRemark(purchaseDetailService.findById(PurchaseOrderDetail.class, purchaseOrderId).getRemark());
						purchaseOrderDetail.setManufacturer(purchaseDetailService.findById(PurchaseOrderDetail.class, purchaseOrderId).getManufacturer());
						purchaseOrderDetail.setSupplier(purchaseDetailService.findById(PurchaseOrderDetail.class, purchaseOrderId).getSupplier());
						purchaseOrderDetail.setPrice(purchaseDetailService.findById(PurchaseOrderDetail.class, purchaseOrderId).getPrice());
						
						
						
						purchaseOrderDetailMap.put("purchaseDetailInfo",purchaseOrderDetail);
						purchaseOrderDetailMap.put("msg","get");

					}else {

						purchaseOrderDetailMap.put("msg","no");		

					}


				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}

				return SUCCESS;

			}






			public void setPurchaseDetailService(
					IPurchaseDetailService purchaseDetailService) {
				this.purchaseDetailService = purchaseDetailService;
			}




			public Map<String, Object> getDataMap() {
				return dataMap;
			}




			public void setDataMap(Map<String, Object> dataMap) {
				this.dataMap = dataMap;
			}




			public Map<String, Object> getPurchaseOrderDetailMap() {
				return purchaseOrderDetailMap;
			}




			public void setPurchaseOrderDetailMap(Map<String, Object> purchaseOrderDetailMap) {
				this.purchaseOrderDetailMap = purchaseOrderDetailMap;
			}




			public Integer getPurchaseOrderDetailId() {
				return purchaseOrderDetailId;
			}




			public void setPurchaseOrderDetailId(Integer purchaseOrderDetailId) {
				this.purchaseOrderDetailId = purchaseOrderDetailId;
			}




			public AssType getAssTypeByAsTypeId() {
				return assTypeByAsTypeId;
			}




			public void setAssTypeByAsTypeId(AssType assTypeByAsTypeId) {
				this.assTypeByAsTypeId = assTypeByAsTypeId;
			}




			public Integer getAsTypeId() {
				return asTypeId;
			}




			public void setAsTypeId(Integer asTypeId) {
				this.asTypeId = asTypeId;
			}




			public PurchaseOrder getPurchaseOrder() {
				return purchaseOrder;
			}




			public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
				this.purchaseOrder = purchaseOrder;
			}




			public Integer getPurchaseOrderId() {
				return purchaseOrderId;
			}




			public void setPurchaseOrderId(Integer purchaseOrderId) {
				this.purchaseOrderId = purchaseOrderId;
			}




			public AssType getAssTypeByPdAsTypeId() {
				return assTypeByPdAsTypeId;
			}




			public void setAssTypeByPdAsTypeId(AssType assTypeByPdAsTypeId) {
				this.assTypeByPdAsTypeId = assTypeByPdAsTypeId;
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




			public String getUnit() {
				return unit;
			}




			public void setUnit(String unit) {
				this.unit = unit;
			}




			public String getAssType() {
				return assType;
			}




			public void setAssType(String assType) {
				this.assType = assType;
			}




			public String getAssName() {
				return assName;
			}




			public void setAssName(String assName) {
				this.assName = assName;
			}




			public Integer getAmount() {
				return amount;
			}




			public void setAmount(Integer amount) {
				this.amount = amount;
			}




			public String getRemark() {
				return remark;
			}




			public void setRemark(String remark) {
				this.remark = remark;
			}




			public String getManufacturer() {
				return manufacturer;
			}




			public void setManufacturer(String manufacturer) {
				this.manufacturer = manufacturer;
			}




			public String getSupplier() {
				return supplier;
			}




			public void setSupplier(String supplier) {
				this.supplier = supplier;
			}




			public long getPrice() {
				return price;
			}




			public void setPrice(long price) {
				this.price = price;
			}




			public PurchaseOrderDetail getPurchaseOrderDetail() {
//				return this.purchaseOrderDetail;
				
				try {
					return this.purchaseOrderDetail = purchaseDetailService.findById(PurchaseOrderDetail.class, purchaseOrderDetailId);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return purchaseOrderDetail;
			}




			public void setPurchaseOrderDetail(PurchaseOrderDetail purchaseOrderDetail) {
				this.purchaseOrderDetail = purchaseOrderDetail;
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




			public void setPurchaseOrderDetailList(
					List<PurchaseOrderDetail> purchaseOrderDetailList) {
				this.purchaseOrderDetailList = purchaseOrderDetailList;
			}


	
	
}
