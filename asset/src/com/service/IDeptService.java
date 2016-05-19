package com.service;

import java.util.List;

import com.entity.Dept;
import com.entity.User;




public interface IDeptService extends IBaseService{
	public List<Dept> getDeptList();
	public void deleteDept(Dept dept);
	public void saveOrUpdateDept(Dept dept);
	public Dept getDept(Integer deptId);
}
