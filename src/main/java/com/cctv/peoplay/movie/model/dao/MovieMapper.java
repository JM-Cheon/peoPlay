package com.cctv.peoplay.movie.model.dao;

import java.util.HashMap;
import java.util.List;

import com.cctv.peoplay.member.model.dto.MemberDTO;
import com.cctv.peoplay.movie.model.dto.ActorDTO;
import com.cctv.peoplay.movie.model.dto.MovieDTO;
import com.cctv.peoplay.movie.model.dto.MovieFileDTO;
import com.cctv.peoplay.movie.model.dto.MovieReviewDTO;
import com.cctv.peoplay.movie.model.dto.MovieWishListDTO;

public interface MovieMapper {
	
	/* 영화 리스트 */
	List<MovieDTO> selectMovieList();

	/* 영화 선택 */
	MovieDTO selectmovie(int no);

	/* 배우 리스트 */
	List<ActorDTO> actorList(int no);

	/* 영화 파일 선택 */
	MovieFileDTO selectMovieMainFile(int no);
	MovieFileDTO selectMovieSubFile(int no);

	/* like or dislike 카운트 */
	
	MovieDTO likeUpdate(HashMap<String, Object> likeUpdate);

	MovieDTO disLikeUpdate(HashMap<String, Object> disLikeUpdate);

	/* 영화 댓글 */
	List<MovieReviewDTO> movieReviewList();

	/* 리뷰  인서트 */
	int reviewInsert(HashMap<String, Object> reviews);

	/* 리뷰 셀렉 */
	List<MovieReviewDTO> movieReviewList(int no);

	/* 리뷰 딜리트 */
	int reviewDelete(HashMap<String, Object> reviewDelete);
	
	/* 메인 */
	MovieDTO mainBastMovie();

	List<MovieDTO> mainNewTopMovie();

	List<MovieDTO> mainTopFavoriteMovie();
	
	
	
	/* list 영화 검색 */
	
	List<MovieDTO> movieNameSearch(HashMap<String, Object> SearchName);
	
	List<MovieDTO> movieGenreSearch1(HashMap<String, Object> genres1);

	List<MovieDTO> movieGenreSearch2(HashMap<String, Object> genres2);
	
	List<MovieDTO> movieGenreSearch3(HashMap<String, Object> genres3);
	
	List<MovieDTO> movieGenreSearch4(HashMap<String, Object> genres4);
	
	List<MovieDTO> movieGenreSearch5(HashMap<String, Object> genres5);

	
	/* 영화 인서트 */
	int insertMovie(MovieDTO movieInsert);

	int insertMovieFileMain(MovieFileDTO movieFileInsertMain);

	int insertMovieFileSub(MovieFileDTO movieFileInsertSub);
	
	int insertActors(ActorDTO insertActors);

	/* 영화 딜리트 */
	int movieDelete(int movieNo);
	
	int actorDelete(int movieNo);

	int movieFileDelete(int movieNo);

	/* 영화 수정 */
	int updateMovie(MovieDTO updateMovie);

	int updateActors(ActorDTO updateActors);

	/* 파일 수정은 movieFileDelete 활용하여 기존 값 삭제 후 등록 */
	int updateMovieFileSub(MovieFileDTO updateMovieFileSub);

	int updateMovieFileMain(MovieFileDTO updateMovieFileSub);

	int movieMainFileOnePickDelete(int no);
	int movieSubFileOnePickDelete(int no);

	/* 좋아요 싫어요 리스트 */
	MovieDTO likeAmount(int movieNo);

	MovieDTO dislikeAmount(int movieNo);

	/* 찜하기 위시리스트 */
	List<MovieWishListDTO> selectWish();

	int insertMovieWishList(HashMap<String, Object> insertWishList);

	int deleteMovieWishList(HashMap<String, Object> deleteWishList);

	MovieWishListDTO selectMovieWishList(HashMap<String, Integer> wishMap);


}















