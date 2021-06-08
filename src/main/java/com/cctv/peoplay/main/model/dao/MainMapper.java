package com.cctv.peoplay.main.model.dao;

import java.util.List;

import com.cctv.peoplay.movie.model.dto.MovieDTO;

public interface MainMapper {

	MovieDTO selectBannerMovie();

	List<MovieDTO> selectBestMovieList();

	List<MovieDTO> selectNewMovieList();

	List<MovieDTO> selectMemberWishMovieList(int no);

	List<MovieDTO> selectMemberFavoriteMovieList(int no);

}
