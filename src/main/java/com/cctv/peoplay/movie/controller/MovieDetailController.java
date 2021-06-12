package com.cctv.peoplay.movie.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cctv.peoplay.member.model.dto.MemberDTO;
import com.cctv.peoplay.member.model.dto.SubscribePaymentDTO;
import com.cctv.peoplay.movie.model.dto.MovieDTO;
import com.cctv.peoplay.movie.model.dto.MovieReviewDTO;
import com.cctv.peoplay.movie.model.dto.MovieWishListDTO;
import com.cctv.peoplay.movie.model.service.MovieService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
@RequestMapping("/movie/*")
@SessionAttributes("loginMember")
public class MovieDetailController {
	
	private final MovieService service;
	
	@Autowired
	public MovieDetailController(MovieService service) {
		this.service = service;
	}
	
	/* 영화 정보 가져오기 */
	@GetMapping(value={"/movie/{no}"}, produces = "application/json; charset=UTF-8")
	public String list(Model model,HttpServletRequest request, @PathVariable("no") int no
			) throws Exception {
		MemberDTO loginMember = (MemberDTO) request.getSession().getAttribute("loginMember");
		System.out.println("진행 됨1?");

		model.addAttribute("detail", service.selectmovie(no));
		model.addAttribute("actorList" , service.actorList(no));
		model.addAttribute("movieMainFiles" , service.selectMovieMainFile(no));
		model.addAttribute("movieSubFiles" , service.selectMovieSubFile(no));
		model.addAttribute("list" , service.selectMovieList());
		model.addAttribute("review" , service.movieReviewList(no));
		model.addAttribute("wish", service.selectWish());
		System.out.println("진행 됨111?");
		HashMap<String, Integer> wishMap = new HashMap<>();
		wishMap.put("userNo", loginMember.getUserNo());
		wishMap.put("no", no);
		System.out.println("진행 됨2?");
		MovieWishListDTO wishList = service.selectMovieWishList(wishMap);
		
		System.out.println("진행 됨3?");
		/* 찜 list */
		if(!(wishList == null)) {
			if(!(wishList.getNo().getNo() == no && wishList.getUserNo().getUserNo() == loginMember.getUserNo())) {
				String nothing = "없음";
				model.addAttribute("wishList", nothing);
			}else {
				String nothing = "있음";
				model.addAttribute("wishList", nothing);
			}
			
		} else {
			String nothing = "없음";
			model.addAttribute("wishList", nothing);
		}
		
		System.out.println("진행 됨4?");

		
		System.out.println(model);

//		/* 라이크 처리 // 라이크DTO를 따로 준 이유는? 그리고 이 경우엔... 다른사람이 like 눌러 카운트 되면  문제 됨. null이 아님 */
//		MovieLikeDTO movieLikeList = service.selectMovieLikeList(no);
//	    
//	    /* 좋아요 list */
//	    if(movieLikeList == null) {
//	       String nothing = "없음";
//	       System.out.println("좋아요 없어?");
//	       model.addAttribute("movieLikeList", nothing);
//	    }else {
//	       System.out.println("좋아요 있어?");
//	       
//	       model.addAttribute("movieLikeList", movieLikeList);
//	    }
		
		return "movie/detail";
	}
	
