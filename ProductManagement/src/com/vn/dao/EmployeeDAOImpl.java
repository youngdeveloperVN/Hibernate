package com.vn.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.vn.entities.Employee;
import com.vn.utils.HibernateUtils;

public class EmployeeDAOImpl implements EmployeeDAO {

	static SessionFactory factory = HibernateUtils.buildSessionFactory();

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getAll() {
		 List<Employee> list = null;
		try {

			// 2. Create session
			Session session = factory.openSession();
			
			// 3. Create Query from session
			javax.persistence.Query query = session.createQuery("From Employee");

			// 4. Execute Query (3);
			list = (List<Employee>)query.getResultList();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public Employee insert(Employee employee) {
		try {
			// 1 Load factory
			factory = HibernateUtils.buildSessionFactory();

			// 2. Create session
			Session session = factory.openSession();
			session.beginTransaction();
			
			// 3. Create Query from session
			session.save(employee);
			session.getTransaction().commit();
			
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employee;
	}
}
