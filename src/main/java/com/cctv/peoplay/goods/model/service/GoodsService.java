package com.cctv.peoplay.goods.model.service;

import java.util.HashMap;
import java.util.List;

import com.cctv.peoplay.goods.model.dto.DeliveryDTO;
import com.cctv.peoplay.goods.model.dto.GoodsAndDetailFileDTO;
import com.cctv.peoplay.goods.model.dto.GoodsAndFileDTO;
import com.cctv.peoplay.goods.model.dto.GoodsCartDTO;
import com.cctv.peoplay.goods.model.dto.GoodsDTO;
import com.cctv.peoplay.goods.model.dto.GoodsDetailFileDTO;
import com.cctv.peoplay.goods.model.dto.GoodsInqueryDTO;
import com.cctv.peoplay.goods.model.dto.GoodsInquiryReplyDTO;
import com.cctv.peoplay.goods.model.dto.GoodsLikeDTO;
import com.cctv.peoplay.goods.model.dto.GoodsReviewDTO;
import com.cctv.peoplay.goods.model.dto.OrderDTO;
import com.cctv.peoplay.goods.model.dto.PaymentDTO;
import com.cctv.peoplay.goods.paging.PagenationDTO;

public interface GoodsService {


	/* 모든 굿즈 불러오기 */
	List<GoodsDTO> selectAllGoods(PagenationDTO pageInfo);

	/* 인기 굿즈 불러오기 */
	List<GoodsDTO> selectPopularGoods(int num);

	/* 선택한 굿즈에 대한 정보 불러오기 */
	GoodsDTO selectOneGoodsInfo(int goodsNo);

	/* 선택한 굿즈의 파일 정보 불러오기 */
	List<GoodsAndFileDTO> goodsAndFile(int goodsNo);

	/* 장바구니에 담기 */
	int insertcart(HashMap<String, Integer> cart);

	/* 장바구니 조회하기 */
	List<GoodsCartDTO> cartList(HashMap<String, Integer> cartListMap);

	/* 선택한 굿즈 후기 조회하기 */
	List<GoodsReviewDTO> seletReivewByGoodsNo(int goodsNo);

	/* 후기 insert */
	int insertReply(HashMap<String, Object> reply);

	/* 후기 삭제 */
	int deleteReply(int goodsReviewNum);

	/* 굿즈 상세페이지 파일 조회 */
	List<GoodsAndDetailFileDTO> selectGoodsDetailFiles(int goodsNo);

	/* 주문페이지 insert */
	int insertOrder(HashMap<String, Integer> order);
	
	/* 주문페이지 조회(주문내역에 있는지 여부 확인) */
	GoodsCartDTO selectOrderList(HashMap<String, Integer> order);

	/* 오더 넘버 조회  */
	OrderDTO selectOrderNum(HashMap<String, Integer> order);

	/* 선택한 주문 번호로 정보 조회하기 */
	OrderDTO orderInfo(int orderNo);

	/* 좋아요 등록 여부 확인용 좋아요 목록 불러오기 */
	GoodsLikeDTO selectGoodsLikeList(HashMap<String, Integer> order);

	/* 좋아요 총 개수 */
	int goodsLikeCountByGoodsNo(int goodsNo);

	/* 좋아요 넣는 것 */
	int insertLike(HashMap<String, Integer> like);

	/* 댓글 수정 메소드 */
	int replyUpdate(HashMap<String, Object> updateReply);

	/* 좋아요 빼기 메소드 */
	int dislikeList(HashMap<String, Integer> dislike);

	/* goods개수 카운트 */
	int countTotalGoods(int num);

	int searchCount(HashMap<String, String> searchMap);

	/* 검색한 상품 조회 */
	List<GoodsDTO> searchlist(HashMap<String, Object> searchListMap);

	/* dc 상품 조회 */
	List<GoodsDTO> selectdcAllGoods(PagenationDTO pageInfo);

	/* ghibri 상품 조회 */
	List<GoodsDTO> selectghibriAllGoods(PagenationDTO pageInfo);

	/* pixar 상품 조회 */
	List<GoodsDTO> selectPixarAllGoods(PagenationDTO pageInfo);

	/* wb 상품 조회 */
	List<GoodsDTO> selectWbAllGoods(PagenationDTO pageInfo);

	/* 굿즈 Q&A 댓글 조회 */
	List<GoodsInqueryDTO> selectInquiryByGoodsNo(int goodsNo);

	/* 결제 후 결제 테이블 insert */
	int updatePayment(HashMap<String, Object> payment);

	/* 결제 완료 후 주문 테이블에서 결제 여부 Y로 전환 */
	int updatePaidGoods(int orderNo);

	/* 결제 테이블 조회 */
	PaymentDTO paymentNo(int orderNo);

	/* 결제 내역 조회 */
	List<PaymentDTO> selectPayment(int paymentNo);

	/* 배송 테이블 삽입 */
	int updatedelivery(HashMap<String, Object> delivery);

	/* 배송 키 조회 */
	DeliveryDTO deliveryInfo(HashMap<String, Object> delivery);

	/* 배송 조회를 select */
	DeliveryDTO selectDeliveryInfo(int deliveryNum);

	/* 신고 insert */
	int reportReply(HashMap<String, Object> reportReply);

	/* 중복 주문 확인 */
	OrderDTO doubleCheckOrder(HashMap<String, Integer> order);

	/* 주문 최소 버튼 메소드 */
	int cancelOrder(int orderNum);

	/* 주문 페이지에서 숫자 재계산 */
	int insertRecalculate(HashMap<String, Object> recalculate);

	/* 주문 취소시 장바구에서 삭제 */
	int deleteWishlist(HashMap<String, Integer> deletewish);

	/* 문의사항 수정 */
	int inquiryUpdate(HashMap<String, Object> updateInquiry);

	/* 문의 사항 등록 */
	int insertInquiry(HashMap<String, Object> inquiry);

	/* 문의 사항 삭제 */
	int deleteInquiry(int goodsInquiryNum);

	List<GoodsInquiryReplyDTO> selectInquiryReply(int goodsInquiryNo);

	/* 구매 내역 확인 */
	List<OrderDTO> paymentCheck(HashMap<String, Integer> order);

	List<PaymentDTO> paymentList(int orderNo);

	/* 상품 좋아요 수 증가 */
	int updateGoodsLikeCount(int goodsNo);

	/* 상품 좋아요 수 감소 */
	int updateGoodsdisLikeCount(int goodsNum);


}
