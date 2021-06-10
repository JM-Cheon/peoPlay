package com.cctv.peoplay.Community.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cctv.peoplay.Community.model.dto.NoticeDTO;
import com.cctv.peoplay.Community.model.dto.PageInfoDTO;
import com.cctv.peoplay.Community.model.service.NoticeService;
import com.cctv.peoplay.Community.paging.Pagenation;

@Controller
@RequestMapping("/noticeAdmin/*")
@SessionAttributes("loginMember")
public class NoticeAdminController {

	private final NoticeService notiecService;

	@Autowired
	public NoticeAdminController(NoticeService notiecService) {
		this.notiecService = notiecService;

	}

	// 공지사항 리스트 + 페이징 처리
	@GetMapping("ntclist")
	public String ntclist(Model model, HttpServletRequest request) {

		String currentPage = request.getParameter("currentPage");

		int pageNo = 1;

		if (currentPage != null && !"".equals(currentPage)) {
			pageNo = Integer.valueOf(currentPage);

			if (pageNo <= 0) {
				pageNo = 1;
			}
		}
		// 페이징 처리용 
		int totalCount = notiecService.count();
		int limit = 10;

		int buttonAmount = 5;
		// 페이징 처리용 DTO
		PageInfoDTO pageInfo = Pagenation.getPageInfo(pageNo, totalCount, limit, buttonAmount);
		// 리스트 가져온다
		List<NoticeDTO> list = notiecService.ntclist(pageInfo);

		model.addAttribute("list", list);
		model.addAttribute("pageInfo", pageInfo);

		return "Community/noticeAdminList";

	}

	// 글작성 페이지 
	@GetMapping("insert")
	public String insert(Model model) {

		return "Community/noticeInsert";
	}

	// 글작성 인서트 
	@PostMapping("insertWrite")
	public String insertWrite(NoticeDTO ntcDTO, Model model) {
		
		int ntcinsertResult = notiecService.insertNotice(ntcDTO);
		
		if(ntcinsertResult > 0) {
			
			model.addAttribute("successCode","ntcInsertWrite");
			
		}else {
			
			model.addAttribute("successCode","ntcInsertFailure");
			
		}
		
		
		return "Community/success";
	}

	// 상세페이지 - 수정하기
	@GetMapping("update/{ntcNo}")
	public String update(Model model, @PathVariable("ntcNo") int ntcNo) {

		NoticeDTO update = notiecService.ntcdetail(ntcNo);
		
		model.addAttribute("update", update);

		return "Community/noticeUpdate";
	}

	// 수정하기 
	@PostMapping("updateWrite")
	public String updateWrite(NoticeDTO ntcDTO, Model model) {

		int ntcUpdateResult = notiecService.updateWrite(ntcDTO);
		
		if(ntcUpdateResult > 0) {
			
			model.addAttribute("successCode","ntcUpdate");
			
		}else {
			
			model.addAttribute("successCode","ntcUpdateFailure");
			
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
		// 검색 후 페이징 처리용
		int totalCount = notiecService.searchCount(searchMap);
		int limit = 10;

		int buttonAmount = 5;

		PageInfoDTO pageInfo = Pagenation.getPageInfo(pageNo, totalCount, limit, buttonAmount);
		
		// 검색하려고 Map에 담았다.
		HashMap<String, Object> searchListMap = new HashMap<>();
		searchListMap.put("searchCondition", searchCondition);
		searchListMap.put("searchValue", searchValue);
		searchListMap.put("startRow", pageInfo.getStartRow());
		searchListMap.put("endRow", pageInfo.getEndRow());


		List<NoticeDTO> searchList = notiecService.searchlist(searchListMap);

		// 검색한 값이 있다면
		if(!searchList.isEmpty()) {
			model.addAttribute("searchList", searchList);
			model.addAttribute("pageInfo", pageInfo);
			model.addAttribute("searchCondition", condition);
			model.addAttribute("searchValue", value);
		}else{
			// 검색 후 게시글이 없다면 메시지를 띄우고 리스트 페이지로 돌아간다. 
			model.addAttribute("successCode" , "search");
			return "Community/success";
		}
		
		return "Community/noticeAdminList";
	}
	
	// 공지사항 삭제(업데이트)
	@GetMapping("delete/{ntcNo}")
	public String noticeDelete (Model model, @PathVariable("ntcNo") int ntcNo) {
		
		int ntcDeleteResult =  notiecService.noticeDelete(ntcNo);
		
		return "redirect:/noticeAdmin/ntclist";
	}
	
	
}
