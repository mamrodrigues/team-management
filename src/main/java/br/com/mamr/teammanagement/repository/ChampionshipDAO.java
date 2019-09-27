package br.com.mamr.teammanagement.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.mamr.teammanagement.domain.Championship;

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
