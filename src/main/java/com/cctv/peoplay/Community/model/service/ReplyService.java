package com.cctv.peoplay.Community.model.service;

import java.util.HashMap;
import java.util.List;

import com.cctv.peoplay.Community.model.dto.commentDTO;

public interface ReplyService {

	List<commentDTO> selectComment(int inquiryNo);

	int CommentInsert(HashMap<String, Object> insertReply);

	int CommentDelete(int commentNo);

	int replyUpdate(HashMap<String, Object> updateReply);


}
