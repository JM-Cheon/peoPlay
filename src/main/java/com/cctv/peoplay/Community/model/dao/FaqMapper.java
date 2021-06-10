package com.cctv.peoplay.Community.model.dao;

import java.util.HashMap;
import java.util.List;

import com.cctv.peoplay.Community.model.dto.FaqDTO;
import com.cctv.peoplay.Community.model.dto.PageInfoDTO;

public interface FaqMapper {
	
	// 게시글 리스트 + 페이징 처리
	List<FaqDTO> faqList(PageInfoDTO pageInfo);
	
	// 페이칭 처리용 총 게시물
	int count();

	// 상세페이지
	FaqDTO FaqDetail(int faqNo);
	
	// 검색 게시글 총 갯수
	int searchCount(HashMap<String, String> searchMap);

	// 검색후 리스트
	List<FaqDTO> searchlist(HashMap<String, Object> searchListMap);
	
	// 글 작성
	int insertFaq(FaqDTO faqDTO);

	// 글 수정
	int updateWrite(FaqDTO faqDTO);

	// 글 삭제
	void faqDelete(int faqNo);

	
}
