package com.vn;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.vn.entities.Employee;
import com.vn.utils.HibernateUtils;

public class MainEmployee {

	static SessionFactory factory;

	public static void main(String[] args) {
		//insert 
		Employee newEmpl = new Employee();
		newEmpl.setName("Empl3");
		newEmpl.setDescription("Empl3");
		insert(newEmpl);
		
		// get all
		List<Employee> list = getAll();
		System.out.println(list.size());

	}

	@SuppressWarnings("unchecked")
	private static List<Employee> getAll() {
		 List<Employee> list = null;
		try {
			// 1 Load factory
			factory = HibernateUtils.buildSessionFactory();

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
	
	private static Employee insert(Employee newEmpl) {
		try {
			// 1 Load factory
			factory = HibernateUtils.buildSessionFactory();

			// 2. Create session
			Session session = factory.openSession();
			session.beginTransaction();
			
			// 3. Create Query from session
			session.save(newEmpl);
			session.getTransaction().commit();
			
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return newEmpl;
	}
}