	/* 좋아요 기능 */
	@PostMapping(value = "likeUpdate", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String likeUpdate(Model model , HttpServletRequest request, @RequestParam("likeUpdate") int movieNo) {	
		
		System.out.println("좋아요 값 넘겨받았는지 " + movieNo);
		
		HashMap<String, Object> likeUpdateMap = new HashMap<String, Object>();
		likeUpdateMap.put("likeUpdate", movieNo);
		
		service.likeUpdate(likeUpdateMap);
		System.out.println("여기서 멈춤?");

		MovieDTO likeResult = service.likeAmount(movieNo); 
		model.addAttribute("likeResult" , likeResult);

		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm:ss").create();
		
		return gson.toJson(likeResult);
	}

	/* 싫어요 기능 */
	@PostMapping(value = "disLikeUpdate", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String disLikeUpdate(Model model , HttpServletRequest request, @RequestParam("disLikeUpdate") int movieNo) {	
		
		System.out.println("싫어요 값 넘겨받았는지 " + movieNo);
		
		HashMap<String, Object> disLikeUpdateMap = new HashMap<String, Object>();
		disLikeUpdateMap.put("disLikeUpdate", movieNo);
		
		service.disLikeUpdate(disLikeUpdateMap);
		System.out.println("여기서 멈춤?");
		MovieDTO dislikeResult = service.dislikeAmount(movieNo); 
		model.addAttribute("dislikeResult" , dislikeResult);

		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm:ss").create();
		
//		return "redirect:/";
		return gson.toJson(dislikeResult);
	}
	
	
	
	/* 찜 기능 */
	@PostMapping(value = "wishList", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String wishListUpdate(Model model , HttpServletRequest request) {	
		
		int userNo = Integer.valueOf(request.getParameter("userNo"));
		int movieNo = Integer.valueOf(request.getParameter("movieNo"));
		
		System.out.println("회원번호 넘겨받았는지 " + userNo);
		System.out.println("영화번호 넘겨받았는지 " + movieNo);
		
		HashMap<String, Object> wishListUpdate = new HashMap<String, Object>();
		wishListUpdate.put("userNo", userNo);
		wishListUpdate.put("no", movieNo);
		
		// 추가
		service.insertMovieWishList(wishListUpdate);
		System.out.println("추가?");
		
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm:ss").create();
		
		return gson.toJson(wishListUpdate);
	}
	@PostMapping(value = "unWishList", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String wishListDelete(Model model , HttpServletRequest request) {	
		
		int userNo = Integer.valueOf(request.getParameter("userNo"));
		int movieNo = Integer.valueOf(request.getParameter("movieNo"));
		
		System.out.println("회원번호 넘겨받았는지 " + userNo);
		System.out.println("영화번호 넘겨받았는지 " + movieNo);
		
		HashMap<String, Object> wishListUpdate = new HashMap<String, Object>();
		wishListUpdate.put("userNo", userNo);
		wishListUpdate.put("no", movieNo);
		
		// 삭제
		service.deleteMovieWishList(wishListUpdate);
		System.out.println("삭제?");
		
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm:ss").create();
		
		return gson.toJson(wishListUpdate);
	}
	
	
	/* 영화 리뷰 */
	@RequestMapping(value = "/reply", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String reivewInsert(Model model , HttpServletRequest request,@RequestParam("userNo") int userNo, @RequestParam("movieNo") int movieNo,
			@RequestParam("replyText") String replyText) {	

		
		System.out.println("userNo " + userNo);
		System.out.println("movieNo " + movieNo);
		System.out.println("replyText " + replyText);
		
		HashMap<String, Object> reviews = new HashMap<String, Object>();
		reviews.put("userNo", userNo);
		reviews.put("movieNo", movieNo);
		reviews.put("replyText", replyText);
		
		/* 리뷰 등록 */
		service.reviewInsert(reviews);
		
		/* 리뷰 조회 */
		List<MovieReviewDTO> list = service.movieReviewList(movieNo);
		model.addAttribute("reviews" , list);

		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm:ss").create();
		
		return gson.toJson(list);
		
	}
	
	/* 댓글 삭제 */
	@PostMapping(value = "/replyDelete", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String reivewDelete(Model model , HttpServletRequest request, @RequestParam("replyNum") String replyNum, @RequestParam("movieNo") int movieNo) {	
		
		System.out.println("삭제 값 넘겨받았는지 " + replyNum);
		
		HashMap<String, Object> reviewDelete = new HashMap<String, Object>();
		reviewDelete.put("replyNum", replyNum);
		
		int delete = service.reviewDelete(reviewDelete);
		System.out.println("delete값 " + delete);
		
		List<MovieReviewDTO> list = service.movieReviewList(movieNo);
		model.addAttribute("reviews" , list);

		System.out.println("영화 댓글 리스트" + list);
		
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm:ss").create();
		
		return gson.toJson(list);
		
	}

	
	/* 액션 장르검색 1 */
	@PostMapping(value = "/movieGenre1", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String GenreSearch1(Model model , HttpServletRequest request, @RequestParam("genreAction") String genreAction) {	
		
		System.out.println("전달 받음? " + genreAction);
		HashMap<String, Object> genres1 = new HashMap<String, Object>();
		genres1.put("genreAction", genreAction);
		System.out.println("전달받음?1: " + genres1);
		
		List<MovieDTO> genresResult1 = service.movieGenreSearch1(genres1);
		model.addAttribute("genresResult1" , genresResult1);

		System.out.println("장르 리스트 1: " + genresResult1);
		
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm:ss").create();
		
		return gson.toJson(genresResult1);
		
	}
	
	/* 판타지 장르검색 2 */
	@PostMapping(value = "/movieGenre2", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String GenreSearch2(Model model , HttpServletRequest request, @RequestParam("genreFantasy") String genreFantasy) {	
		
		System.out.println("전달 받음? " + genreFantasy);
		HashMap<String, Object> genres2 = new HashMap<String, Object>();
		genres2.put("genreFantasy", genreFantasy);
		System.out.println("전달받음?2: " + genres2);
		
		List<MovieDTO> genresResult2 = service.movieGenreSearch2(genres2);
		model.addAttribute("genresResult2" , genresResult2);
		
		System.out.println("장르 리스트 2: " + genresResult2);
		
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm:ss").create();
		
		return gson.toJson(genresResult2);
		
	}
	/* 로맨스 장르검색 3 */
	@PostMapping(value = "/movieGenre3", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String GenreSearch3(Model model , HttpServletRequest request, @RequestParam("genreRomance") String genreRomance) {	
		
		System.out.println("전달 받음? " + genreRomance);
		HashMap<String, Object> genres3 = new HashMap<String, Object>();
		genres3.put("genreRomance", genreRomance);
		System.out.println("전달받음?3: " + genres3);
		
		List<MovieDTO> genresResult3 = service.movieGenreSearch3(genres3);
		model.addAttribute("genresResult3" , genresResult3);
		
		System.out.println("장르 리스트3 : " + genresResult3);
		
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm:ss").create();
		
		return gson.toJson(genresResult3);
		
	}
	/* 코미디 장르검색 4 */
	@PostMapping(value = "/movieGenre4", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String GenreSearch4(Model model , HttpServletRequest request, @RequestParam("genreComedy") String genreComedy) {	
		
		System.out.println("전달 받음? " + genreComedy);
		HashMap<String, Object> genres4 = new HashMap<String, Object>();
		genres4.put("genreComedy", genreComedy);
		System.out.println("전달받음?4: " + genres4);
		
		List<MovieDTO> genresResult4 = service.movieGenreSearch4(genres4);
		model.addAttribute("genresResult4" , genresResult4);
		
		System.out.println("장르 리스트 4: " + genresResult4);
		
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm:ss").create();
		
		return gson.toJson(genresResult4);
		
	}
	/* 호러 장르검색 5 */
	@PostMapping(value = "/movieGenre5", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String GenreSearch5(Model model , HttpServletRequest request, @RequestParam("genreHorror") String genreHorror) {	
		
		System.out.println("전달 받음? " + genreHorror);
		HashMap<String, Object> genres5 = new HashMap<String, Object>();
		genres5.put("genreHorror", genreHorror);
		System.out.println("전달받음?5: " + genres5);
		
		List<MovieDTO> genresResult5 = service.movieGenreSearch5(genres5);
		model.addAttribute("genresResult5" , genresResult5);
		
		System.out.println("장르 리스트 5: " + genresResult5);
		
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm:ss").create();
		
		return gson.toJson(genresResult5);
	}

	/* 제목 검색 */
	@PostMapping(value = "/movieSearch", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String movieNameSearch(Model model , HttpServletRequest request, @RequestParam("searchText") String searchText) {	
		
		System.out.println("전달 받음? " + searchText);
		HashMap<String, Object> SearchName = new HashMap<String, Object>();
		SearchName.put("searchText", searchText);
		System.out.println("전달받음?: " + SearchName);
		
		List<MovieDTO> SearchNameResult = service.movieNameSearch(SearchName);
		model.addAttribute("SearchNameResult" , SearchNameResult);
		
		System.out.println("검색 리스트 : " + SearchNameResult);
		
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm:ss").create();
		
		return gson.toJson(SearchNameResult);
	}

	
	
}
