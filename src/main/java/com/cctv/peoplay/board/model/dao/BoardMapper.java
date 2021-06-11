package com.cctv.peoplay.board.model.dao;

import java.util.HashMap;
import java.util.List;

import com.cctv.peoplay.board.model.dto.BoardAndMemberDTO;
import com.cctv.peoplay.board.model.dto.BoardDTO;
import com.cctv.peoplay.board.model.dto.BoardReplyDTO;
import com.cctv.peoplay.board.model.dto.ReplyOfDTO;
import com.cctv.peoplay.board.model.dto.ReportAndReportPlaceDTO;
import com.cctv.peoplay.board.page.PageDTO;

public interface BoardMapper {

	// 게시글 디테일 페이지
	BoardAndMemberDTO selectBoradDetail(int no);

	// 전체 게시글 리스트 조회
	List<BoardAndMemberDTO> selectBoardList(PageDTO pageInfo);

	// 게시글 작성용
	int insertBoard(BoardDTO board);

	// 게시글 디테일 페이지 진입시 조회수 증가
	int increaceView(int no);
	
	// 전체 게시글 갯수 조회
	int selectCount();

	// 검색 게시글 갯수 조회
	int selectSearchCount(HashMap<String, String> searchMap);

	// 검색 게시글 조회
	List<BoardAndMemberDTO> selectSearchList(HashMap<String, Object> searchListMap);

//	게시판글 제거
	int deleteBoard(int no);

//	게시판 신고
	int insertReport(ReportAndReportPlaceDTO report);

//	게시판 신고 카운트 증가
	int updateReportCount(int reportedPerson);

//	댓글 인서트
	int insertReply(HashMap<String, Object> replyMap);

//	댓글 개수 카운트 증가
	int increaceReplyCount(int postNo);

//	댓글 셀렉트
	List<BoardReplyDTO> selectReply(int postNo);

//	댓글 삭제
	int deleteReply(int replyNo);

//	댓글 갯수 감소
	int decreaceReplyCount(int boardNo);

//	대댓글 작성
	int insertReplyOf(HashMap<String, Object> replyOfMap);

// 대댓글 셀렉트
	List<ReplyOfDTO> selectReplyOf(int refBoardNo);

//	대댓글 제거
	int deleteReplyOf(int replyOfNo);

//	수정페이지 조회
	BoardAndMemberDTO modifyBoard(int no);

//	게시판 내용 수정 
	int modifyUpdate(HashMap<String, Object> modifyMap);

//	댓글 수정
	int modifyReply(HashMap<String, Object> replyModifyMap);
	
//	대댓글 수정
	int modifyReplyOf(HashMap<String, Object> replyOfModifyMap);

//	게시글 신고 카운트 증가
	int increaceReportCount(ReportAndReportPlaceDTO report);

//	댓글 신고 
	int insertReplyRepot(HashMap<String, Object> replyReportMap);

//	댓글 신고 증가
	int increaceReplyReportCount(int replyNo);

//	대댓글 신고 
	int insertReplyOfReport(HashMap<String, Object> replyOfReportMap);

//	대댓글 신고 카운트 증가
	int increaceReplyOfReportCount(int replyOfNo);

//	신고 관리 조회
	List<ReportAndReportPlaceDTO> selectReportList(int no);

//	유저 신고 누적
	int updateUserReportCount(int reportedPersonNo);

//	게시판 신고 상태 변경
	int updateBoardReportStatus(int placeNo);

//	신고 누적 수 조회
	int selectReportCount(int reportedPersonNo);

//	블랙 유저
	int userBlack(int reportedPersonNo);

//  댓글 신고 상태 변경
	int updateReplyReportStatus(int placeNo);
	
//	대댓글 신고 상태 변경
	int updateReplyOfReportStatus(int placeNo);

// 게시판 신고 상태 변경
	int cancleBoardReportStatus(int placeNo);

//	게시판 신고 카운트 초기화
	int resetReportCount(int placeNo);

//	대댓글 신고 상태 변경
	int cancleReplyOfReportStatus(int placeNo);

//	댓글 신고 카운트 초기화
	int resetReplyReportCount(int placeNo);
 
//	 댓글 신고 상태 변경
	int cancleReplyReportStatus(int placeNo);
	
//	대댓글 신고 카운트 초기화
	int resetReplyOfReportCount(int placeNo);

//	굳즈 댓글 상태 변경
	int cancleGoodsReportStatus(int placeNo);

//	굳즈 삭제
	int deleteGoods(int placeNo);

//	신고 상태 변경 (굳즈)
	int updateGoodsReportStatus(int placeNo);



	

	
}
