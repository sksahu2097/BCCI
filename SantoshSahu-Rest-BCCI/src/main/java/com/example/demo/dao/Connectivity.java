package com.example.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Connectivity {

	
	public static PreparedStatement connection(String sql) throws Exception {
		
		
		Class.forName("org.postgresql.Driver");
		Connection con=DriverManager.getConnection("jdbc:postgresql://localhost/winsoft_task","postgres","santoshsahu");
		PreparedStatement pst=con.prepareStatement(sql);
		return pst;
		
	}
	
}
