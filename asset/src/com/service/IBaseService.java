package com.service;

import java.util.List;


public interface IBaseService {
	public <T>T findById(Class<T> cls,Integer id)throws Exception;
	public <T>void create(T t);
	 public <T>void delete(T t);
	 public <T>void saveOrUpdate(T t);
	 public <T>List<T> getList(Class<T> cls);
}
