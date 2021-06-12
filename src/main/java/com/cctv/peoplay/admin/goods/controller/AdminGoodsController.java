package com.cctv.peoplay.admin.goods.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.buf.UDecoder;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cctv.peoplay.admin.goods.model.dto.DeliveryDTO;
import com.cctv.peoplay.admin.goods.model.dto.GoodsAndDetailFileDTO;
import com.cctv.peoplay.admin.goods.model.dto.GoodsAndFileDTO;
import com.cctv.peoplay.admin.goods.model.dto.GoodsDTO;
import com.cctv.peoplay.admin.goods.model.dto.OrderDTO;
import com.cctv.peoplay.admin.goods.model.service.AdminGoodsService;
import com.cctv.peoplay.admin.goods.paging.Pagenation;
import com.cctv.peoplay.admin.goods.paging.PagenationDTO;
import com.cctv.peoplay.goods.model.dto.GoodsInqueryDTO;
import com.cctv.peoplay.goods.model.dto.GoodsInquiryReplyDTO;
import com.cctv.peoplay.goods.model.dto.PaymentDTO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


@Controller
@RequestMapping("/admin/*")
public class AdminGoodsController {
	
	private final AdminGoodsService admingoodsService;

	@Autowired
	public AdminGoodsController(AdminGoodsService admingoodsService) {
		this.admingoodsService = admingoodsService;

	}
	
	/* 관리자 메인 페이지(굿즈상품 관련) 뿌려주는 메소드 */
	@GetMapping("goods")
	public String goodslist(HttpServletRequest request, @ModelAttribute GoodsDTO goodsDTO, Model model) {
		
		String currentPage = request.getParameter("currentPage");

		int pageNo = 1;

		if (currentPage != null && !"".equals(currentPage)) {
			pageNo = Integer.valueOf(currentPage);

			if (pageNo <= 0) {
				pageNo = 1;
			}
		}
		
		int totalCount = admingoodsService.goodsCount();
		
		int limit = 14;

		int buttonAmount = 5;
		
		PagenationDTO pageInfo = Pagenation.getPageInfo(pageNo, totalCount, limit, buttonAmount);

//		List<GoodsDTO> selectAllGoodslist = admingoodsService.selectAdminAllGoods(goodsDTO);
		
		List<GoodsDTO> selectAllGoodslistPaging = admingoodsService.selectAdminAllGoodsPaging(pageInfo);
		List<GoodsAndFileDTO> goodsAndFile = admingoodsService.mainGoodsAndFile();
		
		model.addAttribute("selectAllGoodslist", selectAllGoodslistPaging);
		model.addAttribute("goodsAndFile", goodsAndFile);
		model.addAttribute("pageInfo", pageInfo);
//		model.addAttribute("selectAllGoodslistPaging", selectAllGoodslistPaging);
		
		

		return "admin/goods/goodsList";
	}
	@PostMapping("goods/search")
	public String search(Model model, HttpServletRequest request, @RequestParam("searchCondition") String searchCondition,
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
		int totalCount = admingoodsService.searchCount(searchMap);
		int limit = 14;

		int buttonAmount = 4;

		PagenationDTO pageInfo = Pagenation.getPageInfo(pageNo, totalCount, limit, buttonAmount);
 		
		// 검색하려고 Map에 담았다.
		HashMap<String, Object> searchListMap = new HashMap<>();
		searchListMap.put("searchCondition", searchCondition);
		searchListMap.put("searchValue", searchValue);
		searchListMap.put("startRow", pageInfo.getStartRow());
		searchListMap.put("endRow", pageInfo.getEndRow());

		List<GoodsDTO> searchList = admingoodsService.searchlist(searchListMap);
		
		List<GoodsAndFileDTO> goodsAndFile = admingoodsService.mainGoodsAndFile();
		
		model.addAttribute("goodsAndFile", goodsAndFile);
		
		model.addAttribute("selectAllGoodslist", searchList);

		model.addAttribute("pageInfo", pageInfo);
		
		return "admin/goods/goodsList";
 		
 	}
	
