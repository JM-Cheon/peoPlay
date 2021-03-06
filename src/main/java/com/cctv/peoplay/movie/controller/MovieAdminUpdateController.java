package com.cctv.peoplay.movie.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cctv.peoplay.movie.model.dto.ActorDTO;
import com.cctv.peoplay.movie.model.dto.MovieDTO;
import com.cctv.peoplay.movie.model.dto.MovieFileDTO;
import com.cctv.peoplay.movie.model.service.MovieService;

@Controller
@RequestMapping("/admin/*")
@SessionAttributes("loginMember")
public class MovieAdminUpdateController {
	private final MovieService service;
	
	@Autowired
	public MovieAdminUpdateController(MovieService service) {
		this.service = service;
	}
	
	@GetMapping("/admin/{no}")
	public String list(Model model, HttpServletRequest request, @PathVariable("no") int no) throws Exception {
		
		model.addAttribute("detail", service.selectmovie(no));
		model.addAttribute("adminActorList" ,  service.adminActorList(no));
		model.addAttribute("movieMainFiles" , service.selectMovieMainFile(no));
		model.addAttribute("movieSubFiles" , service.selectMovieSubFile(no));
		model.addAttribute("list" , service.selectMovieList());
		
		return "movie/adminUpdate";
	}
	
	
	@PostMapping("admin/{no}")
	public String updateMovie(Model model, @PathVariable("no") int no, 
			@RequestParam MultipartFile singleFile1, @RequestParam MultipartFile singleFile2,
			HttpServletRequest request, RedirectAttributes rttr) {
		
		MovieDTO movieUpdate = new MovieDTO();

		movieUpdate.setNo(Integer.valueOf(request.getParameter("no")));
		movieUpdate.setName(request.getParameter("name"));
		movieUpdate.setInfo(request.getParameter("info"));
		movieUpdate.setDirector(request.getParameter("director"));
		movieUpdate.setProductionYear(Integer.valueOf(request.getParameter("productionYear")));
		movieUpdate.setMovieTime(request.getParameter("productionYear"));
		movieUpdate.setWatchFear(request.getParameter("watchFear"));
		movieUpdate.setWatchModification(request.getParameter("watchModification"));
		movieUpdate.setWatchDrug(request.getParameter("watchDrug"));
		movieUpdate.setWatchSensationality(request.getParameter("watchSensationality"));
		movieUpdate.setWatchScript(request.getParameter("watchScript"));
		movieUpdate.setWatchTitle(request.getParameter("watchTitle"));
		movieUpdate.setWatchViolence(request.getParameter("watchViolence"));
		movieUpdate.setRatingName(request.getParameter("ratingName"));
		movieUpdate.setGenreName(request.getParameter("genreName"));
		movieUpdate.setMovieVideoRink(request.getParameter("movieVideoRink"));
		
		service.updateMovie(movieUpdate);

		ActorDTO updateActors = new ActorDTO();
		updateActors.setActorName1(request.getParameter("actorName1"));
		updateActors.setActorName2(request.getParameter("actorName2"));
		updateActors.setActorName3(request.getParameter("actorName3"));
		updateActors.setActorName4(request.getParameter("actorName4"));
		updateActors.setActorName5(request.getParameter("actorName5"));
		updateActors.setNo(Integer.valueOf(request.getParameter("no")));

		service.updateActors(updateActors);
		
		/* ?????? ?????? */
		/* webapp ????????? resources????????? ????????? ??????*/
		String root = request.getSession().getServletContext().getRealPath("resources");
		String filePath = root + "\\images\\movieImageFiles";
		
		/* ?????? ?????? */
		File mkdir = new File(filePath);
		if(!mkdir.exists()) {
			mkdir.mkdirs();
		}
		
		/* ????????? ?????? ?????? */
		String originFileName1 = singleFile1.getOriginalFilename();
		String originFileName2 = singleFile2.getOriginalFilename();
		
		/* ????????? ??? ??? ?????? ?????? */
		if(originFileName1 != "" && originFileName2 != "") {
		service.movieFileDelete(no);
		
		String ext1 = originFileName1.substring(originFileName1.lastIndexOf("."));
		String ext2 = originFileName2.substring(originFileName2.lastIndexOf("."));
		String saveName1 = UUID.randomUUID().toString().replace("-", "") + ext1;
		String saveName2 = UUID.randomUUID().toString().replace("-", "") + ext2;
		
		/* ????????? ????????????. */
		try {
			singleFile1.transferTo(new File(filePath + "\\" + saveName1));
			singleFile2.transferTo(new File(filePath + "\\" + saveName2));
			model.addAttribute("message", "?????? ????????? ??????!");
			
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
			
			/* ?????? ??? ?????? ?????? */
			new File(filePath + "\\" + saveName1).delete();
			new File(filePath + "\\" + saveName2).delete();
			model.addAttribute("message", "?????? ????????? ??????!");
		}
	
		/* ????????? ?????? ?????? */
		MovieFileDTO movieFileUpdateSub = new MovieFileDTO();
		MovieFileDTO movieFileUpdateMain = new MovieFileDTO();
		
		movieFileUpdateSub.setNo(Integer.valueOf(request.getParameter("no")));
		movieFileUpdateSub.setOriginName(originFileName2);
		movieFileUpdateSub.setSaveName(saveName2);
		movieFileUpdateSub.setSavePath(filePath);
		
		service.updateMovieFileSub(movieFileUpdateSub);

		movieFileUpdateMain.setNo(Integer.valueOf(request.getParameter("no")));
		movieFileUpdateMain.setOriginName(originFileName1);
		movieFileUpdateMain.setSaveName(saveName1);
		movieFileUpdateMain.setSavePath(filePath);
		
		service.updateMovieFileMain(movieFileUpdateMain);
		
		
	/* start : ??????????????? ?????? ?????? */
		} else if(originFileName1 == "" && originFileName2 != ""){
			
//		System.out.println("?????? ?????? : " + originFileName2);
//		System.out.println("?????? ?????? : " + originFileName1);
	
//		System.out.println("?????? ?????? ?????? ?????? ??? ???????????? : " + no);
		service.movieSubFileOnePickDelete(no);
//		System.out.println("?????? ?????? ?????? ?????????");
		
		
		String ext2 = originFileName2.substring(originFileName2.lastIndexOf("."));
		String saveName2 = UUID.randomUUID().toString().replace("-", "") + ext2;
//		System.out.println("2.????????? ?????? : " + saveName2);
		
		/* ????????? ????????????. */
		try {
			singleFile2.transferTo(new File(filePath + "\\" + saveName2));
			model.addAttribute("message", "?????? ????????? ??????!");
			
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
			
			/* ?????? ??? ?????? ?????? */
			new File(filePath + "\\" + saveName2).delete();
			model.addAttribute("message", "?????? ????????? ??????!");
		}
		
		/* ????????? ?????? ?????? */
		MovieFileDTO movieFileUpdateSub = new MovieFileDTO();
		
		movieFileUpdateSub.setNo(Integer.valueOf(request.getParameter("no")));
		movieFileUpdateSub.setOriginName(originFileName2);
		movieFileUpdateSub.setSaveName(saveName2);
		movieFileUpdateSub.setSavePath(filePath);
		
		service.updateMovieFileSub(movieFileUpdateSub);
//		System.out.println(movieFileUpdateSub);
		
		
	/* start : ??????????????? ?????? ?????? */
		} else if(originFileName1 != "" && originFileName2 == "") {
			
//		System.out.println("?????? ?????? : " + originFileName2);
//		System.out.println("?????? ?????? : " + originFileName1);

//		System.out.println("?????? ?????? ?????? ?????? ??? ???????????? : " + no);
		service.movieMainFileOnePickDelete(no);
		
		
		String ext1 = originFileName1.substring(originFileName1.lastIndexOf("."));
		String saveName1 = UUID.randomUUID().toString().replace("-", "") + ext1;
//		System.out.println("1.????????? ?????? : " + saveName1);
		
		/* ????????? ????????????. */
		try {
			singleFile1.transferTo(new File(filePath + "\\" + saveName1));
			model.addAttribute("message", "?????? ????????? ??????!");
			
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
			
			/* ?????? ??? ?????? ?????? */
			new File(filePath + "\\" + saveName1).delete();
			model.addAttribute("message", "?????? ????????? ??????!");
		}
		
		/* ????????? ?????? ?????? */
		MovieFileDTO movieFileUpdateMain = new MovieFileDTO();
		
		movieFileUpdateMain.setNo(Integer.valueOf(request.getParameter("no")));
		movieFileUpdateMain.setOriginName(originFileName1);
		movieFileUpdateMain.setSaveName(saveName1);
		movieFileUpdateMain.setSavePath(filePath);
		
		service.updateMovieFileMain(movieFileUpdateMain);
//		System.out.println(movieFileUpdateMain);
		
		
		} else {
		}
		
		return "redirect:/movie/adminUpdateSelect";	

		
	}	// method end
	
	/* ?????? ?????? */
	@PostMapping("movieDelete")
	public String deleteMovie(Model model,@RequestParam int movieNo
			, HttpServletRequest request, RedirectAttributes rttr) {
//		System.out.println(movieNo);
		MovieDTO deleteMovie = new MovieDTO();
		
		deleteMovie.setNo(movieNo);

//		System.out.println("?????? ??? : " + deleteMovie);
		
		service.movieDelete(movieNo);
		service.actorDelete(movieNo);
		service.movieFileDelete(movieNo);
//		System.out.println("?????? ??????. ");
		
		return "redirect:/movie/adminUpdateSelect";
	}
	
} 	// class end
