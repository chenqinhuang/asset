package com.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * ParamInfo entity. @author MyEclipse Persistence Tools
 */

public class ParamInfo implements java.io.Serializable {

	// Fields

	private Integer paramInfoId;
	private String paramName;
	private String paramValue;
	private Integer pdParamId;
	private String pdParamName;
	private Set users = new HashSet(0);

	// Constructors

	/** default constructor */
	public ParamInfo() {
	}

	/** full constructor */
	public ParamInfo(String paramName, String paramValue, Integer pdParamId,
			String pdParamName, Set users) {
		this.paramName = paramName;
		this.paramValue = paramValue;
		this.pdParamId = pdParamId;
		this.pdParamName = pdParamName;
		this.users = users;
	}

	// Property accessors

	public Integer getParamInfoId() {
		return this.paramInfoId;
	}

	public void setParamInfoId(Integer paramInfoId) {
		this.paramInfoId = paramInfoId;
	}

	public String getParamName() {
		return this.paramName;
	}

	public void setParamName(String paramName) {
		this.paramName = paramName;
	}

	public String getParamValue() {
		return this.paramValue;
	}

	public void setParamValue(String paramValue) {
		this.paramValue = paramValue;
	}

	public Integer getPdParamId() {
		return this.pdParamId;
	}

	public void setPdParamId(Integer pdParamId) {
		this.pdParamId = pdParamId;
	}

	public String getPdParamName() {
		return this.pdParamName;
	}

	public void setPdParamName(String pdParamName) {
		this.pdParamName = pdParamName;
	}

	public Set getUsers() {
		return this.users;
	}

	public void setUsers(Set users) {
		this.users = users;
	}

}