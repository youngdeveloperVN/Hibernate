package com.vn.main;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;

public class CallableStatementDemo {
	public static void main(String[] args) {
		try {
			//0. Driver 
			Class.forName("com.mysql.jdbc.Driver");
			
			//1 Connection
			String connectionStr = "jdbc:mysql://localhost:3306/shopbanhang";
			Connection conn = DriverManager.getConnection(connectionStr,"root", "");
			//2 Statement
			CallableStatement callableStatement = conn.prepareCall("?= {call calculator(?,?)}");
			callableStatement.setInt(2, 3);
			callableStatement.setInt(3, 5);
			callableStatement.registerOutParameter(1, Types.INTEGER);
			
			//3. show resultvm
			ResultSet rs = callableStatement.getResultSet();
			while(rs.next()) {
				int totalColumn = rs.getMetaData().getColumnCount();
				for (int i = 0; i < totalColumn; i++) {
					Object data = rs.getObject(i);
					System.out.println(data);
				}
			}
			
			//5. Close
			callableStatement.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
