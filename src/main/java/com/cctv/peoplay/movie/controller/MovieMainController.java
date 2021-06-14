package com.cctv.peoplay.movie.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cctv.peoplay.movie.model.service.MovieService;

@Controller
@RequestMapping("/*")
@SessionAttributes("loginMember")
public class MovieMainController {
	
	private final MovieService service;
	
	@Autowired
	public MovieMainController(MovieService service) {
		this.service = service;
	}
	
	/* 메인 관련 (테스트)*/
	@GetMapping(value= {"main"})
	public String mainlist(Model model, HttpServletRequest request) throws Exception {

		model.addAttribute("mainTop" , service.mainBastMovie());
		model.addAttribute("list" , service.selectMovieList());
		model.addAttribute("newTopMovie", service.mainNewTopMovie());
		model.addAttribute("topFavoriteMovie", service.mainTopFavoriteMovie());
//		System.out.println(model);

		return "main/main";
	}
}
