package com.cctv.peoplay.Community.model.service;

import java.util.HashMap;
import java.util.List;

import com.cctv.peoplay.Community.model.dto.NoticeDTO;
import com.cctv.peoplay.Community.model.dto.PageInfoDTO;

public interface NoticeService {

	// 게시글 리스트 + 페이징 처리
	public List<NoticeDTO> ntclist(PageInfoDTO pageInfo);
	
	// 페이칭 처리(전체게시물 수 조회)
	public int count();
	
	// 상세페이지
	public NoticeDTO ntcdetail(int ntcNo);
	
	// 게시글 작성
	public int insertNotice(NoticeDTO ntcDTO);
	
	// 게시글 수정
	public int updateWrite(NoticeDTO ntcDTO);

	// 게시판 검색 결과 갯수 조회
	public int searchCount(HashMap<String, String> searchMap);
	
	// 게시판 검색 결과 조회용
	public List<NoticeDTO> searchlist(HashMap<String, Object> searchListMap);

	// 게시글 조회수 증가
	int ntcdetailCount(int ntcNo);

	// 게시글 삭제(업데이트)
	public int noticeDelete(int ntcNo);

}
