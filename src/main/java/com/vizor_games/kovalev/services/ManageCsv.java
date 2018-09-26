package com.vizor_games.kovalev.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.vizor_games.kovalev.Country;
import com.vizor_games.kovalev.MatchResults;
import com.vizor_games.kovalev.Player;
import com.vizor_games.kovalev.PlayerAssistsGoals;
import com.vizor_games.kovalev.PlayerCard;
import com.vizor_games.kovalev.Proceeds;

/*
 * This class manages to fetch CSV file data into lists
 */
public class ManageCsv {
	FileReader f = null;
	BufferedReader br = null;
	List<Country> lstCountry = null;
	List<Player> lstPlayer = null;
	List<MatchResults> lstMatchResults = null;
	List<PlayerAssistsGoals> lstPlayerAssistsGoals = null;
	List<PlayerCard> lstPlayerCard = null;
	List<Proceeds> proceeds = null;
	
	
	public List<Country> getCountryList() {
		return lstCountry;
	}
	
	public List<Player> getPlayerList(){
		return lstPlayer;
	}
	
	public List<PlayerAssistsGoals> getPlayerAssistsGoals(){
		return lstPlayerAssistsGoals;
	}
	
	public List<MatchResults> getMatchResults(){
		return lstMatchResults;
	}
	
	public List<PlayerCard> getPlayerCards(){
		return lstPlayerCard;
	}
	
	public List<Proceeds> getProceeds(){
		return proceeds;
	}
	public ManageCsv() {
		// TODO Auto-generated constructor stub
		lstCountry = new ArrayList<Country>();
		lstPlayer = new ArrayList<Player>();
		lstMatchResults = new ArrayList<MatchResults>();
		lstPlayerAssistsGoals = new ArrayList<PlayerAssistsGoals>();
		lstPlayerCard = new ArrayList<PlayerCard>();
		proceeds = new ArrayList<Proceeds>();
		
	}
	public String trimForList(String str) {
		String result=str;
		if(str.charAt(0) == '\'' && str.charAt(str.length()-1) == '\'') {
			result=str.substring(1, str.length()-1);
		}
	return result;
	}
	public void ReadCountryCsv(String path) throws IOException {
		f=new FileReader(new File(path));
		br=new BufferedReader(f);
		String line=null;
		while((line=br.readLine())!=null) {
			String[] attributes = line.split(",");
			Country c= new Country();
			c.setCountryName(trimForList(attributes[0]));
			c.setPopulation(Double.parseDouble(attributes[1]));
			c.setNoOfWorldcupsWon(Double.parseDouble(attributes[2]));
			c.setManager(trimForList(attributes[3]));
			lstCountry.add(c);
			}
		System.out.println("successfully read country.csv file");
		}
	public void ReadPlayerCsv(String path) throws IOException {
		f=new FileReader(new File(path));
		br=new BufferedReader(f);
		String line=null;
		while((line=br.readLine())!=null) {
			String[] attributes = line.split(",");
			Player p= new Player();
			p.setPlayerId(Double.parseDouble(attributes[0]));
			p.setName(trimForList(attributes[1]));
			p.setFname(trimForList(attributes[2]));
			p.setLname(trimForList(attributes[3]));
			p.setDOB(trimForList(attributes[4]));
			p.setCountry(trimForList(attributes[5]));
			p.setHeight(Double.parseDouble(attributes[6]));
			p.setClub(trimForList(attributes[7]));
			p.setPosition(trimForList(attributes[8]));
			p.setCapsForCountry(Double.parseDouble(attributes[9]));
			p.setIsCaption(attributes[10].charAt(0));
			lstPlayer.add(p);
			}
		System.out.println("Successfully read players.csv file");
		}
	public void ReadMatchResultsCsv(String path) throws IOException {
		f=new FileReader(new File(path));
		br=new BufferedReader(f);
		String line=null;
		while((line=br.readLine())!=null) {
			String[] attributes = line.split(",");
			MatchResults r= new MatchResults();
			r.setMatchId(Double.parseDouble(attributes[0]));
			r.setDateOfMatch(trimForList(attributes[1]));
			r.setStartTiemOfMatch(trimForList(attributes[2]));
			r.setTeam1(trimForList(attributes[3]));
			r.setTeam2(trimForList(attributes[4]));
			r.setTeam1Score(Double.parseDouble(attributes[5]));
			r.setTeam2Score(Double.parseDouble(attributes[6]));
			r.setStadiumName(trimForList(attributes[7]));
			r.setHostCity(trimForList(attributes[8]));
			lstMatchResults.add(r);
			}
		System.out.println("Successfully read  match_results.csv file");
		}
	public void ReadPlayerAssistsGoalsCsv(String path) throws IOException{
		f=new FileReader(new File(path));
		br=new BufferedReader(f);
		String line=null;
		while((line=br.readLine())!=null) {
			String[] attributes = line.split(",");
			PlayerAssistsGoals a = new PlayerAssistsGoals();
			a.setPlayerId(Double.parseDouble(attributes[0]));
			a.setNoOfMatched(Double.parseDouble(attributes[1]));
			a.setGoals(Double.parseDouble(attributes[2]));
			a.setAssists(Double.parseDouble(attributes[3]));
			a.setMinutesPlayed(Double.parseDouble(attributes[4]));
			lstPlayerAssistsGoals.add(a);
		}
		System.out.println("Successfully read player_assists_goals.csv file");
	}
	public void ReadPlayerCardCsv(String path) throws IOException{
		f=new FileReader(new File(path));
		br=new BufferedReader(f);
		String line=null;
		while((line=br.readLine())!=null) {
			String[] attributes = line.split(",");
			PlayerCard c = new PlayerCard();
			c.setPlayerid(Double.parseDouble(attributes[0]));
			c.setYellowCards(Double.parseDouble(attributes[1]));
			c.setRedCards(Double.parseDouble(attributes[2]));
			lstPlayerCard.add(c);
		}
		System.out.println("Successfully read player_cards.csv file");
	}
}