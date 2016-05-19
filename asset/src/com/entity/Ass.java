package com.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Ass entity. @author MyEclipse Persistence Tools
 */

public class Ass implements java.io.Serializable {

	// Fields

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
	private Set checkDetails = new HashSet(0);
	private Set allocateOrders = new HashSet(0);
	private Set asReturns = new HashSet(0);
	private Set asMaintains = new HashSet(0);
	private Set retirements = new HashSet(0);
	private Set asTransferOrders = new HashSet(0);

	// Constructors

	/** default constructor */
	public Ass() {
	}

	/** full constructor */
	public Ass(AssType assTypeByAsTypeId, AssType assTypeByPdAsTypeId,
			User userByStoremanId, PurchaseOrderDetail purchaseOrderDetail,
			Dept deptByUserDeptId, Dept deptByBuyDeptId,
			User userByFinanceManId, String cardNo, Integer useStatus,
			Integer inStatue, Integer isInBill, String specificationsModels,
			String assName, Date financeBiiDate, String financeCode,
			String assCode, String manufacturer, String supplier,
			Date inWarehouseDate, String unit, Integer amount, String remark,
			long price, Integer isPrint, String oneLabelPath, String barCode,
			Set checkDetails, Set allocateOrders, Set asReturns,
			Set asMaintains, Set retirements, Set asTransferOrders) {
		this.assTypeByAsTypeId = assTypeByAsTypeId;
		this.assTypeByPdAsTypeId = assTypeByPdAsTypeId;
		this.userByStoremanId = userByStoremanId;
		this.purchaseOrderDetail = purchaseOrderDetail;
		this.deptByUserDeptId = deptByUserDeptId;
		this.deptByBuyDeptId = deptByBuyDeptId;
		this.userByFinanceManId = userByFinanceManId;
		this.cardNo = cardNo;
		this.useStatus = useStatus;
		this.inStatue = inStatue;
		this.isInBill = isInBill;
		this.specificationsModels = specificationsModels;
		this.assName = assName;
		this.financeBiiDate = financeBiiDate;
		this.financeCode = financeCode;
		this.assCode = assCode;
		this.manufacturer = manufacturer;
		this.supplier = supplier;
		this.inWarehouseDate = inWarehouseDate;
		this.unit = unit;
		this.amount = amount;
		this.remark = remark;
		this.price = price;
		this.isPrint = isPrint;
		this.oneLabelPath = oneLabelPath;
		this.barCode = barCode;
		this.checkDetails = checkDetails;
		this.allocateOrders = allocateOrders;
		this.asReturns = asReturns;
		this.asMaintains = asMaintains;
		this.retirements = retirements;
		this.asTransferOrders = asTransferOrders;
	}

	// Property accessors

	public Integer getAsId() {
		return this.asId;
	}

	public void setAsId(Integer asId) {
		this.asId = asId;
	}

	public AssType getAssTypeByAsTypeId() {
		return this.assTypeByAsTypeId;
	}

	public void setAssTypeByAsTypeId(AssType assTypeByAsTypeId) {
		this.assTypeByAsTypeId = assTypeByAsTypeId;
	}

	public AssType getAssTypeByPdAsTypeId() {
		return this.assTypeByPdAsTypeId;
	}

	public void setAssTypeByPdAsTypeId(AssType assTypeByPdAsTypeId) {
		this.assTypeByPdAsTypeId = assTypeByPdAsTypeId;
	}

	public User getUserByStoremanId() {
		return this.userByStoremanId;
	}

	public void setUserByStoremanId(User userByStoremanId) {
		this.userByStoremanId = userByStoremanId;
	}

	public PurchaseOrderDetail getPurchaseOrderDetail() {
		return this.purchaseOrderDetail;
	}

	public void setPurchaseOrderDetail(PurchaseOrderDetail purchaseOrderDetail) {
		this.purchaseOrderDetail = purchaseOrderDetail;
	}

	public Dept getDeptByUserDeptId() {
		return this.deptByUserDeptId;
	}

	public void setDeptByUserDeptId(Dept deptByUserDeptId) {
		this.deptByUserDeptId = deptByUserDeptId;
	}

	public Dept getDeptByBuyDeptId() {
		return this.deptByBuyDeptId;
	}

	public void setDeptByBuyDeptId(Dept deptByBuyDeptId) {
		this.deptByBuyDeptId = deptByBuyDeptId;
	}

	public User getUserByFinanceManId() {
		return this.userByFinanceManId;
	}

	public void setUserByFinanceManId(User userByFinanceManId) {
		this.userByFinanceManId = userByFinanceManId;
	}

	public String getCardNo() {
		return this.cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public Integer getUseStatus() {
		return this.useStatus;
	}

	public void setUseStatus(Integer useStatus) {
		this.useStatus = useStatus;
	}

	public Integer getInStatue() {
		return this.inStatue;
	}

	public void setInStatue(Integer inStatue) {
		this.inStatue = inStatue;
	}

	public Integer getIsInBill() {
		return this.isInBill;
	}

	public void setIsInBill(Integer isInBill) {
		this.isInBill = isInBill;
	}

	public String getSpecificationsModels() {
		return this.specificationsModels;
	}

	public void setSpecificationsModels(String specificationsModels) {
		this.specificationsModels = specificationsModels;
	}

	public String getAssName() {
		return this.assName;
	}

	public void setAssName(String assName) {
		this.assName = assName;
	}

	public Date getFinanceBiiDate() {
		return this.financeBiiDate;
	}

	public void setFinanceBiiDate(Date financeBiiDate) {
		this.financeBiiDate = financeBiiDate;
	}

	public String getFinanceCode() {
		return this.financeCode;
	}

	public void setFinanceCode(String financeCode) {
		this.financeCode = financeCode;
	}

	public String getAssCode() {
		return this.assCode;
	}

	public void setAssCode(String assCode) {
		this.assCode = assCode;
	}

	public String getManufacturer() {
		return this.manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getSupplier() {
		return this.supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public Date getInWarehouseDate() {
		return this.inWarehouseDate;
	}

	public void setInWarehouseDate(Date inWarehouseDate) {
		this.inWarehouseDate = inWarehouseDate;
	}

	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Integer getAmount() {
		return this.amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public long getPrice() {
		return this.price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public Integer getIsPrint() {
		return this.isPrint;
	}

	public void setIsPrint(Integer isPrint) {
		this.isPrint = isPrint;
	}

	public String getOneLabelPath() {
		return this.oneLabelPath;
	}

	public void setOneLabelPath(String oneLabelPath) {
		this.oneLabelPath = oneLabelPath;
	}

	public String getBarCode() {
		return this.barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	public Set getCheckDetails() {
		return this.checkDetails;
	}

	public void setCheckDetails(Set checkDetails) {
		this.checkDetails = checkDetails;
	}

	public Set getAllocateOrders() {
		return this.allocateOrders;
	}

	public void setAllocateOrders(Set allocateOrders) {
		this.allocateOrders = allocateOrders;
	}

	public Set getAsReturns() {
		return this.asReturns;
	}

	public void setAsReturns(Set asReturns) {
		this.asReturns = asReturns;
	}

	public Set getAsMaintains() {
		return this.asMaintains;
	}

	public void setAsMaintains(Set asMaintains) {
		this.asMaintains = asMaintains;
	}

	public Set getRetirements() {
		return this.retirements;
	}

	public void setRetirements(Set retirements) {
		this.retirements = retirements;
	}

	public Set getAsTransferOrders() {
		return this.asTransferOrders;
	}

	public void setAsTransferOrders(Set asTransferOrders) {
		this.asTransferOrders = asTransferOrders;
	}

}