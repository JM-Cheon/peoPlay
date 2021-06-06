package com.cctv.peoplay.admin.member.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cctv.peoplay.admin.member.model.dao.AdminMemberMapper;
import com.cctv.peoplay.member.model.dto.MemberDTO;

@Service("adminMemberService")
public class AdminMemberServiceImpl implements AdminMemberService{

	private final AdminMemberMapper mapper;
	
	@Autowired
	public AdminMemberServiceImpl(AdminMemberMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public List<MemberDTO> selectAllMember() {
		return mapper.selectAllMember();
	}

	@Override
	public List<MemberDTO> selectMemberByNo(int no) {
		return mapper.selectMemberByNo(no);
	}

	@Override
	public List<MemberDTO> selectMemberByName(String name) {
		return mapper.selectMemberByName(name);
	}

	@Override
	public List<MemberDTO> selectMemberByNickname(String nickname) {
		return mapper.selectMemberByNickname(nickname);
	}

	@Override
	public List<MemberDTO> selectMemberByReportCount(int reportCount) {
		return mapper.selectMemberByReportCount(reportCount);
	}

	@Override
	public List<MemberDTO> selectMemberByStatus(String status) {
		return mapper.selectMemberByStatus(status);
	}

	@Override
	public List<MemberDTO> selectMemberByBlack(String black) {
		return mapper.selectMemberByBlack(black);
	}

	@Override
	public int updateMemberBlack(MemberDTO member) {
		return mapper.updateMemberBlack(member);
	}
}
