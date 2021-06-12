package com.cctv.peoplay.board.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cctv.peoplay.board.model.dto.BoardAndMemberDTO;
import com.cctv.peoplay.board.model.dto.BoardDTO;
import com.cctv.peoplay.board.model.dto.BoardReplyDTO;
import com.cctv.peoplay.board.model.dto.ReplyOfDTO;
import com.cctv.peoplay.board.model.dto.ReportAndReportPlaceDTO;
import com.cctv.peoplay.board.model.service.BoardService;
import com.cctv.peoplay.board.page.PageDTO;
import com.cctv.peoplay.board.page.Pagenation;

@Controller
@RequestMapping("/board/*")
public class BoardController {

	private BoardService service;

	@Autowired
	public BoardController(BoardService service) {
		this.service = service;
	}

//	 전체 list 조회
	@GetMapping("list")
	public String list(Model model, HttpServletRequest request){
		
		int pageNo =1 ;
	
		String currentPage = request.getParameter("currentPage");
		
//     페이징 처리
		if(currentPage !=null &&!"".equals(currentPage)) {
			
			pageNo= Integer.valueOf(currentPage);
			
			if(pageNo<1) {
				pageNo=1;
			}
		}
		int totalCount= service.selectCount();
		
		
		int limit =10;
		
		int buttonAmount = 5;
	
		PageDTO pageInfo = Pagenation.getPageInfo(pageNo, totalCount, limit, buttonAmount);
		
//		리스트 조회	
		model.addAttribute("list", service.selectBoardList(pageInfo));
		
		model.addAttribute("pageInfo",pageInfo);
		return "board/list";
	}

//	작성페이지
	@GetMapping("write")
	public String write() {

		return "board/write";
	}

//	작성 메소드
	@PostMapping("insert")
	public String boardInsert(@ModelAttribute("board") BoardDTO board) {


		if (service.insertBoard(board) > 0) {
			return "redirect:/board/list";
		} else {
			return null;
		}
	}

//	세부 페이지 + 조회수 증가+ 댓글 + 대댓글
	@GetMapping("detail")
	public void boardDetail(Model model, HttpServletRequest request) {
		
		int no = Integer.valueOf(request.getParameter("no"));
		
//		조회수 증가
		service.increaceView(no);

//		게시글 정보
		model.addAttribute("detail",service.selectBoradDetail(no));

//		댓글 정보
		List<BoardReplyDTO> reply = service.selectReply(no);
		
//		대댓글 정보
		List<ReplyOfDTO> replyOf = service.selectReplyOf(no);
		
		model.addAttribute("replyOf", replyOf);
		model.addAttribute("reply",reply);
		
	}
	
//	검색 기능
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
		int totalCount = service.selectSearchCount(searchMap);

		int limit = 15;

		int buttonAmount = 5;

		PageDTO pageInfo = Pagenation.getPageInfo(pageNo, totalCount, limit, buttonAmount);

		HashMap<String, Object> searchListMap = new HashMap<>();
		searchListMap.put("searchCondition", searchCondition);
		searchListMap.put("searchValue", searchValue);
		searchListMap.put("startRow", pageInfo.getStartRow());
		searchListMap.put("endRow", pageInfo.getEndRow());


		List<BoardAndMemberDTO> searchList = service.selectSearchList(searchListMap);


	
			model.addAttribute("list", searchList);
			model.addAttribute("pageInfo", pageInfo);
			model.addAttribute("searchCondition", condition);
			model.addAttribute("searchValue", value);
		
		
		return "board/list";
	}
	
		
//	게시글 삭제
	@GetMapping("delete")
	public String deleteBoard (Model model, int no) {
		service.deleteBoard(no);
		
	return "redirect:/board/list";
	}
	
//	게시글 신고  및 신고 카운트 증가
	
	@GetMapping("report")
	public String reportBoard(@ModelAttribute("report") ReportAndReportPlaceDTO report, int reportedPerson) {

	service.insertReport(report) ;
	service.increaceReportCount(report);
	
	

	return "redirect:/board/detail?no="+report.getPlaceNo();
	
	}
	
	
// 댓글 작성
	@GetMapping("insertReply")
	 public String reply(Model model, HttpServletRequest request) {
		 
		int postNo= Integer.valueOf( request.getParameter("postNo"));
		int userNo= Integer.valueOf( request.getParameter("userNo"));
		String content= request.getParameter("content");

		HashMap<String, Object> replyMap = new HashMap<>();
		replyMap.put("postNo", postNo);
		replyMap.put("userNo", userNo);
		replyMap.put("content", content);

		
		service.insertReply(replyMap);
		service.increaceReplyCount(postNo);
	    List<BoardReplyDTO> replylist =service.selectReply(postNo);
	 	

		
		model.addAttribute("reply", replylist);
		

		return "redirect:/board/detail?no="+postNo;
	 }
	
//	 댓글 삭제
	@GetMapping("replyDelete")
	public String replyDelete(Model model,HttpServletRequest request ) {
		
		int replyNo = Integer.valueOf(request.getParameter("replyNo"));
		int boardNo = Integer.valueOf(request.getParameter("boardNo"));
		service.deleteReply(replyNo);
		service.decreaceReplyCount(boardNo);
		
		
		return "redirect:/board/detail?no="+boardNo;
	}
	
