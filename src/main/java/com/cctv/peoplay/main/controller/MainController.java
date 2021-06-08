package com.cctv.peoplay.main.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cctv.peoplay.main.model.service.MainService;
import com.cctv.peoplay.member.model.dto.MemberDTO;

@Controller
@RequestMapping("/*")
public class MainController {
	
	private final MainService mainService;
	
	@Autowired
	public MainController(MainService mainService) {
		this.mainService = mainService;
	}
	
	@GetMapping(value={"/", "main"})
	public String main(Model model, HttpServletRequest request) {
		
		MemberDTO loginMember = (MemberDTO) request.getSession().getAttribute("loginMember");
		
		model.addAttribute("banner", mainService.selectBannerMovie());
		model.addAttribute("bestList", mainService.selectBestMovieList());
		model.addAttribute("newList", mainService.selectNewMovieList());
		
		if(loginMember != null) {
			
			int no = loginMember.getUserNo();
			
			model.addAttribute("zzimList", mainService.selectMemberWishMovieList(no));
			model.addAttribute("favList", mainService.selectMemberFavoriteMovieList(no));
		}

		return "main/main";
	}
}
