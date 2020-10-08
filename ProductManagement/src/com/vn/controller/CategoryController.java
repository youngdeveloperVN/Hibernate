package com.vn.controller;

import java.util.ArrayList;
import java.util.List;

import com.vn.dao.CategoryDAO;
import com.vn.dao.CategoryDAOImpl;
import com.vn.entities.Category;
import com.vn.entities.Product;

public class CategoryController {
	
	static CategoryDAO categoryDAO = new CategoryDAOImpl();
	
	public void createCategory(Category category) {
		categoryDAO.create(category);
	}
	
	public static void main(String[] args) {
		//create category
		Category category = new Category();
		category.setName("Category1");
		category.setImage("C://image//image1.png");
		
		List<Product> list = new ArrayList<Product>();
		for (int i = 0; i < 3; i++) {
			Product product = new Product();
			product.setName("Product1");
			product.setPrice(1000);
			list.add(product);
		}
		category.setProducts(list);
		
		categoryDAO.create(category);
	}
	
}
