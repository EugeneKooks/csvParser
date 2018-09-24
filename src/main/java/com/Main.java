package com;

import java.sql.SQLException;
import java.util.Scanner;

import com.vizor_games.kovalev.services.ManageCsv;
import com.vizor_games.kovalev.services.ManageExcel;
import com.vizor_games.kovalev.dao.impl.DAOImpl;



public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Read through\n1)CSV\n2)Excel\n?");
		int choice = s.nextInt();
		s.close();
		try {
		switch (choice) {
		case 1:
			//Reading Through CSV files.
			ManageCsv m = new ManageCsv();
			try {
				//reading all csv files into lists
				m.ReadCountryCsv(".\\files\\Country.csv");
				m.ReadPlayerCsv(".\\\\files\\Players.csv");
				m.ReadMatchResultsCsv(".\\\\files\\Match_results.csv");
				m.ReadPlayerCardCsv(".\\\\files\\Player_Cards.csv");
				m.ReadPlayerAssistsGoalsCsv(".\\\\files\\Player_Assists_Goals.csv");
				
				//using all lists for inserts
				DAOImpl dao = new DAOImpl("root");
				dao.insertCountry(m.getCountryList());
				dao.insertPlayers(m.getPlayerList());
				dao.insertMatchResults(m.getMatchResults());
				dao.insertPlayerCards(m.getPlayerCards());
				dao.insertPlayerAssistsGoals(m.getPlayerAssistsGoals());
				System.out.println("It's OK");

			}catch(SQLException e) {
				System.out.println("Error in CSV handling/inserting");
				e.getMessage();
				e.printStackTrace();
			}			
			break;
		case 2:
			//Reading through xlsx files
			ManageExcel e = new ManageExcel();
			try{
				//using lists for insert
				DAOImpl dao1 = new DAOImpl("root");
				dao1.insertCountry(e.getCountries());
				dao1.insertPlayers(e.getPlayers());
				dao1.insertMatchResults(e.getMatchResults());
				dao1.insertPlayerCards(e.getPlayerCards());
				dao1.insertPlayerAssistsGoals(e.getPlayerAssists());
			}catch(SQLException e1) {
				System.out.println("Error in EXCEL handling/inserting");
				e1.getMessage();
				e1.printStackTrace();
			}
			break;
		default:
			break;
		}
		}catch(Exception ex) {
			ex.getMessage();
			ex.printStackTrace();
		}
	}
}