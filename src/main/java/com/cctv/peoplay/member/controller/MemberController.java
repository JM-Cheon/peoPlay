package com.cctv.peoplay.member.controller;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cctv.peoplay.common.date.DateCalculator;
import com.cctv.peoplay.common.mail.SendMail;
import com.cctv.peoplay.member.model.dto.MemberDTO;
import com.cctv.peoplay.member.model.dto.SubscribePaymentDTO;
import com.cctv.peoplay.member.model.dto.SubscriptionDTO;
import com.cctv.peoplay.member.model.service.MemberService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
@RequestMapping("/member/*")
@SessionAttributes("loginMember")
public class MemberController {
	
	private final MemberService memberService;
	private final BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	public MemberController(MemberService memberService, BCryptPasswordEncoder passwordEncoder) {
		this.memberService = memberService;
		this.passwordEncoder = passwordEncoder;
	}
	
	/* 로그인 페이지로 포워딩 */
	@GetMapping("login")
	public void login() {}
	
	/* 약관문의 페이지로 포워딩 */
	@GetMapping("agreeToS")
	public void agreeToS() {}
	
	/* 선호도 조사 페이지로 포워딩 */
	@GetMapping("checkFavorite")
	public void checkFavorite(Model model) {
		model.addAttribute("actionList", memberService.selectActionMovie());
		model.addAttribute("fantasyList", memberService.selectFactasyMovie());
		model.addAttribute("romanceList", memberService.selectRomanceMovie());
		model.addAttribute("comedyList", memberService.selectComedyMovie());
		model.addAttribute("horrorList", memberService.selectHorroMovie());
	}
	
	/* 회원가입 페이지로 포워딩 */
	@PostMapping("registForm")
	public void registForm(@ModelAttribute MemberDTO member, Model model) {
		model.addAttribute("member", member);
	}
	
	/* 아이디 중북확인 */
	@PostMapping(value="idCheck", produces="application/json; charset=UTF-8")
	@ResponseBody
	public String idCheck(HttpServletRequest request) {
		
		Gson gson = new GsonBuilder().create();
		
		String requestId = request.getParameter("userId");
		String responseId = memberService.selectIdCheck(requestId);
		
		return gson.toJson(responseId);
	}

	/* 닉네임 중복확인 */
	@PostMapping(value="nicknameCheck", produces="application/json; charset=UTF-8")
	@ResponseBody
	public String nicknameCheck(HttpServletRequest request) {
		
		Gson gson = new GsonBuilder().create();
		
		String requestNickname = request.getParameter("nickname");
		String responseNickname = memberService.selectNicknameCheck(requestNickname);
		
		return gson.toJson(responseNickname);
	}
	
	/* 회원가입 */
	@PostMapping("regist")
	public String registMember(HttpServletRequest request, RedirectAttributes rttr) {
		
		MemberDTO member = new MemberDTO();
		
		member.setUserId(request.getParameter("userId"));
		member.setUserPwd(passwordEncoder.encode(request.getParameter("userPwd")));
		member.setUserName(request.getParameter("userName"));
		member.setNickname(request.getParameter("nickname"));
		member.setEmail(request.getParameter("email1") + "@" + request.getParameter("email2"));
		member.setBirthday(Date.valueOf(request.getParameter("birthday")));
		member.setPhone(request.getParameter("phone"));
		member.setUserAddress(request.getParameter("zipCode") + "$" + request.getParameter("address") + "$" + request.getParameter("detailAddress"));
		member.setAction(Integer.valueOf(request.getParameter("action")));
		member.setFantasy(Integer.valueOf(request.getParameter("fantasy")));
		member.setRomance(Integer.valueOf(request.getParameter("romance")));
		member.setComedy(Integer.valueOf(request.getParameter("comedy")));
		member.setHorror(Integer.valueOf(request.getParameter("horror")));
		
		if(memberService.registMember(member)) {
			rttr.addFlashAttribute("message", "회원 가입에 성공하셨습니다.");
		} else {
			rttr.addFlashAttribute("message", "회원 가입에 실패하셨습니다.");
		}
				
		return "redirect:/";
	}
	
	/* 로그인 */
	@PostMapping("login")
	public String loginMember(@ModelAttribute MemberDTO member, Model model, RedirectAttributes rttr) {

		String path = "";
		if(memberService.loginMember(member)) {
			model.addAttribute("loginMember", memberService.selectMember(member));
			rttr.addFlashAttribute("message", "로그인에 성공하셨습니다.");
			path = "redirect:/";
		} else {
			rttr.addFlashAttribute("message", "로그인에 실패하셨습니다.");
			path = "redirect:/member/login";
		}
		return path;
	}
	
	/* 로그아웃 */
	@GetMapping("logout")
	public String logout(SessionStatus status) {
		
		status.setComplete();
		
		return "redirect:/";
	}
	
