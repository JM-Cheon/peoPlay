package com.cctv.peoplay.member.model.service;

import java.util.HashMap;
import java.util.List;

import com.cctv.peoplay.Community.model.dto.QnaDTO;
import com.cctv.peoplay.board.model.dto.BoardDTO;
import com.cctv.peoplay.goods.model.dto.DeliveryDTO;
import com.cctv.peoplay.goods.model.dto.GoodsCartDTO;
import com.cctv.peoplay.goods.model.dto.GoodsLikeDTO;
import com.cctv.peoplay.member.model.dto.MemberDTO;
import com.cctv.peoplay.member.model.dto.SubscribePaymentDTO;
import com.cctv.peoplay.member.model.dto.SubscriptionDTO;
import com.cctv.peoplay.movie.model.dto.MovieAllImgDTO;

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

	List<MovieAllImgDTO> selectActionMovie();

	List<MovieAllImgDTO> selectFactasyMovie();

	List<MovieAllImgDTO> selectRomanceMovie();

	List<MovieAllImgDTO> selectComedyMovie();

	List<MovieAllImgDTO> selectHorroMovie();

	List<MovieAllImgDTO> selectMemberWishMovieList(int userNo);

	List<MovieAllImgDTO> selectWatchMovieList(int userNo);

	List<GoodsCartDTO> selectBasketList(int userNo);

	List<GoodsLikeDTO> selectGoodsLikeList(int userNo);

	List<BoardDTO> selectMemberBoard(int userNo);

	List<QnaDTO> selectAsk(int userNo);

	List<DeliveryDTO> selectOrderList(int userNo);

	int selectCartCount(HashMap<String, Integer> cartSelecter);

}
