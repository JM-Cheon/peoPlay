package com.cctv.peoplay.member.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cctv.peoplay.member.model.dao.MemberMapper;
import com.cctv.peoplay.member.model.dto.MemberDTO;
import com.cctv.peoplay.member.model.dto.SubscribePaymentDTO;
import com.cctv.peoplay.member.model.dto.SubscriptionDTO;

@Service("memberService")
public class MemberServiceImpl implements MemberService{
	
	private final MemberMapper mapper;
	private final BCryptPasswordEncoder passwordEndoder;
	
	@Autowired
	public MemberServiceImpl(MemberMapper mapper, BCryptPasswordEncoder passwordEncoder) {
		this.mapper = mapper;
		this.passwordEndoder = passwordEncoder;
	}

	@Override
	public String selectIdCheck(String requestId) {
		return mapper.selectIdCheck(requestId);
	}

	@Override
	public String selectNicknameCheck(String requestNickname) {
		return mapper.selectNicknameCheck(requestNickname);
	}

	@Override
	public boolean registMember(MemberDTO member) {
		
		boolean result = false;
		int genreResult = 0;
		
		if(mapper.insertMember(member) > 0) {
			genreResult += mapper.insertAction(member.getAction());
			genreResult += mapper.insertFantasy(member.getFantasy());
			genreResult += mapper.insertRomance(member.getRomance());
			genreResult += mapper.insertComedy(member.getComedy());
			genreResult += mapper.insertHorror(member.getHorror());
			
			if(genreResult == 5) {
				result = true;
			}
		}
		
		return result;
	}

	@Override
	public boolean loginMember(MemberDTO member) {
		return passwordEndoder.matches(member.getUserPwd(), mapper.selectEncPassword(member));
	}

	@Override
	public MemberDTO selectMember(MemberDTO member) {
		return mapper.selectMember(member);
	}

	@Override
	public boolean modifySearchPwd(MemberDTO member) {
		return mapper.modifySearchPwd(member) > 0? true: false;
	}

	@Override
	public boolean modifyMember(MemberDTO member) {
		
		boolean result = false;
		
		if(passwordEndoder.matches(member.getUserPwd(), mapper.selectEncPassword(member))) {
			result = mapper.modifyMember(member) > 0? true: false;
		}
		
		return result;
	}

	@Override
	public boolean modifyPwd(MemberDTO member, String nowUserPwd) {
		
		boolean result = false;
		
		if(passwordEndoder.matches(nowUserPwd, mapper.selectEncPassword(member))) {
			result = mapper.modifyPwd(member) > 0? true: false;
		}
		
		return result;
	}

	@Override
	public boolean removeMember(MemberDTO member) {
		
		boolean result = false;
		
		if(passwordEndoder.matches(member.getUserPwd(), mapper.selectEncPassword(member))) {
			result = mapper.removeMember(member) > 0? true: false;
		}
		
		return result;
	}

	@Override
	public SubscriptionDTO selectSubscription(SubscribePaymentDTO payment) {
		return mapper.selectSubscription(payment);
	}

	@Override
	public int insertSubscribePayment(SubscribePaymentDTO payment) {
		return mapper.insertSubscribePayment(payment);
	}

	@Override
	public int modifySubscribeValidity(SubscribePaymentDTO payment) {
		return mapper.modifySubscribeValidity(payment);
	}

	@Override
	public List<SubscribePaymentDTO> selectPaymentList(MemberDTO loginMember) {
		return mapper.selectPaymentList(loginMember);
	}

	@Override
	public int modifyMovieOnOff(MemberDTO loginMember) {
		return mapper.modifyMovieOnOff(loginMember);
	}

	@Override
	public int modifyBoardOnOff(MemberDTO loginMember) {
		return mapper.modifyBoardOnOff(loginMember);
	}
	
}
