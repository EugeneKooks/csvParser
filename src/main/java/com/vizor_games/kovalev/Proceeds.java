package com.vizor_games.kovalev;

import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
/*
 * This calls holds information about Proceeds
 */

public class Proceeds {
	String name;	
	String date;
	String media;
	String campaign;
	String platform;
	Double installs;
	String cost;	
	
public Proceeds() {
		
	}
	public Proceeds(XSSFRow row){
			Iterator<Cell> cellIterator=row.iterator();
			this.setName(cellIterator.next().getStringCellValue());
			this.setDate(cellIterator.next().getStringCellValue());
			this.setMedia(cellIterator.next().getStringCellValue());
			this.setCampaign(cellIterator.next().getStringCellValue());
			this.setPlatform(cellIterator.next().getStringCellValue());
			this.setInstalls(cellIterator.next().getNumericCellValue());
			this.setCost(cellIterator.next().getStringCellValue());
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getMedia() {
		return media;
	}
	public void setMedia(String media) {
		this.media = media;
	}
	public String getCampaign() {
		return campaign;
	}
	public void setCampaign(String campaign) {
		this.campaign = campaign;
	}
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	public Double getInstalls() {
		return installs;
	}
	public void setInstalls(Double installs) {
		this.installs = installs;
	}
	public String getCost() {
		return cost;
	}
	public void setCost(String cost) {
		this.cost = cost;
	}	
}
