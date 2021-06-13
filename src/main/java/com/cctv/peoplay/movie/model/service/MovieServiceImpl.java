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
import com.cctv.peoplay.movie.model.dto.MovieLikeDislikeDTO;
import com.cctv.peoplay.movie.model.dto.MovieReviewDTO;
import com.cctv.peoplay.movie.model.dto.MovieUserFavoriteGenreDTO;
import com.cctv.peoplay.movie.model.dto.MovieWatchListDTO;
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
	public ActorDTO actorList(int no) {
		return mapper.actorList(no);
	}
	@Override
	public List<ActorDTO> adminActorList(int no) {
		return mapper.adminActorList(no);
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

	/* 시청 내역 */
	@Override
	public int insertMovieWatchList(HashMap<String, Object> selectMovieWatchList) {
		return mapper.insertMovieWatchList(selectMovieWatchList);
	}
	
	@Override
	public List<MovieWatchListDTO> selectWatch() {
		return mapper.selectWatch();
	}
	@Override
	public MovieWatchListDTO selectMovieWatchList(HashMap<String, Integer> watchMap) {
		return mapper.selectMovieWatchList(watchMap);
	}

	/* 좋아요 싫어요 */
	@Override
	public List<MovieLikeDislikeDTO> selectMovieLikeDislike() {
		return mapper.selectMovieLikeDislike();
	}
	@Override
	public MovieLikeDislikeDTO selectMovieLikeDislikeList(HashMap<String, Integer> likeDislikeMap) {
		return mapper.selectMovieLikeDislikeList(likeDislikeMap);
	}
	
	@Override
	public MovieLikeDislikeDTO selectLikeRead(HashMap<String, Integer> selectLikeRead) {
		return mapper.selectLikeRead(selectLikeRead);
	}

	@Override
	public MovieLikeDislikeDTO selectDislikeRead(HashMap<String, Integer> selectDislikeRead) {
		return mapper.selectDislikeRead(selectDislikeRead);
	}
	
	@Override
	public int insertMovieLikeDislikeList(HashMap<String, Object> selectMovieLikeDislikeList) {
		return mapper.insertMovieLikeDislikeList(selectMovieLikeDislikeList);
	}
	@Override
	public int deleteMovieLikeDislikeList(HashMap<String, Object> deleteLikeDislikeList) {
		return mapper.deleteMovieLikeDislikeList(deleteLikeDislikeList);
	}
	@Override
	public int updateMovieLikeList(HashMap<String, Object> updateLikeDislikeList) {
		return mapper.updateMovieLikeList(updateLikeDislikeList);
	}

	@Override
	public int updateMovieDislikeList(HashMap<String, Object> updateDislikeList) {
		return mapper.updateMovieDislikeList(updateDislikeList);
	}

	/* 좋아요 싫어요 카운트 */

	@Override
	public int likeUpdate(HashMap<String, Object> likeUpdate) {
		return mapper.likeUpdate(likeUpdate);
	}

	@Override
	public int disLikeUpdate(HashMap<String, Object> disLikeUpdate) {
		return mapper.disLikeUpdate(disLikeUpdate);
	}

	@Override
	public int unlikeUpdate(HashMap<String, Object> unlikeUpdate) {
		return mapper.unlikeUpdate(unlikeUpdate);
	}

	@Override
	public int undisLikeUpdate(HashMap<String, Object> undisLikeUpdate) {
		return mapper.undisLikeUpdate(undisLikeUpdate);
	}

	/* 장르 선호 관련 */
	
	
	@Override
	public MovieDTO movieGenreName(HashMap<String, Integer> movieGenreName) {
		return mapper.movieGenreName(movieGenreName);
	}	

	@Override
	public MovieUserFavoriteGenreDTO seleteUserFavoriteGenre(HashMap<String, Object> selectGenre) {
		return mapper.seleteUserFavoriteGenre(selectGenre);
	}

	@Override
	public int genreCount(HashMap<String, Object> genreCount) {
		return mapper.genreCount(genreCount);
	}

	@Override
	public int unGenreCount(HashMap<String, Object> unGenreCount) {
		return mapper.unGenreCount(unGenreCount);
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

	/* 회원 관련 정보 전달 */
	@Override
	public MovieLikeDislikeDTO selectMemberlikeDislike(HashMap<String, Integer> member) {
		return mapper.selectMemberlikeDislike(member);
	}
	@Override
	public MovieWatchListDTO selectMemberWatch(HashMap<String, Integer> member) {
		return mapper.selectMemberWatch(member);
	}
	@Override
	public MovieWishListDTO selectMemberWish(HashMap<String, Integer> member) {
		return mapper.selectMemberWish(member);
	}
	@Override
	public MovieUserFavoriteGenreDTO selectMemberGenre(HashMap<String, Integer> member) {
		return mapper.selectMemberGenre(member);
	}




	


	



}	//  -- end
