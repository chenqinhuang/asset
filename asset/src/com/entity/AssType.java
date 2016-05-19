package com.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * AssType entity. @author MyEclipse Persistence Tools
 */

public class AssType implements java.io.Serializable {

	// Fields

	private Integer asTypeId;
	private String asTypeCode;
	private String asTypeName;
	private Integer pdAsTypeId;
	private String pdAdTypeName;
	private Set purchaseOrderDetailsForAsTypeId = new HashSet(0);
	private Set assesForAsTypeId = new HashSet(0);
	private Set purchaseOrderDetailsForPdAsTypeId = new HashSet(0);
	private Set assesForPdAsTypeId = new HashSet(0);

	// Constructors

	/** default constructor */
	public AssType() {
	}

	/** full constructor */
	public AssType(String asTypeCode, String asTypeName, Integer pdAsTypeId,
			String pdAdTypeName, Set purchaseOrderDetailsForAsTypeId,
			Set assesForAsTypeId, Set purchaseOrderDetailsForPdAsTypeId,
			Set assesForPdAsTypeId) {
		this.asTypeCode = asTypeCode;
		this.asTypeName = asTypeName;
		this.pdAsTypeId = pdAsTypeId;
		this.pdAdTypeName = pdAdTypeName;
		this.purchaseOrderDetailsForAsTypeId = purchaseOrderDetailsForAsTypeId;
		this.assesForAsTypeId = assesForAsTypeId;
		this.purchaseOrderDetailsForPdAsTypeId = purchaseOrderDetailsForPdAsTypeId;
		this.assesForPdAsTypeId = assesForPdAsTypeId;
	}

	// Property accessors

	public Integer getAsTypeId() {
		return this.asTypeId;
	}

	public void setAsTypeId(Integer asTypeId) {
		this.asTypeId = asTypeId;
	}

	public String getAsTypeCode() {
		return this.asTypeCode;
	}

	public void setAsTypeCode(String asTypeCode) {
		this.asTypeCode = asTypeCode;
	}

	public String getAsTypeName() {
		return this.asTypeName;
	}

	public void setAsTypeName(String asTypeName) {
		this.asTypeName = asTypeName;
	}

	public Integer getPdAsTypeId() {
		return this.pdAsTypeId;
	}

	public void setPdAsTypeId(Integer pdAsTypeId) {
		this.pdAsTypeId = pdAsTypeId;
	}

	public String getPdAdTypeName() {
		return this.pdAdTypeName;
	}

	public void setPdAdTypeName(String pdAdTypeName) {
		this.pdAdTypeName = pdAdTypeName;
	}

	public Set getPurchaseOrderDetailsForAsTypeId() {
		return this.purchaseOrderDetailsForAsTypeId;
	}

	public void setPurchaseOrderDetailsForAsTypeId(
			Set purchaseOrderDetailsForAsTypeId) {
		this.purchaseOrderDetailsForAsTypeId = purchaseOrderDetailsForAsTypeId;
	}

	public Set getAssesForAsTypeId() {
		return this.assesForAsTypeId;
	}

	public void setAssesForAsTypeId(Set assesForAsTypeId) {
		this.assesForAsTypeId = assesForAsTypeId;
	}

	public Set getPurchaseOrderDetailsForPdAsTypeId() {
		return this.purchaseOrderDetailsForPdAsTypeId;
	}

	public void setPurchaseOrderDetailsForPdAsTypeId(
			Set purchaseOrderDetailsForPdAsTypeId) {
		this.purchaseOrderDetailsForPdAsTypeId = purchaseOrderDetailsForPdAsTypeId;
	}

	public Set getAssesForPdAsTypeId() {
		return this.assesForPdAsTypeId;
	}

	public void setAssesForPdAsTypeId(Set assesForPdAsTypeId) {
		this.assesForPdAsTypeId = assesForPdAsTypeId;
	}

}