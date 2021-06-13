package com.cctv.peoplay.goods.model.dao;

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

public interface GoodsMapper {

	List<GoodsDTO> selectAllGoods(PagenationDTO pageInfo);

	List<GoodsDTO> selectPopularGoods(int num);

	GoodsDTO selectOneGoodsInfo(int goodsNo);

	GoodsAndFileDTO goodsAndFile(int goodsNo);

	int insertcart(HashMap<String, Integer> cart);

	List<GoodsCartDTO> cartList(int goodsNo);

	List<GoodsCartDTO> cartList(HashMap<String, Integer> cartListMap);

	List<GoodsReviewDTO> seletReivewByGoodsNo(int goodsNo);

	int insertReply(HashMap<String, Object> reply);

	int deleteReply(int goodsReviewNum);

	GoodsAndDetailFileDTO selectGoodsDetailFiles(int goodsNo);

	int insertOrder(HashMap<String, Integer> order);

	OrderDTO selectOrder(int orderNum);

	GoodsCartDTO selectOrderList(HashMap<String, Integer> order);

	OrderDTO selectOrderNum(HashMap<String, Integer> order);

	OrderDTO orderInfo(int orderNo);

	GoodsLikeDTO selectGoodsLikeList(HashMap<String, Integer> order);

	int goodsLikeCountByGoodsNo(int goodsNo);

	int insertLike(HashMap<String, Integer> like);

	int replyUpdate(HashMap<String, Object> updateReply);

	int dislikeList(HashMap<String, Integer> dislike);

	int countTotalGoods(int num);

	int searchCount(HashMap<String, String> searchMap);

	List<GoodsDTO> searchlist(HashMap<String, Object> searchListMap);

	List<GoodsDTO> selectdcAllGoods(PagenationDTO pageInfo);

	List<GoodsDTO> selectghibriAllGoods(PagenationDTO pageInfo);

	List<GoodsDTO> selectPixarAllGoods(PagenationDTO pageInfo);

	List<GoodsDTO> selectWbAllGoods(PagenationDTO pageInfo);

	List<GoodsInqueryDTO> selectInquiryByGoodsNo(int goodsNo);

	int countTotalGoodsDC();

	int updatePayment(HashMap<String, Object> payment);

	int updatePaidGoods(int orderNo);

	PaymentDTO paymentNo(int orderNo);

	List<PaymentDTO> selectPayment(int paymentNo);

	int updatedelivery(HashMap<String, Object> delivery);

	DeliveryDTO deliveryInfo(HashMap<String, Object> delivery);

	DeliveryDTO selectDeliveryInfo(int deliveryNum);

	int reportReply(HashMap<String, Object> reportReply);

	OrderDTO doubleCheckOrder(HashMap<String, Integer> order);

	int cancelOrder(int orderNum);

	int insertRecalculate(HashMap<String, Object> recalculate);

	int deleteWishlist(HashMap<String, Integer> deletewish);

	int inquiryUpdate(HashMap<String, Object> updateInquiry);

	int insertInquiry(HashMap<String, Object> inquiry);

	int deleteInquiry(int goodsInquiryNum);

	List<GoodsInquiryReplyDTO> selectInquiryReply(int goodsInquiryNo);

	List<OrderDTO> paymentCheck(HashMap<String, Integer> order);

	List<PaymentDTO> paymentList(int orderNo);

	int updateGoodsLikeCount(int goodsNo);

	List<GoodsAndFileDTO> selectPopular(int goodsNum);

	int updateGoodsdisLikeCount(int goodsNum);

	int insertOutGoods(HashMap<String, Object> payment);

	int updateGoodsStock(HashMap<String, Object> payment);

	
}
