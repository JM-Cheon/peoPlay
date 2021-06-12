package com.cctv.peoplay.main.model.service;

import java.util.List;

import com.cctv.peoplay.movie.model.dto.MovieAllImgDTO;

public interface MainService {

	MovieAllImgDTO selectBannerMovie();

	List<MovieAllImgDTO> selectBestMovieList();

	List<MovieAllImgDTO> selectNewMovieList();

	List<MovieAllImgDTO> selectMemberWishMovieList(int no);

	List<MovieAllImgDTO> selectMemberFavoriteMovieList(int no);
	
}
