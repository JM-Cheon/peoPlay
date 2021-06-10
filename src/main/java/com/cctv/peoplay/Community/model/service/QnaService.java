package com.cctv.peoplay.Community.model.service;

import java.util.HashMap;
import java.util.List;

import com.cctv.peoplay.Community.model.dto.PageInfoDTO;
import com.cctv.peoplay.Community.model.dto.QnaDTO;
import com.cctv.peoplay.Community.model.dto.commentDTO;

public interface QnaService {
	// 페이징 처리용 총 게시물
	int count();
	// 게시글 리스트 + 페이징 처리
	List<QnaDTO> qnalist(PageInfoDTO pageInfo);
	// 상세페이지
	QnaDTO QnaDetail(int inquiryNo);
	// 게시글 작성
	int insertQna(QnaDTO qnaDTO);
	// 게시글 수정
	int updateWrite(QnaDTO qnaDTO);
	//게시판 검색 결과 갯수 조회용 메소드
	int searchCount(HashMap<String, String> searchMap);
	// 게시판 검색 결과 조회용
	List<QnaDTO> searchList(HashMap<String, Object> searchListMap);
	// 게시판 삭제(업데이트)
	int qnaDelete(int inquiryNo);
	// 댓글 등록
	int CommentInsert(commentDTO commDTO);
	// 게시글 목록 관리자 
	List<QnaDTO> qnaAdminlist(PageInfoDTO pageInfo);
	// 관리자가 댓글 달면 댓글유무 컬럼 업데이트
	int CommentUpdate(int inquiryNo);
	// 관리자가 댓글 삭제하면 댓글유무 컬럼 업데이트 
	int CommentDeleteUpdate(int inquiryNo);

	
}
