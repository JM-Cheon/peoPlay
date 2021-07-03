package com.cctv.peoplay.goods.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cctv.peoplay.goods.model.dto.DeliveryDTO;
import com.cctv.peoplay.goods.model.dto.GoodsAndDetailFileDTO;
import com.cctv.peoplay.goods.model.dto.GoodsAndFileDTO;
import com.cctv.peoplay.goods.model.dto.GoodsCartDTO;
import com.cctv.peoplay.goods.model.dto.GoodsDTO;
import com.cctv.peoplay.goods.model.dto.GoodsInqueryDTO;
import com.cctv.peoplay.goods.model.dto.GoodsInquiryReplyDTO;
import com.cctv.peoplay.goods.model.dto.GoodsLikeDTO;
import com.cctv.peoplay.goods.model.dto.GoodsReviewDTO;
import com.cctv.peoplay.goods.model.dto.OrderDTO;
import com.cctv.peoplay.goods.model.dto.PaymentDTO;
import com.cctv.peoplay.goods.model.service.GoodsService;
import com.cctv.peoplay.goods.paging.Pagenation;
import com.cctv.peoplay.goods.paging.PagenationDTO;
import com.cctv.peoplay.member.model.dto.MemberDTO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
@RequestMapping("/goods/*")
public class GoodsController {

	private final GoodsService goodsService;

	@Autowired
	public GoodsController(GoodsService goodsService) {
		this.goodsService = goodsService;
	}

	/* 메인 페이지 뿌려주는 메소드 */
	@GetMapping("goodslist")
	public String goodslist(@ModelAttribute GoodsDTO goodsDTO, Model model, HttpServletRequest request) {

		String currentPage = request.getParameter("currentPage");

		MemberDTO loginMember = (MemberDTO) request.getSession().getAttribute("loginMember");

		int pageNo = 1;

		if (currentPage != null && !"".equals(currentPage)) {
			pageNo = Integer.valueOf(currentPage);

			if (pageNo <= 0) {
				pageNo = 1;
			}
		}

		int totalCount = goodsService.countTotalGoods(1);
		int totalCountdc = goodsService.countTotalGoods(2);
		int totalCountghibri = goodsService.countTotalGoods(3);
		int totalCountpixar = goodsService.countTotalGoods(4);
		int totalCountwb = goodsService.countTotalGoods(5);

		int limit = 10;

		int buttonAmount = 5;

		PagenationDTO pageInfo = Pagenation.getPageInfo(pageNo, totalCount, limit, buttonAmount);
		PagenationDTO pageInfoDC = Pagenation.getPageInfo(pageNo, totalCountdc, limit, buttonAmount);
		PagenationDTO pageInfoGhibri = Pagenation.getPageInfo(pageNo, totalCountghibri, limit, buttonAmount);
		PagenationDTO pageInfopixar = Pagenation.getPageInfo(pageNo, totalCountpixar, limit, buttonAmount);
		PagenationDTO pageInfowb = Pagenation.getPageInfo(pageNo, totalCountwb, limit, buttonAmount);

		List<GoodsDTO> selectMarvelGoods = goodsService.selectAllGoods(pageInfo);
		List<GoodsDTO> selectdcGoods = goodsService.selectdcAllGoods(pageInfoDC);
		List<GoodsDTO> selectghibriGoods = goodsService.selectghibriAllGoods(pageInfoGhibri);
		List<GoodsDTO> selectpixarGoods = goodsService.selectPixarAllGoods(pageInfopixar);
		List<GoodsDTO> selectwbGoods = goodsService.selectWbAllGoods(pageInfowb);

		List<GoodsAndFileDTO> goodsAndFile = goodsService.selectPopular(1);

		List<GoodsDTO> marvelpopularList = goodsService.selectPopularGoods(1);
		List<GoodsDTO> dcpopularList = goodsService.selectPopularGoods(2);
		List<GoodsDTO> ghibripopularList = goodsService.selectPopularGoods(3);
		List<GoodsDTO> pixarpopularList = goodsService.selectPopularGoods(4);
		List<GoodsDTO> wbpopularList = goodsService.selectPopularGoods(5);

		model.addAttribute("selectAllGoods", selectMarvelGoods);
		model.addAttribute("pageInfo", pageInfo);

		model.addAttribute("selectdcGoods", selectdcGoods);
		model.addAttribute("pageInfoDC", pageInfoDC);

		model.addAttribute("selectghibriGoods", selectghibriGoods);
		model.addAttribute("pageInfoGhibri", pageInfoGhibri);

		model.addAttribute("selectpixarGoods", selectpixarGoods);
		model.addAttribute("pageInfopixar", pageInfopixar);

		model.addAttribute("selectwbGoods", selectwbGoods);
		model.addAttribute("pageInfowb", pageInfowb);

		model.addAttribute("marvelpopularList", marvelpopularList);
		model.addAttribute("dcpopularList", dcpopularList);
		model.addAttribute("ghibripopularList", ghibripopularList);
		model.addAttribute("pixarpopularList", pixarpopularList);
		model.addAttribute("wbpopularList", wbpopularList);

		return "goods/goods";
	}

