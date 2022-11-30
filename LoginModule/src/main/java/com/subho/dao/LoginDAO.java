package com.subho.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDAO 
{
	    String sql= "select * from login where uname=? and pass=?";
        String url= "jdbc:postgresql://localhost:5432/rapidminer_server";
        String username="subho";
        String password="subho";
        
		public boolean check(String uname, String pass)
		{
			try {
				DriverManager.registerDriver(new org.postgresql.Driver());;
				Connection con = DriverManager.getConnection(url,username,password);
				PreparedStatement st=con.prepareStatement(sql);
				st.setString(1, uname);
				st.setString(2, pass);
				ResultSet rs = st.executeQuery();
				if(rs.next())
				{
					return true;
				}
				
			}catch(Exception e) {
				
				e.printStackTrace();
			}
			
			
			return false;
		}
}
