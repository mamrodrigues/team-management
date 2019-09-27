package br.com.mamr.teammanagement.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.mamr.teammanagement.domain.Team;

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