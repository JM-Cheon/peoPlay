package com.cctv.peoplay.main.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cctv.peoplay.main.model.dao.MainMapper;
import com.cctv.peoplay.member.model.dto.MemberDTO;
import com.cctv.peoplay.member.model.dto.SubscribePaymentDTO;
import com.cctv.peoplay.member.model.dto.SubscriptionDTO;
import com.cctv.peoplay.movie.model.dto.MovieDTO;

@Service("mainService")
public class MainServiceImpl implements MainService{
	
	private final MainMapper mapper;
	
	@Autowired
	public MainServiceImpl(MainMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public MovieDTO selectBannerMovie() {
		return mapper.selectBannerMovie();
	}

	@Override
	public List<MovieDTO> selectBestMovieList() {
		return mapper.selectBestMovieList();
	}

	@Override
	public List<MovieDTO> selectNewMovieList() {
		return mapper.selectNewMovieList();
	}

	@Override
	public List<MovieDTO> selectMemberWishMovieList(int no) {
		return mapper.selectMemberWishMovieList(no);
	}

	@Override
	public List<MovieDTO> selectMemberFavoriteMovieList(int no) {
		return mapper.selectMemberFavoriteMovieList(no);
	}

	
	
}
