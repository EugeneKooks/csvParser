package com.vizor_games.kovalev.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.vizor_games.kovalev.Country;
import com.vizor_games.kovalev.MatchResults;
import com.vizor_games.kovalev.Player;
import com.vizor_games.kovalev.PlayerAssistsGoals;
import com.vizor_games.kovalev.PlayerCard;

/*
 * This class does all db related operations
 */
public class DAOImpl {
	//JDBC driver and database URL Localhost
	static final String JDBC_Driver="com.mysql.jdbc.Driver";
	static final String Db_Url="jdbc:mysql://localhost:3306/soccer";
	
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
	public boolean insertCountry(List<Country> lst) {
		try {		
			String query="insert into country (country_name, population, no_of_worldcup_won, manager) values (?, ?, ?, ?)";
			PreparedStatement pr1 = con.prepareStatement(query);
			for(Country c : lst) {
				pr1 = con.prepareStatement(query);
				pr1.setString(1,clean(c.getCountryName()));
				pr1.setDouble(2,c.getPopulation());
				pr1.setDouble(3,c.getNoOfWorldcupsWon());
				pr1.setString(4,clean(c.getManager()));
				pr1.execute();
			}
			pr1.closeOnCompletion();
			System.out.println("All records inserted into country table");
		}catch(SQLException e) {
			System.out.println(e.getErrorCode()+"---"+e.getMessage());
			e.printStackTrace();
		}
		return true;
	}
	public boolean insertPlayers(List<Player> lst) {
		try {		
			String query="insert into players (player_id, name, fname, lname, dob, player_country, height_cms, club, position, caps_for_country, is_captain) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pr2 = con.prepareStatement(query);
			for(Player p : lst) {
				pr2.setDouble(1,p.getPlayerId());
				pr2.setString(2, clean(p.getName()));
				pr2.setString(3, clean(p.getFname()));
				pr2.setString(4, clean(p.getLname()));
				pr2.setString(5, clean(p.getDOB()));
				pr2.setString(6, clean(p.getCountry()));
				pr2.setDouble(7, p.getHeight());
				pr2.setString(8, clean(p.getClub()));
				pr2.setString(9, clean(p.getPosition()));
				pr2.setInt(10, (int) p.getCapsForCountry());
				pr2.setString(11, String.valueOf(p.getIsCaption()));
				pr2.addBatch();
			}
			pr2.executeBatch();
			pr2.closeOnCompletion();
			System.out.println("all records inserted into players table");
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean insertMatchResults(List<MatchResults> lst) {
		try {
			String query = "insert into match_results (match_id, date_of_match, start_time_of_match, team1, team2, team1_score, team2_score, stadium_name, host_city) values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pr3 = con.prepareStatement(query);
			for(MatchResults r : lst) {
				pr3.setDouble(1, r.getMatchId());
				pr3.setString(2, clean(r.getDateOfMatch()));
				pr3.setString(3, clean(r.getStartTiemOfMatch()));
				pr3.setString(4, clean(r.getTeam1()));
				pr3.setString(5, clean(r.getTeam2()));
				pr3.setDouble(6, r.getTeam1Score());
				pr3.setDouble(7, r.getTeam2Score());
				pr3.setString(8, clean(r.getStadiumName()));
				pr3.setString(9, clean(r.getHostCity()));
				pr3.addBatch();
			}
			pr3.executeBatch();
			pr3.closeOnCompletion();
			System.out.println("All records inserted into match_results table");
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean insertPlayerAssistsGoals(List<PlayerAssistsGoals> lst) {
		try {
			String query = "insert into player_assists_goals ( player_id, no_of_matches, goals, assists, minutes_played) values(?, ?, ?, ?, ?)";
			PreparedStatement pr4 = con.prepareStatement(query);
			for(PlayerAssistsGoals c : lst) {
				pr4.setDouble(1, c.getPlayerId());
				pr4.setDouble(2, c.getNoOfMatched());
				pr4.setDouble(3, c.getGoals());
				pr4.setDouble(4, c.getAssists());
				pr4.setDouble(5, c.getMinutesPlayed());
				pr4.addBatch();
			}
			pr4.executeBatch();
			pr4.closeOnCompletion();
			System.out.println("All records inserted into player_assists_goals table");
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean insertPlayerCards(List<PlayerCard> lst) {
		try {
			String query="insert into player_card (player_id, yellow_cards , red_cards) values(?, ?, ?)";
			PreparedStatement pr5 = con.prepareStatement(query);
			for(PlayerCard c : lst) {
				pr5.setDouble(1, c.getPlayerid());
				pr5.setDouble(2, c.getYellowCards());
				pr5.setDouble(3, c.getRedCards());
				pr5.addBatch();
			}
			pr5.executeBatch();
			pr5.execute("commit");
			pr5.closeOnCompletion();
			System.out.println("all records inserted into player_cards table");
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}