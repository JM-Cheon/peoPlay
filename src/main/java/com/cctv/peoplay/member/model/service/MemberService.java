package com.cctv.peoplay.member.model.service;

import java.util.List;

import com.cctv.peoplay.member.model.dto.MemberDTO;
import com.cctv.peoplay.member.model.dto.SubscribePaymentDTO;
import com.cctv.peoplay.member.model.dto.SubscriptionDTO;

public interface MemberService {

	String selectIdCheck(String requestId);

	String selectNicknameCheck(String requestNickname);

	boolean registMember(MemberDTO member);

	boolean loginMember(MemberDTO member);

	MemberDTO selectMember(MemberDTO member);

	boolean modifySearchPwd(MemberDTO member);

	boolean modifyMember(MemberDTO member);

	boolean modifyPwd(MemberDTO member, String nowUserPwd);

	boolean removeMember(MemberDTO member);

	SubscriptionDTO selectSubscription(SubscribePaymentDTO payment);

	int insertSubscribePayment(SubscribePaymentDTO payment);

	int modifySubscribeValidity(SubscribePaymentDTO payment);

	List<SubscribePaymentDTO> selectPaymentList(MemberDTO loginMember);

	int modifyMovieOnOff(MemberDTO loginMember);

	int modifyBoardOnOff(MemberDTO loginMember);
}
