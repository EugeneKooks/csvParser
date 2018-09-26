package com.vizor_games.kovalev.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import com.vizor_games.kovalev.Proceeds;

/*
 * This class does all db related operations
 */
public class DAOImpl {
	//JDBC driver and database URL Localhost
	static final String JDBC_Driver="com.mysql.jdbc.Driver";
	static final String Db_Url="jdbc:mysql://localhost:3306/vizor";
	
	//username and passsword localhost
	static final String user="root";
	static String pwd;
	
	//connection and statement
	Connection con=null;
	Statement stmt=null;
	ResultSet res = null;
	
	PreparedStatement pr = null;
	public DAOImpl(String pwd) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		DAOImpl.pwd = pwd;
		Class.forName(JDBC_Driver).newInstance();
		con = DriverManager.getConnection(Db_Url,user,pwd);
	}
	public static String clean(String str) {
		if(str.charAt(0) == '\'' && str.charAt(str.length()-1) == '\'') {
			return str.substring(1, str.length()-1);
		}
		return str;
	}
	public boolean insertProceeds(List<Proceeds> lst) {
		try {		
			String query="insert into proceeds (Name, Date, Media, Campaign, Platform, Installs, Cost) values (?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pr1 = con.prepareStatement(query);
			for(Proceeds c : lst) {
				pr1 = con.prepareStatement(query);				
				pr1.setString(1,clean(c.getName()));
				pr1.setString(2,clean(c.getDate()));
				pr1.setString(3,clean(c.getMedia()));
				pr1.setString(4,clean(c.getCampaign()));
				pr1.setString(5,clean(c.getPlatform()));
				pr1.setDouble(6,(c.getInstalls()));
				pr1.setString(7,(c.getCost()));				
			}
			pr1.closeOnCompletion();
			System.out.println("All records inserted into proceeds table");
		}catch(SQLException e) {
			System.out.println(e.getErrorCode()+"---"+e.getMessage());
			e.printStackTrace();
		}
		return true;
	}	
}