package com.cctv.peoplay.admin.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cctv.peoplay.admin.member.model.service.AdminMemberService;
import com.cctv.peoplay.member.model.dto.MemberDTO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
@RequestMapping("/admin/*")
public class AdminMemberContoller {

	private final AdminMemberService memberService;
	
	@Autowired
	public AdminMemberContoller(AdminMemberService memberService) {
		this.memberService = memberService;
	}
	
	@GetMapping(value={"member", "member/main"})
	public String adminMemberMain(Model model) {
		
		return "admin/member/adminMember";
	}
	
	@PostMapping(value="member/list", produces="application/json; charset=UTF-8")
	@ResponseBody
	public String defaultMemberList() {
		
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		List<MemberDTO> memberList = memberService.selectAllMember();		
		return gson.toJson(memberList);
	}

	@PostMapping(value="member/noList", produces="application/json; charset=UTF-8")
	@ResponseBody
	public String noMemberList(HttpServletRequest request) {
		
		int no = Integer.valueOf(request.getParameter("no"));
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		List<MemberDTO> memberList = memberService.selectMemberByNo(no);		
		return gson.toJson(memberList);
	}

	@PostMapping(value="member/nameList", produces="application/json; charset=UTF-8")
	@ResponseBody
	public String nameMemberList(HttpServletRequest request) {
		
		String name = request.getParameter("name");
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		List<MemberDTO> memberList = memberService.selectMemberByName(name);		
		return gson.toJson(memberList);
	}

	@PostMapping(value="member/nickList", produces="application/json; charset=UTF-8")
	@ResponseBody
	public String nicknameMemberList(HttpServletRequest request) {
		
		String nickname = request.getParameter("nick");
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		List<MemberDTO> memberList = memberService.selectMemberByNickname(nickname);		
		return gson.toJson(memberList);
	}
	
	@PostMapping(value="member/reportList", produces="application/json; charset=UTF-8")
	@ResponseBody
	public String reportMemberList(HttpServletRequest request) {
		
		int reportCount = Integer.valueOf(request.getParameter("report"));
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		List<MemberDTO> memberList = memberService.selectMemberByReportCount(reportCount);		
		return gson.toJson(memberList);
	}
	
	@PostMapping(value="member/statusList", produces="application/json; charset=UTF-8")
	@ResponseBody
	public String statusMemberList(HttpServletRequest request) {
		
		String status = request.getParameter("status");
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		List<MemberDTO> memberList = memberService.selectMemberByStatus(status);		
		return gson.toJson(memberList);
	}

	@PostMapping(value="member/blackList", produces="application/json; charset=UTF-8")
	@ResponseBody
	public String blackMemberList(HttpServletRequest request) {
		
		String black = request.getParameter("black");
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		List<MemberDTO> memberList = memberService.selectMemberByBlack(black);		
		return gson.toJson(memberList);
	}

	@PostMapping(value="member/black", produces="application/json; charset=UTF-8")
	@ResponseBody
	public String MemberBlack(HttpServletRequest request) {
		
		MemberDTO member = new MemberDTO();
		member.setUserNo(Integer.valueOf(request.getParameter("no")));
		Gson gson = new GsonBuilder().create();
		int result = memberService.updateMemberBlack(member);
		
		return gson.toJson(result);
	}
	
}
