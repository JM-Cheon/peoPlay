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
		
		/* 경로 설정 */
		/* webapp 아래의 resources까지의 경로를 추출*/
		String root = request.getSession().getServletContext().getRealPath("resources");
		String filePath = root + "\\images\\movieImageFiles";
		
		/* 폴더 생성 */
		File mkdir = new File(filePath);
		if(!mkdir.exists()) {
			mkdir.mkdirs();
		}
		
		/* 파일명 변경 처리 */
		String originFileName1 = singleFile1.getOriginalFilename();
		String originFileName2 = singleFile2.getOriginalFilename();
		
		/* 파일이 둘 다 있을 경우 */
		if(originFileName1 != "" && originFileName2 != "") {
		service.movieFileDelete(no);
		
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
	
		/* 새로운 파일 등록 */
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
		
		
	/* start : 서브파일만 있는 경우 */
		} else if(originFileName1 == "" && originFileName2 != ""){
			
//		System.out.println("서브 파일 : " + originFileName2);
//		System.out.println("메인 파일 : " + originFileName1);
	
//		System.out.println("기존 파일 삭제 번호 값 받았는지 : " + no);
		service.movieSubFileOnePickDelete(no);
//		System.out.println("기존 파일 삭제 되었음");
		
		
		String ext2 = originFileName2.substring(originFileName2.lastIndexOf("."));
		String saveName2 = UUID.randomUUID().toString().replace("-", "") + ext2;
//		System.out.println("2.변경한 이름 : " + saveName2);
		
		/* 파일을 저장한다. */
		try {
			singleFile2.transferTo(new File(filePath + "\\" + saveName2));
			model.addAttribute("message", "파일 업로드 성공!");
			
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
			
			/* 실패 시 파일 삭제 */
			new File(filePath + "\\" + saveName2).delete();
			model.addAttribute("message", "파일 업로드 실패!");
		}
		
		/* 새로운 파일 등록 */
		MovieFileDTO movieFileUpdateSub = new MovieFileDTO();
		
		movieFileUpdateSub.setNo(Integer.valueOf(request.getParameter("no")));
		movieFileUpdateSub.setOriginName(originFileName2);
		movieFileUpdateSub.setSaveName(saveName2);
		movieFileUpdateSub.setSavePath(filePath);
		
		service.updateMovieFileSub(movieFileUpdateSub);
//		System.out.println(movieFileUpdateSub);
		
		
	/* start : 메인파일만 있는 경우 */
		} else if(originFileName1 != "" && originFileName2 == "") {
			
//		System.out.println("서브 파일 : " + originFileName2);
//		System.out.println("메인 파일 : " + originFileName1);

//		System.out.println("기존 파일 삭제 번호 값 받았는지 : " + no);
		service.movieMainFileOnePickDelete(no);
		
		
		String ext1 = originFileName1.substring(originFileName1.lastIndexOf("."));
		String saveName1 = UUID.randomUUID().toString().replace("-", "") + ext1;
//		System.out.println("1.변경한 이름 : " + saveName1);
		
		/* 파일을 저장한다. */
		try {
			singleFile1.transferTo(new File(filePath + "\\" + saveName1));
			model.addAttribute("message", "파일 업로드 성공!");
			
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
			
			/* 실패 시 파일 삭제 */
			new File(filePath + "\\" + saveName1).delete();
			model.addAttribute("message", "파일 업로드 실패!");
		}
		
		/* 새로운 파일 등록 */
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
	
	/* 영화 삭제 */
	@PostMapping("movieDelete")
	public String deleteMovie(Model model,@RequestParam int movieNo
			, HttpServletRequest request, RedirectAttributes rttr) {
//		System.out.println(movieNo);
		MovieDTO deleteMovie = new MovieDTO();
		
		deleteMovie.setNo(movieNo);

//		System.out.println("삭제 값 : " + deleteMovie);
		
		service.movieDelete(movieNo);
		service.actorDelete(movieNo);
		service.movieFileDelete(movieNo);
//		System.out.println("삭제 완료. ");
		
		return "redirect:/movie/adminUpdateSelect";
	}
	
} 	// class end
