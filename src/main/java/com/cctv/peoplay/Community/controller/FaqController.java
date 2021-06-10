package com.cctv.peoplay.Community.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cctv.peoplay.Community.model.dto.FaqDTO;
import com.cctv.peoplay.Community.model.dto.PageInfoDTO;
import com.cctv.peoplay.Community.model.service.FaqService;
import com.cctv.peoplay.Community.paging.Pagenation;

@Controller
@RequestMapping("/Faq/*")
public class FaqController {

	private final FaqService faqService;

	@Autowired
	public FaqController(FaqService faqService) {
		this.faqService = faqService;
	}

	 //Faq 리스트 + 페이징 처리
	@GetMapping("faqList")
	public String Faqlist(Model model, HttpServletRequest request) {

		String currentPage = request.getParameter("currentPage");

		int pageNo = 1;

		if (currentPage != null && !"".equals(currentPage)) {
			pageNo = Integer.valueOf(currentPage);

			if (pageNo <= 0) {
				pageNo = 1;
			}
		}
		// 페이징 처리용 게시글 총 갯수
		int totalCount = faqService.count();

		int limit = 10;

		int buttonAmount = 5;

		PageInfoDTO pageInfo = Pagenation.getPageInfo(pageNo, totalCount, limit, buttonAmount);
		
		// 리스트 목록
		List<FaqDTO> list = faqService.faqList(pageInfo);

		model.addAttribute("faqList", list);
		model.addAttribute("pageInfo", pageInfo);

		return "Community/FaqList";

	}
	
}
