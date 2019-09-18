package br.com.mamr.teammanagement.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.mamr.teammanagement.model.Team;

@Repository
@Transactional
public class TeamDAO extends BaseDAO<Team>{
	
	public TeamDAO() {
		super(Team.class);
	}

	protected TeamDAO(Class<Team> persistedClass) {
		super(persistedClass);
	}
	
}