package com.service.impl;

import java.util.List;

import com.dao.IBaseDao;
import com.dao.IUserDao;
import com.service.IBaseService;
import com.service.IUserService;

public class BaseService implements IBaseService {
	protected IBaseDao baseDao; 
	
   
	public IBaseDao getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(IBaseDao baseDao) {
		this.baseDao = baseDao;
	}

	public <T>T findById(Class<T> cls,Integer id)throws Exception{
         return baseDao.findById(cls, id);
     }
	     
     public <T>void create(T t){
    	 try {
    		 baseDao.create(t);
		} catch (Exception e) {
	         System.out.println("===============111"+e.getMessage());
		}
         
         
     }
	     
     public <T>void delete(T t){
    	  baseDao.delete(t);
     }
     
     public <T>void saveOrUpdate(T t){
    	 baseDao.saveOrUpdate(t);
	 }
	 
	 public <T>List<T> getList(Class<T> cls){
	     return baseDao.getList(cls);
	 }
	     
    
}