	@GetMapping("/goods/{goodsNo}")
	public String AdminGoodsDetail(Model model, @PathVariable("goodsNo") int goodsNo, ModelAndView mv) {
		
		GoodsDTO selectGoodsInfoByGoodsNo = admingoodsService.selectGoodsInfoByGoodsNo(goodsNo);
		
		GoodsAndFileDTO goodsAndFile = admingoodsService.goodsAndFile(goodsNo);
		
		GoodsAndDetailFileDTO goodsAndDetailFile = admingoodsService.goodsAndDetailFile(goodsNo);
		
		if(!(selectGoodsInfoByGoodsNo == null)) {
			
			if(selectGoodsInfoByGoodsNo.getGoodsStatus().equals("Y")){
				model.addAttribute("goodsStatus", "판매가능");
			}else {
				model.addAttribute("goodsStatus", "판매불가능");
			}
			
		}else {
			model.addAttribute("goodsStatus", "판매가능");
			
		}
		model.addAttribute("selectGoodsInfoByGoodsNo", selectGoodsInfoByGoodsNo);

		model.addAttribute("goodsAndFile", goodsAndFile);
		
		model.addAttribute("goodsAndDetailFile", goodsAndDetailFile);
		
		return "admin/goods/goodsDetail";
	}
	
	@PostMapping("/goods/adminDeleteGoods")
	@ResponseBody
	public String deleteGoods(Model model, @RequestParam("goodsNum") int goodsNum) {
		
		int deleteGoods = admingoodsService.deleteGoods(goodsNum);
		
		
		GoodsDTO selectGoodsInfoByGoodsNo = admingoodsService.selectGoodsInfoByGoodsNo(goodsNum);
		
		Gson gson = new GsonBuilder().create();
		
		return gson.toJson(selectGoodsInfoByGoodsNo);
		
	}
	@PostMapping("/goods/adminliveGoods")
	@ResponseBody
	public String ResaleGoods(Model model, @RequestParam("goodsNum") int goodsNum) {
		
		int resale = admingoodsService.resaleGoods(goodsNum);
		
		
		GoodsDTO selectGoodsInfoByGoodsNo = admingoodsService.selectGoodsInfoByGoodsNo(goodsNum);
		
		Gson gson = new GsonBuilder().create();
		
		return gson.toJson(selectGoodsInfoByGoodsNo);
		
	}
	@GetMapping("/goods/update")
	public String updateGoods(Model model, @RequestParam("goodsNum") int goodsNum) {
		
		
		GoodsDTO selectGoodsInfoByGoodsNo = admingoodsService.selectGoodsInfoByGoodsNo(goodsNum);
		
		GoodsAndFileDTO goodsAndFile = admingoodsService.goodsAndFile(goodsNum);
		
		GoodsAndDetailFileDTO goodsAndDetailFile = admingoodsService.goodsAndDetailFile(goodsNum);
		
		model.addAttribute("selectGoodsInfoByGoodsNo", selectGoodsInfoByGoodsNo);

		model.addAttribute("goodsAndFile", goodsAndFile);
		
		model.addAttribute("goodsAndDetailFile", goodsAndDetailFile);
		
		return "admin/goods/goodsUpdate";
		
	}
	@GetMapping("/goods/enroll")
	public String enrollGoods(Model model) {
		
		
		return "admin/goods/enroll";
		
	}
	@PostMapping("/goods/enrollGoods")
	public String enrollGoodsDetail(Model model) {
		
		
		return "admin/goods/enroll";
	}
	
