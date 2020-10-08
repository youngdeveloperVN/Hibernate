package com.vn.controller;

import com.vn.dao.CategoryDAO;
import com.vn.dao.CategoryDAOImpl;
import com.vn.dao.ProductDAO;
import com.vn.dao.ProductDAOImpl;
import com.vn.entities.Category;
import com.vn.entities.Product;

public class TestProduct {
	
	static ProductDAO productDAO = new ProductDAOImpl();
	static CategoryDAO categoryDAO = new CategoryDAOImpl();
	
	public static void main(String[] args) {
			//CRUD => create , read, update, delete
			Product product = new Product();
			product.setName("Product1");
			product.setPrice(1000);
			
			//create category
			Category category = new Category();
			category.setName("Category1");
			category.setImage("C://image//image1.png");
			
			product.setCategory(category);
			categoryDAO.create(category);
			productDAO.create(product);
			System.out.println("Done!");
	//		read();
	//		update();
	//		delete();
		}
}

