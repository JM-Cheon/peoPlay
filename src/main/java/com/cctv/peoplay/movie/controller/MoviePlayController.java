package com.cctv.peoplay.movie.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cctv.peoplay.movie.model.service.MovieService;

@Controller
@RequestMapping(value ="/movie/*", method= {RequestMethod.GET})
@SessionAttributes("loginMember")
public class MoviePlayController {

	private final MovieService service;
	
	@Autowired
	public MoviePlayController(MovieService service) {
		this.service = service;
	}	

	@GetMapping("/{no}/play")
	public String list(Model model, HttpServletRequest request,@PathVariable("no") int no) throws Exception {
		
		model.addAttribute("play", service.selectmovie(no));
		
		System.out.println("no:" + no);
		System.out.println(model);

		return "movie/play";
	}
}