//	대댓글 작성
	@GetMapping("insertReplyOf")
	public String insertReplyOf(Model model, HttpServletRequest request) {
		
		String replyOfContent = request.getParameter("replyOfContent");
		int refNo= Integer.valueOf(request.getParameter("refNo"));
		int userNo = Integer.valueOf(request.getParameter("userNo"));
		int refBoardNo = Integer.valueOf(request.getParameter("refBoardNo"));
		
		HashMap<String, Object> replyOfMap = new HashMap<>();
		replyOfMap.put("replyOfContent", replyOfContent);
		replyOfMap.put("refNo", refNo);
		replyOfMap.put("userNo", userNo);
		replyOfMap.put("refBoardNo", refBoardNo);

		
		service.insertReplyOf(replyOfMap);
		service.increaceReplyCount(refBoardNo);
		
		List<ReplyOfDTO> replyOfList= service.selectReplyOf(refBoardNo);
		
		model.addAttribute("replyOf", replyOfList);
		
		
		
		return "redirect:/board/detail?no="+refBoardNo;
	}
	 
//	 대댓글 삭제
	@GetMapping("deleteReplyOf")
	public String deleteReplyOf(Model model, HttpServletRequest request) {
		
		int replyOfNo = Integer.valueOf(request.getParameter("replyOfNo"));
		int refBoardNo = Integer.valueOf(request.getParameter("refBoardNo"));
		
		
		
		service.deleteReplyOf(replyOfNo);
		
		service.decreaceReplyCount(refBoardNo);
		
		return "redirect:/board/detail?no="+refBoardNo;
	}
	
//	 modify 페이지 연결 및 select
	@GetMapping("modify")
	public void Boardmodify(Model model, HttpServletRequest request) {
		int no = Integer.valueOf(request.getParameter("no"));
		
		BoardAndMemberDTO board = service.modifyBoard(no);
				
		
		model.addAttribute("modify",board);
		
	}
	
//	 게시글 수정
	@PostMapping("modifyUpdate")
	public String modifyInsert(Model model, HttpServletRequest request) {
		
		int no = Integer.valueOf(request.getParameter("no"));
		String title= request.getParameter("title");
		String category = request.getParameter("category");
		String content = request.getParameter("content");
		
		HashMap<String, Object> modifyMap = new HashMap<>();
		modifyMap.put("no", no);
		modifyMap.put("title", title);
		modifyMap.put("category", category);
		modifyMap.put("content", content);

		 service.modifyUpdate(modifyMap);
		
		
		
		return "redirect:/board/detail?no="+no;
	}
	
//	 댓글 수정
	@GetMapping("modifyReply")
	public String modifyReply(Model model, HttpServletRequest request) {
		int replyNo = Integer.valueOf(request.getParameter("replyNo"));
		String modifyContent = request.getParameter("modifyContent");
		int boardNo = Integer.valueOf(request.getParameter("boardNo"));
		
		HashMap<String, Object> replyModifyMap = new HashMap<>();
		replyModifyMap.put("replyNo", replyNo);
		replyModifyMap.put("modifyContent", modifyContent);
		
		
		service.modifyReply(replyModifyMap);
		
		
		return "redirect:/board/detail?no="+boardNo;

	}
	
//	대댓글 수정
	@GetMapping("modifyReplyOf")
	public String modifyReplyOf(Model model, HttpServletRequest request) {
		int replyOfNo = Integer.valueOf(request.getParameter("replyOfNo"));
		int boardNo = Integer.valueOf(request.getParameter("boardNo"));
		String modifyReplyOfContent = request.getParameter("modifyReplyOfContent");
		
		HashMap<String, Object> replyOfModifyMap = new HashMap<>();
		replyOfModifyMap.put("replyOfNo", replyOfNo);
		replyOfModifyMap.put("modifyReplyOfContent", modifyReplyOfContent);
		
		service.modifyReplyOf(replyOfModifyMap);
		
		
		return "redirect:/board/detail?no="+boardNo;

	}
	
	
	@GetMapping("reportReply")
	public String reportReply(Model model, HttpServletRequest request) {
		
	 int replyNo =  Integer.valueOf(request.getParameter("refNo"));
	 int boardNo = Integer.valueOf(request.getParameter("refBoardNo"));
	 String reportReason = request.getParameter("reportReason");
	 int userNo = Integer.valueOf(request.getParameter("userNo"));
	 int reportedPerson= Integer.valueOf(request.getParameter("reportedPerson"));
	 
	 
	 HashMap<String, Object> replyReportMap = new HashMap<>();
	 replyReportMap.put("replyNo", replyNo);
	 replyReportMap.put("reportReason", reportReason);
	 replyReportMap.put("userNo", userNo);
	 replyReportMap.put("reportedPerson", reportedPerson);
	 replyReportMap.put("boardNo",boardNo);
	 
	 service.insertReplyRepot(replyReportMap);
	 
	 service.increaceReplyReportCount(replyNo);
	 
		return "redirect:/board/detail?no="+boardNo;
	}
	
	@GetMapping("reportReplyOf")
	public String reportReplyOf(Model model, HttpServletRequest request) {
		
	int replyOfNo = Integer.valueOf(request.getParameter("replyOfNo"));
	 int userNo = Integer.valueOf(request.getParameter("userNo"));
	 int reportedPerson= Integer.valueOf(request.getParameter("reportedPerson"));
	 String reportReason = request.getParameter("reportReason");
	 int boardNo = Integer.valueOf(request.getParameter("refBoardNo"));

	 HashMap<String, Object> replyOfReportMap = new HashMap<>();
	 replyOfReportMap.put("replyOfNo", replyOfNo);
	 replyOfReportMap.put("reportReason", reportReason);
	 replyOfReportMap.put("userNo", userNo);
	 replyOfReportMap.put("reportedPerson", reportedPerson);
	 replyOfReportMap.put("boardNo", boardNo);
	 
	 service.insertReplyOfReport(replyOfReportMap);
	
	 service.increaceReplyOfReportCount(replyOfNo);
		
		return "redirect:/board/detail?no="+boardNo;
	}
	
}
