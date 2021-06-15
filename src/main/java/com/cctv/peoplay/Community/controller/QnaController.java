package com.cctv.peoplay.Community.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cctv.peoplay.Community.model.dto.PageInfoDTO;
import com.cctv.peoplay.Community.model.dto.QnaDTO;
import com.cctv.peoplay.Community.model.dto.commentDTO;
import com.cctv.peoplay.Community.model.service.QnaService;
import com.cctv.peoplay.Community.model.service.ReplyService;
import com.cctv.peoplay.Community.paging.Pagenation;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


@Controller
@RequestMapping("/QNA/*")
public class QnaController {

	private final QnaService qnaService;
	private final ReplyService replyService;

	@Autowired
	public QnaController(QnaService qnaService,ReplyService replyService) {
		this.qnaService = qnaService;
		this.replyService = replyService;
		
	
	}
	
	// QNA 리스트 + 페이징 처리
	@GetMapping("qnaList")
	public String qnaList(Model model, HttpServletRequest request) {

		String currentPage = request.getParameter("currentPage");

		int pageNo = 1;

		if (currentPage != null && !"".equals(currentPage)) {
			pageNo = Integer.valueOf(currentPage);

			if (pageNo <= 0) {
				pageNo = 1;
			}
		}
		// 페이징 처리용 게시글 총 갯수
		int totalCount = qnaService.count();
		
		int limit = 10;

		int buttonAmount = 5;

		PageInfoDTO pageInfo = Pagenation.getPageInfo(pageNo, totalCount, limit, buttonAmount);
		
		// 게시글 목록
		List<QnaDTO> list = qnaService.qnalist(pageInfo);
		
		model.addAttribute("list", list);
		model.addAttribute("pageInfo", pageInfo);

		return "Community/QnaList";

	}

	// 상세페이지 
	@GetMapping("qnaDetail/{inquiryNo}")
	public String qnaDetail(Model model, @PathVariable("inquiryNo") int inquiryNo,HttpServletResponse response) {
		response.setContentType("application/json; charset=UTF-8");
		
		QnaDTO qnaDetail = qnaService.QnaDetail(inquiryNo);
		List<commentDTO> selectComment = replyService.selectComment(inquiryNo);
	
		model.addAttribute("qnaDetail", qnaDetail);
		model.addAttribute("selectComment",selectComment);
		
		return "Community/qnaDetail";
	}

	// 글작성 페이지
	@GetMapping("insert")
	public String insert(Model model) {

		return "Community/QnaInsert";
	}

	// 글작성 인서트 
	@PostMapping("insertWrite")
	public String insertWrite(QnaDTO qnaDTO, Model model) {
		
		int qnaInsertResult = qnaService.insertQna(qnaDTO);
		
		// 트렌젝션 처리
		if(qnaInsertResult > 0) {
			
			model.addAttribute("successCode","qnaInsertWrite");
			
		}else {
			
			model.addAttribute("successCode","qnaInsertFailure");
			
		}
		
		return "Community/success";
	}

	// 상세페이지 - 수정하기
	@GetMapping("update/{inquiryNo}")
	public String update(Model model, @PathVariable("inquiryNo") int inquiryNo) {

		QnaDTO update = qnaService.QnaDetail(inquiryNo);
		
		model.addAttribute("update", update);

		return "Community/qnaUpdate";
	}

	// 수정하기 
	@PostMapping("updateWrite")
	public String updateWrite(@ModelAttribute("qnaDTO") QnaDTO qnaDTO, Model model) {

		int qnaUpdateResult = qnaService.updateWrite(qnaDTO);
		
		// 트렌젝션 처리
		if(qnaUpdateResult > 0) {
			
			model.addAttribute("successCode","qnaUpdateWrite");
		}else {
			
			model.addAttribute("successCode","qnaUpdateFailure");
		}
		
		
		return "Community/success";
	}

	@GetMapping("search")
	public String search(Model model, HttpServletRequest request, @Param("searchCondition") String searchCondition,
			@Param("searchValue") String searchValue) {

		String condition = request.getParameter("searchCondition");
		String value = request.getParameter("searchValue");
		
		// 검색 후 게시물 페이징 처리용  Map
		HashMap<String, String> searchMap = new HashMap<>();
		searchMap.put("searchCondition", condition);
		searchMap.put("searchValue", value);

		String currentPage = request.getParameter("currentPage");

		int pageNo = 1;

		if (currentPage != null && !"".equals(currentPage)) {
			pageNo = Integer.valueOf(currentPage);

			if (pageNo <= 0) {
				pageNo = 1;
			}
		}
		// 검색 후 게시물 총 갯수
		int totalCount = qnaService.searchCount(searchMap);
		
		int limit = 10;

		int buttonAmount = 5;

		PageInfoDTO pageInfo = Pagenation.getPageInfo(pageNo, totalCount, limit, buttonAmount);
		// 파라미터를 여러개 던질수 없어
		// 검색을 위해 map으로 묶어서 던짐
		HashMap<String, Object> searchListMap = new HashMap<>();
		searchListMap.put("searchCondition", searchCondition);
		searchListMap.put("searchValue", searchValue);
		searchListMap.put("startRow", pageInfo.getStartRow());
		searchListMap.put("endRow", pageInfo.getEndRow());
		
		List<QnaDTO> searchList = qnaService.searchList(searchListMap);
		
		// 게시물이 비어 있지 않다면 
		if(!searchList.isEmpty()) {
			model.addAttribute("searchList", searchList);
			model.addAttribute("pageInfo", pageInfo);
			model.addAttribute("searchCondition", condition);
			model.addAttribute("searchValue", value);
		}else{
			// 검색 후 게시글이 없다면 메시지를 띄우고 리스트 페이지로 돌아간다. 
			model.addAttribute("successCode" , "qnaSearch");
			return "Community/success";
		}
		

		return "Community/QnaList";

	}
	// QNA 삭제(업데이트)
		@GetMapping("delete/{inquiryNo}")
		public String qnaDelete (Model model, @PathVariable("inquiryNo") int inquiryNo) {
			
			 qnaService.qnaDelete(inquiryNo);
			
		

			return "redirect:/QNA/qnaList";
		}
		
}
