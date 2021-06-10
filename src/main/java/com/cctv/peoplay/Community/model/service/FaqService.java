package com.cctv.peoplay.Community.model.service;

import java.util.HashMap;
import java.util.List;

import com.cctv.peoplay.Community.model.dto.FaqDTO;
import com.cctv.peoplay.Community.model.dto.NoticeDTO;
import com.cctv.peoplay.Community.model.dto.PageInfoDTO;

public interface FaqService {
	
	public List<FaqDTO> faqList(PageInfoDTO pageInfo);

	public int count();

	public FaqDTO FaqDetail(int faqNo);

	public int searchCount(HashMap<String, String> searchMap);

	public List<FaqDTO> searchlist(HashMap<String, Object> searchListMap);

	public int insertFaq(FaqDTO ntcDTO);

	public int updateWrite(FaqDTO faqDTO);

	public void faqDelete(int faqNo);

}
