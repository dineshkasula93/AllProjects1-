package com.bellinfo.cricket.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="player")
public class Player {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String teamname;
	private String playername;
	private int age;
	private String specialization;
	private int noc;
	private int totalruns;
	

	public String getTeamname() {
		return teamname;
	}

	public void setTeamname(String teamname) {
		this.teamname = teamname;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public int getNoc() {
		return noc;
	}

	public void setNoc(int noc) {
		this.noc = noc;
	}

	public int getTotalruns() {
		return totalruns;
	}

	public void setTotalruns(int totalruns) {
		this.totalruns = totalruns;
	}

	public String getPlayername() {
		return playername;
	}

	public void setPlayername(String playername) {
		this.playername = playername;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	

	@Override
	public String toString() {
		return "Player [id=" + id + ", teamname=" + teamname + ", playername=" + playername + ", age=" + age
				+ ", specialization=" + specialization + ", noc=" + noc + ", totalruns=" + totalruns + "]";
	}
	
	
	

}
