package com.cctv.peoplay.board.model.service;

import java.util.HashMap;
import java.util.List;

import com.cctv.peoplay.board.model.dto.BoardAndMemberDTO;
import com.cctv.peoplay.board.model.dto.BoardDTO;
import com.cctv.peoplay.board.model.dto.BoardReplyDTO;
import com.cctv.peoplay.board.model.dto.ReplyOfDTO;
import com.cctv.peoplay.board.model.dto.ReportAndReportPlaceDTO;
import com.cctv.peoplay.board.page.PageDTO;

public interface BoardService {

	List<BoardAndMemberDTO> selectBoardList(PageDTO pageInfo) ;

	int insertBoard(BoardDTO board);

	BoardAndMemberDTO selectBoradDetail(int no);

	int increaceView(int no);

	int selectCount();

	int selectSearchCount(HashMap<String, String> searchMap);

	List<BoardAndMemberDTO> selectSearchList(HashMap<String, Object> searchListMap);

	int deleteBoard(int no);

	int insertReport(ReportAndReportPlaceDTO report);

	int updateReportCount(int reportedPerson);

	int insertReply(HashMap<String, Object> replyMap);

	int increaceReplyCount(int postNo);

	List<BoardReplyDTO> selectReply(int postNo);

	int deleteReply(int replyNo);

	int decreaceReplyCount(int boardNo);

	int insertReplyOf(HashMap<String, Object> replyOfMap);

	List<ReplyOfDTO> selectReplyOf(int refBoardNo);

	int deleteReplyOf(int replyOfNo);

	BoardAndMemberDTO modifyBoard(int no);

	int modifyUpdate(HashMap<String, Object> modifyMap);

	int modifyReply(HashMap<String, Object> replyModifyMap);

	int modifyReplyOf(HashMap<String, Object> replyOfModifyMap);

	int increaceReportCount(ReportAndReportPlaceDTO report);

	int insertReplyRepot(HashMap<String, Object> replyReportMap);

	int increaceReplyReportCount(int replyNo);

	int insertReplyOfReport(HashMap<String, Object> replyOfReportMap);

	int increaceReplyOfReportCount(int replyOfNo);

	List<ReportAndReportPlaceDTO> selectReportList(int no);

	int updateUserReportCount(int reportedPersonNo);

	int updateBoardReportStatus(int placeNo);

	int selectReportCount(int reportedPersonNo);

	int userBlack(int reportedPersonNo);

	int updateReplyReportStatus(int placeNo);

	int updateReplyOfReportStatus(int placeNo);

	int cancleBoardReportStatus(int placeNo);

	int resetReportCount(int placeNo);

	int cancleReplyOfReportStatus(int placeNo);

	int resetReplyReportCount(int placeNo);

	int cancleReplyReportStatus(int placeNo);

	int resetReplyOfReportCount(int placeNo);

	int cancleGoodsReportStatus(int placeNo);

	int deleteGoods(int placeNo);

	int updateGoodsReportStatus(int placeNo);




	



	

	



}
