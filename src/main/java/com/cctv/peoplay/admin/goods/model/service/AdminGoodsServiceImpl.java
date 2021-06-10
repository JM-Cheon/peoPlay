package com.cctv.peoplay.admin.goods.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cctv.peoplay.admin.goods.model.dao.AdminGoodsMapper;
import com.cctv.peoplay.admin.goods.model.dto.DeliveryDTO;
import com.cctv.peoplay.admin.goods.model.dto.GoodsAndDetailFileDTO;
import com.cctv.peoplay.admin.goods.model.dto.GoodsAndFileDTO;
import com.cctv.peoplay.admin.goods.model.dto.GoodsDTO;
import com.cctv.peoplay.admin.goods.paging.PagenationDTO;
import com.cctv.peoplay.goods.model.dto.PaymentDTO;

@Service("adminGoodsService")
public class AdminGoodsServiceImpl implements AdminGoodsService {
	
private AdminGoodsMapper adminGoodsMapper;
	
	@Autowired
	public AdminGoodsServiceImpl(AdminGoodsMapper adminGoodsMapper) {
		this.adminGoodsMapper = adminGoodsMapper;
	}

	@Override
	public List<GoodsDTO> selectAdminAllGoods(GoodsDTO goodsDTO) {
		return adminGoodsMapper.selectAdminAllGoods(goodsDTO);
	}

	@Override
	public GoodsDTO selectGoodsInfoByGoodsNo(int goodsNo) {
		return adminGoodsMapper.selectGoodsInfoByGoodsNo(goodsNo);
	}

	@Override
	public List<GoodsAndFileDTO> goodsAndFile(int goodsNo) {
		return adminGoodsMapper.goodsAndFile(goodsNo);
	}

	@Override
	public List<GoodsAndDetailFileDTO> goodsAndDetailFile(int goodsNo) {
		return adminGoodsMapper.goodsAndDetailFile(goodsNo);
	}

	@Override
	public int deleteGoods(int goodsNum) {
		return adminGoodsMapper.deleteGoods(goodsNum);
	}

	@Override
	public int insertGoodsinfo(HashMap<String, Object> goodsDetail) {
		return adminGoodsMapper.insertGoodsinfo(goodsDetail);
	}

	@Override
	public int insertImageFiles(Map<String, String> map) {
		return adminGoodsMapper.insertImageFiles(map);
	}

	@Override
	public int goodsDetailFiles(Map<String, String> detailFile) {
		return adminGoodsMapper.goodsDetailFiles(detailFile);
	}

	@Override
	public int goodsCount() {
		return adminGoodsMapper.goodsCount();
	}

	@Override
	public List<GoodsDTO> selectAdminAllGoodsPaging(PagenationDTO pageInfo) {
		return adminGoodsMapper.selectAdminAllGoodsPaging(pageInfo);
	}

	@Override
	public int searchCount(HashMap<String, String> searchMap) {
		return adminGoodsMapper.searchCount(searchMap);
	}

	@Override
	public List<GoodsDTO> searchlist(HashMap<String, Object> searchListMap) {
		return adminGoodsMapper.searchlist(searchListMap);
	}

	@Override
	public List<PaymentDTO> paymentList(PagenationDTO pageInfo) {
		return adminGoodsMapper.paymentList(pageInfo);
	}

	@Override
	public int searchPaymentCount(HashMap<String, String> searchMap) {
		return adminGoodsMapper.searchPaymentCount(searchMap);
	}

	@Override
	public List<GoodsDTO> searchPaymentlist(HashMap<String, Object> searchListMap) {
		return adminGoodsMapper.searchPaymentlist(searchListMap);
	}

	@Override
	public int paymentgoodsCount() {
		return adminGoodsMapper.paymentgoodsCount();
	}

	@Override
	public int updateGoodsinfo(HashMap<String, Object> goodsDetail) {
		return adminGoodsMapper.updateGoodsinfo(goodsDetail);
	}

	@Override
	public int updateImageFiles(Map<String, String> file) {
		return adminGoodsMapper.updateImageFiles(file);
	}

	@Override
	public int updategoodsDetailFiles(Map<String, String> detailFile) {
		return adminGoodsMapper.updategoodsDetailFiles(detailFile);
	}

	@Override
	public List<DeliveryDTO> deliveryList(PagenationDTO pageInfo) {
		return adminGoodsMapper.deliveryList(pageInfo);
	}

	@Override
	public int deliverygoodsCount() {
		return adminGoodsMapper.deliverygoodsCount();
	}

	@Override
	public int searchDeliveryCount(HashMap<String, String> searchMap) {
		return adminGoodsMapper.searchDeliveryCount(searchMap);
	}

	@Override
	public List<GoodsDTO> searchDeliverylist(HashMap<String, Object> searchListMap) {
		return adminGoodsMapper.searchDeliverylist(searchListMap);
	}

	@Override
	public int updateStatus(HashMap<String, Object> deliverystatus) {
		return adminGoodsMapper.updateStatus(deliverystatus);
	}

	@Override
	public DeliveryDTO deliveryStatusList(int deliveryNum) {
		return adminGoodsMapper.deliveryStatusList(deliveryNum);
	}

	@Override
	public int stockgoodsCount() {
		return adminGoodsMapper.stockgoodsCount();
	}

	@Override
	public List<GoodsAndFileDTO> mainGoodsAndFile() {
		return adminGoodsMapper.mainGoodsAndFile();
	}



}
