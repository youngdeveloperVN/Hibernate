package com.vn.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.vn.entities.Category;
import com.vn.utils.HibernateUtils;

public class CategoryDAOImpl implements CategoryDAO {

	static SessionFactory factory = HibernateUtils.buildSessionFactory();
	
	@Override
	public Integer delete(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category create(Category category) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			session.save(category);
			
			transaction.commit();
			session.close();
			return category;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Category update(Category category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
