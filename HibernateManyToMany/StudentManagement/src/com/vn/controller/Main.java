package com.vn.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.vn.entities.Course;
import com.vn.entities.Student;
import com.vn.utils.HibernateUtils;

public class Main {
	
	static SessionFactory factory = HibernateUtils.buildSessionFactory();
	
	public static void main(String[] args) {
		
		//insert left, right, => join table
		Student student1 = new Student();
		student1.setName("Student1");
		Student student2 = new Student();
		student2.setName("Student2");
		
		Course course1 = new Course();
		course1.setName("Course1");
		Course course2 = new Course();
		course2.setName("Course2");
		
		try {
			Session session = factory.openSession();
			session.beginTransaction();
			
			session.save(student1);
			session.save(student2);
			
			session.save(course1);
			session.save(course2);
			
			// Course
			course1.getListStudent().add(student1);
			course1.getListStudent().add(student2);
			course2.getListStudent().add(student1);
			course2.getListStudent().add(student2);
//			// Student
			student1.getListCourse().add(course1);
			student1.getListCourse().add(course2);
			student2.getListCourse().add(course1);
			student2.getListCourse().add(course2);
			
			//re-save
			session.save(student1);
			session.save(student2);
			session.save(course1);
			session.save(course2);
			
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Done!");
		
	}
	
	
}
