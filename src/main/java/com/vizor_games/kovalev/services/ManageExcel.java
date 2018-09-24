package com.vizor_games.kovalev.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.vizor_games.kovalev.Country;
import com.vizor_games.kovalev.MatchResults;
import com.vizor_games.kovalev.Player;
import com.vizor_games.kovalev.PlayerAssistsGoals;
import com.vizor_games.kovalev.PlayerCard;

/*
 * This class manages to fetch Excel data into lists
 */
public class ManageExcel {
	 String COUNTRY_PATH="C:\\Users\\Nikhil\\Documents\\db1_project1\\Country.xlsx";
	 String MATCH_RESULTS_PATH="C:\\Users\\Nikhil\\Documents\\db1_project1\\Match_results.xlsx";
	 String PLAYER_ASSISTS_GOALS_PATH="C:\\\\Users\\\\Nikhil\\\\Documents\\\\db1_project1\\Player_Assists_Goals.xlsx";
	 String PLAYER_CARDS_PATH="C:\\Users\\Nikhil\\Documents\\db1_project1\\Player_Cards.xlsx";
	 String PLAYERS_PATH="C:\\Users\\Nikhil\\Documents\\db1_project1\\Players.xlsx";
	
	 List<Country> countryList = new ArrayList<Country>();
	 List<Player> playerList = new ArrayList<Player>();
	 List<MatchResults> matchResultsList = new ArrayList<MatchResults>();
	 List<PlayerCard> playerCardList = new ArrayList<PlayerCard>();
	 List<PlayerAssistsGoals> playerAssistsGoalsList = new ArrayList<PlayerAssistsGoals>();
	
	 public String trimForList(String str) {
			String result=str;
			if(str.charAt(0) == '\'' && str.charAt(str.length()-1) == '\'') {
				result=str.substring(1, str.length()-1);
			}
		return result;
	}
	public List<Country> getCountries() throws IOException {
		Iterator<Row> rowIterator = getRowIterator(COUNTRY_PATH);
		while(rowIterator.hasNext()) {
			XSSFRow row = (XSSFRow) rowIterator.next();
			Country c = new Country(row);
			countryList.add(c);
		}
		return countryList;	
	}
	
	public List<MatchResults> getMatchResults() throws IOException {
		Iterator<Row> rowIterator = getRowIterator(MATCH_RESULTS_PATH);
		while(rowIterator.hasNext()) {
			XSSFRow row = (XSSFRow) rowIterator.next();
			MatchResults m= new MatchResults(row);
			matchResultsList.add(m);
		}
		return matchResultsList;
	}
	
	public List<Player> getPlayers() throws IOException {
		Iterator<Row> rowIterator = getRowIterator(PLAYERS_PATH);
		while(rowIterator.hasNext()) {
			XSSFRow row = (XSSFRow) rowIterator.next();
			Player p= new Player(row);
			playerList.add(p);
		}
		return playerList;
	}
	
	public List<PlayerAssistsGoals> getPlayerAssists() throws IOException {
		Iterator<Row> rowIterator = getRowIterator(PLAYER_ASSISTS_GOALS_PATH);
		while(rowIterator.hasNext()) {
			XSSFRow row = (XSSFRow) rowIterator.next();
			PlayerAssistsGoals p= new PlayerAssistsGoals(row);
			playerAssistsGoalsList.add(p);
		}
		return playerAssistsGoalsList;
	}
	
	public List<PlayerCard> getPlayerCards() throws IOException {
		Iterator<Row> rowIterator = getRowIterator(PLAYER_ASSISTS_GOALS_PATH);
		while(rowIterator.hasNext()) {
			XSSFRow row = (XSSFRow) rowIterator.next();
			PlayerCard p= new PlayerCard(row);
			playerCardList.add(p);
		}
		return playerCardList;
	}
	
	public static Iterator<Row> getRowIterator(String path) throws IOException{
		File f = new File(path);
		FileInputStream fis = new FileInputStream(f);	
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
	    XSSFSheet spreadsheet = workbook.getSheetAt(0);
	    Iterator < Row > rowIterator = spreadsheet.iterator();
	    workbook.close();
		return rowIterator;
	}
}
