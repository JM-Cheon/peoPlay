package com.cctv.peoplay.admin.main.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cctv.peoplay.admin.main.model.dao.AdminMainMapper;

@Service("adminMainService")
public class AdminMainServiceImpl implements AdminMainService{	

	private final AdminMainMapper mapper;
	
	@Autowired
	public AdminMainServiceImpl(AdminMainMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public int selectPaymentByDay() {
		return mapper.selectPaymentByDay();
	}

	@Override
	public int selectPaymentByMonth() {
		return mapper.selectPaymentByMonth();
	}

	@Override
	public int selectPaymentByYear() {
		return mapper.selectPaymentByYear();
	}
}
