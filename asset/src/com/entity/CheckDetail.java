package com.entity;

import java.util.Date;

/**
 * CheckDetail entity. @author MyEclipse Persistence Tools
 */

public class CheckDetail implements java.io.Serializable {

	// Fields

	private Integer checkDetailId;
	private AssCheck assCheck;
	private Ass ass;
	private Date checkDate;
	private Integer checkResult;

	// Constructors

	/** default constructor */
	public CheckDetail() {
	}

	/** full constructor */
	public CheckDetail(AssCheck assCheck, Ass ass, Date checkDate,
			Integer checkResult) {
		this.assCheck = assCheck;
		this.ass = ass;
		this.checkDate = checkDate;
		this.checkResult = checkResult;
	}

	// Property accessors

	public Integer getCheckDetailId() {
		return this.checkDetailId;
	}

	public void setCheckDetailId(Integer checkDetailId) {
		this.checkDetailId = checkDetailId;
	}

	public AssCheck getAssCheck() {
		return this.assCheck;
	}

	public void setAssCheck(AssCheck assCheck) {
		this.assCheck = assCheck;
	}

	public Ass getAss() {
		return this.ass;
	}

	public void setAss(Ass ass) {
		this.ass = ass;
	}

	public Date getCheckDate() {
		return this.checkDate;
	}

	public void setCheckDate(Date checkDate) {
		this.checkDate = checkDate;
	}

	public Integer getCheckResult() {
		return this.checkResult;
	}

	public void setCheckResult(Integer checkResult) {
		this.checkResult = checkResult;
	}

}