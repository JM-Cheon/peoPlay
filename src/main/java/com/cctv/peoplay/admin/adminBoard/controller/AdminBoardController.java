package com.cctv.peoplay.admin.adminBoard.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cctv.peoplay.board.model.dto.BoardReplyDTO;
import com.cctv.peoplay.board.model.dto.ReplyOfDTO;
import com.cctv.peoplay.board.model.dto.ReportAndReportPlaceDTO;
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
		
		
		int limit =15;
		
		int buttonAmount = 5;
	
		PageDTO pageInfo = Pagenation.getPageInfo(pageNo, totalCount, limit, buttonAmount);
		
//		리스트 조회	
		model.addAttribute("list", service.selectBoardList(pageInfo));
		
		model.addAttribute("pageInfo",pageInfo);
		return "admin/adminBoard/list";
	}
	
//	관리자 게시판 상세페이지
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
	
//	 신고 관리 페이지 연결
	@GetMapping("reportList")
	public String reportListPage() {
		
		
		return "admin/adminBoard/reportList";
	}
	
//	 관리 페이지 리스트
	@GetMapping("selectReportList")
	public String reportList(Model model, HttpServletRequest request) {
		
		int no = Integer.valueOf(request.getParameter("no"));
		
		List<ReportAndReportPlaceDTO> selectReportList = service.selectReportList(no);
		model.addAttribute("list", selectReportList);
		model.addAttribute("no", no);
		
		
		return "admin/adminBoard/reportList";
	}
	
//	
	
//  신고 확인
 @GetMapping("reportConfirm")
	 public String reportConfirm (Model model,HttpServletRequest request) {
	 
		int no = Integer.valueOf(request.getParameter("no"));
		int reportedPersonNo= Integer.valueOf(request.getParameter("reportedPersonNo"));
		int placeNo= Integer.valueOf(request.getParameter("placeNo"));
		int reportNo = Integer.valueOf(request.getParameter("reportNo"));
		int refBoardNo= Integer.valueOf(request.getParameter("refBoardNo"));
		
		
		if (no ==1) {
			service.updateUserReportCount(reportedPersonNo);
			service.deleteBoard(placeNo);
			service.updateBoardReportStatus(placeNo);
			int userReportCount = service.selectReportCount(reportedPersonNo);
				if(userReportCount >4) {
				service.userBlack(reportedPersonNo);
			}
		}
		if(no==3) {
			service.updateUserReportCount(reportedPersonNo);
			service.deleteReply(placeNo);
			service.decreaceReplyCount(refBoardNo);
			service.updateReplyReportStatus(placeNo);
			int userReportCount = service.selectReportCount(reportedPersonNo);
				if(userReportCount >4) {
				service.userBlack(reportedPersonNo);
		}
		}
		
		if(no==4) {
			service.updateUserReportCount(reportedPersonNo);
			service.deleteReplyOf(placeNo);
			service.decreaceReplyCount(refBoardNo);
			service.updateReplyOfReportStatus(placeNo);
			int userReportCount = service.selectReportCount(reportedPersonNo);
				if(userReportCount >4) {
				service.userBlack(reportedPersonNo);
		}
		}
		
	 
		return "redirect:/admin/adminBoard/reportList";
 }
 
 
 @GetMapping("reportCancle")
 public String reportCancle(Model model, HttpServletRequest request) {
	 int no = Integer.valueOf(request.getParameter("no"));
		int placeNo= Integer.valueOf(request.getParameter("placeNo"));
	
		
		if (no ==1) {
			service.cancleBoardReportStatus(placeNo);
			service.resetReportCount(placeNo);
			}
		if (no ==3) {
			service.cancleReplyOfReportStatus(placeNo);
			service.resetReplyReportCount(placeNo);
			}
		if (no ==4) {
			service.cancleReplyReportStatus(placeNo);
			service.resetReplyOfReportCount(placeNo);
			}
		
		
	 
	 
	 return "redirect:/admin/adminBoard/reportList";
 }
 
 
}


