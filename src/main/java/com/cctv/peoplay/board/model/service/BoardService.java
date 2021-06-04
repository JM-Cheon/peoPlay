package com.cctv.peoplay.board.model.service;

import java.util.List;

import com.cctv.peoplay.board.model.dto.BoardAndMemberDTO;
import com.cctv.peoplay.board.model.dto.BoardDTO;

public interface BoardService {

	List<BoardAndMemberDTO> selectBoardList() ;

	int insertBoard(BoardDTO board);
	

}
