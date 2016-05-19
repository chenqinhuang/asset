package com.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private Integer userId;
	private Dept dept;
	private ParamInfo paramInfo;
	private String userName;
	private String pwd;
	private Integer status;
	private Integer sex;
	private Set retirementsForAuditorId = new HashSet(0);
	private Set asTransfersForReceiverId = new HashSet(0);
	private Set asTransfersForTransferId = new HashSet(0);
	private Set allocateOrdersForInManId = new HashSet(0);
	private Set asMaintains = new HashSet(0);
	private Set allocateOrdersForOutManId = new HashSet(0);
	private Set asReturnsForReturnId = new HashSet(0);
	private Set asTransferOrders = new HashSet(0);
	private Set assChecks = new HashSet(0);
	private Set retirementsForRetirementManId = new HashSet(0);
	private Set asReturnsForUserIs = new HashSet(0);
	private Set assesForStoremanId = new HashSet(0);
	private Set assesForFinanceManId = new HashSet(0);
	private Set purchaseOrders = new HashSet(0);
	private Set purchaseOrderDetails = new HashSet(0);

	// Constructors

	/** default constructor */
	public User() {
	}

	/** full constructor */
	public User(Dept dept, ParamInfo paramInfo, String userName, String pdw,
			Integer status, Integer sex, Set retirementsForAuditorId,
			Set asTransfersForReceiverId, Set asTransfersForTransferId,
			Set allocateOrdersForInManId, Set asMaintains,
			Set allocateOrdersForOutManId, Set asReturnsForReturnId,
			Set asTransferOrders, Set assChecks,
			Set retirementsForRetirementManId, Set asReturnsForUserIs,
			Set assesForStoremanId, Set assesForFinanceManId,
			Set purchaseOrders, Set purchaseOrderDetails) {
		this.dept = dept;
		this.paramInfo = paramInfo;
		this.userName = userName;
		this.pwd = pwd;
		this.status = status;
		this.sex = sex;
		this.retirementsForAuditorId = retirementsForAuditorId;
		this.asTransfersForReceiverId = asTransfersForReceiverId;
		this.asTransfersForTransferId = asTransfersForTransferId;
		this.allocateOrdersForInManId = allocateOrdersForInManId;
		this.asMaintains = asMaintains;
		this.allocateOrdersForOutManId = allocateOrdersForOutManId;
		this.asReturnsForReturnId = asReturnsForReturnId;
		this.asTransferOrders = asTransferOrders;
		this.assChecks = assChecks;
		this.retirementsForRetirementManId = retirementsForRetirementManId;
		this.asReturnsForUserIs = asReturnsForUserIs;
		this.assesForStoremanId = assesForStoremanId;
		this.assesForFinanceManId = assesForFinanceManId;
		this.purchaseOrders = purchaseOrders;
		this.purchaseOrderDetails = purchaseOrderDetails;
	}

	// Property accessors

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Dept getDept() {
		return this.dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	public ParamInfo getParamInfo() {
		return this.paramInfo;
	}

	public void setParamInfo(ParamInfo paramInfo) {
		this.paramInfo = paramInfo;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pdw) {
		this.pwd = pdw;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getSex() {
		return this.sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Set getRetirementsForAuditorId() {
		return this.retirementsForAuditorId;
	}

	public void setRetirementsForAuditorId(Set retirementsForAuditorId) {
		this.retirementsForAuditorId = retirementsForAuditorId;
	}

	public Set getAsTransfersForReceiverId() {
		return this.asTransfersForReceiverId;
	}

	public void setAsTransfersForReceiverId(Set asTransfersForReceiverId) {
		this.asTransfersForReceiverId = asTransfersForReceiverId;
	}

	public Set getAsTransfersForTransferId() {
		return this.asTransfersForTransferId;
	}

	public void setAsTransfersForTransferId(Set asTransfersForTransferId) {
		this.asTransfersForTransferId = asTransfersForTransferId;
	}

	public Set getAllocateOrdersForInManId() {
		return this.allocateOrdersForInManId;
	}

	public void setAllocateOrdersForInManId(Set allocateOrdersForInManId) {
		this.allocateOrdersForInManId = allocateOrdersForInManId;
	}

	public Set getAsMaintains() {
		return this.asMaintains;
	}

	public void setAsMaintains(Set asMaintains) {
		this.asMaintains = asMaintains;
	}

	public Set getAllocateOrdersForOutManId() {
		return this.allocateOrdersForOutManId;
	}

	public void setAllocateOrdersForOutManId(Set allocateOrdersForOutManId) {
		this.allocateOrdersForOutManId = allocateOrdersForOutManId;
	}

	public Set getAsReturnsForReturnId() {
		return this.asReturnsForReturnId;
	}

	public void setAsReturnsForReturnId(Set asReturnsForReturnId) {
		this.asReturnsForReturnId = asReturnsForReturnId;
	}

	public Set getAsTransferOrders() {
		return this.asTransferOrders;
	}

	public void setAsTransferOrders(Set asTransferOrders) {
		this.asTransferOrders = asTransferOrders;
	}

	public Set getAssChecks() {
		return this.assChecks;
	}

	public void setAssChecks(Set assChecks) {
		this.assChecks = assChecks;
	}

	public Set getRetirementsForRetirementManId() {
		return this.retirementsForRetirementManId;
	}

	public void setRetirementsForRetirementManId(
			Set retirementsForRetirementManId) {
		this.retirementsForRetirementManId = retirementsForRetirementManId;
	}

	public Set getAsReturnsForUserIs() {
		return this.asReturnsForUserIs;
	}

	public void setAsReturnsForUserIs(Set asReturnsForUserIs) {
		this.asReturnsForUserIs = asReturnsForUserIs;
	}

	public Set getAssesForStoremanId() {
		return this.assesForStoremanId;
	}

	public void setAssesForStoremanId(Set assesForStoremanId) {
		this.assesForStoremanId = assesForStoremanId;
	}

	public Set getAssesForFinanceManId() {
		return this.assesForFinanceManId;
	}

	public void setAssesForFinanceManId(Set assesForFinanceManId) {
		this.assesForFinanceManId = assesForFinanceManId;
	}

	public Set getPurchaseOrders() {
		return this.purchaseOrders;
	}

	public void setPurchaseOrders(Set purchaseOrders) {
		this.purchaseOrders = purchaseOrders;
	}

	public Set getPurchaseOrderDetails() {
		return this.purchaseOrderDetails;
	}

	public void setPurchaseOrderDetails(Set purchaseOrderDetails) {
		this.purchaseOrderDetails = purchaseOrderDetails;
	}

}