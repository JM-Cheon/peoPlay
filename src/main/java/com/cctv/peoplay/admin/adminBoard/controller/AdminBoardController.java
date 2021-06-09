package com.cctv.peoplay.admin.adminBoard.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cctv.peoplay.admin.adminBoard.model.service.AdminBoardService;
import com.cctv.peoplay.board.model.service.BoardService;
import com.cctv.peoplay.board.page.PageDTO;
import com.cctv.peoplay.board.page.Pagenation;

@Controller
@RequestMapping("/admin/adminBoard/*")
public class AdminBoardController {

	private BoardService service;

	@Autowired
	public AdminBoardController(BoardService service) {
		this.service = service;
	}
	
//	 전체 list 조회
	@GetMapping("list")
	public String list(Model model, HttpServletRequest request){
		
		int pageNo =1 ;
	
		String currentPage = request.getParameter("currentPage");
		
//    페이징 처리
		if(currentPage !=null &&!"".equals(currentPage)) {
			
			pageNo= Integer.valueOf(currentPage);
			
			if(pageNo<1) {
				pageNo=1;
			}
		}
		int totalCount= service.selectCount();
		
		System.out.println(totalCount);
		
		int limit =15;
		
		int buttonAmount = 5;
	
		PageDTO pageInfo = Pagenation.getPageInfo(pageNo, totalCount, limit, buttonAmount);
		
		System.out.println(pageInfo);
//		리스트 조회	
		model.addAttribute("list", service.selectBoardList(pageInfo));
		
		model.addAttribute("pageInfo",pageInfo);
		System.out.println(model);
		return "admin/adminBoard/list";
	}
	
	
}
