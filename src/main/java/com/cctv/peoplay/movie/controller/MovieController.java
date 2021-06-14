package com.cctv.peoplay.movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cctv.peoplay.movie.model.service.MovieService;

@Controller
@RequestMapping("/movie/*")
@SessionAttributes("loginMember")
public class MovieController {

	private final MovieService service;
	
	@Autowired
	public MovieController(MovieService service) {
		this.service = service;
	}
	
	
	/* 영화 리스트 맵핑 */
	@GetMapping("list")
	public String list(Model model) throws Exception {
		model.addAttribute("list" , service.selectMovieList());

//		System.out.println(model);
		
		return "movie/list";
	}
	
}
