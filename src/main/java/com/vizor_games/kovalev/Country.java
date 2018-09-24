package com.vizor_games.kovalev
;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
/*
 * This calls holds information about Country
 */
public class Country {
	String countryName;
	float population;
	double noOfWorldcupsWon;
	String manager;
	public Country() {
		
	}
	public Country(XSSFRow row){
			Iterator<Cell> cellIterator=row.iterator();
			this.setCountryName(cellIterator.next().getStringCellValue());
			this.setPopulation(cellIterator.next().getNumericCellValue());
			this.setNoOfWorldcupsWon(cellIterator.next().getNumericCellValue());
			this.setManager(cellIterator.next().getStringCellValue());
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public float getPopulation() {
		return population;
	}
	public void setPopulation(double d) {
		this.population = (float) d;
	}
	public double getNoOfWorldcupsWon() {
		return noOfWorldcupsWon;
	}
	public void setNoOfWorldcupsWon(double d) {
		this.noOfWorldcupsWon = d;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
}