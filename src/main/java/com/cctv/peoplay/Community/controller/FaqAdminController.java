package com.cctv.peoplay.Community.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cctv.peoplay.Community.model.dto.FaqDTO;
import com.cctv.peoplay.Community.model.dto.PageInfoDTO;
import com.cctv.peoplay.Community.model.service.FaqService;
import com.cctv.peoplay.Community.paging.Pagenation;
@Controller
@RequestMapping("/FaqAdmin/*")
public class FaqAdminController {

	private final FaqService faqService;

	@Autowired
	public FaqAdminController(FaqService faqService) {
		this.faqService = faqService;
	}
	
	// FaqAdmin 리스트 + 페이징 처리
		@GetMapping("faqAdminList")
		public String FaqAdminlist(Model model, HttpServletRequest request) {
			
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
			
			// 게시글 목록
			List<FaqDTO> list = faqService.faqList(pageInfo);
			
			model.addAttribute("faqAdminList", list);
			model.addAttribute("pageInfo", pageInfo);
			
			return "Community/FaqAdminList";
			
		}
		// 상세페이지
			@GetMapping("faqDetail/{faqNo}")
			public String ntcdetail(Model model, @PathVariable("faqNo") int faqNo,
					@ModelAttribute("FaqDTO") FaqDTO faqDTO) {
				
				// 상세페이지 가기
				FaqDTO faqdetail = faqService.FaqDetail(faqNo);

				model.addAttribute("faqdetail", faqdetail);
				
				return "Community/FaqDetail";
			}


		// 글작성 페이지
		@GetMapping("insert")
		public String insert(Model model) {

			return "Community/FaqInsert";
		}

		// 글작성 인서트
		@PostMapping("insertWrite")
		public String insertWrite(FaqDTO faqDTO, Model model) {

			int faninsertResult = faqService.insertFaq(faqDTO);
			
			if(faninsertResult > 0) {
				
				model.addAttribute("successCode","faqInsertWrite");
				
			}else {
				
				model.addAttribute("successCode","faqInsertFailure");
			}
			
			return "Community/success";
		}

		// 상세페이지 - 수정하기
		@GetMapping("update/{faqNo}")
		public String update(Model model, @PathVariable("faqNo") int faqNo) {

			FaqDTO update = faqService.FaqDetail(faqNo);
			
			model.addAttribute("update", update);

			return "Community/FaqUpdate";
		}

		// 수정하기
		@PostMapping("updateWrite")
		public String updateWrite(@ModelAttribute("faqDTO") FaqDTO faqDTO, Model model) {

			int faqUpdateResult = faqService.updateWrite(faqDTO);
			
			if(faqUpdateResult > 0) {
				
				model.addAttribute("successCode","faqUpdateWrite");
				
			}else {
				
				model.addAttribute("successCode","faqUpdateFailure");
				
			}
			
			return "Community/success";
		}

		@GetMapping("search")
		public String search(Model model, HttpServletRequest request, @Param("searchCondition") String searchCondition,
				@Param("searchValue") String searchValue) {

			String condition = request.getParameter("searchCondition");
			String value = request.getParameter("searchValue");

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
			int totalCount = faqService.searchCount(searchMap);

			int limit = 10;

			int buttonAmount = 5;

			PageInfoDTO pageInfo = Pagenation.getPageInfo(pageNo, totalCount, limit, buttonAmount);

			HashMap<String, Object> searchListMap = new HashMap<>();
			searchListMap.put("searchCondition", searchCondition);
			searchListMap.put("searchValue", searchValue);
			searchListMap.put("startRow", pageInfo.getStartRow());
			searchListMap.put("endRow", pageInfo.getEndRow());

			List<FaqDTO> searchList = faqService.searchlist(searchListMap);
			
			if(!searchList.isEmpty()) {
				model.addAttribute("searchList", searchList);
				model.addAttribute("pageInfo", pageInfo);
				model.addAttribute("searchCondition", condition);
				model.addAttribute("searchValue", value);
			}else{
				// 검색 후 게시글이 없다면 메시지를 띄우고 리스트 페이지로 돌아간다. 
				model.addAttribute("successCode" , "FaqAdminSearch");
				return "Community/success";

			}
			
			return "Community/FaqAdminList";

		}
		// faq 삭제(업데이트)
		@GetMapping("delete/{faqNo}")
		public String faqDelete (Model model, @PathVariable("faqNo") int faqNo) {
			
			faqService.faqDelete(faqNo);
			
			return "redirect:/FaqAdmin/faqAdminList";
		}
}
