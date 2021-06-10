package com.cctv.peoplay.Community.model.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cctv.peoplay.Community.model.dao.QnaMapper;
import com.cctv.peoplay.Community.model.dto.PageInfoDTO;
import com.cctv.peoplay.Community.model.dto.QnaDTO;
import com.cctv.peoplay.Community.model.dto.commentDTO;
@Service
public class QnaServiceImpl implements QnaService{
	
	private final QnaMapper qnaMapper;
	@Autowired
	public QnaServiceImpl(QnaMapper qnaMapper) {
		this.qnaMapper = qnaMapper;
		
	}

	// 페이징 처리용 총 게시물
	@Override
	public int count() {
		
		return qnaMapper.count();
	}
	// 게시글 리스트 + 페이징 처리
	@Override
	public List<QnaDTO> qnalist(PageInfoDTO pageInfo) {
		
		return qnaMapper.qnalist(pageInfo);
	}
	// 상세페이지
	@Override
	public QnaDTO QnaDetail(int inquiryNo) {
		
		return qnaMapper.QnaDetail(inquiryNo);
	}
	// 게시글 작성
	@Override
	public int insertQna(QnaDTO qnaDTO) {
		
		return qnaMapper.insertQna(qnaDTO);
	}
	// 게시글 수정
	@Override
	public int updateWrite(QnaDTO qnaDTO) {
		
		return qnaMapper.updateWrite(qnaDTO);
	}
	//게시판 검색 결과 갯수 조회용 메소드
	@Override
	public int searchCount(HashMap<String, String> searchMap) {
		
		return qnaMapper.searchCount(searchMap);
	}
	// 게시판 검색 결과 조회용
	@Override
	public List<QnaDTO> searchList(HashMap<String, Object> searchListMap) {
		
		return qnaMapper.searchList(searchListMap);
	}
	// 게시판 삭제(업데이트)
	@Override
	public int qnaDelete(int inquiryNo) {
		
		return qnaMapper.qnaDelete(inquiryNo);
		
	}
	// 댓글 등록
	@Override
	public int CommentInsert(commentDTO commDTO) {
		
		return qnaMapper.CommentInsert(commDTO);
	}
	// 게시글 목록 관리자 
	@Override
	public List<QnaDTO> qnaAdminlist(PageInfoDTO pageInfo) {
		
		return qnaMapper.qnaAdminlist(pageInfo);
	}
	// 관리자가 댓글 달면 댓글유무 컬럼 업데이트
	@Override
	public int CommentUpdate(int inquiryNo) {
		
		return qnaMapper.CommentUpdate(inquiryNo);
		
	}
	// 관리자가 댓글 삭제하면 댓글유무 컬럼 업데이트 
	@Override
	public int CommentDeleteUpdate(int inquiryNo) {
		
		return qnaMapper.CommentDeleteUpdate(inquiryNo);
	}

	
}
