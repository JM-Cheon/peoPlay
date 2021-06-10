package com.cctv.peoplay.Community.model.dao;

import java.util.HashMap;
import java.util.List;

import com.cctv.peoplay.Community.model.dto.commentDTO;

public interface ReplyMapper {

	int CommentInsert(HashMap<String, Object> insertReply);

	List<commentDTO> selectComment(int inquiryNo);

	int CommentDelete(int commentNo);

	int replyUpdate(HashMap<String, Object> updateReply);

}
