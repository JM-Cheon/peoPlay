package com.cctv.peoplay.Community.model.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cctv.peoplay.Community.model.dao.NoticeMapper;
import com.cctv.peoplay.Community.model.dto.NoticeDTO;
import com.cctv.peoplay.Community.model.dto.PageInfoDTO;



@Service("noticeService")
public class NoticeServiceImpl implements NoticeService{
	
	private final NoticeMapper noticeMapper;
	
	@Autowired	
	public NoticeServiceImpl(NoticeMapper noticeMapper) {
		this.noticeMapper = noticeMapper;
		
	}
	// 게시글 리스트 + 페이징 처리
	@Override
	public List<NoticeDTO> ntclist(PageInfoDTO pageInfo) {
		
		return noticeMapper.ntclist(pageInfo);
	}
	
	// 페이징 처리용 총 게시물
	@Override
	public int count() {
		
		return noticeMapper.count();
	}
	
	// 상세페이지
	@Override
	public NoticeDTO ntcdetail(int ntcNo) {
		
		return noticeMapper.ntcdetail(ntcNo);
	}
	// 게시글 작성
	@Override
	public int insertNotice(NoticeDTO ntcDTO) {
		
		return noticeMapper.insertNotice(ntcDTO);
	}
	// 게시글 수정
	@Override
	public int updateWrite(NoticeDTO ntcDTO) {
		
		return noticeMapper.updateWrite(ntcDTO);
	}
	//게시판 검색 결과 갯수 조회용 메소드
	@Override
	public int searchCount(HashMap<String, String> searchMap) {
		
		return noticeMapper.searchCount(searchMap);
	}
	// 게시판 검색 결과 조회용
	@Override
	public List<NoticeDTO> searchlist(HashMap<String, Object> searchListMap) {
		
		return noticeMapper.searchlist(searchListMap);
	}
	// 게시글 조회수 증가
	@Override
	public int ntcdetailCount(int ntcNo) {
		
		return noticeMapper.ntcdetailCount(ntcNo);
	}
	// 게시글 삭제(업데이트)
	@Override
	public int noticeDelete(int ntcNo) {
		
		return noticeMapper.noticeDelete(ntcNo);
		
	}
	
    
	



	
	

}
