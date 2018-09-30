package com.games.kuks.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import com.games.kuks.Proceeds;
import com.games.kuks.Revenue;

/*
 * This class does all db related operations
 */
public class DAOImpl {
	//JDBC driver and database URL Localhost
	static final String JDBC_Driver="com.mysql.jdbc.Driver";
	static final String Db_Url="jdbc:mysql://localhost:3306/vizor?autoReconnect=true&useSSL=false";
	
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
			String query="insert into proceeds (name, date, media, campaign, platform, installs, cost) values (?, ?, ?, ?, ?, ?, ?)";			

			PreparedStatement pr1 = con.prepareStatement(query);
			for(Proceeds c : lst) {
				pr1.setString(1,clean(c.getName()));
				pr1.setString(2,clean(c.getDate()));
				pr1.setString(3,clean(c.getMedia()));
				pr1.setString(4,clean(c.getCampaign()));
				pr1.setString(5,clean(c.getPlatform()));
				pr1.setString(6,clean(c.getInstalls()));
				pr1.setString(7,clean(c.getCost()));
				pr1.addBatch();
			}
			pr1.executeBatch();
			pr1.closeOnCompletion();
			System.out.println("All records inserted into proceeds table");
		}catch(SQLException e) {
			System.out.println(e.getErrorCode()+"---"+e.getMessage());
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean insertRevenue(List<Revenue> lst) {
		try {	
			String query="insert into revenue (name, installTime, eventTime, eventRevenueUSD, mediaSource, campaign, countryCode, customerUserID, platform) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";			

			PreparedStatement pr1 = con.prepareStatement(query);
			for(Revenue c : lst) {
				pr1.setString(1,clean(c.getName()));
				pr1.setString(2,clean(c.getInstallTime()));
				pr1.setString(3,clean(c.getEventTime()));
				pr1.setString(4,clean(c.getEventRevenueUSD()));
				pr1.setString(5,clean(c.getMediaSource()));
				pr1.setString(6,clean(c.getCampaign()));
				pr1.setString(7,clean(c.getCountryCode()));
				pr1.setString(8,clean(c.getCustomerUserID()));
				pr1.setString(9,clean(c.getPlatform()));
				pr1.addBatch();
			}
			pr1.executeBatch();
			pr1.closeOnCompletion();
			System.out.println("All records inserted into revenue table");
		}catch(SQLException e) {
			System.out.println(e.getErrorCode()+"---"+e.getMessage());
			e.printStackTrace();
			return false;
		}
		return true;
	}	
}