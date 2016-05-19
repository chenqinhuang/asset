package com.dao;

import java.util.List;


public interface IBaseDao {
	public <T> T findById(Class<T> cls,Integer id) throws Exception;
	public <T>boolean create(T t);
	 public <T> boolean delete(T t);
	 public <T>boolean saveOrUpdate(T t);
	 public <T>List<T> getList(Class<T> cls);
}
