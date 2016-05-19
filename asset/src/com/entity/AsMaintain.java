package com.entity;

import java.util.Date;

/**
 * AsMaintain entity. @author MyEclipse Persistence Tools
 */

public class AsMaintain implements java.io.Serializable {

	// Fields

	private Integer asMaintainId;
	private Ass ass;
	private User user;
	private String damageCondition;
	private Date repairFee;
	private Integer status;
	private Integer beforeAssUseStatus;

	// Constructors

	/** default constructor */
	public AsMaintain() {
	}

	/** full constructor */
	public AsMaintain(Ass ass, User user, String damageCondition,
			Date repairFee, Integer status, Integer beforeAssUseStatus) {
		this.ass = ass;
		this.user = user;
		this.damageCondition = damageCondition;
		this.repairFee = repairFee;
		this.status = status;
		this.beforeAssUseStatus = beforeAssUseStatus;
	}

	// Property accessors

	public Integer getAsMaintainId() {
		return this.asMaintainId;
	}

	public void setAsMaintainId(Integer asMaintainId) {
		this.asMaintainId = asMaintainId;
	}

	public Ass getAss() {
		return this.ass;
	}

	public void setAss(Ass ass) {
		this.ass = ass;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getDamageCondition() {
		return this.damageCondition;
	}

	public void setDamageCondition(String damageCondition) {
		this.damageCondition = damageCondition;
	}

	public Date getRepairFee() {
		return this.repairFee;
	}

	public void setRepairFee(Date repairFee) {
		this.repairFee = repairFee;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getBeforeAssUseStatus() {
		return this.beforeAssUseStatus;
	}

	public void setBeforeAssUseStatus(Integer beforeAssUseStatus) {
		this.beforeAssUseStatus = beforeAssUseStatus;
	}

}