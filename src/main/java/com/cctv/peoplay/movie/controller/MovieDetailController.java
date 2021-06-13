package com.cctv.peoplay.movie.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cctv.peoplay.member.model.dto.MemberDTO;
import com.cctv.peoplay.member.model.service.MemberService;
import com.cctv.peoplay.movie.model.dto.ActorDTO;
import com.cctv.peoplay.movie.model.dto.MovieDTO;
import com.cctv.peoplay.movie.model.dto.MovieLikeDislikeDTO;
import com.cctv.peoplay.movie.model.dto.MovieReviewDTO;
import com.cctv.peoplay.movie.model.dto.MovieUserFavoriteGenreDTO;
import com.cctv.peoplay.movie.model.dto.MovieWatchListDTO;
import com.cctv.peoplay.movie.model.dto.MovieWishListDTO;
import com.cctv.peoplay.movie.model.service.MovieService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
@RequestMapping("/movie/*")
@SessionAttributes("loginMember")
public class MovieDetailController {
	
	private final MovieService service;
	private final MemberService memberService;
	
	@Autowired
	public MovieDetailController(MovieService service, MemberService memberService) {
		this.service = service;
		this.memberService = memberService;		
	}
	
	/* 영화 정보 가져오기 */
	@GetMapping(value={"/movie/{no}"}, produces = "application/json; charset=UTF-8")
	public String list(@ModelAttribute MemberDTO member, Model model,HttpServletRequest request, @PathVariable("no") int no
			) throws Exception {
		MemberDTO loginMember = (MemberDTO) request.getSession().getAttribute("loginMember");
		ActorDTO acterList = service.actorList(no);

		model.addAttribute("detail", service.selectmovie(no));
		model.addAttribute("actorList" , acterList);
		model.addAttribute("adminActorList" ,  service.adminActorList(no));
		model.addAttribute("movieMainFiles" , service.selectMovieMainFile(no));
		model.addAttribute("movieSubFiles" , service.selectMovieSubFile(no));
		model.addAttribute("list" , service.selectMovieList());
		model.addAttribute("review" , service.movieReviewList(no));
		model.addAttribute("wish", service.selectWish());
		model.addAttribute("watch", service.selectWatch());
		
		/* 장르 처리 */
		
		
		/* 좋아요 싫어요 해시 맵 */
		HashMap<String, Integer> likeDislikeMap = new HashMap<>();
		likeDislikeMap.put("userNo", loginMember.getUserNo());
		likeDislikeMap.put("no", no);
		MovieLikeDislikeDTO likeList = service.selectLikeRead(likeDislikeMap);
		MovieLikeDislikeDTO dislikeList = service.selectDislikeRead(likeDislikeMap);

		
		// 있으면 좋아요 비어 있으면 없음
		if(!(likeList == null)) {
			String nothing = "좋아요";
			model.addAttribute("likeDislikeList", nothing);
		} else {
			String nothing = "없음";
			model.addAttribute("likeDislikeList", nothing);
		}

		// 있으면 싫어요 비어 있으면 없음
		if(!(dislikeList == null)) {
			String nothing = "싫어요";
			model.addAttribute("dislikeList", nothing);
		} else {
			String nothing = "없음";
			model.addAttribute("dislikeList", nothing);
		}
			
		
	/* 찜 해시 맵 */
	HashMap<String, Integer> wishMap = new HashMap<>();
	wishMap.put("userNo", loginMember.getUserNo());
	wishMap.put("no", no);
	MovieWishListDTO wishList = service.selectMovieWishList(wishMap);
	
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
	
	/* 재생 목록 해시 맵 */
	HashMap<String, Integer> watchMap = new HashMap<>();
	watchMap.put("userNo", loginMember.getUserNo());
	watchMap.put("no", no);
	MovieWatchListDTO watchList = service.selectMovieWatchList(watchMap);
	
	/* 재생목록 list */
	if(!(watchList == null)) {
		if(!(watchList.getNo().getNo() == no && watchList.getUserNo().getUserNo() == loginMember.getUserNo())) {
		}else {
			String nothing = "있음";
			model.addAttribute("watchList", nothing);
		}
	} else {
		String nothing = "없음";
		model.addAttribute("watchList", nothing);
	}
	model.addAttribute("loginMember", memberService.selectMember(loginMember));

		return "movie/detail";
	}

