package com.vn.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.vn.entities.Product;
import com.vn.utils.HibernateUtils;

public class ProductDAOImpl implements ProductDAO {
	
	static SessionFactory factory = HibernateUtils.buildSessionFactory();

	@Override
	public Product create(Product product) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			session.save(product);
			
			transaction.commit();
			session.close();
			return product;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
