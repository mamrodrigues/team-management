package br.com.mamr.teammanagement.domain;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Team {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	@OneToOne
	private Coach coach;
	
	private String emblem;

	@OneToMany(mappedBy = "team")
	private List<Player> players;
	
	@ManyToMany(mappedBy = "teams")
	private List<Championship> championships;
	
	@Temporal(TemporalType.DATE)
	private Calendar birthdate;
	
	private Sport sport;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Coach getCoach() {
		return coach;
	}

	public void setCoach(Coach coach) {
		this.coach = coach;
	}

	public String getEmblem() {
		return emblem;
	}

	public void setEmblem(String emblem) {
		this.emblem = emblem;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public Calendar getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Calendar birthdate) {
		this.birthdate = birthdate;
	}

	public Sport getSport() {
		return sport;
	}

	public void setSport(Sport sport) {
		this.sport = sport;
	}

	public List<Championship> getChampionships() {
		return championships;
	}

	public void setChampionships(List<Championship> championships) {
		this.championships = championships;
	}
	
}
