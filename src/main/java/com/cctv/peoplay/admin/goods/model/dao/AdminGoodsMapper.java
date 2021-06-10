package com.cctv.peoplay.admin.goods.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cctv.peoplay.admin.goods.model.dto.DeliveryDTO;
import com.cctv.peoplay.admin.goods.model.dto.GoodsAndDetailFileDTO;
import com.cctv.peoplay.admin.goods.model.dto.GoodsAndFileDTO;
import com.cctv.peoplay.admin.goods.model.dto.GoodsDTO;
import com.cctv.peoplay.admin.goods.paging.PagenationDTO;
import com.cctv.peoplay.goods.model.dto.PaymentDTO;

public interface AdminGoodsMapper {

	public List<GoodsDTO> selectAdminAllGoods(GoodsDTO goodsDTO);

	public GoodsDTO selectGoodsInfoByGoodsNo(int goodsNo);

	public List<GoodsAndFileDTO> goodsAndFile(int goodsNo);

	public List<GoodsAndDetailFileDTO> goodsAndDetailFile(int goodsNo);

	public int deleteGoods(int goodsNum);

	public int insertGoodsinfo(HashMap<String, Object> goodsDetail);

	public int insertImageFiles(Map<String, String> map);

	public int goodsDetailFiles(Map<String, String> detailFile);

	public int goodsCount();

	public List<GoodsDTO> selectAdminAllGoodsPaging(PagenationDTO pageInfo);

	public int searchCount(HashMap<String, String> searchMap);

	public List<GoodsDTO> searchlist(HashMap<String, Object> searchListMap);

	public List<PaymentDTO> paymentList(PagenationDTO pageInfo);

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

}
