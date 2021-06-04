package com.cctv.peoplay.admin.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/*")
public class AdminMainController {
		
	@GetMapping(value={"/", "/main"})
	public String main() {
			
		return "admin/main/adminMain";
	}
}
