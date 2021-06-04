package com.cctv.peoplay.board.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cctv.peoplay.board.model.dto.BoardDTO;
import com.cctv.peoplay.board.model.service.BoardService;


@Controller
@RequestMapping("/board/*")
@SessionAttributes("loginMember")
public class BoardController {
	
	private BoardService service;

	@Autowired
	public BoardController(BoardService service) {
		this.service= service;
	}
	
//	 list page 이동
	@GetMapping("list")
	public String list(Model model) throws Exception {
		
		model.addAttribute("list",service.selectBoardList());
		System.out.println(model);
		return "board/list";
	}
	
	@GetMapping("write")
	public String write() {
		
		
		return "board/write";
	}
	
	@PostMapping("insert")
	public String boardInsert(@ModelAttribute("board") BoardDTO board, Model model) {
		
		
		System.out.println(board);
		

				if(service.insertBoard(board)>0) {
					return "redirect:/board/list";
				}else {
					return null;
				}
		
		
	}
	
	
}
