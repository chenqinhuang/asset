package com.entity;

import java.util.Date;

/**
 * Retirement entity. @author MyEclipse Persistence Tools
 */

public class Retirement implements java.io.Serializable {

	// Fields

	private Integer retirementOrderId;
	private User userByRetirementManId;
	private Ass ass;
	private User userByAuditorId;
	private Date retirementDate;
	private Date checkDate;
	private Integer status;

	// Constructors

	/** default constructor */
	public Retirement() {
	}

	/** full constructor */
	public Retirement(User userByRetirementManId, Ass ass,
			User userByAuditorId, Date retirementDate, Date checkDate,
			Integer status) {
		this.userByRetirementManId = userByRetirementManId;
		this.ass = ass;
		this.userByAuditorId = userByAuditorId;
		this.retirementDate = retirementDate;
		this.checkDate = checkDate;
		this.status = status;
	}

	// Property accessors

	public Integer getRetirementOrderId() {
		return this.retirementOrderId;
	}

	public void setRetirementOrderId(Integer retirementOrderId) {
		this.retirementOrderId = retirementOrderId;
	}

	public User getUserByRetirementManId() {
		return this.userByRetirementManId;
	}

	public void setUserByRetirementManId(User userByRetirementManId) {
		this.userByRetirementManId = userByRetirementManId;
	}

	public Ass getAss() {
		return this.ass;
	}

	public void setAss(Ass ass) {
		this.ass = ass;
	}

	public User getUserByAuditorId() {
		return this.userByAuditorId;
	}

	public void setUserByAuditorId(User userByAuditorId) {
		this.userByAuditorId = userByAuditorId;
	}

	public Date getRetirementDate() {
		return this.retirementDate;
	}

	public void setRetirementDate(Date retirementDate) {
		this.retirementDate = retirementDate;
	}

	public Date getCheckDate() {
		return this.checkDate;
	}

	public void setCheckDate(Date checkDate) {
		this.checkDate = checkDate;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}