	/* 아이디 찾기 페이지로 포워딩 */
	@GetMapping("searchId")
	public void searchId() {}
	
	/* 아이디 찾기 */
	@PostMapping("searchId")
	public String searchIdResult(@ModelAttribute MemberDTO member, HttpServletRequest request, Model model, RedirectAttributes rttr) {
		
		String email = request.getParameter("email1") + "@" + request.getParameter("email2");
		
		member.setEmail(email);
		
		member = memberService.selectMember(member);
		
		if(member == null) {
			rttr.addFlashAttribute("message", "일치하는 회원이 존재하지 않습니다.");
			return "redirect:/member/searchId";
		}
		
		String emailKey = "";
		if(member.getEmail().contains("naver.com")) {
			emailKey =  SendMail.naverMailSend(member.getEmail());
			model.addAttribute("emailKey", emailKey);
			model.addAttribute("userId", member.getUserId());
		} else {
			emailKey =  SendMail.gmailSend(member.getEmail());
			model.addAttribute("emailKey", emailKey);
			model.addAttribute("userId", member.getUserId());
		}
		
		return "/member/searchId_res";
	}
	
	/* 비밀번호 찾기 페이지로 포워딩 */
	@GetMapping("searchPwd")
	public void searchPwd() {}
	
	/* 비밀번호찾기 */
	@PostMapping("searchPwd")
	public String searchPwdResult(@ModelAttribute MemberDTO member, HttpServletRequest request, Model model, RedirectAttributes rttr) {
		
		String email = request.getParameter("email1") + "@" + request.getParameter("email2");
		
		member.setEmail(email);
		
		member = memberService.selectMember(member);
		
		if(member == null) {
			rttr.addFlashAttribute("message", "일치하는 회원이 존재하지 않습니다.");
			return "redirect:/member/searchPwd";
		}
		
		String emailKey = "";
		if(member.getEmail().contains("naver.com")) {
			emailKey =  SendMail.naverMailSend(member.getEmail());
			model.addAttribute("emailKey", emailKey);
		} else {
			emailKey =  SendMail.gmailSend(member.getEmail());
			model.addAttribute("emailKey", emailKey);
		}
		
		return "/member/searchPwd_res";
	}
	
	/* 비밀번호 찾기 후 비밀번호 변경 페이지로 포워딩 */
	@GetMapping("modifySearchPwd")
	public void modifySearchPwd() {}
	
	/* 비밀번호찾기 후 비밀번호 변경 */
	@PostMapping("modifySearchPwd")
	public String modifySearchPwdToMember(@ModelAttribute MemberDTO member, HttpServletRequest request, RedirectAttributes rttr) {
		
		member.setUserPwd(passwordEncoder.encode(request.getParameter("userPwd")));
		
		String path = "";
		if(memberService.modifySearchPwd(member)) {
			rttr.addFlashAttribute("message", "비밀번호 변경에 성공하셨습니다.");
			path = "redirect:/";
		} else {
			rttr.addFlashAttribute("message", "비밀번호 변경에 실패하셨습니다.");
			path = "redirect:/member/searchPwd";
		}
		
		return path;
	}
	
	/* 마이페이지로 값 select와 동시에 포워딩 */
	@GetMapping("mypage")
	public void mypage(HttpServletRequest request, Model model) {
		
		MemberDTO loginMember = (MemberDTO) request.getSession().getAttribute("loginMember");
		
		model.addAttribute("paymentList", memberService.selectPaymentList(loginMember));
		model.addAttribute("zzimList", memberService.selectMemberWishMovieList(loginMember.getUserNo()));
		model.addAttribute("watchList", memberService.selectWatchMovieList(loginMember.getUserNo()));
		model.addAttribute("basketList", memberService.selectBasketList(loginMember.getUserNo()));
		model.addAttribute("goodsLikeList", memberService.selectGoodsLikeList(loginMember.getUserNo()));
	}
	
	/* 마이페이지 영화 후기 ON, OFF */
	@PostMapping(value="modifyMovieOnOff", produces="application/json; charset=UTF-8")
	@ResponseBody
	public String modifyMovieOnOff(HttpServletRequest request, Model model) {
		
		Gson gson = new GsonBuilder().create();
		
		MemberDTO loginMember = (MemberDTO) request.getSession().getAttribute("loginMember");
		int modifyResult = memberService.modifyMovieOnOff(loginMember);
		String modifyShape = "";
		if(modifyResult > 0) {
			MemberDTO modifyMember = memberService.selectMember(loginMember);
			model.addAttribute("loginMember", modifyMember);
			if(modifyMember.getMovieReviewYN().equals("Y")) {
				modifyShape = "on";
			} else {
				modifyShape = "off";
			}
		}
		
		return gson.toJson(modifyShape);
	}

