package com.dao.impl;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.dao.IUserDao;
import com.entity.User;

/**
 * 
 * @author hpp
 *
 */

public class UserDao extends BaseDao implements IUserDao {
	private SessionFactory sessionFactory;
	public SessionFactory getFactory() {

		return sessionFactory;
	}

	public void setFactory(SessionFactory sessionFactory) {

		this.sessionFactory = sessionFactory;
	}

	@Override
	public List getLoginUser(String userName, String pwd) {
		// TODO Auto-generated method stub
		Object o[]={userName,pwd};
		return this.getHibernateTemplate().find("select user from User as user where user.userName=? and user.pwd=?",o);
	}

//	@Override
//	public String register(String userName, String pwd) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	@Override
	public boolean register(Object o) {  
        try {  
        	
        	System.out.println("注册成功dao.impl");
            this.getHibernateTemplate().saveOrUpdate(o);;  
            return true;  
        } catch (Exception e) {  
        	System.out.println(e.getMessage());
            return false;  
        }  
    }

	@Override
	public List<User> getUserList() {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().find("from User");
		
	}

	@Override
	public boolean deleteUser(Object o) {
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
	public User getUser(Integer userId) {
		// TODO Auto-generated method stub
		
		return (User)this.getHibernateTemplate().get(User.class,userId);
	}

	@Override
	public boolean saveOrUpdate(Object o) {
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
