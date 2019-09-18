package br.com.mamr.teammanagement.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.mamr.teammanagement.model.Player;

@Repository
@Transactional
public class PlayerDAO extends BaseDAO<Player> {
	
	public PlayerDAO() {
		super(Player.class);
	}

	protected PlayerDAO(Class<Player> persistedClass) {
		super(persistedClass);
	}

}
