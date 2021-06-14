package com.cctv.peoplay.admin.goods.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cctv.peoplay.admin.goods.model.dto.DeliveryDTO;
import com.cctv.peoplay.admin.goods.model.dto.GoodsAndDetailFileDTO;
import com.cctv.peoplay.admin.goods.model.dto.GoodsAndFileDTO;
import com.cctv.peoplay.admin.goods.model.dto.GoodsDTO;
import com.cctv.peoplay.admin.goods.model.dto.GoodsInAndOutDTO;
import com.cctv.peoplay.admin.goods.model.dto.OrderDTO;
import com.cctv.peoplay.admin.goods.paging.PagenationDTO;
import com.cctv.peoplay.goods.model.dto.GoodsInqueryDTO;
import com.cctv.peoplay.goods.model.dto.GoodsInquiryReplyDTO;

public interface AdminGoodsMapper {

	public List<GoodsDTO> selectAdminAllGoods(GoodsDTO goodsDTO);

	public GoodsDTO selectGoodsInfoByGoodsNo(int goodsNo);

	public GoodsAndFileDTO goodsAndFile(int goodsNo);

	public GoodsAndDetailFileDTO goodsAndDetailFile(int goodsNo);

	public int deleteGoods(int goodsNum);

	public int insertGoodsinfo(HashMap<String, Object> goodsDetail);

	public int insertImageFiles(Map<String, String> map);

	public int goodsDetailFiles(Map<String, String> detailFile);

	public int goodsCount();

	public List<GoodsDTO> selectAdminAllGoodsPaging(PagenationDTO pageInfo);

	public int searchCount(HashMap<String, String> searchMap);

	public List<GoodsDTO> searchlist(HashMap<String, Object> searchListMap);

	public List<OrderDTO> paymentList(PagenationDTO pageInfo);

	public int searchPaymentCount(HashMap<String, String> searchMap);

	public List<GoodsDTO> searchPaymentlist(HashMap<String, Object> searchListMap);

	public int paymentgoodsCount();

	public int updateGoodsinfo(HashMap<String, Object> goodsDetail);

	public int deleteFiles(int goodsNum);

	public int updateImageFiles(Map<String, String> file);

	public int updategoodsDetailFiles(Map<String, String> detailFile);

	public List<DeliveryDTO> deliveryList(PagenationDTO pageInfo);

	public int deliverygoodsCount();

	public int searchDeliveryCount(HashMap<String, String> searchMap);

	public List<GoodsDTO> searchDeliverylist(HashMap<String, Object> searchListMap);

	public int updateStatus(HashMap<String, Object> deliverystatus);

	public DeliveryDTO deliveryStatusList(int deliveryNum);

	public int stockgoodsCount();

	public List<GoodsAndFileDTO> mainGoodsAndFile();

	public int inquiryList();

	public List<GoodsInqueryDTO> inquiryListPaging(PagenationDTO pageInfo);

	public int updateInquiryAnswer(HashMap<String, Object> answerInquiry);

	public int updateYN(int inquiryReplyNum);

	public List<GoodsInquiryReplyDTO> selectInquiryReply();

	public int resaleGoods(int goodsNum);

	public int stockList();

	public List<GoodsDTO> selectGoodsStock();

	public int insertInitiate(GoodsDTO insertStock);

	public List<GoodsInAndOutDTO> selectGoodsList(PagenationDTO pageInfo);

	public int searchStockSearch(HashMap<String, String> searchMap);

	public List<GoodsInAndOutDTO> selectStockPaging(HashMap<String, Object> searchListMap);

	public int deletePastImage(int goodsNo);

	public int deletedetailfile(int goodsNo);

	public int updateStockManage(HashMap<String, Object> goodsDetail);

	public int searchInquirySearch(HashMap<String, String> searchMap);

	public List<GoodsInqueryDTO> selectInquiryPaging(HashMap<String, Object> searchListMap);


}
