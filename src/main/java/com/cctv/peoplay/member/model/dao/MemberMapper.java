package com.cctv.peoplay.member.model.dao;

import java.util.List;

import com.cctv.peoplay.member.model.dto.MemberDTO;
import com.cctv.peoplay.member.model.dto.SubscribePaymentDTO;
import com.cctv.peoplay.member.model.dto.SubscriptionDTO;

public interface MemberMapper {

	String selectIdCheck(String requestId);

	String selectNicknameCheck(String requestNickname);

	int insertMember(MemberDTO member);

	int insertAction(int action);
	
	int insertFantasy(int fantasy);
	
	int insertRomance(int romance);
	
	int insertComedy(int comedy);
	
	int insertHorror(int horror);

	String selectEncPassword(MemberDTO member);

	MemberDTO selectMember(MemberDTO member);

	int modifySearchPwd(MemberDTO member);

	int modifyMember(MemberDTO member);

	int modifyPwd(MemberDTO member);

	int removeMember(MemberDTO member);

	SubscriptionDTO selectSubscription(SubscribePaymentDTO payment);

	int insertSubscribePayment(SubscribePaymentDTO payment);

	int modifySubscribeValidity(SubscribePaymentDTO payment);

	List<SubscribePaymentDTO> selectPaymentList(MemberDTO loginMember);

	int modifyMovieOnOff(MemberDTO loginMember);

	int modifyBoardOnOff(MemberDTO loginMember);


}
