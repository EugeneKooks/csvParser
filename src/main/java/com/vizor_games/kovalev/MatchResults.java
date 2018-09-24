package com.vizor_games.kovalev;

import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;

/*
 * This calls holds information about match_results
 */
public class MatchResults {
	double matchId;
	String dateOfMatch;
	String startTiemOfMatch;
	String team1;
	String team2;
	double team1Score;
	double team2Score;
	String stadiumName;
	String hostCity;
	
	public MatchResults(XSSFRow row){
			Iterator<Cell> cellIterator=row.iterator();
			this.setMatchId(cellIterator.next().getNumericCellValue());
			this.setDateOfMatch(cellIterator.next().getStringCellValue());
			this.setStartTiemOfMatch(cellIterator.next().getStringCellValue());
			this.setTeam1(cellIterator.next().getStringCellValue());
			this.setTeam2(cellIterator.next().getStringCellValue());
			this.setTeam1Score(cellIterator.next().getNumericCellValue());
			this.setTeam2Score(cellIterator.next().getNumericCellValue());
			this.setStadiumName(cellIterator.next().getStringCellValue());
			this.setHostCity(cellIterator.next().getStringCellValue());
	}
	
	public MatchResults() {
		// TODO Auto-generated constructor stub
	}

	public double getMatchId() {
		return matchId;
	}
	public void setMatchId(double d) {
		this.matchId = d;
	}
	public String getDateOfMatch() {
		return dateOfMatch;
	}
	public void setDateOfMatch(String date) {
		this.dateOfMatch = date;
	}
	public String getStartTiemOfMatch() {
		return startTiemOfMatch;
	}
	public void setStartTiemOfMatch(String startTiemOfMatch) {
		this.startTiemOfMatch = startTiemOfMatch;
	}
	public String getTeam1() {
		return team1;
	}
	public void setTeam1(String team1) {
		this.team1 = team1;
	}
	public String getTeam2() {
		return team2;
	}
	public void setTeam2(String team2) {
		this.team2 = team2;
	}
	public double getTeam1Score() {
		return team1Score;
	}
	public void setTeam1Score(double d) {
		this.team1Score = d;
	}
	public double getTeam2Score() {
		return team2Score;
	}
	public void setTeam2Score(double team2Score) {
		this.team2Score = team2Score;
	}
	public String getStadiumName() {
		return stadiumName;
	}
	public void setStadiumName(String stadiumName) {
		this.stadiumName = stadiumName;
	}
	public String getHostCity() {
		return hostCity;
	}
	public void setHostCity(String hostCity) {
		this.hostCity = hostCity;
	}
}
