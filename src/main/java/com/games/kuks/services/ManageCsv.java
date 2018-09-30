package com.vizor_games.kovalev.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.vizor_games.kovalev.Proceeds;
import com.vizor_games.kovalev.Revenue;

/*
 * This class manages to fetch CSV file data into lists
 */
public class ManageCsv {
	FileReader f = null;
	BufferedReader br = null;	
	List<Proceeds> proceeds = null;
	List<Revenue> revenue = null;
		
	
	public List<Proceeds> getProceeds(){
		return proceeds;
	}

	public List<Revenue> getRevenue(){
		return revenue;
	}
	
	public ManageCsv() {		
		proceeds = new ArrayList<Proceeds>();
		revenue = new ArrayList<Revenue>();
	}
	public String trimForList(String str) {
		String result=str;
		if(str.charAt(0) == '\'' && str.charAt(str.length()-1) == '\'') {
			result=str.substring(1, str.length()-1);
		}
	return result;
	}
	public void ReadProceedsCSViOS(String path) throws IOException {
		f=new FileReader(new File(path));
		br=new BufferedReader(f);
		String line=null;	
		while((line=br.readLine())!=null) {
			String[] attributes = line.split(",");
			Proceeds p= new Proceeds();
			p.setName(trimForList(path));
			p.setDate(trimForList(attributes[0]));
			p.setMedia(trimForList(attributes[2]));
			p.setCampaign(trimForList(attributes[3]));
			p.setPlatform(trimForList("ios"));
			p.setInstalls(trimForList(attributes[7]));
			p.setCost(trimForList(attributes[13]));
			proceeds.add(p);
			}
		System.out.println("successfully read Proceeds iOS csv file");
		}
	
	public void ReadProceedsCSVAndroid(String path) throws IOException {
		f=new FileReader(new File(path));
		br=new BufferedReader(f);
		String line=null;	
		while((line=br.readLine())!=null) {
			String[] attributes = line.split(",");
			Proceeds p= new Proceeds();
			p.setName(trimForList(path));
			p.setDate(trimForList(attributes[0]));
			p.setMedia(trimForList(attributes[2]));
			p.setCampaign(trimForList(attributes[3]));
			p.setPlatform(trimForList("android"));
			p.setInstalls(trimForList(attributes[7]));
			p.setCost(trimForList(attributes[13]));
			proceeds.add(p);
			}
		System.out.println("successfully read Proceeds android csv file");
		}
	
	public void ReadRevenueCSViOS(String path) throws IOException {
		f=new FileReader(new File(path));
		br=new BufferedReader(f);
		String line=null;
		br.readLine();
		int i = 0;
		while((line=br.readLine())!=null) {
			String[] attributes = line.split(",");
			System.out.println("i = " + i);
			Revenue r= new Revenue();
			r.setName(trimForList(path));
			r.setInstallTime(trimForList(attributes[1]));
			r.setEventTime(trimForList(attributes[2]));
			r.setEventRevenueUSD(trimForList(attributes[10]));
			r.setMediaSource(trimForList(attributes[14]));
			r.setCampaign(trimForList(attributes[17]));
		    r.setCountryCode(trimForList(attributes[49]));
		    r.setCustomerUserID(trimForList(attributes[61]));
			if (i!=55) {r.setPlatform(trimForList(attributes[67]));}
			revenue.add(r);
			i++;
			}
		System.out.println("successfully read Revenue iOS csv file");
		}
	
	public void ReadRevenueCSVAndroid(String path) throws IOException {
		f=new FileReader(new File(path));
		br=new BufferedReader(f);
		String line=null;	
		while((line=br.readLine())!=null) {
			String[] attributes = line.split(",");
			Revenue r= new Revenue();
			r.setName(trimForList(path));
			r.setInstallTime(trimForList(attributes[2]));
			r.setEventTime(trimForList(attributes[3]));
			r.setEventRevenueUSD(trimForList(attributes[8]));
			r.setMediaSource(trimForList(attributes[12]));
			r.setCampaign(trimForList(attributes[15]));
			r.setCountryCode(trimForList(attributes[48]));
			r.setCustomerUserID(trimForList(attributes[62]));
			r.setPlatform(trimForList(attributes[65]));
			revenue.add(r);
			}
		System.out.println("successfully read Revenue android csv file");
		}
}