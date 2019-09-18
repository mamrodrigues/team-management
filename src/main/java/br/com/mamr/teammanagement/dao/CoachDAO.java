package br.com.mamr.teammanagement.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.mamr.teammanagement.model.Coach;

@Repository
@Transactional
public class CoachDAO extends BaseDAO<Coach>{
	
	public CoachDAO() {
		super(Coach.class);
	}

	protected CoachDAO(Class<Coach> persistedClass) {
		super(persistedClass);
	}

}