	@PostMapping("/goods/enrollGoodsData")
	public String enrollGoodsDetailData(HttpServletRequest request, RedirectAttributes model, 
			@RequestParam(name="goodsFiles1", required=false)  MultipartFile goodsFiles1,
			@RequestParam(name="goodsFiles2", required=false) MultipartFile goodsFiles2,
			@RequestParam(name="goodsFiles3", required=false) MultipartFile goodsFiles3,
			@RequestParam(name="goodsFiles4", required=false) MultipartFile  goodsFiles4,
			@RequestParam(name="goodsFiles5", required=false) MultipartFile  goodsFiles5,
			@RequestParam(name="goodsDetailFiles", required=false) List<MultipartFile> goodsDetailFiles) {
		
		String goodsName = request.getParameter("goodsName");
		String goodsCompany = request.getParameter("goodsCompany");
		String goodsMovie = request.getParameter("goodsMovie");
		int goodsClassifyCode = Integer.parseInt(request.getParameter("goodsClassifyCode"));
		int goodsStock = Integer.parseInt(request.getParameter("goodsStock"));
		int goodsCategory = Integer.parseInt(request.getParameter("goodsCategory"));
		int goodsMoney = Integer.parseInt(request.getParameter("goodsMoney"));
		String goodsNationality = request.getParameter("goodsNationality");
		String goodsShortInfo = request.getParameter("goodsShortInfo");
		
		
		
		HashMap<String, Object> goodsDetail = new HashMap<>();
		goodsDetail.put("goodsName", goodsName);
		goodsDetail.put("goodsCompany", goodsCompany);
		goodsDetail.put("goodsMoney", goodsMoney);
		goodsDetail.put("goodsMovie", goodsMovie);
		goodsDetail.put("goodsClassifyCode", goodsClassifyCode);
		goodsDetail.put("goodsStock", goodsStock);
		goodsDetail.put("goodsNationality", goodsNationality);
		goodsDetail.put("goodsCategory", goodsCategory);
		goodsDetail.put("goodsShortInfo", goodsShortInfo);
		
		int insertGoodsinfo = admingoodsService.insertGoodsinfo(goodsDetail);
//		GoodsDTO selectGoodsNum = admingoodsService.selectGoodsNum();
		
//		model.addAttribute("insertGoodsinfo", insertGoodsinfo);
		
		/* 앞에 보여지는 페이지 사진 처리 */
		String root1 = request.getSession().getServletContext().getRealPath("resources");
		
		String filePath1 = root1 + "\\images\\goods\\goodsImageFiles";
		
		File mkdir1 = new File(filePath1);
		if(!mkdir1.exists()) {
			mkdir1.mkdirs();
		}
		List<MultipartFile> goodsFiles = new ArrayList<>();
		if(!goodsFiles1.isEmpty()) {
			goodsFiles.add(goodsFiles1);
		}else if(!goodsFiles2.isEmpty()) {
			goodsFiles.add(goodsFiles2);
		}else if(!goodsFiles3.isEmpty()) {
			goodsFiles.add(goodsFiles3);
		}else if(!goodsFiles4.isEmpty()) {
			goodsFiles.add(goodsFiles4);
		}else if(!goodsFiles5.isEmpty()) {
			goodsFiles.add(goodsFiles5);
		}
		
		
		List<Map<String, String>> goodsImageFiles = new ArrayList<>();
		
		
		for(int i = 0; i < goodsFiles.size(); i ++) {
			
			if(goodsFiles.get(i) != null) {
				
				/* 파일명 변경 처리 */
				String originFileName1 = goodsFiles.get(i).getOriginalFilename();
				String ext1 = originFileName1.substring(originFileName1.lastIndexOf("."));
				String saveName1 = UUID.randomUUID().toString().replace("-", "") + ext1;

				/* 파일에 관한 정보 추출 후 보관 */
				Map<String, String> file = new HashMap<>();
				file.put("originFileName", originFileName1);
				file.put("saveName", saveName1);
				file.put("filePath", filePath1);
				file.put("thumbnailPath", filePath1);
				
				
				if(i == 0) {
					file.put("distinguish","head" );
					
				}else {
					file.put("distinguish","body" );
				}

				goodsImageFiles.add(file);
				
			} 
			
			
//			model.addAttribute("imageFiles", imageFiles);
		}

		/* 파일을 저장한다. */
		try {
			
			for(int i = 0; i < goodsFiles.size(); i++) {

				Map<String, String> file = goodsImageFiles.get(i);
				
				int imageFiles = admingoodsService.insertImageFiles(file);

				goodsFiles.get(i).transferTo(new File(filePath1 + "\\" + file.get("saveName")));

			}
			
			
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
			
			/* 실패시 파일 삭제 */
			for(int i = 0; i < goodsFiles.size(); i ++) {
				Map<String, String> file = goodsImageFiles.get(i);
				
				new File(filePath1 + "\\" + file.get("saveName")).delete();
			}
		}
		
		
		/* 상세페이지 사진 처리 */
		String root2 = request.getSession().getServletContext().getRealPath("resources");
		
		String filePath2 = root2 + "\\images\\goods\\goodsDetailFiles2";
		
		File mkdir2 = new File(filePath2);
		if(!mkdir2.exists()) {
			mkdir2.mkdirs();
		}
	
		
		List<Map<String, String>> goodsDetailFilessave = new ArrayList<>();
		if(!goodsDetailFiles.isEmpty()) {
			
			for(int i = 0; i < goodsDetailFiles.size(); i ++) {
				/* 파일명 변경 처리 */
				String originFileName2 = goodsDetailFiles.get(i).getOriginalFilename();
				String ext2 = originFileName2.substring(originFileName2.lastIndexOf("."));
				String saveName2 = UUID.randomUUID().toString().replace("-", "") + ext2;
				
				/* 파일에 관한 정보 추출 후 보관 */
				Map<String, String> detailFile = new HashMap<>();
				detailFile.put("originFileName", originFileName2);
				detailFile.put("saveName", saveName2);
				detailFile.put("filePath", filePath2);
				detailFile.put("thumbnailPath", filePath2);
				
				goodsDetailFilessave.add(detailFile);
			}
		}

		/* 파일을 저장한다. */
		try {
			
			for(int i = 0; i < goodsDetailFiles.size(); i++) {

				Map<String, String> detailFile = goodsDetailFilessave.get(i);

				goodsDetailFiles.get(i).transferTo(new File(filePath2 + "\\" + detailFile.get("saveName")));
				
				int savedetailfiles = admingoodsService.goodsDetailFiles(detailFile);
			}
			
			
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
			
			/* 실패시 파일 삭제 */
			for(int i = 0; i < goodsDetailFiles.size(); i ++) {
				Map<String, String> file = goodsDetailFilessave.get(i);
				
				new File(filePath2 + "\\" + file.get("saveName")).delete();
			}
		}
		
		return "redirect:/admin/goods";
	}
	
	
	@PostMapping("/goods/updateGoods2")
	public String updateGoods(HttpServletRequest request, RedirectAttributes model, 
			@RequestParam(name="goodsFiles1", required=false)  MultipartFile goodsFiles1,
			@RequestParam(name="goodsFiles2", required=false) MultipartFile goodsFiles2,
			@RequestParam(name="goodsFiles3", required=false) MultipartFile goodsFiles3,
			@RequestParam(name="goodsFiles4", required=false) MultipartFile  goodsFiles4,
			@RequestParam(name="goodsFiles5", required=false) MultipartFile  goodsFiles5,
			@RequestParam(name="goodsDetailFiles", required=false) List<MultipartFile> goodsDetailFiles) {
		
		String goodsName = request.getParameter("goodsName");
		String goodsCompany = request.getParameter("goodsCompany");
		String goodsMovie = request.getParameter("goodsMovie");
		int goodsNo = Integer.parseInt(request.getParameter("goodsNum"));
		int goodsStock = Integer.parseInt(request.getParameter("goodsStock"));
		int goodsMoney = Integer.parseInt(request.getParameter("goodsPrice"));
		String goodsNationality = request.getParameter("goodsNationality");
		String goodsShortInfo = request.getParameter("goodsShortInfo");
		String goodsStatus = request.getParameter("goodsStatus");
		String goodsOrigin = request.getParameter("goodsOrigin");
		String goodsNumber = request.getParameter("goodsNumber");
		
		HashMap<String, Object> goodsDetail = new HashMap<>();
		goodsDetail.put("goodsNo", goodsNo);
		goodsDetail.put("goodsName", goodsName);
		goodsDetail.put("goodsCompany", goodsCompany);
		goodsDetail.put("goodsMoney", goodsMoney);
		goodsDetail.put("goodsMovie", goodsMovie);
		goodsDetail.put("goodsStock", goodsStock);
		goodsDetail.put("goodsNationality", goodsNationality);
		goodsDetail.put("goodsShortInfo", goodsShortInfo);
		goodsDetail.put("goodsStatus", goodsStatus);
		goodsDetail.put("goodsOrigin", goodsOrigin);
		
		int updateGoodsinfo = admingoodsService.updateGoodsinfo(goodsDetail);
//		GoodsDTO selectGoodsNum = admingoodsService.selectGoodsNum();
		
//		model.addAttribute("insertGoodsinfo", insertGoodsinfo);
		
		/* 앞에 보여지는 페이지 사진 처리 */
		String root1 = request.getSession().getServletContext().getRealPath("resources");
		
		String filePath1 = root1 + "\\images\\goods\\goodsImageFiles";
		
		File mkdir1 = new File(filePath1);
		if(!mkdir1.exists()) {
			mkdir1.mkdirs();
		}
		List<MultipartFile> goodsFiles = new ArrayList<>();
		
		if(!goodsFiles1.isEmpty()) {
			goodsFiles.add(goodsFiles1);
		}else if(!goodsFiles2.isEmpty()) {
			goodsFiles.add(goodsFiles2);
		}else if(!goodsFiles3.isEmpty()) {
			goodsFiles.add(goodsFiles3);
		}else if(!goodsFiles4.isEmpty()) {
			goodsFiles.add(goodsFiles4);
		}else if(!goodsFiles5.isEmpty()) {
			goodsFiles.add(goodsFiles5);
		}
		
		
		List<Map<String, String>> goodsImageFiles = new ArrayList<>();
		
		
		for(int i = 0; i < goodsFiles.size(); i ++) {
			
			if(goodsFiles.get(i) != null) {
				
				/* 파일명 변경 처리 */
				String originFileName1 = goodsFiles.get(i).getOriginalFilename();
				String ext1 = originFileName1.substring(originFileName1.lastIndexOf("."));
				String saveName1 = UUID.randomUUID().toString().replace("-", "") + ext1;

				/* 파일에 관한 정보 추출 후 보관 */
				Map<String, String> file = new HashMap<>();
				file.put("originFileName", originFileName1);
				file.put("saveName", saveName1);
				file.put("filePath", filePath1);
				file.put("thumbnailPath", filePath1);
				file.put("goodsNumber", goodsNumber);

				goodsImageFiles.add(file);
				
			} 
			
			
//			model.addAttribute("imageFiles", imageFiles);
		}

		/* 파일을 저장한다. */
		try {
			
			for(int i = 0; i < goodsFiles.size(); i++) {

				Map<String, String> file = goodsImageFiles.get(i);
				
				int imageFiles = admingoodsService.updateImageFiles(file);

				goodsFiles.get(i).transferTo(new File(filePath1 + "\\" + file.get("saveName")));

			}
			
			model.addAttribute("message", "파일 업로드 성공!");
			
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
			
			/* 실패시 파일 삭제 */
			for(int i = 0; i < goodsFiles.size(); i ++) {
				Map<String, String> file = goodsImageFiles.get(i);
				
				new File(filePath1 + "\\" + file.get("saveName")).delete();
			}
			model.addAttribute("message", "파일 업로드 실패!");
		}
		
		
		/* 상세페이지 사진 처리 */
		String root2 = request.getSession().getServletContext().getRealPath("resources");
		
		String filePath2 = root2 + "\\images\\goods\\goodsDetailFiles2";
		
		File mkdir2 = new File(filePath2);
		if(!mkdir2.exists()) {
			mkdir2.mkdirs();
		}
	
		
		List<Map<String, String>> goodsDetailFilessave = new ArrayList<>();
		if((goodsDetailFiles.isEmpty())) {
			System.out.println("dd");
		for(int i = 0; i < goodsDetailFiles.size(); i ++) {
			/* 파일명 변경 처리 */
			String originFileName2 = goodsDetailFiles.get(i).getOriginalFilename();
			String ext2 = originFileName2.substring(originFileName2.lastIndexOf("."));
			String saveName2 = UUID.randomUUID().toString().replace("-", "") + ext2;

			/* 파일에 관한 정보 추출 후 보관 */
			Map<String, String> detailFile = new HashMap<>();
			detailFile.put("originFileName", originFileName2);
			detailFile.put("saveName", saveName2);
			detailFile.put("filePath", filePath2);
			detailFile.put("thumbnailPath", filePath2);
			detailFile.put("goodsNumber", goodsNumber);

			goodsDetailFilessave.add(detailFile);
			}
		/* 파일을 저장한다. */
		try {
			
			for(int i = 0; i < goodsDetailFiles.size(); i++) {
				
				Map<String, String> detailFile = goodsDetailFilessave.get(i);
				
				goodsDetailFiles.get(i).transferTo(new File(filePath2 + "\\" + detailFile.get("saveName")));
				
				int savedetailfiles = admingoodsService.updategoodsDetailFiles(detailFile);
			}
			
			model.addAttribute("message", "파일 업로드 성공!");
			
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
			
			/* 실패시 파일 삭제 */
			for(int i = 0; i < goodsDetailFiles.size(); i ++) {
				Map<String, String> file = goodsDetailFilessave.get(i);
				
				new File(filePath2 + "\\" + file.get("saveName")).delete();
			}
			model.addAttribute("message", "파일 업로드 실패!");
		}
		
		}

		
		
		return "redirect:/admin/goods";
	}
	
