package com.cctv.peoplay.movie.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cctv.peoplay.member.model.dto.MemberDTO;
import com.cctv.peoplay.member.model.service.MemberService;
import com.cctv.peoplay.movie.model.dto.MovieWatchListDTO;
import com.cctv.peoplay.movie.model.service.MovieService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
@RequestMapping("/movie/*")
@SessionAttributes("loginMember")
public class MoviePlayController {

	private final MovieService service;
	private final MemberService memberService;
	
	@Autowired
	public MoviePlayController(MovieService service, MemberService memberService) {
		this.service = service;
		this.memberService = memberService;		
	}
	

	/* 재생정보 가져오기 */
	@GetMapping(value={"/{no}/play"}, produces = "application/json; charset=UTF-8")
	public String list(Model model, HttpServletRequest request,@PathVariable("no") int no) throws Exception {
		MemberDTO loginMember = (MemberDTO) request.getSession().getAttribute("loginMember");

		model.addAttribute("play", service.selectmovie(no));
		model.addAttribute("number", no);

		/* 재생 목록 해시 맵 */
		HashMap<String, Integer> watchMap = new HashMap<>();
		watchMap.put("userNo", loginMember.getUserNo());
		watchMap.put("no", no);
		MovieWatchListDTO watchList = service.selectMovieWatchList(watchMap);
		/* 재생목록 list */
		if(!(watchList == null)) {
			if(!(watchList.getNo().getNo() == no && watchList.getUserNo().getUserNo() == loginMember.getUserNo())) {
			}else {
				String nothing = "있음";
				model.addAttribute("watchList", nothing);
			}
		} else {
			String nothing = "없음";
			model.addAttribute("watchList", nothing);
		}
		
		return "movie/play";
	}

	/* 재생목록 인서트 */
	@PostMapping(value = "watchList", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String watchListUpdate(@ModelAttribute MemberDTO member, Model model , HttpServletRequest request) {	
		MemberDTO loginMember = (MemberDTO) request.getSession().getAttribute("loginMember");

		int userNo = Integer.valueOf(request.getParameter("userNo"));
		int movieNo = Integer.valueOf(request.getParameter("movieNo"));
		
		HashMap<String, Object> watchListUpdate = new HashMap<String, Object>();
		watchListUpdate.put("userNo", userNo);
		watchListUpdate.put("no", movieNo);
		
		// 추가
		service.insertMovieWatchList(watchListUpdate);
		model.addAttribute("loginMember", memberService.selectMember(member));
		model.addAttribute("loginMember", memberService.selectMember(loginMember));

		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm:ss").create();
		
		return gson.toJson(watchListUpdate);
	}


}
