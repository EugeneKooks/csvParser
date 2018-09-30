package com.games.kuks;

import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;

public class Revenue {
	String name;
	String installTime;
	String eventTime;
	String eventRevenueUSD;	
	String mediaSource;	
	String campaign;
	String countryCode;
	String customerUserID;
	String platform;
	
public Revenue() {
		
	}
	public Revenue(XSSFRow row){
			Iterator<Cell> cellIterator=row.iterator();
			this.setName(cellIterator.next().getStringCellValue());
			this.setInstallTime(cellIterator.next().getStringCellValue());
			this.setEventTime(cellIterator.next().getStringCellValue());
			this.setEventRevenueUSD(cellIterator.next().getStringCellValue());
			this.setMediaSource(cellIterator.next().getStringCellValue());
			this.setCampaign(cellIterator.next().getStringCellValue());
			this.setCountryCode(cellIterator.next().getStringCellValue());
			this.setCustomerUserID(cellIterator.next().getStringCellValue());
			this.setPlatform(cellIterator.next().getStringCellValue());			
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInstallTime() {
		return installTime;
	}
	public void setInstallTime(String installTime) {
		this.installTime = installTime;
	}
	public String getEventTime() {
		return eventTime;
	}
	public void setEventTime(String eventTime) {
		this.eventTime = eventTime;
	}
	public String getEventRevenueUSD() {
		return eventRevenueUSD;
	}
	public void setEventRevenueUSD(String eventRevenueUSD) {
		this.eventRevenueUSD = eventRevenueUSD;
	}
	public String getMediaSource() {
		return mediaSource;
	}
	public void setMediaSource(String mediaSource) {
		this.mediaSource = mediaSource;
	}
	public String getCampaign() {
		return campaign;
	}
	public void setCampaign(String campaign) {
		this.campaign = campaign;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getCustomerUserID() {
		return customerUserID;
	}
	public void setCustomerUserID(String customerUserID) {
		this.customerUserID = customerUserID;
	}
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
		
}
