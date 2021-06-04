package com.cctv.peoplay.board.model.dao;

import java.util.List;

import com.cctv.peoplay.board.model.dto.BoardAndMemberDTO;
import com.cctv.peoplay.board.model.dto.BoardDTO;

public interface BoardMapper {

	// 게시글 조회용
	List<BoardAndMemberDTO> selectBoardList();

	// 게시글 작성용
	int insertBoard(BoardDTO board);

	
}
