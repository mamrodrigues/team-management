package br.com.mamr.teammanagement.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.mamr.teammanagement.model.Championship;

@Repository
@Transactional
public class ChampionshipDAO extends BaseDAO<Championship>{
	
	public ChampionshipDAO() {
		super(Championship.class);
	}

	protected ChampionshipDAO(Class<Championship> persistedClass) {
		super(persistedClass);
	}

}
