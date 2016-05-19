package com.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.entity.Ass;
import com.entity.AssType;
import com.entity.Dept;
import com.entity.PurchaseOrderDetail;
import com.entity.User;
import com.opensymphony.xwork2.ActionSupport;
import com.service.IAssetService;
import com.service.IPurchaseDetailService;

public class AssAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private IAssetService assetService;
	private List<Ass> assList;
	private Map<String,Object> dataMap;  
	
	//资产入库所需参数
	private List<PurchaseOrderDetail> purchaseOrderDetailList;
	private IPurchaseDetailService purchaseDetailService;
	private Integer purchaseOrderId;
	
	//数据库字段start
	private Integer asId;
	private AssType assTypeByAsTypeId;
	private AssType assTypeByPdAsTypeId;
	private User userByStoremanId;
	private PurchaseOrderDetail purchaseOrderDetail;
	private Dept deptByUserDeptId;
	private Dept deptByBuyDeptId;
	private User userByFinanceManId;
	private String cardNo;
	private Integer useStatus;
	private Integer inStatue;
	private Integer isInBill;
	private String specificationsModels;
	private String assName;
	private Date financeBiiDate;
	private String financeCode;
	private String assCode;
	private String manufacturer;
	private String supplier;
	private Date inWarehouseDate;
	private String unit;
	private Integer amount;
	private String remark;
	private long price;
	private Integer isPrint;
	private String oneLabelPath;
	private String barCode;
	//数据库字段end
	
	private int start; 
    private int length;
	
	public String msg;
	
	
	//资产入库
	public String addAsset(){
		
		Date timeNowDate = new Date();
		System.out.println("进得来吗1");
		try {	
			
			this.purchaseOrderDetailList = purchaseDetailService.getList(PurchaseOrderDetail.class);
			System.out.println("进得来吗2");
			for(int i=0;i<this.purchaseOrderDetailList.size();i++)
			{    
				System.out.println("进得来吗3");
				if(purchaseOrderId!=null&&purchaseOrderId.equals(this.purchaseOrderDetailList.get(i).getPurchaseOrder().getPurchaseOrderId())){
					System.out.println("进得来吗4");
					if(this.purchaseOrderDetailList.get(i).getAmount()>0){
						System.out.println("进得来吗5");
						for(int j=0;j<this.purchaseOrderDetailList.get(i).getAmount();j++){
							System.out.println("进得来吗6");
							Ass ass = new Ass();
							Dept dept = new Dept();
							User user = new User();
							AssType assType = new AssType();
							PurchaseOrderDetail purchaseOrderDetail = new PurchaseOrderDetail();
							
							
							//资产类别Id
				        	assType.setAsTypeId(this.purchaseOrderDetailList.get(i).getAssTypeByAsTypeId().getAsTypeId());
				        	ass.setAssTypeByAsTypeId(assType);
				        	//上级资产类别Id
				        	assType.setPdAsTypeId(this.purchaseOrderDetailList.get(i).getAssTypeByPdAsTypeId().getPdAsTypeId());
				        	ass.setAssTypeByPdAsTypeId(assType);
				        	//采购单明细Id
				        	purchaseOrderDetail.setPurchaseOrderDetailId(this.purchaseOrderDetailList.get(i).getPurchaseOrderDetailId());
				        	ass.setPurchaseOrderDetail(purchaseOrderDetail);
				        	//采购部门Id
							dept.setDeptId(this.purchaseOrderDetailList.get(i).getAssTypeByPdAsTypeId().getAsTypeId());
							ass.setDeptByBuyDeptId(dept);
				        	//使用人部门Id
				        	dept.setDeptId(this.purchaseOrderDetailList.get(i).getAssTypeByAsTypeId().getAsTypeId());
				        	ass.setDeptByUserDeptId(dept);
				        	//保管人Id
				        	user.setUserId(this.purchaseOrderDetailList.get(i).getUser().getUserId());
				        	ass.setUserByStoremanId(user);
				        	//财务入账人Id
				        	user.setUserId(this.purchaseOrderDetailList.get(i).getUser().getUserId());
				        	ass.setUserByFinanceManId(user);
							
							
							
//							ass.setAssTypeByAsTypeId(this.purchaseOrderDetailList.get(i).getAssTypeByAsTypeId());
							
							ass.setSupplier(this.purchaseOrderDetailList.get(i).getSupplier());
							System.out.println("供应商是："+this.purchaseOrderDetailList.get(i).getSupplier());
							ass.setManufacturer(this.purchaseOrderDetailList.get(i).getManufacturer());
							ass.setPrice(this.purchaseOrderDetailList.get(i).getPrice());
							ass.setAmount(1);
							ass.setRemark(this.purchaseOrderDetailList.get(i).getRemark());
							ass.setAssName(this.purchaseOrderDetailList.get(i).getAssName());
							ass.setUnit(this.purchaseOrderDetailList.get(i).getUnit());
							ass.setInWarehouseDate(timeNowDate);
							assetService.create(ass);
							msg="success";
						}
					}
				}
			
			}
			

			

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return SUCCESS;
	    
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//获取资产列表
			public String assetList(){    

				this.assList = assetService.getList(Ass.class);

				List<Object> aaData = new ArrayList<Object>();

				for(int i=0;i<this.assList.size();i++)
				{    
					Ass asset = new Ass();
					
					AssType assType = new AssType();
					PurchaseOrderDetail purchaseOrderDetail = new PurchaseOrderDetail();
					
					User user = new User();
		        	Dept dept = new Dept();

		        	asset.setAsId(this.assList.get(i).getAsId());
		        	
		        	//资产类别Id
		        	assType.setAsTypeId(this.assList.get(i).getAssTypeByAsTypeId().getAsTypeId());
		        	asset.setAssTypeByAsTypeId(assType);
		        	//上级资产类别Id
		        	assType.setPdAsTypeId(this.assList.get(i).getAssTypeByPdAsTypeId().getPdAsTypeId());
		        	asset.setAssTypeByPdAsTypeId(assType);
		        	//采购单明细Id
		        	purchaseOrderDetail.setPurchaseOrderDetailId(this.assList.get(i).getPurchaseOrderDetail().getPurchaseOrderDetailId());
		        	asset.setPurchaseOrderDetail(purchaseOrderDetail);
		        	//采购部门Id
		        	dept.setDeptId(this.assList.get(i).getDeptByBuyDeptId().getDeptId());
		        	asset.setDeptByBuyDeptId(dept);
		        	//使用人部门Id
		        	dept.setDeptId(this.assList.get(i).getDeptByUserDeptId().getDeptId());
		        	asset.setDeptByUserDeptId(dept);
		        	//保管人Id
		        	user.setUserId(this.assList.get(i).getUserByStoremanId().getUserId());
		        	asset.setUserByStoremanId(user);
		        	//财务入账人Id
		        	user.setUserId(this.assList.get(i).getUserByFinanceManId().getUserId());
		        	asset.setUserByFinanceManId(user);
		        	
		        	asset.setCardNo(this.assList.get(i).getCardNo());
		        	asset.setUseStatus(this.assList.get(i).getUseStatus());
		        	asset.setInStatue(this.assList.get(i).getInStatue());
		        	asset.setIsInBill(this.assList.get(i).getIsInBill());
		        	asset.setSpecificationsModels(this.assList.get(i).getSpecificationsModels());
		        	asset.setAssName(this.assList.get(i).getAssName());
		        	asset.setFinanceBiiDate(this.assList.get(i).getFinanceBiiDate());
		        	asset.setFinanceCode(this.assList.get(i).getFinanceCode());
		        	asset.setManufacturer(this.assList.get(i).getManufacturer());
		        	asset.setSupplier(this.assList.get(i).getSupplier());
		        	asset.setInWarehouseDate(this.assList.get(i).getInWarehouseDate());
		        	asset.setUnit(this.assList.get(i).getUnit());
		        	asset.setAmount(this.assList.get(i).getAmount());
		        	asset.setRemark(this.assList.get(i).getRemark());
		        	asset.setPrice(this.assList.get(i).getPrice());
		        	asset.setIsPrint(this.assList.get(i).getIsPrint());
		        	asset.setOneLabelPath(this.assList.get(i).getOneLabelPath());
		        	asset.setBarCode(this.assList.get(i).getBarCode());
		       
					aaData.add(asset);  	
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
			
			
			
			
			
			
			
			
			

			public IAssetService getAssetService() {
				return assetService;
			}

			public void setAssetService(IAssetService assetService) {
				this.assetService = assetService;
			}

			public List<Ass> getAssList() {
				return assList;
			}

			public void setAssList(List<Ass> assList) {
				this.assList = assList;
			}

			public Map<String, Object> getDataMap() {
				return dataMap;
			}

			public void setDataMap(Map<String, Object> dataMap) {
				this.dataMap = dataMap;
			}

			public Integer getAsId() {
				return asId;
			}

			public void setAsId(Integer asId) {
				this.asId = asId;
			}

			public AssType getAssTypeByAsTypeId() {
				return assTypeByAsTypeId;
			}

			public void setAssTypeByAsTypeId(AssType assTypeByAsTypeId) {
				this.assTypeByAsTypeId = assTypeByAsTypeId;
			}

			public AssType getAssTypeByPdAsTypeId() {
				return assTypeByPdAsTypeId;
			}

			public void setAssTypeByPdAsTypeId(AssType assTypeByPdAsTypeId) {
				this.assTypeByPdAsTypeId = assTypeByPdAsTypeId;
			}

			public User getUserByStoremanId() {
				return userByStoremanId;
			}

			public void setUserByStoremanId(User userByStoremanId) {
				this.userByStoremanId = userByStoremanId;
			}

			public PurchaseOrderDetail getPurchaseOrderDetail() {
				return purchaseOrderDetail;
			}

			public void setPurchaseOrderDetail(PurchaseOrderDetail purchaseOrderDetail) {
				this.purchaseOrderDetail = purchaseOrderDetail;
			}

			public Dept getDeptByUserDeptId() {
				return deptByUserDeptId;
			}

			public void setDeptByUserDeptId(Dept deptByUserDeptId) {
				this.deptByUserDeptId = deptByUserDeptId;
			}

			public Dept getDeptByBuyDeptId() {
				return deptByBuyDeptId;
			}

			public void setDeptByBuyDeptId(Dept deptByBuyDeptId) {
				this.deptByBuyDeptId = deptByBuyDeptId;
			}

			public User getUserByFinanceManId() {
				return userByFinanceManId;
			}

			public void setUserByFinanceManId(User userByFinanceManId) {
				this.userByFinanceManId = userByFinanceManId;
			}

			public String getCardNo() {
				return cardNo;
			}

			public void setCardNo(String cardNo) {
				this.cardNo = cardNo;
			}

			public Integer getUseStatus() {
				return useStatus;
			}

			public void setUseStatus(Integer useStatus) {
				this.useStatus = useStatus;
			}

			public Integer getInStatue() {
				return inStatue;
			}

			public void setInStatue(Integer inStatue) {
				this.inStatue = inStatue;
			}

			public Integer getIsInBill() {
				return isInBill;
			}

			public void setIsInBill(Integer isInBill) {
				this.isInBill = isInBill;
			}

			public String getSpecificationsModels() {
				return specificationsModels;
			}

			public void setSpecificationsModels(String specificationsModels) {
				this.specificationsModels = specificationsModels;
			}

			public String getAssName() {
				return assName;
			}

			public void setAssName(String assName) {
				this.assName = assName;
			}

			public Date getFinanceBiiDate() {
				return financeBiiDate;
			}

			public void setFinanceBiiDate(Date financeBiiDate) {
				this.financeBiiDate = financeBiiDate;
			}

			public String getFinanceCode() {
				return financeCode;
			}

			public void setFinanceCode(String financeCode) {
				this.financeCode = financeCode;
			}

			public String getAssCode() {
				return assCode;
			}

			public void setAssCode(String assCode) {
				this.assCode = assCode;
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

			public Date getInWarehouseDate() {
				return inWarehouseDate;
			}

			public void setInWarehouseDate(Date inWarehouseDate) {
				this.inWarehouseDate = inWarehouseDate;
			}

			public String getUnit() {
				return unit;
			}

			public void setUnit(String unit) {
				this.unit = unit;
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

			public long getPrice() {
				return price;
			}

			public void setPrice(long price) {
				this.price = price;
			}

			public Integer getIsPrint() {
				return isPrint;
			}

			public void setIsPrint(Integer isPrint) {
				this.isPrint = isPrint;
			}

			public String getOneLabelPath() {
				return oneLabelPath;
			}

			public void setOneLabelPath(String oneLabelPath) {
				this.oneLabelPath = oneLabelPath;
			}

			public String getBarCode() {
				return barCode;
			}

			public void setBarCode(String barCode) {
				this.barCode = barCode;
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

			public String getMsg() {
				return msg;
			}

			public void setMsg(String msg) {
				this.msg = msg;
			}
			
			public static long getSerialversionuid() {
				return serialVersionUID;
			}


			public List<PurchaseOrderDetail> getPurchaseOrderDetailList() {
				return purchaseOrderDetailList;
			}



			public void setPurchaseOrderDetailList(
					List<PurchaseOrderDetail> purchaseOrderDetailList) {
				this.purchaseOrderDetailList = purchaseOrderDetailList;
			}


			public IPurchaseDetailService getPurchaseDetailService() {
				return purchaseDetailService;
			}






			public void setPurchaseDetailService(
					IPurchaseDetailService purchaseDetailService) {
				this.purchaseDetailService = purchaseDetailService;
			}








			public Integer getPurchaseOrderId() {
				return purchaseOrderId;
			}


			public void setPurchaseOrderId(Integer purchaseOrderId) {
				this.purchaseOrderId = purchaseOrderId;
			}
	
	
}