	@GetMapping("/goods/Payment")
	public String GoodsPayment(HttpServletRequest request, Model model) {
		
		String currentPage = request.getParameter("currentPage");

		int pageNo = 1;

		if (currentPage != null && !"".equals(currentPage)) {
			pageNo = Integer.valueOf(currentPage);

			if (pageNo <= 0) {
				pageNo = 1;
			}
		}
		
		int totalCount = admingoodsService.paymentgoodsCount();
		
		int limit = 14;

		int buttonAmount = 4;
		
		PagenationDTO pageInfo = Pagenation.getPageInfo(pageNo, totalCount, limit, buttonAmount);
		
		List<OrderDTO> paymentList = admingoodsService.paymentList(pageInfo);
		
		model.addAttribute("paymentList",paymentList);
		model.addAttribute("pageInfo", pageInfo);
		
		return "admin/goods/payment";
		
	}
	@PostMapping("goods/paymentSearch")
	public String Paymentsearch(Model model, HttpServletRequest request, @RequestParam("searchCondition") String searchCondition,
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
		int totalCount = admingoodsService.searchPaymentCount(searchMap);
		int limit = 14;

		int buttonAmount = 4;

		PagenationDTO pageInfo = Pagenation.getPageInfo(pageNo, totalCount, limit, buttonAmount);
 		
		// 검색하려고 Map에 담았다.
		HashMap<String, Object> searchListMap = new HashMap<>();
		searchListMap.put("searchCondition", searchCondition);
		searchListMap.put("searchValue", searchValue);
		searchListMap.put("startRow", pageInfo.getStartRow());
		searchListMap.put("endRow", pageInfo.getEndRow());

		List<GoodsDTO> searchList = admingoodsService.searchPaymentlist(searchListMap);
		
		model.addAttribute("paymentList", searchList);

		model.addAttribute("pageInfo", pageInfo);
		
		return "admin/goods/payment";
 		
 	}
	