	/* 선택한 굿즈 상품에 대한 상세 정보 불러오는 메소드 */
	@GetMapping(value="/goods/{goodsNo}", produces = "application/json; charset=UTF-8")
	public String selectOrderDelete(Model model, @PathVariable("goodsNo") int goodsNo, ModelAndView mv, HttpServletRequest request) {

		GoodsDTO selectOneGoodsInfo = goodsService.selectOneGoodsInfo(goodsNo);

		GoodsAndFileDTO goodsAndFile = goodsService.goodsAndFile(goodsNo);

		List<GoodsReviewDTO> seletReivewByGoodsNo = goodsService.seletReivewByGoodsNo(goodsNo);

		int ReviewCount = seletReivewByGoodsNo.size();

		List<GoodsInqueryDTO> selectInquiryByGoodsNo = goodsService.selectInquiryByGoodsNo(goodsNo);
		List<GoodsInquiryReplyDTO> selectInquiryReply = goodsService.selectInquiryReply(goodsNo);

		GoodsAndDetailFileDTO selectGoodsDetailFiles = goodsService.selectGoodsDetailFiles(goodsNo);

		MemberDTO loginMember = (MemberDTO) request.getSession().getAttribute("loginMember");

		HashMap<String, Integer> order = new HashMap<>();
		order.put("userNo", loginMember.getUserNo());
		order.put("goodsNo", goodsNo);

		/* 주문 현황을 확인하여 후기 작성 가능 여부를 판단 */
		List<OrderDTO> paymentCheck = goodsService.paymentCheck(order);
		if(!paymentCheck.isEmpty()) {

			for(int i = 0; i < paymentCheck.size(); i++) {

				if(paymentCheck.get(i).getUserNo().getUserNo() == loginMember.getUserNo() && 
						paymentCheck.get(i).getGoodsNo().getGoodsNum() == goodsNo) {

					model.addAttribute("paidGoods", "Y");

					List<PaymentDTO> paymentList = goodsService.paymentList(paymentCheck.get(i).getOrderNo());

					for(int j = 0; j < paymentList.size(); j++) {

						model.addAttribute("paidNumber", paymentList );

					}

				}else {

					model.addAttribute("paidGoods", "N");

				}

			}
		}else {

			model.addAttribute("paidGoods", "N");
		}

		GoodsCartDTO cartList = goodsService.selectOrderList(order);

		GoodsLikeDTO goodsLikeList = goodsService.selectGoodsLikeList(order);

		/* 좋아요에 대해서 null값 예외 처리 및 데이터 유무에 따른 처리 메소드 */
		if(!(goodsLikeList == null)) {
			if(!(goodsLikeList.getGoodsNum().getGoodsNum() == goodsNo && goodsLikeList.getUserNo().getUserNo() == 1)) {
				String nothing = "없음";
				model.addAttribute("goodsLikeList", nothing);
			}else {
				String nothing = "있음";
				model.addAttribute("goodsLikeList", nothing);
			}

		} else {
			String nothing = "없음";
			model.addAttribute("goodsLikeList", nothing);
		}

		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();


		/* 댓글을 불러오기 */
		model.addAttribute("seletReivewByGoodsNo", seletReivewByGoodsNo);

		/* Q&A 불러오기 */
		model.addAttribute("selectInquiryByGoodsNo", selectInquiryByGoodsNo);

		/* 선택한 굿즈 이미지 파일을 가져오기 */
		model.addAttribute("goodsAndFile", goodsAndFile);

		model.addAttribute("selectGoodsDetailFiles", selectGoodsDetailFiles);

		/* 선택한 굿즈에 대한 정보 조회 */
		model.addAttribute("selectOneGoodsInfo", selectOneGoodsInfo);

		/* 선택한 굿즈에 문의사항 답변 */
		model.addAttribute("selectInquiryReply", gson.toJson(selectInquiryReply));

		/* 댓글 갯수 */
		model.addAttribute("ReviewCount", ReviewCount);

		/* 로그인 멤버 */
		model.addAttribute("loginMember", loginMember);

		/* 장바구니 null값에 대한 예외 처리 */
		if(!(cartList == null)) {

			if(!(cartList.getUserNum().getUserNo() == 1 && cartList.getGoodsNum().getGoodsNum() == goodsNo)) {
				String nothing = "없음";
				model.addAttribute("cartList", nothing);
			} else {

				model.addAttribute("cartList", cartList);
			}
		}else {
			String nothing = "없음";
			model.addAttribute("cartList", nothing);
		}

		return "goods/goodsDetail";
	}

