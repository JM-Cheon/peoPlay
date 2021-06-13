package com.cctv.peoplay.goods.model.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cctv.peoplay.goods.model.dao.GoodsMapper;
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



@Service("selectAllGoods")
public class GoodsServiceImpl implements GoodsService {
	
	private GoodsMapper goodsMapper;
	
	@Autowired
	public GoodsServiceImpl(GoodsMapper goodsMapper) {
		this.goodsMapper = goodsMapper;
	}
	
	/* 모든 굿즈 조회해오기 */
	@Override
	public List<GoodsDTO> selectAllGoods(PagenationDTO pageInfo) {
		return goodsMapper.selectAllGoods(pageInfo);
	}

	/* 인기 굿즈 조회해오기 */
	@Override
	public List<GoodsDTO> selectPopularGoods(int num) {
		return goodsMapper.selectPopularGoods(num);
	}

	/* 선택한 굿즈(일반 굿즈) 조회해오기 */
	@Override
	public GoodsDTO selectOneGoodsInfo(int goodsNo) {

		return goodsMapper.selectOneGoodsInfo(goodsNo);
	}
	
	/* 선택한 굿즈(일반 굿즈) 사진 첨부파일 불러오기 */
	@Override
	public GoodsAndFileDTO goodsAndFile(int goodsNo) {
		
		return goodsMapper.goodsAndFile(goodsNo);
	}


	/* 장바구니 담기 (ajax 처리) */
	@Override
	public int insertcart(HashMap<String, Integer> cart) {
		// TODO Auto-generated method stub
		return goodsMapper.insertcart(cart);
	}

	/* 장바구니 내역 조회 */
	@Override
	public List<GoodsCartDTO> cartList(HashMap<String, Integer> cartListMap) {
		
		return goodsMapper.cartList(cartListMap);
	}

	@Override
	public List<GoodsReviewDTO> seletReivewByGoodsNo(int goodsNo) {
		return goodsMapper.seletReivewByGoodsNo(goodsNo);
	}

	@Override
	public int insertReply(HashMap<String, Object> reply) {
		return goodsMapper.insertReply(reply);
	}

	@Override
	public int deleteReply(int goodsReviewNum) {
		return goodsMapper.deleteReply(goodsReviewNum);
	}

	@Override
	public GoodsAndDetailFileDTO selectGoodsDetailFiles(int goodsNo) {
		return goodsMapper.selectGoodsDetailFiles(goodsNo);
	}

	@Override
	public int insertOrder(HashMap<String, Integer> order) {
		return goodsMapper.insertOrder(order);	
	}


	@Override
	public GoodsCartDTO selectOrderList(HashMap<String, Integer> order) {
		return goodsMapper.selectOrderList(order);	
	}

	@Override
	public OrderDTO selectOrderNum(HashMap<String, Integer> order) {
		return goodsMapper.selectOrderNum(order);
	}

	@Override
	public OrderDTO orderInfo(int orderNo) {
		return goodsMapper.orderInfo(orderNo);
	}

	@Override
	public GoodsLikeDTO selectGoodsLikeList(HashMap<String, Integer> order) {
		return goodsMapper.selectGoodsLikeList(order);
	}

	@Override
	public int goodsLikeCountByGoodsNo(int goodsNo) {
		return goodsMapper.goodsLikeCountByGoodsNo(goodsNo);
	}

	@Override
	public int insertLike(HashMap<String, Integer> like) {
		return goodsMapper.insertLike(like);
	}

	@Override
	public int replyUpdate(HashMap<String, Object> updateReply) {
		return goodsMapper.replyUpdate(updateReply);
	}

	@Override
	public int dislikeList(HashMap<String, Integer> dislike) {
		return goodsMapper.dislikeList(dislike);
	}

	@Override
	public int countTotalGoods(int num) {
		return goodsMapper.countTotalGoods(num);
	}

	@Override
	public int searchCount(HashMap<String, String> searchMap) {
		return goodsMapper.searchCount(searchMap);
	}

	@Override
	public List<GoodsDTO> searchlist(HashMap<String, Object> searchListMap) {
		return goodsMapper.searchlist(searchListMap);
	}

