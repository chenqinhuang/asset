package com.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * PurchaseOrder entity. @author MyEclipse Persistence Tools
 */

public class PurchaseOrder implements java.io.Serializable {

	// Fields

	private Integer purchaseOrderId;
	private Dept dept;
	private User user;
	private Date purchaseDate;
	private String purchaseUse;
	private Integer status;
	private Set purchaseOrderDetails = new HashSet(0);

	// Constructors

	/** default constructor */
	public PurchaseOrder() {
	}

	/** full constructor */
	public PurchaseOrder(Dept dept, User user, Date purchaseDate,
			String purchaseUse, Integer status, Set purchaseOrderDetails) {
		this.dept = dept;
		this.user = user;
		this.purchaseDate = purchaseDate;
		this.purchaseUse = purchaseUse;
		this.status = status;
		this.purchaseOrderDetails = purchaseOrderDetails;
	}

	// Property accessors

	public Integer getPurchaseOrderId() {
		return this.purchaseOrderId;
	}

	public void setPurchaseOrderId(Integer purchaseOrderId) {
		this.purchaseOrderId = purchaseOrderId;
	}

	public Dept getDept() {
		return this.dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getPurchaseDate() {
		return this.purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public String getPurchaseUse() {
		return this.purchaseUse;
	}

	public void setPurchaseUse(String purchaseUse) {
		this.purchaseUse = purchaseUse;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Set getPurchaseOrderDetails() {
		return this.purchaseOrderDetails;
	}

	public void setPurchaseOrderDetails(Set purchaseOrderDetails) {
		this.purchaseOrderDetails = purchaseOrderDetails;
	}

}