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
public class MovieAdminButtonPageController {
		
		private final MovieService service;

		@Autowired
		public MovieAdminButtonPageController(MovieService service) {
			this.service = service;
		}
		@GetMapping(value={"adminButton"})
		public String adminPage1(Model model) throws Exception {
			model.addAttribute("list" , service.selectMovieList());

			System.out.println(model);
			
			return "movie/adminButton";
		}
		@GetMapping(value={"adminInsert"})
		public String adminPage2(Model model) throws Exception {
			model.addAttribute("list" , service.selectMovieList());
			
			System.out.println(model);
			
			return "movie/adminInsert";
		}
		@GetMapping(value={"adminUpdateSelect"})
		public String adminPage3(Model model) throws Exception {
			model.addAttribute("list" , service.selectMovieList());
			
			System.out.println(model);
			
			return "movie/adminUpdateSelect";
		}
		
}
