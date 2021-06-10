package com.cctv.peoplay.Community.model.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cctv.peoplay.Community.model.dao.ReplyMapper;
import com.cctv.peoplay.Community.model.dto.commentDTO;

@Service
public class ReplyServiceImpl implements ReplyService{

	private final ReplyMapper replyMapper;
	
	@Autowired
	public ReplyServiceImpl(ReplyMapper replyMapper) {
		this.replyMapper = replyMapper;
		
	}

	@Override
	public List<commentDTO> selectComment(int inquiryNo) {
		
		return replyMapper.selectComment(inquiryNo);
	}

	@Override
	public int CommentInsert(HashMap<String, Object> insertReply) {
		
		return replyMapper.CommentInsert(insertReply);
		
	}

	@Override
	public int CommentDelete(int commentNo) {
		
		return replyMapper.CommentDelete(commentNo);
		
	}

	@Override
	public int replyUpdate(HashMap<String, Object> updateReply) {
		
		return replyMapper.replyUpdate(updateReply);
	}
	
	

}
