package com;

import java.sql.SQLException;
import com.vizor_games.kovalev.services.ManageCsv;
import com.vizor_games.kovalev.dao.impl.DAOImpl;



public class Main {
	public static void main(String[] args) {
		try {	
			// Reading Through CSV files.
			ManageCsv m = new ManageCsv();
			try {
				// reading all csv files into lists
				m.ReadProceedsCSViOS(".\\files\\Proceeds\\com_vizorapps_mahjong_partners_daily.csv");
				m.ReadProceedsCSVAndroid(".\\files\\Proceeds\\id1098189387_partners_daily_report_2018.csv");
				m.ReadRevenueCSViOS(".\\files\\Revenue\\com_vizorapps_mahjong_non_organi.csv");
				m.ReadRevenueCSVAndroid(".\\files\\Revenue\\id1098189387_non_organic_in_app_events_2018.csv");
				// using all lists for inserts
				DAOImpl dao = new DAOImpl("root");
				dao.insertProceeds(m.getProceeds());
				dao.insertRevenue(m.getRevenue());
				System.out.println("It's OK");
			} catch (SQLException e) {
				System.out.println("Error in CSV handling/inserting");
				e.getMessage();
				e.printStackTrace();
			}
		} catch (Exception ex) {
			ex.getMessage();
			ex.printStackTrace();
		}
	}
}