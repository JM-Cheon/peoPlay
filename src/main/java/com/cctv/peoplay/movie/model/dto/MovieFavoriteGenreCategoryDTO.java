package com.cctv.peoplay.movie.model.dto;

public class MovieFavoriteGenreCategoryDTO {
	
	
	/* 어떻게 처리할 지 고민해보자 */
	private int favoriteGenreNo;
	private String favoriteGenreName;
	
	
	public MovieFavoriteGenreCategoryDTO() {
	}
	public MovieFavoriteGenreCategoryDTO(int favoriteGenreNo, String favoriteGenreName) {
		this.favoriteGenreNo = favoriteGenreNo;
		this.favoriteGenreName = favoriteGenreName;
	}
	public int getFavoriteGenreNo() {
		return favoriteGenreNo;
	}
	public void setFavoriteGenreNo(int favoriteGenreNo) {
		this.favoriteGenreNo = favoriteGenreNo;
	}
	public String getFavoriteGenreName() {
		return favoriteGenreName;
	}
	public void setFavoriteGenreName(String favoriteGenreName) {
		this.favoriteGenreName = favoriteGenreName;
	}
	@Override
	public String toString() {
		return "MovieFavoriteGenreCategoryDTO [favoriteGenreNo=" + favoriteGenreNo + ", favoriteGenreName="
				+ favoriteGenreName + "]";
	}
	
	
}
