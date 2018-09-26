package com;

import java.sql.SQLException;
import com.vizor_games.kovalev.services.ManageCsv;
import com.vizor_games.kovalev.dao.impl.DAOImpl;



public class Main {
	public static void main(String[] args) {		
		try {		
			//Reading Through CSV files.
			ManageCsv m = new ManageCsv();
			try {
				//reading all csv files into lists			
				m.ReadProceedsCsvIos(".\\\\files\\Proceeds\\com_vizorapps_mahjong_partners_daily.csv");
				//using all lists for inserts
				DAOImpl dao = new DAOImpl("root");
				dao.insertProceeds(m.getProceeds());				
				System.out.println("It's OK");
			}catch(SQLException e) {
				System.out.println("Error in CSV handling/inserting");
				e.getMessage();
				e.printStackTrace();
			}			
		}catch(Exception ex) {
			ex.getMessage();
			ex.printStackTrace();
		}
	}
}