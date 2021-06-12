package com.cctv.peoplay.movie.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
@RequestMapping("/movie/*")
@SessionAttributes("loginMember")
public class MovieAdminInsertController {
	
	private final MovieService service;

	@Autowired
	public MovieAdminInsertController(MovieService service) {
		this.service = service;
	}
	
	@GetMapping("admin")
	public String adminPage(Model model) throws Exception {
		model.addAttribute("list" , service.selectMovieList());

		return "movie/admin";
	}
	
	/* 영화 등록 */
	@PostMapping("admin")
	public String movieUpload(Model model, @RequestParam MultipartFile singleFile1, @RequestParam MultipartFile singleFile2,
			HttpServletRequest request, RedirectAttributes rttr) {

		MovieDTO movieInsert = new MovieDTO();

		movieInsert.setName(request.getParameter("name"));
		movieInsert.setInfo(request.getParameter("info"));
		movieInsert.setDirector(request.getParameter("director"));
		movieInsert.setProductionYear(Integer.valueOf(request.getParameter("productionYear")));
		movieInsert.setMovieTime(request.getParameter("productionYear"));
		movieInsert.setWatchFear(request.getParameter("watchFear"));
		movieInsert.setWatchModification(request.getParameter("watchModification"));
		movieInsert.setWatchDrug(request.getParameter("watchDrug"));
		movieInsert.setWatchSensationality(request.getParameter("watchSensationality"));
		movieInsert.setWatchScript(request.getParameter("watchScript"));
		movieInsert.setWatchTitle(request.getParameter("watchTitle"));
		movieInsert.setWatchViolence(request.getParameter("watchViolence"));
		movieInsert.setRatingName(request.getParameter("ratingName"));
		movieInsert.setGenreName(request.getParameter("genreName"));
		movieInsert.setMovieVideoRink(request.getParameter("movieVideoRink"));

		service.insertMovie(movieInsert);

		ActorDTO insertActors = new ActorDTO();
		insertActors.setActorName1(request.getParameter("actorName1"));
		insertActors.setActorName2(request.getParameter("actorName2"));
		insertActors.setActorName3(request.getParameter("actorName3"));
		insertActors.setActorName4(request.getParameter("actorName4"));
		insertActors.setActorName5(request.getParameter("actorName5"));
		
		System.out.println(insertActors);
		service.insertActors(insertActors);

		/* 경로 설정 */
		/* webapp 아래의 resources까지의 경로를 추출*/
		String root = request.getSession().getServletContext().getRealPath("resources");
		System.out.println(root);
		String filePath = root + "\\images\\movieImageFiles";
		
		/* 폴더 생성 */
		File mkdir = new File(filePath);
		if(!mkdir.exists()) {
			mkdir.mkdirs();
		}
		
		/* 파일명 변경 처리 */
		String originFileName1 = singleFile1.getOriginalFilename();
		String originFileName2 = singleFile2.getOriginalFilename();
		String ext1 = originFileName1.substring(originFileName1.lastIndexOf("."));
		String ext2 = originFileName2.substring(originFileName2.lastIndexOf("."));
		String saveName1 = UUID.randomUUID().toString().replace("-", "") + ext1;
		String saveName2 = UUID.randomUUID().toString().replace("-", "") + ext2;
		
		/* 파일을 저장한다. */
		try {
			singleFile1.transferTo(new File(filePath + "\\" + saveName1));
			singleFile2.transferTo(new File(filePath + "\\" + saveName2));
			model.addAttribute("message", "파일 업로드 성공!");
			
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
			
			/* 실패 시 파일 삭제 */
			new File(filePath + "\\" + saveName1).delete();
			new File(filePath + "\\" + saveName2).delete();
			model.addAttribute("message", "파일 업로드 실패!");
		}
		/* 파일 등록 */
		MovieFileDTO movieFileInsertSub = new MovieFileDTO();
		MovieFileDTO movieFileInsertMain = new MovieFileDTO();
		
		movieFileInsertSub.setOriginName(originFileName2);
		movieFileInsertSub.setSaveName(saveName2);
		movieFileInsertSub.setSavePath(filePath);

		service.insertMovieFileSub(movieFileInsertSub);
		System.out.println(movieFileInsertSub);
		
		movieFileInsertMain.setOriginName(originFileName1);
		movieFileInsertMain.setSaveName(saveName1);
		movieFileInsertMain.setSavePath(filePath);

		service.insertMovieFileMain(movieFileInsertMain);
		System.out.println(movieFileInsertMain);
		
		
		return "movie/adminButton";
	}

	
	
}