	/* 장바구니에 넣는 메소드 */
	@GetMapping("/cart")
	public ModelAndView insertGoodsCartList(ModelAndView mv, HttpServletResponse response,
			HttpServletRequest request, @RequestParam("goodsNum") int goodsNum, @RequestParam("userNum") int userNum,
			RedirectAttributes rttr) {

		int count = 1;

		/* 장바구니에 회원 번호와 상품 번호를 넘겨서 존재하는지 확인 */
		HashMap<String, Integer> cartListMap = new HashMap<>();
		cartListMap.put("goodsNum", goodsNum);
		cartListMap.put("userNum", userNum);

		List<GoodsCartDTO> cartList = goodsService.cartList(cartListMap);

		HashMap<String, Integer> cart = new HashMap<>();
		cart.put("goodsNum", goodsNum);
		cart.put("userNum", userNum);
		cart.put("count", count);

		/* 장바구니에 없다면 */
		if (cartList.isEmpty()) {
			int goodscart = goodsService.insertcart(cart);

		} else {	// 장바구니에 존재한다면

			mv.addObject("message", "이미 장바구니에 담겨있습니다.");
			mv.addObject("cart", "있음");
		}

		response.setContentType("application/json; charset=UTF-8");
		mv.setViewName("jsonview");

		return mv;
	}

	/* 상품 좋아요 insert 메소드 (Ajax로 처리) */
	@GetMapping("/like")
	@ResponseBody
	public ModelAndView goodsLikeBtn(ModelAndView mv, HttpServletResponse response,
			HttpServletRequest request, @RequestParam("goodsNum") int goodsNum, @RequestParam("memNum") int memNum) {

		HashMap<String, Integer> like = new HashMap<>();
		like.put("goodsNum", goodsNum);
		like.put("memNum", memNum);


		int likeList = goodsService.insertLike(like);

		if(likeList > 0) {
			int updateGoodsLikeCount =  goodsService.updateGoodsLikeCount(goodsNum);
		}

		response.setContentType("application/json; charset=UTF-8");
		mv.setViewName("jsonview");

		return mv;
	}

	/* 상품 좋아요 취소 메소드 (Ajax로 처리) */
	@GetMapping("/dislike")
	@ResponseBody
	public ModelAndView goodsDislikeBtn(ModelAndView mv, HttpServletResponse response,
			HttpServletRequest request, @RequestParam("goodsNum") int goodsNum, @RequestParam("memNum") int memNum) {

		HashMap<String, Integer> dislike = new HashMap<>();
		dislike.put("goodsNum", goodsNum);
		dislike.put("memNum", memNum);

		int dislikeList = goodsService.dislikeList(dislike);

		if(dislikeList > 0) {
			int updateGoodsdisLikeCount =  goodsService.updateGoodsdisLikeCount(goodsNum);
		}

		response.setContentType("application/json; charset=UTF-8");
		mv.setViewName("jsonview");

		return mv;
	}

