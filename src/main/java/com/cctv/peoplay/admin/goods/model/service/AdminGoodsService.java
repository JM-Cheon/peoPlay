package com.cctv.peoplay.admin.goods.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cctv.peoplay.admin.goods.model.dto.DeliveryDTO;
import com.cctv.peoplay.admin.goods.model.dto.GoodsAndDetailFileDTO;
import com.cctv.peoplay.admin.goods.model.dto.GoodsAndFileDTO;
import com.cctv.peoplay.admin.goods.model.dto.GoodsDTO;
import com.cctv.peoplay.admin.goods.paging.PagenationDTO;
import com.cctv.peoplay.goods.model.dto.PaymentDTO;


public interface AdminGoodsService {

	/* 굿즈 관리 모든 상품 추가 메소드 */
	List<GoodsDTO> selectAdminAllGoods(GoodsDTO goodsDTO);

	/* 굿즈 관리 선택한 정보 불러오는 메소드 */
	GoodsDTO selectGoodsInfoByGoodsNo(int goodsNo);

	/* 굿즈 관리 선택한 정보 파일(썸네일 사진) 메소드 */
	List<GoodsAndFileDTO> goodsAndFile(int goodsNo);

	/* 굿즈 관리 선택한 정보 파일(상세페이지 사진 ) 메소드 */
	List<GoodsAndDetailFileDTO> goodsAndDetailFile(int goodsNo);

	/* 굿즈 삭제문(status를 N으로) */
	int deleteGoods(int goodsNum);

	/* 굿즈 상세 정보 insert */
	int insertGoodsinfo(HashMap<String, Object> goodsDetail);

	/* 굿즈 위에 뿌려주는 사진 insert */
	int insertImageFiles(Map<String, String> map);

	/* 굿즈 상세페이지 insert */
	int goodsDetailFiles(Map<String, String> detailFile);

	/* 굿즈 상품 총 개수 count */
	int goodsCount();

	/* 페이징 처리용 select */
	List<GoodsDTO> selectAdminAllGoodsPaging(PagenationDTO pageInfo);

	/* 조건 별 검색 */
	int searchCount(HashMap<String, String> searchMap);

	/* 조건별로 검색한거 조회 */
	List<GoodsDTO> searchlist(HashMap<String, Object> searchListMap);

	/* 결제 내역 조회 (페이징 처리 */
	List<PaymentDTO> paymentList(PagenationDTO pageInfo);

	/* 페이징 처리 (결제 count) */
	int searchPaymentCount(HashMap<String, String> searchMap);

	/* 조건 별 검색 (페이징 처리) */
	List<GoodsDTO> searchPaymentlist(HashMap<String, Object> searchListMap);

	/* 페이징 처리를 위한 결제 테이블 count */
	int paymentgoodsCount();

	/* 굿즈 정보 수정 */
	int updateGoodsinfo(HashMap<String, Object> goodsDetail);

	/* 굿즈  수정시 이미지 파일 덮어씌우기 */
	int updateImageFiles(Map<String, String> file);

	/* 굿즈  수정시 상세이미지 파일 덮어씌우기 */
	int updategoodsDetailFiles(Map<String, String> detailFile);

	/* 굿즈 배송 조회 (페이징 처리) */
	List<DeliveryDTO> deliveryList(PagenationDTO pageInfo);

	/* 배송 내역 count 조회 */
	int deliverygoodsCount();

	/* 배송 조건 별 count 조회 */
	int searchDeliveryCount(HashMap<String, String> searchMap);

	/* 검색조건에 따른 배송 조회 */
	List<GoodsDTO> searchDeliverylist(HashMap<String, Object> searchListMap);

	/* 배송 조회 업데이트 (ajax) */
	int updateStatus(HashMap<String, Object> deliverystatus);

	/* 배송조회 한 개 조회하기 */
	DeliveryDTO deliveryStatusList(int deliveryNum);

	/* 재고관리 페이지 count */
	int stockgoodsCount();

	/* 관리자 메인페이지에서 사진 가져오기 */
	List<GoodsAndFileDTO> mainGoodsAndFile();



}