	/* 마이페이지 게시판 스포 ON, OFF */
	@PostMapping(value="modifyBoardOnOff", produces="application/json; charset=UTF-8")
	@ResponseBody
	public String modifyBoardOnOff(HttpServletRequest request, Model model) {
		
		Gson gson = new GsonBuilder().create();
		
		MemberDTO loginMember = (MemberDTO) request.getSession().getAttribute("loginMember");
		int modifyResult = memberService.modifyBoardOnOff(loginMember);
		String modifyShape = "";
		if(modifyResult > 0) {
			MemberDTO modifyMember = memberService.selectMember(loginMember);
			model.addAttribute("loginMember", modifyMember);
			if(modifyMember.getSpoilerYN().equals("Y")) {
				modifyShape = "on";
			} else {
				modifyShape = "off";
			}
		}
		
		return gson.toJson(modifyShape);
	}
	
	/* 회원정보수정 */
	@PostMapping("modifyMember")
	public String modifyMember(@ModelAttribute MemberDTO member, HttpServletRequest request, RedirectAttributes rttr, Model model) {
		
		String address = request.getParameter("zipCode") + "$" + request.getParameter("address") + "$" + request.getParameter("detailAddress");
		String email = request.getParameter("email1") + "@" + request.getParameter("email2");
		member.setUserAddress(address);
		member.setEmail(email);
		
		if(memberService.modifyMember(member)) {
			rttr.addFlashAttribute("message", "회원정보수정에 성공하셨습니다.");
			model.addAttribute("loginMember", memberService.selectMember(member));
		} else {
			rttr.addFlashAttribute("message", "회원정보수정에 실패하셨습니다.");
		}
		
		return "redirect:/member/mypage";
	}
	
	@PostMapping("modifyPwd")
	public String modifyPwd(@ModelAttribute MemberDTO member, HttpServletRequest request, RedirectAttributes rttr, Model model) {
		
		String nowUserPwd = request.getParameter("nowUserPwd");
		member.setUserPwd(passwordEncoder.encode(member.getUserPwd()));
		
		if(memberService.modifyPwd(member, nowUserPwd)) {
			rttr.addFlashAttribute("message", "비밀번호변경에 성공하셨습니다.");
			model.addAttribute("loginMember", memberService.selectMember(member));
		} else {
			rttr.addFlashAttribute("message", "비밀번호변경에 실패하셨습니다.");
		}
		
		return "redirect:/member/mypage";
	}
	
	@PostMapping("removeMember")
	public String removeMember(@ModelAttribute MemberDTO member, RedirectAttributes rttr, SessionStatus status) {
		
		String path = "";
		if(memberService.removeMember(member)) {
			rttr.addFlashAttribute("message", "회원탈퇴에 성공하셨습니다. 이용해주셔서 감사합니다.");
			path = "redirect:/";
			status.setComplete();
		} else {
			rttr.addFlashAttribute("message", "회원탈퇴에 실패하셨습니다.");
			path = "redirect:/member/mypage";
		}
		
		return path;
	}
	
	@GetMapping("subscribe")
	public void subscribe() {}
	
	@PostMapping("subscribe")
	public String subscribePayment(@ModelAttribute SubscribePaymentDTO payment, HttpServletRequest request, Model model, RedirectAttributes rttr) {
		
		SubscriptionDTO sub = new SubscriptionDTO();
		sub.setNumber(Integer.valueOf(request.getParameter("subscriptionNumber")));
		payment.setSubscription(sub);
		payment.setSubscription(memberService.selectSubscription(payment));
		
		MemberDTO member = new MemberDTO();
		member.setUserNo(payment.getUserNo());
		member = memberService.selectMember(member);
		
		payment.setPaymentValidity(new java.sql.Date(new DateCalculator().dateAdd(payment.getSubscription().getNumber(), payment.getSubscription().getPeriod(), member.getSubscribeValidity()).getTime()));

		if(1 == payment.getSubscription().getPeriod()) {
			payment.setPaymentPrice(payment.getSubscription().getPrice());
		} else if(3 == payment.getSubscription().getPeriod()) {
			payment.setPaymentPrice(payment.getSubscription().getPrice() * 3);
		} else if(12 == payment.getSubscription().getPeriod()) {
			payment.setPaymentPrice(payment.getSubscription().getPrice() * 12);
		}
		
		String path = "";
		if(memberService.insertSubscribePayment(payment) > 0 && memberService.modifySubscribeValidity(payment) > 0) {
			path = "redirect:/";
			rttr.addFlashAttribute("message", "결제가 완료되었습니다.");
			model.addAttribute("loginMember", memberService.selectMember(member));
		} else {
			path = "redirect:/member/subscribe";
			rttr.addFlashAttribute("message", "결제에 실패하셨습니다.");
		}
		
		return path;
	}
	
}