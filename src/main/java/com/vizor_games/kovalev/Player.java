package com.vizor_games.kovalev;

import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;

/*
 * This calls holds information about Player
 */
public class Player {
	double playerId;
	String name;
	String fname;
	String lname;
	String DOB;
	String country;
	double height;
	String club;
	String position;
	double capsForCountry;
	char isCaption;

	public Player(XSSFRow row){
			Iterator<Cell> cellIterator=row.iterator();
			this.setPlayerId(cellIterator.next().getNumericCellValue());
			this.setName(cellIterator.next().getStringCellValue());
			this.setFname(cellIterator.next().getStringCellValue());
			this.setLname(cellIterator.next().getStringCellValue());
			this.setDOB(cellIterator.next().getStringCellValue());
			this.setCountry(cellIterator.next().getStringCellValue());
			this.setHeight(cellIterator.next().getNumericCellValue());
			this.setClub(cellIterator.next().getStringCellValue());
			this.setPosition(cellIterator.next().getStringCellValue());
			this.setCapsForCountry(cellIterator.next().getNumericCellValue());
			if(cellIterator.next().getBooleanCellValue()){
				this.setIsCaption('Y');
			}else {
				this.setIsCaption('N');
			}
	}
	public Player() {
		// TODO Auto-generated constructor stub
	}
	public double getPlayerId() {
		return playerId;
	}
	public void setPlayerId(double d) {
		this.playerId = d;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String dOB) {
		DOB = dOB;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double d) {
		this.height = d;
	}
	public String getClub() {
		return club;
	}
	public void setClub(String club) {
		this.club = club;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public double getCapsForCountry() {
		return capsForCountry;
	}
	public void setCapsForCountry(double d) {
		this.capsForCountry = d;
	}
	public char getIsCaption() {
		return isCaption;
	}
	public void setIsCaption(char isCaption) {
		this.isCaption = isCaption;
	}
	
}
