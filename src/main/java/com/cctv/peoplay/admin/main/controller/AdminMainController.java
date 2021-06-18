package com.cctv.peoplay.admin.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cctv.peoplay.admin.main.model.service.AdminMainService;

@Controller
@RequestMapping("/admin/*")
public class AdminMainController {
	
	private final AdminMainService mainService;
	
	@Autowired
	public AdminMainController(AdminMainService mainService) {
		this.mainService = mainService;
	}
		
	@GetMapping(value={"/", "/main"})
	public String main(Model model) {
		
		model.addAttribute("day", mainService.selectPaymentByDay());
		model.addAttribute("month", mainService.selectPaymentByMonth());
		model.addAttribute("year", mainService.selectPaymentByYear());
		return "admin/main/adminMain";
	}
}
