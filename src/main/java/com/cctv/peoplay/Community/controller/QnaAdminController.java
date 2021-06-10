package com.cctv.peoplay.Community.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cctv.peoplay.Community.model.dto.PageInfoDTO;
import com.cctv.peoplay.Community.model.dto.QnaDTO;
import com.cctv.peoplay.Community.model.dto.commentDTO;
import com.cctv.peoplay.Community.model.service.QnaService;
import com.cctv.peoplay.Community.model.service.ReplyService;
import com.cctv.peoplay.Community.paging.Pagenation;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


@Controller
@RequestMapping("/QNAadmin/*")
public class QnaAdminController {

	private final QnaService qnaService;
	private final ReplyService replyService;

	@Autowired
	public QnaAdminController(QnaService qnaService,ReplyService replyService) {
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
		List<QnaDTO> list = qnaService.qnaAdminlist(pageInfo);
		
		model.addAttribute("list", list);
		model.addAttribute("pageInfo", pageInfo);

		return "Community/QnaAdminList";

	}

	// 상세페이지 
	@GetMapping("qnaDetail/{inquiryNo}")
	public String qnaDetail(Model model, @PathVariable("inquiryNo") int inquiryNo,HttpServletResponse response) {
		response.setContentType("application/json; charset=UTF-8");
		
		QnaDTO qnaDetail = qnaService.QnaDetail(inquiryNo);
		
		List<commentDTO> selectComment = replyService.selectComment(inquiryNo);
	
		/* SimpleDateFormat로 처리 */
		
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
		

		return "Community/QnaAdminList";

	}
	// QNA 삭제(업데이트)
		@GetMapping("delete/{inquiryNo}")
		public String qnaDelete (Model model, @PathVariable("inquiryNo") int inquiryNo) {
			
			int deleteResult = qnaService.qnaDelete(inquiryNo);
			// 삭제는 스크립트로 처리 했음
			if(deleteResult > 0) {
				
			}

			return "redirect:/QNA/qnaList";
		}
		
		// ajax 댓글 인서트
		@RequestMapping(value = "/qnaDetail/reply", method = RequestMethod.POST, produces = "application/json; UTF-8")
		@ResponseBody
		public String CommentInsert(Model model, ModelAndView mv, @RequestParam("inquiryNo") int inquiryNo,
				@RequestParam("replyContent") String replyContent){
			
			HashMap<String, Object> insertReply = new HashMap<>();
			insertReply.put("inquiryNo", inquiryNo);
			insertReply.put("replyContent", replyContent);
			
			// 댓글 등록
			int insertReplyResult = replyService.CommentInsert(insertReply);
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
			
			if(insertReplyResult > 0) {
				
				int commentUpdateResult = qnaService.CommentUpdate(inquiryNo);
					
					if(commentUpdateResult > 0) {
						
						List<commentDTO> selectComment = replyService.selectComment(inquiryNo);
						
						return gson.toJson(selectComment);
					}
			}
			
			// 댓글 조회
			List<commentDTO> selectComment = replyService.selectComment(inquiryNo);
			
			return gson.toJson(selectComment);

		}
		// ajax 댓글 삭제
		@RequestMapping(value = "/qnaDetail/reply/delete", method = RequestMethod.POST, produces = "application/json; UTF-8")
		@ResponseBody
		public String  CommentDelete(Model model,@RequestParam("commentNo") int commentNo, @RequestParam("inquiryNo") int inquiryNo) {
			
			int commentDeleteResult = replyService.CommentDelete(commentNo);
			
			if(commentDeleteResult > 0) {
				
				int commentDeleteUpdateResult = qnaService.CommentDeleteUpdate(inquiryNo);
				
			}
			
			List<commentDTO> selectComment = replyService.selectComment(inquiryNo);
			
			model.addAttribute("selectComment",selectComment);
			
			Gson gson = new GsonBuilder().create();
			
			return gson.toJson(selectComment);
		}
		
		//댓글 수정 요청 처리(모달창)
		@RequestMapping(value = "/reply/update", method = RequestMethod.POST, produces = "application/json; UTF-8" )
		public String
			authCommentUpdate(@ModelAttribute commentDTO commDTO
					,@RequestParam("replyContent") String replyContent
					,@RequestParam("inquiryNo") int inquiryNo
					,@RequestParam("commentNo") int commentNo){
			
			HashMap<String, Object> updateReply = new HashMap<>();
			 updateReply.put("inquiryNo", inquiryNo);
			 updateReply.put("commentNo", commentNo);
			 updateReply.put("replyContent", replyContent);
			
			 int replyUpdate = replyService.replyUpdate(updateReply);
			 
			 if(replyUpdate > 0 ) {
				 
			 }
			
			return  "redirect:/QNA/qnaDetail/" + inquiryNo;
		}
		
		

}
