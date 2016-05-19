package com.dao;

import java.util.List;

import com.entity.Dept;
import com.entity.User;


public interface IDeptDao extends IBaseDao{
	
	public List<Dept> getDeptList();
	boolean deleteDept(Object o);
	public Dept getDept(Integer deptId);
	public boolean saveOrUpdateDept(Object o);
}