	/* 주문 테이블에 있을 때 */
	@GetMapping("/order")
	public String goodsOrder(ModelAndView mv, HttpServletResponse response, Model model,
			HttpServletRequest request, @RequestParam("goodsNum") int goodsNum, 
			@RequestParam("memNum") int memNum, @RequestParam("count") int count) {

		HashMap<String, Integer> order = new HashMap<>();
		order.put("goodsNum", goodsNum);
		order.put("memNum", memNum);
		order.put("count", count);

		OrderDTO doubleCheckOrder = goodsService.doubleCheckOrder(order);
		GoodsAndFileDTO goodsAndFile = goodsService.goodsAndFile(goodsNum);

		if(doubleCheckOrder == null) {

			int insertOrder = goodsService.insertOrder(order);
		}
		OrderDTO orderList = goodsService.selectOrderNum(order);

		int infoOrderNum = orderList.getOrderNo();

		OrderDTO orderInfo = goodsService.orderInfo(infoOrderNum);

		model.addAttribute("orderInfo", orderInfo);

		/* 계산하기(수량 x 상품 가격) */
		int amount = orderInfo.getOrderCount();
		int price = orderInfo.getGoodsNo().getGoodsPrice();

		/* vat */
		double vat = price * 0.1;

		int totalPrice = amount * price;

		GoodsDTO selectOneGoodsInfo = goodsService.selectOneGoodsInfo(goodsNum);
		model.addAttribute("selectOneGoodsInfo", selectOneGoodsInfo);

		/* 선택한 굿즈 이미지 파일을 가져오기 */
		model.addAttribute("goodsAndFile", goodsAndFile);
		model.addAttribute("totalPrice", totalPrice);
		model.addAttribute("vat", vat);

		return "goods/goodsorder";
	}

	/* 주문 테이블에 없을 때 */
	@GetMapping( "/newOrder")
	public String goodsOrderNotYet(ModelAndView mv, HttpServletResponse response, Model model,
			HttpServletRequest request, @RequestParam("goodsNum") int goodsNum, 
			@RequestParam("memNum") int memNum, @RequestParam("count") int count) {

		HashMap<String, Integer> order = new HashMap<>();
		order.put("goodsNum", goodsNum);
		order.put("memNum", memNum);
		order.put("count", count);

		OrderDTO doubleCheckOrder = goodsService.doubleCheckOrder(order);
		GoodsAndFileDTO goodsAndFile = goodsService.goodsAndFile(goodsNum);
		if(doubleCheckOrder == null) {

			int insertOrder = goodsService.insertOrder(order);
		}
		OrderDTO orderList = goodsService.selectOrderNum(order);

		int infoOrderNum = orderList.getOrderNo();

		OrderDTO orderInfo = goodsService.orderInfo(infoOrderNum);

		model.addAttribute("orderInfo", orderInfo );

		/* 계산하기(수량 x 상품 가격) */
		int amount = orderInfo.getOrderCount();
		int price = orderInfo.getGoodsNo().getGoodsPrice();

		int totalPrice = amount * price;
		GoodsDTO selectOneGoodsInfo = goodsService.selectOneGoodsInfo(goodsNum);
		model.addAttribute("selectOneGoodsInfo", selectOneGoodsInfo);

		/* 선택한 굿즈 이미지 파일을 가져오기 */
		model.addAttribute("goodsAndFile", goodsAndFile);
		model.addAttribute("totalPrice", totalPrice);
		return "goods/goodsorder";
	}


