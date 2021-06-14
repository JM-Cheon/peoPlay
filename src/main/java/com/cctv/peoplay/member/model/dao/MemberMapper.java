package com.cctv.peoplay.member.model.dao;

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
