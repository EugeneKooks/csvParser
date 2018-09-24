package com.vizor_games.kovalev;

import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;

/*
 * This calls holds information about Player_assists_goals
 */
public class PlayerAssistsGoals {
	double playerId;
	double noOfMatched;
	double goals;
	double assists;
	double minutesPlayed;
	
	public PlayerAssistsGoals(XSSFRow row) {
			Iterator<Cell> cellIterator=row.iterator();
			this.setPlayerId(cellIterator.next().getNumericCellValue());
			this.setNoOfMatched(cellIterator.next().getNumericCellValue());
			this.setGoals(cellIterator.next().getNumericCellValue());
			this.setMinutesPlayed(cellIterator.next().getNumericCellValue());
	}
	public PlayerAssistsGoals() {
		// TODO Auto-generated constructor stub
	}
	public double getPlayerId() {
		return playerId;
	}
	public void setPlayerId(double playerId) {
		this.playerId = playerId;
	}
	public double getNoOfMatched() {
		return noOfMatched;
	}
	public void setNoOfMatched(double noOfMatched) {
		this.noOfMatched = noOfMatched;
	}
	public double getGoals() {
		return goals;
	}
	public void setGoals(double goals) {
		this.goals = goals;
	}
	public double getAssists() {
		return assists;
	}
	public void setAssists(double assists) {
		this.assists = assists;
	}
	public double getMinutesPlayed() {
		return minutesPlayed;
	}
	public void setMinutesPlayed(double minutesPlayed) {
		this.minutesPlayed = minutesPlayed;
	}
}
