package com.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * PurchaseOrderDetail entity. @author MyEclipse Persistence Tools
 */

public class PurchaseOrderDetail implements java.io.Serializable {

	// Fields

	private Integer purchaseOrderDetailId;
	private AssType assTypeByAsTypeId;
	private PurchaseOrder purchaseOrder;
	private AssType assTypeByPdAsTypeId;
	private User user;
	private String unit;
	private String assType;
	private String assName;
	private Integer amount;
	private String remark;
	private String manufacturer;
	private String supplier;
	private long price;
	private Set asses = new HashSet(0);

	// Constructors

	/** default constructor */
	public PurchaseOrderDetail() {
	}

	/** full constructor */
	public PurchaseOrderDetail(AssType assTypeByAsTypeId,
			PurchaseOrder purchaseOrder, AssType assTypeByPdAsTypeId,
			User user, String unit, String assType, String assName,
			Integer amount, String remark, String manufacturer,
			String supplier, long price, Set asses) {
		this.assTypeByAsTypeId = assTypeByAsTypeId;
		this.purchaseOrder = purchaseOrder;
		this.assTypeByPdAsTypeId = assTypeByPdAsTypeId;
		this.user = user;
		this.unit = unit;
		this.assType = assType;
		this.assName = assName;
		this.amount = amount;
		this.remark = remark;
		this.manufacturer = manufacturer;
		this.supplier = supplier;
		this.price = price;
		this.asses = asses;
	}

	// Property accessors

	public Integer getPurchaseOrderDetailId() {
		return this.purchaseOrderDetailId;
	}

	public void setPurchaseOrderDetailId(Integer purchaseOrderDetailId) {
		this.purchaseOrderDetailId = purchaseOrderDetailId;
	}

	public AssType getAssTypeByAsTypeId() {
		return this.assTypeByAsTypeId;
	}

	public void setAssTypeByAsTypeId(AssType assTypeByAsTypeId) {
		this.assTypeByAsTypeId = assTypeByAsTypeId;
	}

	public PurchaseOrder getPurchaseOrder() {
		return this.purchaseOrder;
	}

	public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}

	public AssType getAssTypeByPdAsTypeId() {
		return this.assTypeByPdAsTypeId;
	}

	public void setAssTypeByPdAsTypeId(AssType assTypeByPdAsTypeId) {
		this.assTypeByPdAsTypeId = assTypeByPdAsTypeId;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getAssType() {
		return this.assType;
	}

	public void setAssType(String assType) {
		this.assType = assType;
	}

	public String getAssName() {
		return this.assName;
	}

	public void setAssName(String assName) {
		this.assName = assName;
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

	public long getPrice() {
		return this.price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public Set getAsses() {
		return this.asses;
	}

	public void setAsses(Set asses) {
		this.asses = asses;
	}

}