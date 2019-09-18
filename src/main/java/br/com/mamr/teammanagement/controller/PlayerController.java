package br.com.mamr.teammanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.mamr.teammanagement.dao.PlayerDAO;
import br.com.mamr.teammanagement.model.Player;

@Controller
@RequestMapping("/players")
public class PlayerController {

	@Autowired
	private PlayerDAO playerDAO;
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView add(Player team) {
		playerDAO.save(team);
		
		ModelAndView modelAndView = new ModelAndView("redirect:/players");
		return modelAndView;
	}
	
}
