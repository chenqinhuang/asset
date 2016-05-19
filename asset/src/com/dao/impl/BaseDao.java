package com.dao.impl;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.hibernate.SessionFactory;

import com.dao.IBaseDao;


import java.lang.reflect.ParameterizedType;
import java.util.List;



public class BaseDao extends HibernateDaoSupport implements IBaseDao {
	
	private SessionFactory sessionFactory;

	protected String className;
	
	public BaseDao(){
	        
	}
	public SessionFactory getFactory() {

		return sessionFactory;
	}

	public void setFactory(SessionFactory sessionFactory) {

		this.sessionFactory = sessionFactory;
	}
	
	 
	 public <T> T findById(Class<T> cls,Integer id) throws Exception
		{
			T obj=null;
				obj=(T)super.getHibernateTemplate().get(cls,id);
			
			
			return obj;
		}
	public <T> boolean create(T t){
		try {
		     this.getHibernateTemplate().save(t);
		     
		     return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("===============222"+e.getMessage());
		     return false;
		}
	 }

	 public <T> boolean delete(T t){
		try {
		     this.getHibernateTemplate().delete(t);
		     return true;
		} catch (Exception e) {
			// TODO: handle exception
			 
		     return false;
		}
	 }

	 
	 public <T>boolean saveOrUpdate(T t) {  
			
	        try {  
	        	
	            this.getHibernateTemplate().saveOrUpdate(t); 
	            return true;  
	        } catch (Exception e) {  
	        	
	            return false;  
	        }  
	    }
	 
	 public <T>List<T> getList(Class<T> cls){
	     return (List<T>)this.getHibernateTemplate().find("from "+cls.getName());
	 }
	
}
