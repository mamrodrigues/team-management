package br.com.mamr.teammanagement.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.mamr.teammanagement.dao.TeamDAO;
import br.com.mamr.teammanagement.infra.FileSaver;
import br.com.mamr.teammanagement.model.Team;
import br.com.mamr.teammanagement.validation.TeamValidation;

@Controller
@RequestMapping("/teams")
public class TeamController {
	
	@Autowired
	private TeamDAO dao;
	
	@Autowired
    private FileSaver fileSaver;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(new TeamValidation());
	}

//	@RequestMapping(method = RequestMethod.GET)
//	public ModelAndView form(Team team) {
//		ModelAndView modelAndView = new ModelAndView("/team/register");
//		//modelAndView.addObject("players", players);
//		return modelAndView;
//	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView register(MultipartFile emblem, @Valid Team team, BindingResult result, 
				RedirectAttributes redirectAttributes){
		
//		if(result.hasErrors()) {
//			return form(team);
//		}
		
		String path = fileSaver.write("team-emblem", emblem);
		team.setEmblem(path);
		
		dao.save(team);
		
		redirectAttributes.addFlashAttribute("sucesso", "Team successfully registered");
		
		return new ModelAndView("redirect:produtos");
	}
	
	@RequestMapping( method=RequestMethod.GET)
	public ModelAndView list() {
		List<Team> teams = dao.getList();
		ModelAndView modelAndView = new ModelAndView("/team/list");
		modelAndView.addObject("team", teams);
		return modelAndView;
	}
	
	@RequestMapping("/{id}")
	public ModelAndView detail(@PathVariable("id") Long id){
	    ModelAndView modelAndView = new ModelAndView("/team/detail");
	    Team team = dao.find(id);
	    modelAndView.addObject("team", team);
	    return modelAndView;
	}
}
