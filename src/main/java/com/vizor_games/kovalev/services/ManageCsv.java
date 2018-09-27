package com.vizor_games.kovalev.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.vizor_games.kovalev.Proceeds;

/*
 * This class manages to fetch CSV file data into lists
 */
public class ManageCsv {
	FileReader f = null;
	BufferedReader br = null;	
	List<Proceeds> proceeds = null;

		
	
	public List<Proceeds> getProceeds(){
		return proceeds;
	}
	public ManageCsv() {		
		proceeds = new ArrayList<Proceeds>();		
	}
	public String trimForList(String str) {
		String result=str;
		if(str.charAt(0) == '\'' && str.charAt(str.length()-1) == '\'') {
			result=str.substring(1, str.length()-1);
		}
	return result;
	}
	public void ReadProceedsCsviOS(String path) throws IOException {
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
		System.out.println("successfully read iOS .csv file");
		}
	
	public void ReadProceedsCsvAndroid(String path) throws IOException {
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
		System.out.println("successfully read android .csv file");
		}	
}