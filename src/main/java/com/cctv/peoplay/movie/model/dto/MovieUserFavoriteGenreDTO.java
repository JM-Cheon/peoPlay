package com.cctv.peoplay.movie.model.dto;

import com.cctv.peoplay.member.model.dto.MemberDTO;

public class MovieUserFavoriteGenreDTO {
	
	
	/* 더필요한게 없는지 고민해보자 */
	
	private MemberDTO userNo;
	private int favoriteGenreNo;
	private int genreShameNumber;
	
	private MovieFavoriteGenreCategoryDTO movieFavoriteGenreCategory;
	
	
	
	public MovieUserFavoriteGenreDTO() {
	}



	public MovieUserFavoriteGenreDTO(MemberDTO userNo, int favoriteGenreNo, int genreShameNumber,
			MovieFavoriteGenreCategoryDTO movieFavoriteGenreCategory) {
		super();
		this.userNo = userNo;
		this.favoriteGenreNo = favoriteGenreNo;
		this.genreShameNumber = genreShameNumber;
		this.movieFavoriteGenreCategory = movieFavoriteGenreCategory;
	}



	public MemberDTO getUserNo() {
		return userNo;
	}



	public void setUserNo(MemberDTO userNo) {
		this.userNo = userNo;
	}



	public int getFavoriteGenreNo() {
		return favoriteGenreNo;
	}



	public void setFavoriteGenreNo(int favoriteGenreNo) {
		this.favoriteGenreNo = favoriteGenreNo;
	}



	public int getGenreShameNumber() {
		return genreShameNumber;
	}



	public void setGenreShameNumber(int genreShameNumber) {
		this.genreShameNumber = genreShameNumber;
	}



	public MovieFavoriteGenreCategoryDTO getMovieFavoriteGenreCategory() {
		return movieFavoriteGenreCategory;
	}



	public void setMovieFavoriteGenreCategory(MovieFavoriteGenreCategoryDTO movieFavoriteGenreCategory) {
		this.movieFavoriteGenreCategory = movieFavoriteGenreCategory;
	}



	@Override
	public String toString() {
		return "MovieUserFavoriteGenreDTO [userNo=" + userNo + ", favoriteGenreNo=" + favoriteGenreNo
				+ ", genreShameNumber=" + genreShameNumber + ", movieFavoriteGenreCategory="
				+ movieFavoriteGenreCategory + "]";
	}

	
	
	
	
}
