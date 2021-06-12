package com.cctv.peoplay.main.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cctv.peoplay.main.model.dao.MainMapper;
import com.cctv.peoplay.movie.model.dto.MovieAllImgDTO;

@Service("mainService")
public class MainServiceImpl implements MainService{
	
	private final MainMapper mapper;
	
	@Autowired
	public MainServiceImpl(MainMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public MovieAllImgDTO selectBannerMovie() {
		return mapper.selectBannerMovie();
	}

	@Override
	public List<MovieAllImgDTO> selectBestMovieList() {
		return mapper.selectBestMovieList();
	}

	@Override
	public List<MovieAllImgDTO> selectNewMovieList() {
		return mapper.selectNewMovieList();
	}

	@Override
	public List<MovieAllImgDTO> selectMemberWishMovieList(int no) {
		return mapper.selectMemberWishMovieList(no);
	}

	@Override
	public List<MovieAllImgDTO> selectMemberFavoriteMovieList(int no) {
		return mapper.selectMemberFavoriteMovieList(no);
	}

	
	
}
