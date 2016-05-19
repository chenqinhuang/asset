package com.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;

import com.dao.IDeptDao;
import com.entity.Dept;
import com.entity.User;


/**
 * 
 * @author hpp
 *
 */
public class DeptDao extends BaseDao implements IDeptDao{
	
	private SessionFactory sessionFactory;
	public SessionFactory getFactory() {

		return sessionFactory;
	}

	public void setFactory(SessionFactory sessionFactory) {

		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Dept> getDeptList() {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().find("from Dept");
	}

	@Override
	public boolean deleteDept(Object o) {
		// TODO Auto-generated method stub
		try {  
            this.getHibernateTemplate().delete(o);  
            return true;  
        } catch (Exception e) {
        	e.printStackTrace();
            return false;  
        }  
	}

	@Override
	public Dept getDept(Integer deptId) {
		// TODO Auto-generated method stub
		return (Dept)this.getHibernateTemplate().get(Dept.class,deptId);
	}

	@Override
	public boolean saveOrUpdateDept(Object o) {
		// TODO Auto-generated method stub
		try {  

			System.out.println("保存成功dao.impl");
			this.getHibernateTemplate().saveOrUpdate(o);;  
			return true;  
		} catch (Exception e) {  
			System.out.println(e.getMessage());
			return false;  
		}  
	}
	
	
	
	
	

}
