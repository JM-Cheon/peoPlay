package com.cctv.peoplay.movie.model.dao;

import java.util.HashMap;
import java.util.List;

import com.cctv.peoplay.member.model.dto.MemberDTO;
import com.cctv.peoplay.movie.model.dto.ActorDTO;
import com.cctv.peoplay.movie.model.dto.MovieDTO;
import com.cctv.peoplay.movie.model.dto.MovieFileDTO;
import com.cctv.peoplay.movie.model.dto.MovieLikeDislikeDTO;
import com.cctv.peoplay.movie.model.dto.MovieReviewDTO;
import com.cctv.peoplay.movie.model.dto.MovieUserFavoriteGenreDTO;
import com.cctv.peoplay.movie.model.dto.MovieWatchListDTO;
import com.cctv.peoplay.movie.model.dto.MovieWishListDTO;

public interface MovieMapper {
	
	/* 영화 리스트 */
	List<MovieDTO> selectMovieList();

	/* 영화 선택 */
	MovieDTO selectmovie(int no);

	/* 배우 리스트 */
	ActorDTO actorList(int no);
	List<ActorDTO> adminActorList(int no);

	/* 영화 파일 선택 */
	MovieFileDTO selectMovieMainFile(int no);
	MovieFileDTO selectMovieSubFile(int no);

	/* 영화 댓글 */
	List<MovieReviewDTO> movieReviewList();

	/* 리뷰  인서트 */
	int reviewInsert(HashMap<String, Object> reviews);

	/* 리뷰 셀렉 */
	List<MovieReviewDTO> movieReviewList(int no);

	/* 리뷰 딜리트 */
	int reviewDelete(HashMap<String, Object> reviewDelete);
	
	/* 메인(test) */
	MovieDTO mainBastMovie();

	List<MovieDTO> mainNewTopMovie();

	List<MovieDTO> mainTopFavoriteMovie();
	
	
	
	/* 장르 list 영화 검색 */
	
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


	/* 찜하기 위시리스트 */
	List<MovieWishListDTO> selectWish();

	int insertMovieWishList(HashMap<String, Object> insertWishList);

	int deleteMovieWishList(HashMap<String, Object> deleteWishList);

	MovieWishListDTO selectMovieWishList(HashMap<String, Integer> wishMap);

	/* 시청 내역 */
	List<MovieWatchListDTO> selectWatch();

	int insertMovieWatchList(HashMap<String, Object> selectMovieWatchList);

	int deleteMovieWatchList(HashMap<String, Object> deleteWatchList);

	MovieWatchListDTO selectMovieWatchList(HashMap<String, Integer> watchMap);

	/* 좋아요 싫어요 */
	
	List<MovieLikeDislikeDTO> selectMovieLikeDislike();

	MovieLikeDislikeDTO selectMovieLikeDislikeList(HashMap<String, Integer> likeDislikeMap);
	
	MovieLikeDislikeDTO selectLikeRead(HashMap<String, Integer> selectLikeRead);
	
	MovieLikeDislikeDTO selectDislikeRead(HashMap<String, Integer> selectDislikeRead);
	
	int insertMovieLikeDislikeList(HashMap<String, Object> selectMovieLikeDislikeList);
	
	int deleteMovieLikeDislikeList(HashMap<String, Object> deleteLikeDislikeList);

	int updateMovieLikeList(HashMap<String, Object> updateLikeDislikeList);

	int updateMovieDislikeList(HashMap<String, Object> updateDislikeList);
	
	/* 좋아요 싫어요 카운트 */
	
	int likeUpdate(HashMap<String, Object> likeUpdate);

	int disLikeUpdate(HashMap<String, Object> disLikeUpdate);
	
	int unlikeUpdate(HashMap<String, Object> unlikeUpdate);
	
	int undisLikeUpdate(HashMap<String, Object> undisLikeUpdate);

	/* 장르 선호 관련 */
	MovieDTO movieGenreName(HashMap<String, Integer> movieGenreName);
	
	MovieUserFavoriteGenreDTO seleteUserFavoriteGenre(HashMap<String, Object> selectGenre);

	int genreCount(HashMap<String, Object> genreCount);

	int unGenreCount(HashMap<String, Object> unGenreCount);
	
	
	
	/* 좋아요 싫어요 리스트 */
	MovieDTO likeAmount(int movieNo);

	MovieDTO dislikeAmount(int movieNo);

	/* 회원 관련 정보 전달 */
	MovieLikeDislikeDTO selectMemberlikeDislike(HashMap<String, Integer> member);

	MovieWatchListDTO selectMemberWatch(HashMap<String, Integer> member);

	MovieWishListDTO selectMemberWish(HashMap<String, Integer> member);

	MovieUserFavoriteGenreDTO selectMemberGenre(HashMap<String, Integer> member);

	
	
}















