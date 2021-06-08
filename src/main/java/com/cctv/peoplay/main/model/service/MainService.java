package com.cctv.peoplay.main.model.service;

import java.util.List;

import com.cctv.peoplay.movie.model.dto.MovieDTO;

public interface MainService {

	MovieDTO selectBannerMovie();

	List<MovieDTO> selectBestMovieList();

	List<MovieDTO> selectNewMovieList();

	List<MovieDTO> selectMemberWishMovieList(int no);

	List<MovieDTO> selectMemberFavoriteMovieList(int no);
	
}
