package br.com.mamr.teammanagement.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.mamr.teammanagement.domain.Player;

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