	/* 굿즈 상품 댓글 다는 메소드 (Ajax로 처리) */
	@GetMapping(value="/reply", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String goodsReplyAjax(ModelAndView mv, HttpServletResponse response,
			@RequestParam("goodsNum") int goodsNum, @RequestParam("payNum") int payNum, 
			@RequestParam("userNum") int userNum, @RequestParam("replytext") String replytext) {

		HashMap<String, Object> reply = new HashMap<>();
		reply.put("goodsNum", goodsNum);
		reply.put("userNum", userNum);
		reply.put("replytext", replytext);
		reply.put("payNum", payNum);

		int replyinsert = goodsService.insertReply(reply);

		List<GoodsReviewDTO> seletReivewByGoodsNo = goodsService.seletReivewByGoodsNo(goodsNum);

		Gson gson = new GsonBuilder()
				.setDateFormat("yyyy-MM-dd")
				.create();

		return gson.toJson(seletReivewByGoodsNo);
	}

	/* 굿즈 상품에 대한 문의 하는 메소드 (Ajax로 처리) */
	@GetMapping(value="/inquiry", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String goodsInquiryAjax(ModelAndView mv, HttpServletResponse response,
			@RequestParam("goodsNum") int goodsNum, 
			@RequestParam("userNum") int userNum, @RequestParam("inquiryText") String inquiryText) {

		HashMap<String, Object> inquiry = new HashMap<>();
		inquiry.put("goodsNum", goodsNum);
		inquiry.put("userNum", userNum);
		inquiry.put("inquiryText", inquiryText);

		int Inquiryinsert = goodsService.insertInquiry(inquiry);

		List<GoodsInqueryDTO> selectInquiryByGoodsNo = goodsService.selectInquiryByGoodsNo(goodsNum);

		Gson gson = new GsonBuilder()
				.setDateFormat("yyyy-MM-dd")
				.create();

		return gson.toJson(selectInquiryByGoodsNo);
	}

	/* 굿즈 상품 댓글을 삭제하는 메소드 (Ajax로 처리) */
	@GetMapping(value="/replyDelete", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String goodsReplyDeleteAjax(ModelAndView mv, HttpServletResponse response,
			@RequestParam("goodsReviewNum") int goodsReviewNum, @RequestParam("goodsNum") int goodsNum) {

		int deleteReply = goodsService.deleteReply(goodsReviewNum);

		List<GoodsReviewDTO> seletReivewByGoodsNo = goodsService.seletReivewByGoodsNo(goodsNum);

		int count = seletReivewByGoodsNo.size();
		mv.addObject("count",count);

		Gson gson = new GsonBuilder()
				.setDateFormat("yyyy-MM-dd")
				.create();

		return gson.toJson(seletReivewByGoodsNo);
	}

	/* 굿즈 상품에 대한 문의를 삭제하는 메소드 (Ajax로 처리) */
	@PostMapping(value="/inquiryDelete", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String goodsInquiryDeleteAjax(ModelAndView mv, HttpServletResponse response,
			@RequestParam("goodsInquiryNum") int goodsInquiryNum, @RequestParam("goodsNum") int goodsNum) {

		int deleteInquiry = goodsService.deleteInquiry(goodsInquiryNum);

		List<GoodsInqueryDTO> selectInquiryByGoodsNo = goodsService.selectInquiryByGoodsNo(goodsNum);

		Gson gson = new GsonBuilder()
				.setDateFormat("yyyy-MM-dd")
				.create();

		return gson.toJson(selectInquiryByGoodsNo);
	}

	/* 굿즈 댓글 수정에 대한 메소드 */
	@PostMapping(value="/updateReply", produces = "application/json; charset=UTF-8")
	public String goodsReplyUpdate(ModelAndView mv, HttpServletResponse response, 
			@RequestParam("updateContent") String updateContent, 
			@RequestParam("reviewNum") int reviewNum, @RequestParam("goodsNum") int goodsNum) {

		HashMap<String, Object> updateReply = new HashMap<>();
		updateReply.put("goodsNum", goodsNum);
		updateReply.put("reviewNum", reviewNum);
		updateReply.put("updateContent", updateContent);

		int replyUpdate = goodsService.replyUpdate(updateReply);

		return "redirect:/goods/" + goodsNum;
	}

	/* 굿즈 문의사항 수정에 대한 메소드 */
	@PostMapping(value="/updateInquiry", produces = "application/json; charset=UTF-8")
	public String goodsUpdateInquiry(ModelAndView mv, HttpServletResponse response, 
			@RequestParam("inquiryUpdateContent") String inquiryUpdateContent, 
			@RequestParam("inquiryNum") int inquiryNum, @RequestParam("goodsNumber") int goodsNumber) {

		HashMap<String, Object> updateInquiry = new HashMap<>();
		updateInquiry.put("goodsNum", goodsNumber);
		updateInquiry.put("inquiryNum", inquiryNum);
		updateInquiry.put("inquiryUpdateContent", inquiryUpdateContent);

		int inquiryUpdate = goodsService.inquiryUpdate(updateInquiry);

		return "redirect:/goods/" + goodsNumber;
	}

	/* 굿즈 상품을 구매하는 메소드 */
	@PostMapping(value="/payGoods", produces = "application/json; charset=UTF-8")
	public String payGoods(ModelAndView mv, HttpServletResponse response, @RequestParam("orderNo") int orderNo,
			@RequestParam("totalPrice2") int totalPrice2,  @RequestParam("deliveryCode") int deliveryCode,
			@RequestParam("goodsNum") int goodsNum, @RequestParam("quantities") int quantities,
			Model model, HttpServletRequest request, HttpSession session) {

		HashMap<String, Object> payment = new HashMap<>();
		payment.put("orderNo", orderNo);
		payment.put("totalPrice", totalPrice2);
		payment.put("quantities", quantities);
		payment.put("goodsNum", goodsNum);

		int updatePayment = goodsService.updatePayment(payment);
		if(updatePayment > 0) {
			int updatePaidGoods = goodsService.updatePaidGoods(orderNo);

			if(updatePaidGoods > 0	) { // 상품 구매 후 
				/* 상품 결제 후 재고관리, 장바구니, 굿즈 재고에 대한 업데이트 */
				int updateGoodsStock = goodsService.updateGoodsStock(payment);
				int insertOutGoods = goodsService.insertOutGoods(payment);
				int deleteWishList = goodsService.deleteWishList(payment);
			}
		}

		MemberDTO loginMember = (MemberDTO) request.getSession().getAttribute("loginMember");

		GoodsAndFileDTO goodsAndFile = goodsService.goodsAndFile(goodsNum);
		session.setAttribute("goodsAndFile", goodsAndFile);

		HashMap<String, Object> delivery2 = new HashMap<>();
		delivery2.put("orderNo", orderNo);
		delivery2.put("totalPrice", totalPrice2);
		delivery2.put("goodsNum", goodsNum);
		delivery2.put("deliveryCode", deliveryCode);
		delivery2.put("memNum", loginMember.getUserNo());

		int updatedelivery = goodsService.updatedelivery(delivery2);

		DeliveryDTO deliveryNo = goodsService.deliveryInfo(delivery2);

		DeliveryDTO selectDeliveryInfo = goodsService.selectDeliveryInfo(deliveryNo.getDeliveryNumber());

		String str = "";

		if( selectDeliveryInfo.getShipmentCode().getShipmentMemoCode()== 1) {
			str = "집 앞에 놓아주세요.";
		} else if(selectDeliveryInfo.getShipmentCode().getShipmentMemoCode() == 2) {
			str = "경비실에 맡겨주세요.";
		} else if(selectDeliveryInfo.getShipmentCode().getShipmentMemoCode() == 3) {
			str = "부재시 문 앞에 놓아주세요.";
		} else if(selectDeliveryInfo.getShipmentCode().getShipmentMemoCode() == 4) {
			str = "택배함에 넣어주세요.";
		}

		session.setAttribute("selectDeliveryInfo", selectDeliveryInfo);
		session.setAttribute("deliveryCode", str);

		return "goods/orderFinished";
	}

	/* 굿즈 상품 조건별 검색 */
	@GetMapping("search")
	public String goodsSearch(Model model, HttpServletRequest request, @RequestParam("searchCondition") String searchCondition,
			@RequestParam("searchValue") String searchValue) {

		String condition = request.getParameter("searchCondition");
		String value = request.getParameter("searchValue");


		HashMap<String, String> searchMap = new HashMap<>();
		searchMap.put("searchCondition", condition);
		searchMap.put("searchValue", value);

		String currentPage = request.getParameter("currentPage");

		int pageNo = 1;

		if (currentPage != null && !"".equals(currentPage)) {
			pageNo = Integer.valueOf(currentPage);

			if (pageNo <= 0) {
				pageNo = 1;
			}
		}

		// 검색 후 페이징 처리용
		int totalCount = goodsService.searchCount(searchMap);
		int limit = 10;

		int buttonAmount = 5;

		PagenationDTO pageInfo = Pagenation.getPageInfo(pageNo, totalCount, limit, buttonAmount);

		// 검색하려고 Map에 담았다.
		HashMap<String, Object> searchListMap = new HashMap<>();
		searchListMap.put("searchCondition", searchCondition);
		searchListMap.put("searchValue", searchValue);
		searchListMap.put("startRow", pageInfo.getStartRow());
		searchListMap.put("endRow", pageInfo.getEndRow());

		List<GoodsDTO> searchList = goodsService.searchlist(searchListMap);

		List<GoodsDTO> marvelpopularList = goodsService.selectPopularGoods(1);
		List<GoodsDTO> dcpopularList = goodsService.selectPopularGoods(2);
		List<GoodsDTO> ghibripopularList = goodsService.selectPopularGoods(3);
		List<GoodsDTO> pixarpopularList = goodsService.selectPopularGoods(4);
		List<GoodsDTO> wbpopularList = goodsService.selectPopularGoods(5);

		model.addAttribute("selectAllGoods", searchList);
		//			model.addAttribute("selectdcGoods", selectdcGoods);
		//			model.addAttribute("selectghibriGoods", selectghibriGoods);
		//			model.addAttribute("selectpixarGoods", selectpixarGoods);
		//			model.addAttribute("selectwbGoods", selectwbGoods);

		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("marvelpopularList", marvelpopularList);
		model.addAttribute("dcpopularList", dcpopularList);
		model.addAttribute("ghibripopularList", ghibripopularList);
		model.addAttribute("pixarpopularList", pixarpopularList);
		model.addAttribute("wbpopularList", wbpopularList);


		return "goods/goods";

	}

	/* 굿즈 댓글에 대한 신고 처리 */
	@PostMapping("/report")
	public String goodsReportReview(ModelAndView mv, HttpServletResponse response,
			HttpServletRequest request, @RequestParam("reportReason") String reportReason,
			@RequestParam("reportedPerson") int reportedPerson , @RequestParam("placeNo") int placeNo,
			@RequestParam("reportReplyNo") int reportReplyNo, @RequestParam("userNo") int userNo)  {

		HashMap<String, Object> reportReply = new HashMap<>();
		reportReply.put("reportReason", reportReason);
		reportReply.put("reportedPerson", reportedPerson);
		reportReply.put("goodsNo", placeNo);
		reportReply.put("reportReplyNo", reportReplyNo);
		reportReply.put("userNo", userNo);


		int replyReport = goodsService.reportReply(reportReply);

		return "redirect:/goods/" + placeNo;
	}

	@GetMapping("cancel")
	public String goodsCancelOrder(Model model, HttpServletRequest request, ModelAndView mv,
			@RequestParam("orderNum") int orderNum, @RequestParam("goodsNo") int goodsNo) {

		/* 주문 취소 */
		int cancelOrder = goodsService.cancelOrder(orderNum);
		MemberDTO loginMember = (MemberDTO) request.getSession().getAttribute("loginMember");
		/* 장바구니에서 삭제 */
		HashMap<String, Integer> deletewish = new HashMap<String, Integer>();
		deletewish.put("orderNum", orderNum);
		deletewish.put("goodsNo", goodsNo);
		deletewish.put("userNo", loginMember.getUserNo());

		int deleteWishlist = goodsService.deleteWishlist(deletewish);

		HashMap<String, Integer> order = new HashMap<>();
		order.put("userNo", loginMember.getUserNo());
		order.put("goodsNo", goodsNo);

		HashMap<String, Integer> cartListMap = new HashMap<>();
		cartListMap.put("goodsNum", goodsNo);
		cartListMap.put("userNum", loginMember.getUserNo());

		List<GoodsCartDTO> cartList = goodsService.cartList(cartListMap);
		mv.addObject("cartList", cartList);
		//			mv.addObject("OrderList", OrderList);

		return "redirect:" + goodsNo;
	}

	/* 굿즈 주문 페이지에서 수량 증감 시 메소드 (Ajax로 처리) */
	@GetMapping(value="/recalculate", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String recalculate(Model model, ModelAndView mv, HttpServletResponse response,
			@RequestParam("orderNo") int orderNo, 
			@RequestParam("count") int count) {

		HashMap<String, Object> recalculate = new HashMap<>();
		recalculate.put("orderNo", orderNo);
		recalculate.put("count", count);

		int insertRecalculate = goodsService.insertRecalculate(recalculate);

		Gson gson = new GsonBuilder()
				.setDateFormat("yyyy-MM-dd")
				.create();

		OrderDTO orderInfo = goodsService.orderInfo(orderNo);


		/* 계산하기(수량 x 상품 가격) */
		int amount = orderInfo.getOrderCount();
		int price = orderInfo.getGoodsNo().getGoodsPrice();

		return gson.toJson(orderInfo);
	}

}

















