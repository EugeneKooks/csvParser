package com.vizor_games.kovalev;

import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;

/*
 * This calls holds information about Player_card
 */
public class PlayerCard {
	double playerid;
	double yellowCards;
	double redCards;
	public PlayerCard(XSSFRow row) {
			Iterator<Cell> cellIterator=row.iterator();
			this.setPlayerid(cellIterator.next().getNumericCellValue());
			this.setYellowCards(cellIterator.next().getNumericCellValue());
			this.setRedCards(cellIterator.next().getNumericCellValue());
	}
	public PlayerCard() {
		// TODO Auto-generated constructor stub
	}
	public double getPlayerid() {
		return playerid;
	}
	public void setPlayerid(double playerid) {
		this.playerid = playerid;
	}
	public double getYellowCards() {
		return yellowCards;
	}
	public void setYellowCards(double yellowCards) {
		this.yellowCards = yellowCards;
	}
	public double getRedCards() {
		return redCards;
	}
	public void setRedCards(double redCards) {
		this.redCards = redCards;
	}
	
}
