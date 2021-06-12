package com.cctv.peoplay.movie.model.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cctv.peoplay.member.model.dto.MemberDTO;
import com.cctv.peoplay.movie.model.dao.MovieMapper;
import com.cctv.peoplay.movie.model.dto.ActorDTO;
import com.cctv.peoplay.movie.model.dto.MovieDTO;
import com.cctv.peoplay.movie.model.dto.MovieFileDTO;
import com.cctv.peoplay.movie.model.dto.MovieReviewDTO;
import com.cctv.peoplay.movie.model.dto.MovieWishListDTO;

@Service("movieService")
public class MovieServiceImpl implements MovieService {

	private final MovieMapper mapper;

	@Autowired
	public MovieServiceImpl (MovieMapper mapper) {
		this.mapper = mapper;
	}

	/* 영화 전체 */
	@Override
	public List<MovieDTO> selectMovieList(){
		return mapper.selectMovieList();
	}

	/* 영화 선택 */
	@Override
	public MovieDTO selectmovie(int no) {
		return mapper.selectmovie(no);
	}
	
	/* 배우 선택 */
	@Override
	public List<ActorDTO> actorList(int no) {
		return mapper.actorList(no);
	}

	/* 영화 파일 선택 */
	@Override
	public MovieFileDTO selectMovieMainFile(int no) {
		return mapper.selectMovieMainFile(no);
	}
	@Override
	public MovieFileDTO selectMovieSubFile(int no) {
		return mapper.selectMovieSubFile(no);
	}
	
	/* 메인 베스트 영화 */
	public MovieDTO mainBastMovie() {
		return mapper.mainBastMovie();
	}
	
	/* 메인 영화 인기 순위*/
	public List<MovieDTO> mainTopFavoriteMovie(){
		return mapper.mainTopFavoriteMovie();
	}
	
	/* 메인 영화 최신 순위*/
	public List<MovieDTO> mainNewTopMovie(){
		return mapper.mainNewTopMovie();
	}
	
	@Override
	public MovieDTO likeUpdate(HashMap<String, Object> likeUpdate) {
		return mapper.likeUpdate(likeUpdate);
	}

	@Override
	public MovieDTO disLikeUpdate(HashMap<String, Object> disLikeUpdate) {
		return mapper.disLikeUpdate(disLikeUpdate);
	}

	@Override
	public List<MovieReviewDTO> movieReviewList() {

		return mapper.movieReviewList();
	}

	/* 리뷰 셀렉 리스트 */
	@Override
	public List<MovieReviewDTO> movieReviewList(int no) {
		return mapper.movieReviewList(no);
	}

	/* 리뷰 인서트 */
	@Override
	public int reviewInsert(HashMap<String, Object> reviews) {
		return mapper.reviewInsert(reviews);
	}

	/* 리뷰 딜리트 */
	@Override
	public int reviewDelete(HashMap<String, Object> reviewDelete) {
		return mapper.reviewDelete(reviewDelete);
	}
	/* 영화 검색 */
	@Override
	public List<MovieDTO> movieNameSearch(HashMap<String, Object> SearchName) {
		return mapper.movieNameSearch(SearchName);
	}

	@Override
	public List<MovieDTO> movieGenreSearch1(HashMap<String, Object> genres1) {
		return mapper.movieGenreSearch1(genres1);
	}
	@Override
	public List<MovieDTO> movieGenreSearch2(HashMap<String, Object> genres2) {
		return mapper.movieGenreSearch2(genres2);
	}
	@Override
	public List<MovieDTO> movieGenreSearch3(HashMap<String, Object> genres3) {
		return mapper.movieGenreSearch3(genres3);
	}
	@Override
	public List<MovieDTO> movieGenreSearch4(HashMap<String, Object> genres4) {
		return mapper.movieGenreSearch4(genres4);
	}
	@Override
	public List<MovieDTO> movieGenreSearch5(HashMap<String, Object> genres5) {
		return mapper.movieGenreSearch5(genres5);
	}

	/* 관리자 영화 인서트 */
	@Override
	public Boolean insertMovie(MovieDTO movieInsert) {
		return mapper.insertMovie(movieInsert) > 0? true: false;
	}

	@Override
	public Boolean insertMovieFileMain(MovieFileDTO movieFileInsertMain) {
		return mapper.insertMovieFileMain(movieFileInsertMain) > 0? true: false;
	}

	@Override
	public Boolean insertMovieFileSub(MovieFileDTO movieFileInsertSub) {
		return mapper.insertMovieFileSub(movieFileInsertSub) > 0? true: false;
	}

	@Override
	public Boolean insertActors(ActorDTO insertActors) {
		return mapper.insertActors(insertActors) > 0? true: false;
	}
	/* 영화 삭제 */
	@Override
	public int movieDelete(int movieNo) {
		return mapper.movieDelete(movieNo);
	}

	@Override
	public int actorDelete(int movieNo) {
		return mapper.actorDelete(movieNo);
	}

	@Override
	public int movieFileDelete(int movieNo) {
		return mapper.movieFileDelete(movieNo);
	}
	
	
	/* 영화 수정 */
	/* 영화파일 수정은 딜리트 후 INSERT */
	@Override
	public Boolean updateMovie(MovieDTO updateMovie) {
		return  mapper.updateMovie(updateMovie) > 0? true: false;
	}

	@Override
	public Boolean updateActors(ActorDTO updateActors) {
		return mapper.updateActors(updateActors) > 0? true: false;
	}

	/* 파일 수정은 movieFileDelete 활용하여 기존 값 삭제 후 등록 */
	@Override
	public Boolean updateMovieFileSub(MovieFileDTO updateMovieFileSub) {
		return mapper.updateMovieFileSub(updateMovieFileSub) > 0? true: false;
	}

	@Override
	public Boolean updateMovieFileMain(MovieFileDTO updateMovieFileMain) {
		return mapper.updateMovieFileMain(updateMovieFileMain) > 0? true: false;
	}

	
	/* 영화 파일등록을 하나만 할 경우 하나만 삭제 */
	@Override
	public int movieMainFileOnePickDelete(int no) {
		return mapper.movieMainFileOnePickDelete(no);
	}

	@Override
	public int movieSubFileOnePickDelete(int no) {
		return mapper.movieSubFileOnePickDelete(no);
	}

	/* 좋아요 싫어요 리스트*/
	@Override
	public MovieDTO likeAmount(int movieNo) {
		return mapper.likeAmount(movieNo);
	}

	@Override
	public MovieDTO dislikeAmount(int movieNo) {
		return mapper.dislikeAmount(movieNo);
	}

	/* 찜하기 */

	
	@Override
	public int insertMovieWishList(HashMap<String, Object> insertWishList) {
		return mapper.insertMovieWishList(insertWishList);
	}

	@Override
	public int deleteMovieWishList(HashMap<String, Object> deleteWishList) {
		return mapper.deleteMovieWishList(deleteWishList);
	}

	@Override
	public List<MovieWishListDTO> selectWish() {
		return  mapper.selectWish();
	}
	@Override
	public MovieWishListDTO selectMovieWishList(HashMap<String, Integer> wishMap) {
		return mapper.selectMovieWishList(wishMap);
	}
	


}	//  -- end
