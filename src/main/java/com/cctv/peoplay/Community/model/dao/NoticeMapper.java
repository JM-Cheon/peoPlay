package com.cctv.peoplay.Community.model.dao;

import java.util.HashMap;
import java.util.List;

import com.cctv.peoplay.Community.model.dto.NoticeDTO;
import com.cctv.peoplay.Community.model.dto.PageInfoDTO;


public interface NoticeMapper {
	// 게시글 리스트 + 페이징 처리
	List<NoticeDTO> ntclist(PageInfoDTO pageInfo);
	
	// 페이칭 처리용 총 게시물
	int count();
	
	// 상세페이지
	NoticeDTO ntcdetail(int ntcNo);
	
	// 게시글 작성
	int insertNotice(NoticeDTO ntcDTO);
	
	// 게시글 수정
	int updateWrite(NoticeDTO ntcDTO);

	//게시판 검색 결과 갯수 조회용 메소드
	int searchCount(HashMap<String, String> searchMap);

	// 게시판 검색 결과 조회용
	List<NoticeDTO> searchlist(HashMap<String, Object> searchListMap);

	// 게시글 조회수 증가
	int ntcdetailCount(int ntcNo);
	
	// 게시글 삭제(업데이트)
	int noticeDelete(int ntcNo);



}
