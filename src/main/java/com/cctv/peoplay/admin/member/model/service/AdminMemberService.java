package com.cctv.peoplay.admin.member.model.service;

import java.util.List;

import com.cctv.peoplay.member.model.dto.MemberDTO;

public interface AdminMemberService {

	List<MemberDTO> selectAllMember();

	List<MemberDTO> selectMemberByNo(int no);

	List<MemberDTO> selectMemberByName(String name);

	List<MemberDTO> selectMemberByNickname(String nickname);

	List<MemberDTO> selectMemberByReportCount(int reportCount);

	List<MemberDTO> selectMemberByStatus(String status);

	List<MemberDTO> selectMemberByBlack(String black);

	int updateMemberBlack(MemberDTO member);

}
