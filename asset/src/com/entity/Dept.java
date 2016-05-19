package com.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Dept entity. @author MyEclipse Persistence Tools
 */

public class Dept implements java.io.Serializable {

	// Fields

	private Integer deptId;
	private String deptName;
	private Set users = new HashSet(0);
	private Set assesForBuyDeptId = new HashSet(0);
	private Set purchaseOrders = new HashSet(0);
	private Set assesForUserDeptId = new HashSet(0);
	private Set allocateOrdersForOutDeptId = new HashSet(0);
	private Set allocateOrdersForInDeptId = new HashSet(0);

	// Constructors

	/** default constructor */
	public Dept() {
	}

	/** full constructor */
	public Dept(String deptName, Set users, Set assesForBuyDeptId,
			Set purchaseOrders, Set assesForUserDeptId,
			Set allocateOrdersForOutDeptId, Set allocateOrdersForInDeptId) {
		this.deptName = deptName;
		this.users = users;
		this.assesForBuyDeptId = assesForBuyDeptId;
		this.purchaseOrders = purchaseOrders;
		this.assesForUserDeptId = assesForUserDeptId;
		this.allocateOrdersForOutDeptId = allocateOrdersForOutDeptId;
		this.allocateOrdersForInDeptId = allocateOrdersForInDeptId;
	}

	// Property accessors

	public Integer getDeptId() {
		return this.deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return this.deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Set getUsers() {
		return this.users;
	}

	public void setUsers(Set users) {
		this.users = users;
	}

	public Set getAssesForBuyDeptId() {
		return this.assesForBuyDeptId;
	}

	public void setAssesForBuyDeptId(Set assesForBuyDeptId) {
		this.assesForBuyDeptId = assesForBuyDeptId;
	}

	public Set getPurchaseOrders() {
		return this.purchaseOrders;
	}

	public void setPurchaseOrders(Set purchaseOrders) {
		this.purchaseOrders = purchaseOrders;
	}

	public Set getAssesForUserDeptId() {
		return this.assesForUserDeptId;
	}

	public void setAssesForUserDeptId(Set assesForUserDeptId) {
		this.assesForUserDeptId = assesForUserDeptId;
	}

	public Set getAllocateOrdersForOutDeptId() {
		return this.allocateOrdersForOutDeptId;
	}

	public void setAllocateOrdersForOutDeptId(Set allocateOrdersForOutDeptId) {
		this.allocateOrdersForOutDeptId = allocateOrdersForOutDeptId;
	}

	public Set getAllocateOrdersForInDeptId() {
		return this.allocateOrdersForInDeptId;
	}

	public void setAllocateOrdersForInDeptId(Set allocateOrdersForInDeptId) {
		this.allocateOrdersForInDeptId = allocateOrdersForInDeptId;
	}

}