	@Override
	public List<GoodsDTO> selectdcAllGoods(PagenationDTO pageInfo) {
		return goodsMapper.selectdcAllGoods(pageInfo);
	}

	@Override
	public List<GoodsDTO> selectghibriAllGoods(PagenationDTO pageInfo) {
		return goodsMapper.selectghibriAllGoods(pageInfo);
	}

	@Override
	public List<GoodsDTO> selectPixarAllGoods(PagenationDTO pageInfo) {
		return goodsMapper.selectPixarAllGoods(pageInfo);
	}

	@Override
	public List<GoodsDTO> selectWbAllGoods(PagenationDTO pageInfo) {
		return goodsMapper.selectPixarAllGoods(pageInfo);
	}

	@Override
	public List<GoodsInqueryDTO> selectInquiryByGoodsNo(int goodsNo) {
		return goodsMapper.selectInquiryByGoodsNo(goodsNo);
	}

	@Override
	public int updatePayment(HashMap<String, Object> payment) {
		return goodsMapper.updatePayment(payment);
	}

	@Override
	public int updatePaidGoods(int orderNo) {
		return goodsMapper.updatePaidGoods(orderNo);
	}

	@Override
	public PaymentDTO paymentNo(int orderNo) {
		return goodsMapper.paymentNo(orderNo);
	}

	@Override
	public List<PaymentDTO> selectPayment(int paymentNo) {
		return goodsMapper.selectPayment(paymentNo);
	}

	@Override
	public int updatedelivery(HashMap<String, Object> delivery) {
		return goodsMapper.updatedelivery(delivery);
	}

	@Override
	public DeliveryDTO deliveryInfo(HashMap<String, Object> delivery) {
		return goodsMapper.deliveryInfo(delivery);
	}

	@Override
	public DeliveryDTO selectDeliveryInfo(int deliveryNum) {
		return goodsMapper.selectDeliveryInfo(deliveryNum);
	}

	@Override
	public int reportReply(HashMap<String, Object> reportReply) {
		return goodsMapper.reportReply(reportReply);
	}

	@Override
	public OrderDTO doubleCheckOrder(HashMap<String, Integer> order) {
		return goodsMapper.doubleCheckOrder(order);
	}

	@Override
	public int cancelOrder(int orderNum) {
		return goodsMapper.cancelOrder(orderNum);
	}

	@Override
	public int insertRecalculate(HashMap<String, Object> recalculate) {
		return goodsMapper.insertRecalculate(recalculate);
	}

	@Override
	public int deleteWishlist(HashMap<String, Integer> deletewish) {
		return goodsMapper.deleteWishlist(deletewish);
	}

	@Override
	public int inquiryUpdate(HashMap<String, Object> updateInquiry) {
		return goodsMapper.inquiryUpdate(updateInquiry);
	}

	@Override
	public int insertInquiry(HashMap<String, Object> inquiry) {
		return goodsMapper.insertInquiry(inquiry);

	}

	@Override
	public int deleteInquiry(int goodsInquiryNum) {
		return goodsMapper.deleteInquiry(goodsInquiryNum);
	}

	@Override
	public List<GoodsInquiryReplyDTO> selectInquiryReply(int goodsInquiryNo) {
		return goodsMapper.selectInquiryReply(goodsInquiryNo);
	}

	@Override
	public List<OrderDTO> paymentCheck(HashMap<String, Integer> order) {
		return goodsMapper.paymentCheck(order);
	}

	@Override
	public List<PaymentDTO> paymentList(int orderNo) {
		return goodsMapper.paymentList(orderNo);

	}

	@Override
	public int updateGoodsLikeCount(int goodsNo) {
		return goodsMapper.updateGoodsLikeCount(goodsNo);
	}

	@Override
	public int updateGoodsdisLikeCount(int goodsNum) {
		return goodsMapper.updateGoodsdisLikeCount(goodsNum);
	}

	@Override
	public List<GoodsAndFileDTO> selectPopular(int i) {
		return goodsMapper.selectPopular(i);

	}

	@Override
	public int insertOutGoods(HashMap<String, Object> payment) {
		return goodsMapper.insertOutGoods(payment);
	}

	@Override
	public int updateGoodsStock(HashMap<String, Object> payment) {
		return goodsMapper.updateGoodsStock(payment);
	}




}
