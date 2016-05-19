package com.entity;

/**
 * AsTransferOrder entity. @author MyEclipse Persistence Tools
 */

public class AsTransferOrder implements java.io.Serializable {

	// Fields

	private Integer asTransferOrderId;
	private AsTransfer asTransfer;
	private Ass ass;
	private User user;
	private Integer receiveResult;

	// Constructors

	/** default constructor */
	public AsTransferOrder() {
	}

	/** full constructor */
	public AsTransferOrder(AsTransfer asTransfer, Ass ass, User user,
			Integer receiveResult) {
		this.asTransfer = asTransfer;
		this.ass = ass;
		this.user = user;
		this.receiveResult = receiveResult;
	}

	// Property accessors

	public Integer getAsTransferOrderId() {
		return this.asTransferOrderId;
	}

	public void setAsTransferOrderId(Integer asTransferOrderId) {
		this.asTransferOrderId = asTransferOrderId;
	}

	public AsTransfer getAsTransfer() {
		return this.asTransfer;
	}

	public void setAsTransfer(AsTransfer asTransfer) {
		this.asTransfer = asTransfer;
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

	public Integer getReceiveResult() {
		return this.receiveResult;
	}

	public void setReceiveResult(Integer receiveResult) {
		this.receiveResult = receiveResult;
	}

}