package com.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * AsTransfer entity. @author MyEclipse Persistence Tools
 */

public class AsTransfer implements java.io.Serializable {

	// Fields

	private Integer asTransferId;
	private User userByTransferId;
	private User userByReceiverId;
	private Date transferBeginDate;
	private Date transferFinishDate;
	private Integer status;
	private Integer transferType;
	private Set asTransferOrders = new HashSet(0);

	// Constructors

	/** default constructor */
	public AsTransfer() {
	}

	/** full constructor */
	public AsTransfer(User userByTransferId, User userByReceiverId,
			Date transferBeginDate, Date transferFinishDate, Integer status,
			Integer transferType, Set asTransferOrders) {
		this.userByTransferId = userByTransferId;
		this.userByReceiverId = userByReceiverId;
		this.transferBeginDate = transferBeginDate;
		this.transferFinishDate = transferFinishDate;
		this.status = status;
		this.transferType = transferType;
		this.asTransferOrders = asTransferOrders;
	}

	// Property accessors

	public Integer getAsTransferId() {
		return this.asTransferId;
	}

	public void setAsTransferId(Integer asTransferId) {
		this.asTransferId = asTransferId;
	}

	public User getUserByTransferId() {
		return this.userByTransferId;
	}

	public void setUserByTransferId(User userByTransferId) {
		this.userByTransferId = userByTransferId;
	}

	public User getUserByReceiverId() {
		return this.userByReceiverId;
	}

	public void setUserByReceiverId(User userByReceiverId) {
		this.userByReceiverId = userByReceiverId;
	}

	public Date getTransferBeginDate() {
		return this.transferBeginDate;
	}

	public void setTransferBeginDate(Date transferBeginDate) {
		this.transferBeginDate = transferBeginDate;
	}

	public Date getTransferFinishDate() {
		return this.transferFinishDate;
	}

	public void setTransferFinishDate(Date transferFinishDate) {
		this.transferFinishDate = transferFinishDate;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getTransferType() {
		return this.transferType;
	}

	public void setTransferType(Integer transferType) {
		this.transferType = transferType;
	}

	public Set getAsTransferOrders() {
		return this.asTransferOrders;
	}

	public void setAsTransferOrders(Set asTransferOrders) {
		this.asTransferOrders = asTransferOrders;
	}

}