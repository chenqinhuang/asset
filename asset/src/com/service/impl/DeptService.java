package com.service.impl;

import java.util.List;

import com.dao.IDeptDao;
import com.dao.IUserDao;
import com.entity.Dept;
import com.service.IBaseService;
import com.service.IDeptService;

public class DeptService  extends BaseService implements IDeptService {

	private IDeptDao deptDao;
	
	public IDeptDao getDeptDao() {
		return deptDao;
	}


	public void setDeptDao(IDeptDao deptDao) {
		this.deptDao = deptDao;
	}
	
	
	@Override
	public List<Dept> getDeptList() {
		// TODO Auto-generated method stub
		return deptDao.getDeptList();
	}


	@Override
	public void deleteDept(Dept dept) {
		// TODO Auto-generated method stub
		deptDao.deleteDept(dept);
	}


	@Override
	public void saveOrUpdateDept(Dept dept) {
		// TODO Auto-generated method stub
		this.deptDao.saveOrUpdateDept(dept);
	}


	@Override
	public Dept getDept(Integer deptId) {
		// TODO Auto-generated method stub
		return deptDao.getDept(deptId);
	}


	

}
