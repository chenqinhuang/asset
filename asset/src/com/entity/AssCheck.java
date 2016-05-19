package com.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * AssCheck entity. @author MyEclipse Persistence Tools
 */

public class AssCheck implements java.io.Serializable {

	// Fields

	private Integer asCheckId;
	private User user;
	private Date beginDate;
	private Integer status;
	private Set checkDetails = new HashSet(0);

	// Constructors

	/** default constructor */
	public AssCheck() {
	}

	/** full constructor */
	public AssCheck(User user, Date beginDate, Integer status, Set checkDetails) {
		this.user = user;
		this.beginDate = beginDate;
		this.status = status;
		this.checkDetails = checkDetails;
	}

	// Property accessors

	public Integer getAsCheckId() {
		return this.asCheckId;
	}

	public void setAsCheckId(Integer asCheckId) {
		this.asCheckId = asCheckId;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getBeginDate() {
		return this.beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Set getCheckDetails() {
		return this.checkDetails;
	}

	public void setCheckDetails(Set checkDetails) {
		this.checkDetails = checkDetails;
	}

}