	/* 좋아요 인서트 */	
	@PostMapping(value = "likeList", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String likeUpdate(@ModelAttribute MemberDTO member, Model model , HttpServletRequest request) {	
		
		int userNo = Integer.valueOf(request.getParameter("userNo"));
		int movieNo = Integer.valueOf(request.getParameter("movieNo"));
		
		
		String like = "좋아요";
		HashMap<String, Object> insertMovieLikeDislikeList = new HashMap<String, Object>();
		insertMovieLikeDislikeList.put("userNo", userNo);
		insertMovieLikeDislikeList.put("no", movieNo);
		insertMovieLikeDislikeList.put("likeDislike", like);

		HashMap<String, Object> likeUpdate = new HashMap<String, Object>();
		likeUpdate.put("likeUpdate", movieNo);
		
		// 추가
		service.insertMovieLikeDislikeList(insertMovieLikeDislikeList);
		service.likeUpdate(likeUpdate);

		/* 좋아요 싫어요 해시 맵 */
		HashMap<String, Integer> likeDislikeMap = new HashMap<>();
		likeDislikeMap.put("userNo", userNo);
		likeDislikeMap.put("no", movieNo);
		MovieLikeDislikeDTO likeDislikeList = service.selectMovieLikeDislikeList(likeDislikeMap);
		
		
		
//		/* 장르 선호 해시 맵 */
		//무비 장르 가져옴  
		HashMap<String, Integer> genreNameMap = new HashMap<>();
		genreNameMap.put("no", movieNo);
		MovieDTO genreNameList = service.movieGenreName(genreNameMap);

		
		// 장르 선택 함
		HashMap<String, Object> selectGenre = new HashMap<>();
		selectGenre.put("userNo", userNo);
		selectGenre.put("favoriteGenreName", genreNameList.getGenreName());
		
		// 장르 가져옴
		MovieUserFavoriteGenreDTO generinsert = service.seleteUserFavoriteGenre(selectGenre);
		
		
		/* 장르 카운트  추가 */
		HashMap<String, Object> GenreCount = new HashMap<String, Object>();
		GenreCount.put("userNo", generinsert.getUserNo().getUserNo());
		GenreCount.put("genreNo", generinsert.getMovieFavoriteGenreCategory().getFavoriteGenreNo());
		
		// 셀렉트 추가
		service.genreCount(GenreCount);
		
		model.addAttribute("loginMember", memberService.selectMember(member));

		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm:ss").create();
		
		return gson.toJson(likeDislikeList);
	}
	
	/* 좋아요 해제  */
	@PostMapping(value = "unlikeList", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String likeDelete(@ModelAttribute MemberDTO member, Model model , HttpServletRequest request) {	
		
		int userNo = Integer.valueOf(request.getParameter("userNo"));
		int movieNo = Integer.valueOf(request.getParameter("movieNo"));
		
		HashMap<String, Object> deleteMovieLikeDislikeList = new HashMap<String, Object>();
		deleteMovieLikeDislikeList.put("userNo", userNo);
		deleteMovieLikeDislikeList.put("no", movieNo);

		HashMap<String, Integer> likeDislikeMap = new HashMap<>();
		likeDislikeMap.put("userNo", userNo);
		likeDislikeMap.put("no", movieNo);
		MovieLikeDislikeDTO likeDislikeList = service.selectMovieLikeDislikeList(likeDislikeMap);
		
		HashMap<String, Object> unlikeUpdate = new HashMap<String, Object>();
		unlikeUpdate.put("unlikeUpdate", movieNo);
		/* 삭제 */
 		service.deleteMovieLikeDislikeList(deleteMovieLikeDislikeList);
 		service.unlikeUpdate(unlikeUpdate);
		
 		
 		
// 		/* 장르 선호 해시 맵 */
		// 무비 장르 가져옴 
		HashMap<String, Integer> genreNameMap = new HashMap<>();
		genreNameMap.put("no", movieNo);
		MovieDTO genreNameList = service.movieGenreName(genreNameMap);

		
		// 장르 선택 함
		HashMap<String, Object> selectGenre = new HashMap<>();
		selectGenre.put("userNo", userNo);
		selectGenre.put("favoriteGenreName", genreNameList.getGenreName());
		
		// 장르 가져옴
		MovieUserFavoriteGenreDTO generinsert = service.seleteUserFavoriteGenre(selectGenre);
 		
		/* 장르 -카운트  추가 */
		HashMap<String, Object> unGenreCount = new HashMap<String, Object>();
		unGenreCount.put("unuserNo", generinsert.getUserNo().getUserNo());
		unGenreCount.put("ungenreNo", generinsert.getMovieFavoriteGenreCategory().getFavoriteGenreNo());
 		
		// 카운트 제거
		service.unGenreCount(unGenreCount);
		
		
		model.addAttribute("loginMember", memberService.selectMember(member));

		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm:ss").create();
		
		return gson.toJson(deleteMovieLikeDislikeList);
	}
	/* 좋아요 등록 및 싫어요 취소  */
	@PostMapping(value = "changelikeList", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String dislikechangelikeUpdate(@ModelAttribute MemberDTO member, Model model , HttpServletRequest request) {	
		int userNo = Integer.valueOf(request.getParameter("userNo"));
		int movieNo = Integer.valueOf(request.getParameter("movieNo"));
		
		/* 삭제가 아닌 업데이트 */
		HashMap<String, Object> updateMovieLikeList = new HashMap<String, Object>();
		updateMovieLikeList.put("userNo", userNo);
		updateMovieLikeList.put("no", movieNo);
		

		HashMap<String, Object> undisLikeUpdate = new HashMap<String, Object>();
		undisLikeUpdate.put("undisLikeUpdate", movieNo);

		HashMap<String, Object> likeUpdate = new HashMap<String, Object>();
		likeUpdate.put("likeUpdate", movieNo);
		
		/* 변경 및 삭제 */
 		service.updateMovieLikeList(updateMovieLikeList);
		service.undisLikeUpdate(undisLikeUpdate);

 		/* 좋아요 플러스 */
 		service.likeUpdate(likeUpdate);		 		
 		

 		
//		/* 장르 선호 해시 맵 */
		//무비 장르 가져옴  
		HashMap<String, Integer> genreNameMap = new HashMap<>();
		genreNameMap.put("no", movieNo);
		MovieDTO genreNameList = service.movieGenreName(genreNameMap);

		
		// 장르 선택 함
		HashMap<String, Object> selectGenre = new HashMap<>();
		selectGenre.put("userNo", userNo);
		selectGenre.put("favoriteGenreName", genreNameList.getGenreName());
		
		// 장르 가져옴
		MovieUserFavoriteGenreDTO generinsert = service.seleteUserFavoriteGenre(selectGenre);
		
		
		/* 장르 카운트  추가 */
		HashMap<String, Object> GenreCount = new HashMap<String, Object>();
		GenreCount.put("userNo", generinsert.getUserNo().getUserNo());
		GenreCount.put("genreNo", generinsert.getMovieFavoriteGenreCategory().getFavoriteGenreNo());
		
		/* 장르 -카운트  추가 */
		HashMap<String, Object> unGenreCount = new HashMap<String, Object>();
		unGenreCount.put("unuserNo", generinsert.getUserNo().getUserNo());
		unGenreCount.put("ungenreNo", generinsert.getMovieFavoriteGenreCategory().getFavoriteGenreNo());
		
		// 좋아요 추가 싫어요 감소(2개 카운트)
		service.genreCount(GenreCount);
		service.genreCount(GenreCount);
 		
 		
		model.addAttribute("loginMember", memberService.selectMember(member));

		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm:ss").create();
		
		return gson.toJson(updateMovieLikeList);
	}
	
	
	/* 싫어요 인서트 */	
	@PostMapping(value = "dislikeList", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String dislikeUpdate(@ModelAttribute MemberDTO member, Model model , HttpServletRequest request) {	
		
		int userNo = Integer.valueOf(request.getParameter("userNo"));
		int movieNo = Integer.valueOf(request.getParameter("movieNo"));
		String dislike = "싫어요";
		HashMap<String, Object> insertMovieLikeDislikeList = new HashMap<String, Object>();
		insertMovieLikeDislikeList.put("userNo", userNo);
		insertMovieLikeDislikeList.put("no", movieNo);
		insertMovieLikeDislikeList.put("likeDislike", dislike);

		HashMap<String, Object> disLikeUpdate = new HashMap<String, Object>();
		disLikeUpdate.put("disLikeUpdate", movieNo);
		
		// 추가
		service.insertMovieLikeDislikeList(insertMovieLikeDislikeList);
		service.disLikeUpdate(disLikeUpdate);
		
		
// 		/* 장르 선호 해시 맵 */
		// 무비 장르 가져옴 
		HashMap<String, Integer> genreNameMap = new HashMap<>();
		genreNameMap.put("no", movieNo);
		MovieDTO genreNameList = service.movieGenreName(genreNameMap);

		
		// 장르 선택 함
		HashMap<String, Object> selectGenre = new HashMap<>();
		selectGenre.put("userNo", userNo);
		selectGenre.put("favoriteGenreName", genreNameList.getGenreName());
		
		// 장르 가져옴
		MovieUserFavoriteGenreDTO generinsert = service.seleteUserFavoriteGenre(selectGenre);

		/* 장르 -카운트  추가 */
		HashMap<String, Object> unGenreCount = new HashMap<String, Object>();
		unGenreCount.put("unuserNo", generinsert.getUserNo().getUserNo());
		unGenreCount.put("ungenreNo", generinsert.getMovieFavoriteGenreCategory().getFavoriteGenreNo());
 		
		// 카운트 제거
		service.unGenreCount(unGenreCount);
		
		model.addAttribute("loginMember", memberService.selectMember(member));

		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm:ss").create();
		
		return gson.toJson(insertMovieLikeDislikeList);
	}
	
	/* 싫어요 해제  */
	@PostMapping(value = "undislikeList", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String dislikeDelete(@ModelAttribute MemberDTO member, Model model , HttpServletRequest request) {	
		
		int userNo = Integer.valueOf(request.getParameter("userNo"));
		int movieNo = Integer.valueOf(request.getParameter("movieNo"));
		
		HashMap<String, Object> deleteMovieLikeDislikeList = new HashMap<String, Object>();
		deleteMovieLikeDislikeList.put("userNo", userNo);
		deleteMovieLikeDislikeList.put("no", movieNo);

		HashMap<String, Object> undisLikeUpdate = new HashMap<String, Object>();
		undisLikeUpdate.put("undisLikeUpdate", movieNo);
		/* 삭제 */
 		service.deleteMovieLikeDislikeList(deleteMovieLikeDislikeList);
 		service.undisLikeUpdate(undisLikeUpdate);
		
 		
		
//		/* 장르 선호 해시 맵 */
		//무비 장르 가져옴  
		HashMap<String, Integer> genreNameMap = new HashMap<>();
		genreNameMap.put("no", movieNo);
		MovieDTO genreNameList = service.movieGenreName(genreNameMap);

		
		// 장르 선택 함
		HashMap<String, Object> selectGenre = new HashMap<>();
		selectGenre.put("userNo", userNo);
		selectGenre.put("favoriteGenreName", genreNameList.getGenreName());
		
		// 장르 가져옴
		MovieUserFavoriteGenreDTO generinsert = service.seleteUserFavoriteGenre(selectGenre);
		
		
		/* 장르 카운트  추가 */
		HashMap<String, Object> GenreCount = new HashMap<String, Object>();
		GenreCount.put("userNo", generinsert.getUserNo().getUserNo());
		GenreCount.put("genreNo", generinsert.getMovieFavoriteGenreCategory().getFavoriteGenreNo());
		
		// 카운트 플러스
		service.genreCount(GenreCount);
 		
		model.addAttribute("loginMember", memberService.selectMember(member));

		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm:ss").create();
		
		return gson.toJson(deleteMovieLikeDislikeList);
	}
	/* 싫어요 등록 및 좋아요 취소  */
	@PostMapping(value = "changedislikeList", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String likechangedislikeUpdate(@ModelAttribute MemberDTO member, Model model , HttpServletRequest request) {	
		
		int userNo = Integer.valueOf(request.getParameter("userNo"));
		int movieNo = Integer.valueOf(request.getParameter("movieNo"));

		/* 삭제가 아닌 업데이트 */
		HashMap<String, Object> updateMovieDislikeList = new HashMap<String, Object>();
		updateMovieDislikeList.put("userNo", userNo);
		updateMovieDislikeList.put("no", movieNo);
		
		HashMap<String, Object> unlikeUpdate = new HashMap<String, Object>();
		unlikeUpdate.put("unlikeUpdate", movieNo);

		HashMap<String, Object> disLikeUpdate = new HashMap<String, Object>();
		disLikeUpdate.put("disLikeUpdate", movieNo);
		/* 업데이트 */
 		service.updateMovieDislikeList(updateMovieDislikeList);
 		service.unlikeUpdate(unlikeUpdate);
 		
 		/* 싫어요 플러스 */
 		service.disLikeUpdate(disLikeUpdate);
		
 		
 		
// 		/* 장르 선호 해시 맵 */
		// 무비 장르 가져옴 
		HashMap<String, Integer> genreNameMap = new HashMap<>();
		genreNameMap.put("no", movieNo);
		MovieDTO genreNameList = service.movieGenreName(genreNameMap);

		
		// 장르 선택 함
		HashMap<String, Object> selectGenre = new HashMap<>();
		selectGenre.put("userNo", userNo);
		selectGenre.put("favoriteGenreName", genreNameList.getGenreName());
		
		// 장르 가져옴
		MovieUserFavoriteGenreDTO generinsert = service.seleteUserFavoriteGenre(selectGenre);
 		

		/* 장르 카운트  추가 */
		HashMap<String, Object> GenreCount = new HashMap<String, Object>();
		GenreCount.put("userNo", generinsert.getUserNo().getUserNo());
		GenreCount.put("genreNo", generinsert.getMovieFavoriteGenreCategory().getFavoriteGenreNo());
		
		/* 장르 -카운트  추가 */
		HashMap<String, Object> unGenreCount = new HashMap<String, Object>();
		unGenreCount.put("unuserNo", generinsert.getUserNo().getUserNo());
		unGenreCount.put("ungenreNo", generinsert.getMovieFavoriteGenreCategory().getFavoriteGenreNo());
 		
		// 싫어요 추가 좋아요 제거(-2개 카운트)
		service.unGenreCount(unGenreCount);
		service.unGenreCount(unGenreCount);
 		
		model.addAttribute("loginMember", memberService.selectMember(member));

		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm:ss").create();
		
		return gson.toJson(updateMovieDislikeList);
	}
	
	

	
	
	/* 찜 인서트 */	
	@PostMapping(value = "wishList", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String wishListUpdate(@ModelAttribute MemberDTO member, Model model , HttpServletRequest request) {	
		
		int userNo = Integer.valueOf(request.getParameter("userNo"));
		int movieNo = Integer.valueOf(request.getParameter("movieNo"));
		
		HashMap<String, Object> wishListUpdate = new HashMap<String, Object>();
		wishListUpdate.put("userNo", userNo);
		wishListUpdate.put("no", movieNo);
		
		/* 인서트 추가 */
		service.insertMovieWishList(wishListUpdate);
		model.addAttribute("loginMember", memberService.selectMember(member));

		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm:ss").create();
		
		return gson.toJson(wishListUpdate);
	}
	
	/* 찜 딜리트 */
	@PostMapping(value = "unWishList", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String wishListDelete(@ModelAttribute MemberDTO member, Model model , HttpServletRequest request) {	
		
		int userNo = Integer.valueOf(request.getParameter("userNo"));
		int movieNo = Integer.valueOf(request.getParameter("movieNo"));
		
		HashMap<String, Object> wishListUpdate = new HashMap<String, Object>();
		wishListUpdate.put("userNo", userNo);
		wishListUpdate.put("no", movieNo);
		
		/* 삭제 */
 		service.deleteMovieWishList(wishListUpdate);
		model.addAttribute("loginMember", memberService.selectMember(member));

		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm:ss").create();
		
		return gson.toJson(wishListUpdate);
	}
	
	
	/* 영화 리뷰 */
	@RequestMapping(value = "/reply", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String reivewInsert(Model model , HttpServletRequest request,@RequestParam("userNo") int userNo, @RequestParam("movieNo") int movieNo,
			@RequestParam("replyText") String replyText) {	

		
		
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
		
		HashMap<String, Object> reviewDelete = new HashMap<String, Object>();
		reviewDelete.put("replyNum", replyNum);
		
		int delete = service.reviewDelete(reviewDelete);
		
		List<MovieReviewDTO> list = service.movieReviewList(movieNo);
		model.addAttribute("reviews" , list);
		
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm:ss").create();
		
		return gson.toJson(list);
		
	}

	
	/* 액션 장르검색 1 */
	@PostMapping(value = "/movieGenre1", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String GenreSearch1(Model model , HttpServletRequest request, @RequestParam("genreAction") String genreAction) {	
		
		HashMap<String, Object> genres1 = new HashMap<String, Object>();
		genres1.put("genreAction", genreAction);
		
		List<MovieDTO> genresResult1 = service.movieGenreSearch1(genres1);
		model.addAttribute("genresResult1" , genresResult1);

		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm:ss").create();
		
		return gson.toJson(genresResult1);
		
	}
	
	/* 판타지 장르검색 2 */
	@PostMapping(value = "/movieGenre2", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String GenreSearch2(Model model , HttpServletRequest request, @RequestParam("genreFantasy") String genreFantasy) {	
		
		HashMap<String, Object> genres2 = new HashMap<String, Object>();
		genres2.put("genreFantasy", genreFantasy);
		
		List<MovieDTO> genresResult2 = service.movieGenreSearch2(genres2);
		model.addAttribute("genresResult2" , genresResult2);
		
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm:ss").create();
		
		return gson.toJson(genresResult2);
		
	}
	/* 로맨스 장르검색 3 */
	@PostMapping(value = "/movieGenre3", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String GenreSearch3(Model model , HttpServletRequest request, @RequestParam("genreRomance") String genreRomance) {	
		
		HashMap<String, Object> genres3 = new HashMap<String, Object>();
		genres3.put("genreRomance", genreRomance);
		
		List<MovieDTO> genresResult3 = service.movieGenreSearch3(genres3);
		model.addAttribute("genresResult3" , genresResult3);
		
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm:ss").create();
		
		return gson.toJson(genresResult3);
		
	}
	/* 코미디 장르검색 4 */
	@PostMapping(value = "/movieGenre4", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String GenreSearch4(Model model , HttpServletRequest request, @RequestParam("genreComedy") String genreComedy) {	
		
		HashMap<String, Object> genres4 = new HashMap<String, Object>();
		genres4.put("genreComedy", genreComedy);
		
		List<MovieDTO> genresResult4 = service.movieGenreSearch4(genres4);
		model.addAttribute("genresResult4" , genresResult4);
		
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm:ss").create();
		
		return gson.toJson(genresResult4);
		
	}
	/* 공포 장르검색 5 */
	@PostMapping(value = "/movieGenre5", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String GenreSearch5(Model model , HttpServletRequest request, @RequestParam("genreHorror") String genreHorror) {	
		
		HashMap<String, Object> genres5 = new HashMap<String, Object>();
		genres5.put("genreHorror", genreHorror);
		
		List<MovieDTO> genresResult5 = service.movieGenreSearch5(genres5);
		model.addAttribute("genresResult5" , genresResult5);
		
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm:ss").create();
		
		return gson.toJson(genresResult5);
	}

	/* 제목 검색 */
	@PostMapping(value = "/movieSearch", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String movieNameSearch(Model model , HttpServletRequest request, @RequestParam("searchText") String searchText) {	
		
		HashMap<String, Object> SearchName = new HashMap<String, Object>();
		SearchName.put("searchText", searchText);
		
		List<MovieDTO> SearchNameResult = service.movieNameSearch(SearchName);
		model.addAttribute("SearchNameResult" , SearchNameResult);
		
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm:ss").create();
		
		return gson.toJson(SearchNameResult);
	}

	
	
}
