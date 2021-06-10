package com.cctv.peoplay.Community.model.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cctv.peoplay.Community.model.dao.FaqMapper;
import com.cctv.peoplay.Community.model.dto.FaqDTO;
import com.cctv.peoplay.Community.model.dto.NoticeDTO;
import com.cctv.peoplay.Community.model.dto.PageInfoDTO;
@Service
public class FaqServiceImpl implements FaqService{

	private final FaqMapper faqMapper;
	
	@Autowired
	public FaqServiceImpl(FaqMapper faqMapper) {
		this.faqMapper = faqMapper;
		
	}
	// 페이칭 처리용 총 게시물
	@Override
	public int count() {
		
		return faqMapper.count();
	}
	// 게시글 리스트 + 페이징 처리
	@Override
	public List<FaqDTO> faqList(PageInfoDTO pageInfo) {
	
		return faqMapper.faqList(pageInfo);
	}
	// 상세페이지
	@Override
	public FaqDTO FaqDetail(int faqNo) {
		
		return faqMapper.FaqDetail(faqNo);
	}
	// 검색 게시글 총 갯수
	@Override
	public int searchCount(HashMap<String, String> searchMap) {
		
		return faqMapper.searchCount(searchMap);
	}
	// 검색후 리스트
	@Override
	public List<FaqDTO> searchlist(HashMap<String, Object> searchListMap) {
		
		return faqMapper.searchlist(searchListMap);
	}
	// 글 작성
	@Override
	public int insertFaq(FaqDTO faqDTO) {
			
		return faqMapper.insertFaq(faqDTO);
	}
	// 글 수정
	@Override
	public int updateWrite(FaqDTO faqDTO) {
		
		return faqMapper.updateWrite(faqDTO);
	}
	// 글 삭제
	@Override
	public void faqDelete(int faqNo) {
		
		faqMapper.faqDelete(faqNo);
	}

	

	

}
