package com.cctv.peoplay.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cctv.peoplay.board.model.dao.BoardMapper;
import com.cctv.peoplay.board.model.dto.BoardAndMemberDTO;
import com.cctv.peoplay.board.model.dto.BoardDTO;

@Service("boardService")
public class BoardServiceImpl implements BoardService{
	
	
	private BoardMapper mapper ;
	
	@Autowired
	public BoardServiceImpl (BoardMapper mapper) {
		this.mapper=mapper;
	}
	

	@Override
	public List<BoardAndMemberDTO> selectBoardList(){
		return mapper.selectBoardList();
	}


	@Override
	public int insertBoard(BoardDTO board) {
			return mapper.insertBoard(board);
		
	}



	


	
}
