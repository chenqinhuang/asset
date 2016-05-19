package com.entity;

import java.util.Date;

/**
 * AsReturn entity. @author MyEclipse Persistence Tools
 */

public class AsReturn implements java.io.Serializable {

	// Fields

	private Integer asReturnId;
	private Ass ass;
	private User userByUserIs;
	private User userByReturnId;
	private Date useDate;
	private Date returnDate;
	private Integer status;

	// Constructors

	/** default constructor */
	public AsReturn() {
	}

	/** full constructor */
	public AsReturn(Ass ass, User userByUserIs, User userByReturnId,
			Date useDate, Date returnDate, Integer status) {
		this.ass = ass;
		this.userByUserIs = userByUserIs;
		this.userByReturnId = userByReturnId;
		this.useDate = useDate;
		this.returnDate = returnDate;
		this.status = status;
	}

	// Property accessors

	public Integer getAsReturnId() {
		return this.asReturnId;
	}

	public void setAsReturnId(Integer asReturnId) {
		this.asReturnId = asReturnId;
	}

	public Ass getAss() {
		return this.ass;
	}

	public void setAss(Ass ass) {
		this.ass = ass;
	}

	public User getUserByUserIs() {
		return this.userByUserIs;
	}

	public void setUserByUserIs(User userByUserIs) {
		this.userByUserIs = userByUserIs;
	}

	public User getUserByReturnId() {
		return this.userByReturnId;
	}

	public void setUserByReturnId(User userByReturnId) {
		this.userByReturnId = userByReturnId;
	}

	public Date getUseDate() {
		return this.useDate;
	}

	public void setUseDate(Date useDate) {
		this.useDate = useDate;
	}

	public Date getReturnDate() {
		return this.returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}