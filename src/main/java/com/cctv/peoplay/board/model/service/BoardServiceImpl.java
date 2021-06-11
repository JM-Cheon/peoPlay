package com.cctv.peoplay.board.model.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cctv.peoplay.board.model.dao.BoardMapper;
import com.cctv.peoplay.board.model.dto.BoardAndMemberDTO;
import com.cctv.peoplay.board.model.dto.BoardDTO;
import com.cctv.peoplay.board.model.dto.BoardReplyDTO;
import com.cctv.peoplay.board.model.dto.ReplyOfDTO;
import com.cctv.peoplay.board.model.dto.ReportAndReportPlaceDTO;
import com.cctv.peoplay.board.page.PageDTO;

@Service("boardService")
public class BoardServiceImpl implements BoardService{
	
	
	private BoardMapper mapper ;
	
	@Autowired
	public BoardServiceImpl (BoardMapper mapper) {
		this.mapper=mapper;
	}
	

	@Override
	public List<BoardAndMemberDTO> selectBoardList(PageDTO pageInfo){
		return mapper.selectBoardList( pageInfo);
	}


	@Override
	public int insertBoard(BoardDTO board) {
			return mapper.insertBoard(board);
		
	}


	@Override
	public BoardAndMemberDTO selectBoradDetail(int no) {
		return mapper.selectBoradDetail(no);
	}


	@Override
	public int increaceView(int no) {
		return mapper.increaceView(no);
	}


	@Override
	public int selectCount() {
		return mapper.selectCount();
	}



	@Override
	public int selectSearchCount(HashMap<String, String> searchMap) {
		return mapper.selectSearchCount(searchMap);
	}


	@Override
	public List<BoardAndMemberDTO> selectSearchList(HashMap<String, Object> searchListMap) {
		// TODO Auto-generated method stub
		return mapper.selectSearchList(searchListMap);
	}


	@Override
	public int deleteBoard(int no) {		
	
		 return mapper.deleteBoard(no);
	}

	@Override
	public int insertReport(ReportAndReportPlaceDTO report) {
		return mapper.insertReport(report);
	}


	@Override
	public int updateReportCount(int reportedPerson) {
		return mapper.updateReportCount(reportedPerson);
	}


	@Override
	public int insertReply(HashMap<String, Object> replyMap) {
		return mapper.insertReply(replyMap);
	}


	@Override
	public int increaceReplyCount(int postNo) {
		return mapper.increaceReplyCount(postNo);
	}



	@Override
	public List<BoardReplyDTO> selectReply(int postNo) {
		return mapper.selectReply(postNo);
	}


	@Override
	public int deleteReply(int replyNo) {
		return mapper.deleteReply(replyNo);
	}


	@Override
	public int decreaceReplyCount(int boardNo) {
		return mapper.decreaceReplyCount(boardNo);
	}


	@Override
	public int insertReplyOf(HashMap<String, Object> replyOfMap) {
		return mapper.insertReplyOf(replyOfMap);
	}


	@Override
	public List<ReplyOfDTO> selectReplyOf(int refBoardNo) {
		return mapper.selectReplyOf(refBoardNo);
	}


	@Override
	public int deleteReplyOf(int replyOfNo) {
		return mapper.deleteReplyOf(replyOfNo);
	}


	@Override
	public BoardAndMemberDTO modifyBoard(int no) {
		return mapper.modifyBoard(no);
	}


	@Override
	public int modifyUpdate(HashMap<String, Object> modifyMap) {
		return mapper.modifyUpdate(modifyMap);
	}


	@Override
	public int modifyReply(HashMap<String, Object> replyModifyMap) {
		return mapper.modifyReply(replyModifyMap);
	}


	@Override
	public int modifyReplyOf(HashMap<String, Object> replyOfModifyMap) {
		return mapper.modifyReplyOf(replyOfModifyMap);
	}


	@Override
	public int increaceReportCount(ReportAndReportPlaceDTO report) {
		return mapper.increaceReportCount(report);
	}


	@Override
	public int insertReplyRepot(HashMap<String, Object> replyReportMap) {
		return mapper.insertReplyRepot(replyReportMap);
	}


	@Override
	public int increaceReplyReportCount(int replyNo) {
		return mapper.increaceReplyReportCount(replyNo);
	}


	@Override
	public int insertReplyOfReport(HashMap<String, Object> replyOfReportMap) {
		return mapper.insertReplyOfReport(replyOfReportMap);
	}


	@Override
	public int increaceReplyOfReportCount(int replyOfNo) {
		return mapper.increaceReplyOfReportCount(replyOfNo);
	}


	@Override
	public List<ReportAndReportPlaceDTO> selectReportList(int no) {
		return mapper.selectReportList(no);
	}


	@Override
	public int updateUserReportCount(int reportedPersonNo) {
		return mapper.updateUserReportCount(reportedPersonNo);
	}


	@Override
	public int updateBoardReportStatus(int placeNo) {
		return mapper.updateBoardReportStatus(placeNo);
	}


	@Override
	public int selectReportCount(int reportedPersonNo) {
		return mapper.selectReportCount(reportedPersonNo);
	}


	@Override
	public int userBlack(int reportedPersonNo) {
		return mapper.userBlack(reportedPersonNo);
	}


	@Override
	public int updateReplyReportStatus(int placeNo) {
		return mapper.updateReplyReportStatus(placeNo);
	}


	@Override
	public int updateReplyOfReportStatus(int placeNo) {
		return mapper.updateReplyOfReportStatus(placeNo);
	}


	@Override
	public int cancleBoardReportStatus(int placeNo) {
		return mapper.cancleBoardReportStatus(placeNo);
	}


	@Override
	public int resetReportCount(int placeNo) {
		return mapper.resetReportCount(placeNo);
	}


	@Override
	public int cancleReplyOfReportStatus(int placeNo) {
		return mapper.cancleReplyOfReportStatus(placeNo);
	}


	@Override
	public int resetReplyReportCount(int placeNo) {
		return mapper.resetReplyReportCount(placeNo);

	}


	@Override
	public int cancleReplyReportStatus(int placeNo) {
		return mapper.cancleReplyReportStatus(placeNo);

	}


	@Override
	public int resetReplyOfReportCount(int placeNo) {
		return mapper.resetReplyOfReportCount(placeNo);

	}


	@Override
	public int cancleGoodsReportStatus(int placeNo) {
		return mapper.cancleGoodsReportStatus(placeNo);
	}


	@Override
	public int deleteGoods(int placeNo) {
		// TODO Auto-generated method stub
		return mapper.deleteGoods(placeNo);
	}


	@Override
	public int updateGoodsReportStatus(int placeNo) {
		// TODO Auto-generated method stub
		return mapper.updateGoodsReportStatus(placeNo);
	}








	

	


	



	


	


	
}
