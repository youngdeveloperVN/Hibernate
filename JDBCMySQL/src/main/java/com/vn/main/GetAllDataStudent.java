package com.vn.main;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class GetAllDataStudent {

	public static void main(String[] args) {
		try {
			//0. Driver 
			Class.forName("com.mysql.jdbc.Driver");
			
			//1 Connection
			String connectionStr = "jdbc:mysql://localhost:3306/shopbanhang";
			Connection conn = DriverManager.getConnection(connectionStr,"root", "");
			
			//2 Statement
			Statement sttm = conn.createStatement();
			
			//3 execute statement
			sttm.execute("SELECT id, name as categoryName FROM category WHERE 1=1");
			ResultSet resultSet = sttm.getResultSet();
			while(resultSet.next()) {
				String cName = resultSet.getString("categoryName");
				int id = resultSet.getInt("id");
				System.out.println(cName);
				System.out.println(id);
			}
			
			String sqlUpdate = "update category set name =? WHERE id=?";
			PreparedStatement preparedStatement = conn.prepareStatement(sqlUpdate);
			preparedStatement.setString(1, "C3");
			preparedStatement.setString(2, "2");
			int countUpdate = preparedStatement.executeUpdate();
			System.out.println("Updated: "+ countUpdate + " rows");
			//SELECT COUNT(*) FROM category => "count"
			
			// 4.1 get metadata 
			DatabaseMetaData metaData = conn.getMetaData();
			System.out.println(metaData.getUserName());
			
			//5. Close
			resultSet.close();
			sttm.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
