package com.vizor_games.kovalev.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.vizor_games.kovalev.MatchResults;
import com.vizor_games.kovalev.Proceeds;

/*
 * This class manages to fetch CSV file data into lists
 */
public class ManageCsv {
	FileReader f = null;
	BufferedReader br = null;	
	List<Proceeds> proceeds = null;
	List<MatchResults> lstMatchResults = null;

		
	public List<MatchResults> getLstMatchResults() {
		return lstMatchResults;
	}
	public void setLstMatchResults(List<MatchResults> lstMatchResults) {
		this.lstMatchResults = lstMatchResults;
	}
	public List<Proceeds> getProceeds(){
		return proceeds;
	}
	public ManageCsv() {		
		proceeds = new ArrayList<Proceeds>();
		lstMatchResults = new ArrayList<MatchResults>();
		
	}
	public String trimForList(String str) {
		String result=str;
		if(str.charAt(0) == '\'' && str.charAt(str.length()-1) == '\'') {
			result=str.substring(1, str.length()-1);
		}
	return result;
	}
	public void ReadProceedsCsvIos(String path) throws IOException {
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
		System.out.println("successfully read .csv file");
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
	
}