	@GetMapping("/goods/Delivery")
	public String GoodsDelivery(HttpServletRequest request, Model model) {
		
		String currentPage = request.getParameter("currentPage");

		int pageNo = 1;

		if (currentPage != null && !"".equals(currentPage)) {
			pageNo = Integer.valueOf(currentPage);

			if (pageNo <= 0) {
				pageNo = 1;
			}
		}
		
		int totalCount = admingoodsService.deliverygoodsCount();
		
		int limit = 14;

		int buttonAmount = 4;
		
		PagenationDTO pageInfo = Pagenation.getPageInfo(pageNo, totalCount, limit, buttonAmount);
		
		List<DeliveryDTO> deliveryList = admingoodsService.deliveryList(pageInfo);
		
		model.addAttribute("deliveryList",deliveryList);
		model.addAttribute("pageInfo", pageInfo);
		
		return "admin/goods/delivery";
		
	}	
	@PostMapping("goods/DeliverySearch")
	public String Deliverysearch(Model model, HttpServletRequest request, @RequestParam("searchCondition") String searchCondition,
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
		int totalCount = admingoodsService.searchDeliveryCount(searchMap);
		int limit = 14;

		int buttonAmount = 4;

		PagenationDTO pageInfo = Pagenation.getPageInfo(pageNo, totalCount, limit, buttonAmount);
 		
		// 검색하려고 Map에 담았다.
		HashMap<String, Object> searchListMap = new HashMap<>();
		searchListMap.put("searchCondition", searchCondition);
		searchListMap.put("searchValue", searchValue);
		searchListMap.put("startRow", pageInfo.getStartRow());
		searchListMap.put("endRow", pageInfo.getEndRow());

		List<GoodsDTO> deliveryList = admingoodsService.searchDeliverylist(searchListMap);
		
		model.addAttribute("deliveryList", deliveryList);

		model.addAttribute("pageInfo", pageInfo);
		
		return "admin/goods/delivery";
 		
 	}	
	
	
	@PostMapping(value="/goods/deliveryStatus", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String deliveryStatus(HttpServletResponse response,
			 @RequestParam("deliveryNum") int deliveryNum, @RequestParam("status") int status) {
		
		HashMap<String, Object> deliverystatus = new HashMap<>();
		deliverystatus.put("deliveryNum", deliveryNum);
		deliverystatus.put("status", status);
		
		int updateStatus = admingoodsService.updateStatus(deliverystatus);
		
		
		Gson gson = new GsonBuilder().create();
		
		return gson.toJson(updateStatus);
	}
	
	@PostMapping(value="/goods/inquiryAnswerAdmin", produces = "application/json; charset=UTF-8")
	public String nquiryAnswerAdmin(HttpServletResponse response,
			@RequestParam("inquiryReplyNum") int inquiryReplyNum, @RequestParam("inquiryAnswer") String inquiryAnswer,
			@RequestParam("goodsNum") int goodsNum, @RequestParam("userNo") int userNo) {
		
		System.out.println("왓어?");
		System.out.println("inquiryAnswer" + inquiryAnswer);
		System.out.println("inquiryReplyNum" + inquiryReplyNum);
		System.out.println("goodsNum" + goodsNum);
		System.out.println("userNo" + userNo);
		
		HashMap<String, Object> answerInquiry = new HashMap<>();
		answerInquiry.put("inquiryReplyNum", inquiryReplyNum);
		answerInquiry.put("inquiryAnswer", inquiryAnswer);
		answerInquiry.put("goodsNum", goodsNum);
		answerInquiry.put("userNo", userNo);
		
		int updateInquiryAnswer = admingoodsService.updateInquiryAnswer(answerInquiry);
		System.out.println("ddd");
		
		if(updateInquiryAnswer > 0) {
			
			int updateYN = admingoodsService.updateYN(inquiryReplyNum);
		}
		
		return "redirect:/admin/goods/InquiryAnswer";
	}
	
	@GetMapping("/goods/InquiryAnswer")
	public String GoodsStock(HttpServletRequest request, Model model) {
		
		String currentPage = request.getParameter("currentPage");

		int pageNo = 1;

		if (currentPage != null && !"".equals(currentPage)) {
			pageNo = Integer.valueOf(currentPage);

			if (pageNo <= 0) {
				pageNo = 1;
			}
		}
		
		int totalCount = admingoodsService.inquiryList();
		
		int limit = 14;

		int buttonAmount = 4;
		
		PagenationDTO pageInfo = Pagenation.getPageInfo(pageNo, totalCount, limit, buttonAmount);
		
		List<GoodsInqueryDTO> inquiryListPaging = admingoodsService.inquiryListPaging(pageInfo);
		List<GoodsInquiryReplyDTO> selectInquiryReply = admingoodsService.selectInquiryReply();

		Gson gson = new GsonBuilder().create();
		
		model.addAttribute("selectInquiryReply", gson.toJson(selectInquiryReply));
		model.addAttribute("inquiryListPaging", inquiryListPaging);
		model.addAttribute("pageInfo", pageInfo);
		
		return "admin/goods/inquiryAnswer";
		
	}	
	
	
	
	
	
}
