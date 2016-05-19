package com.entity;

import java.util.Date;

/**
 * AllocateOrder entity. @author MyEclipse Persistence Tools
 */

public class AllocateOrder implements java.io.Serializable {

	// Fields

	private Integer allocateOrderId;
	private Dept deptByOutDeptId;
	private User userByOutManId;
	private User userByInManId;
	private Dept deptByInDeptId;
	private Ass ass;
	private Date outDate;
	private String outReason;
	private Integer status;
	private Date inConfirmDate;

	// Constructors

	/** default constructor */
	public AllocateOrder() {
	}

	/** full constructor */
	public AllocateOrder(Dept deptByOutDeptId, User userByOutManId,
			User userByInManId, Dept deptByInDeptId, Ass ass, Date outDate,
			String outReason, Integer status, Date inConfirmDate) {
		this.deptByOutDeptId = deptByOutDeptId;
		this.userByOutManId = userByOutManId;
		this.userByInManId = userByInManId;
		this.deptByInDeptId = deptByInDeptId;
		this.ass = ass;
		this.outDate = outDate;
		this.outReason = outReason;
		this.status = status;
		this.inConfirmDate = inConfirmDate;
	}

	// Property accessors

	public Integer getAllocateOrderId() {
		return this.allocateOrderId;
	}

	public void setAllocateOrderId(Integer allocateOrderId) {
		this.allocateOrderId = allocateOrderId;
	}

	public Dept getDeptByOutDeptId() {
		return this.deptByOutDeptId;
	}

	public void setDeptByOutDeptId(Dept deptByOutDeptId) {
		this.deptByOutDeptId = deptByOutDeptId;
	}

	public User getUserByOutManId() {
		return this.userByOutManId;
	}

	public void setUserByOutManId(User userByOutManId) {
		this.userByOutManId = userByOutManId;
	}

	public User getUserByInManId() {
		return this.userByInManId;
	}

	public void setUserByInManId(User userByInManId) {
		this.userByInManId = userByInManId;
	}

	public Dept getDeptByInDeptId() {
		return this.deptByInDeptId;
	}

	public void setDeptByInDeptId(Dept deptByInDeptId) {
		this.deptByInDeptId = deptByInDeptId;
	}

	public Ass getAss() {
		return this.ass;
	}

	public void setAss(Ass ass) {
		this.ass = ass;
	}

	public Date getOutDate() {
		return this.outDate;
	}

	public void setOutDate(Date outDate) {
		this.outDate = outDate;
	}

	public String getOutReason() {
		return this.outReason;
	}

	public void setOutReason(String outReason) {
		this.outReason = outReason;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getInConfirmDate() {
		return this.inConfirmDate;
	}

	public void setInConfirmDate(Date inConfirmDate) {
		this.inConfirmDate = inConfirmDate;
	}

}