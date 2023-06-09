package com.vegan.mypage.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.vegan.classes.dto.ClassesDTO;
import com.vegan.mypage.dto.MypageDTO;
import com.vegan.mypage.service.MypageService;
import com.vegan.recipe.dto.RecipeDTO;



@Controller
public class MypageController {

	@Autowired MypageService service;
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	
	@RequestMapping(value = "/profile.do")
	public String profile(HttpSession session, Model model) {
		String page = "login";
		String loginId = (String) session.getAttribute("loginId");
		MypageDTO dto = service.profile(loginId);
		logger.info("dto:"+dto);
		if (dto != null) {
			page = "profile";
			logger.info("profile:"+dto);
			model.addAttribute("user",dto);

			String msg =(String) session.getAttribute("msg");
			if (msg != null) {
				model.addAttribute("msg",msg);
				//쓰고난 세션은 반드시 바로 삭제해 줘야 한다.
				session.removeAttribute("msg");
			}
		}
		
		return page;
	}
	
	
	@RequestMapping(value="/profilePhoto.do")
	public String profilePhoto(HttpSession session, MultipartFile photo ) {
		String loginId = (String) session.getAttribute("loginId");
		int row =service.profilePhoto(photo, loginId);
		if (row == 1) {
			session.setAttribute("msg","사진이 등록되었습니다.");
		}
		
		
		return "redirect:/profile.do";
	}
	

	@RequestMapping(value = "/profileUpdate.do")
	public String profileUpdate(HttpSession session, Model model,@RequestParam String introduction) {
		
		String loginId = (String) session.getAttribute("loginId");
		int row = service.proUpdate(loginId,introduction);
		if (row == 1) {
			session.setAttribute("msg","소개글이 등록되었습니다.");
		}
		
		return "redirect:/profile.do";
	}
	
	@RequestMapping(value = "/profileDetail.do")
	public String detail(Model model,HttpSession session) {
		String loginId = (String) session.getAttribute("loginId");
		MypageDTO dto = service.profileDetail(loginId);
			
			logger.info("detail:"+dto);
			model.addAttribute("detail",dto);
		
			String msg =(String) session.getAttribute("msg");
			if (msg != null) {
				model.addAttribute("msg",msg);
				//쓰고난 세션은 반드시 바로 삭제해 줘야 한다.
				session.removeAttribute("msg");
			}
		return "userDetail";
	}
	@RequestMapping(value = "/userUpdate.do")
	public String update( Model model, @RequestParam HashMap<String,String> params, HttpSession session) {
		logger.info("update param:"+params);
		if (session.getAttribute("loginId")!= null) {
			service.update(params);
			session.setAttribute("msg","정보가 수정되었습니다.");
		}
		return "redirect:/profile.do";
	}
	
	@RequestMapping(value ="/passwardChk.go")
	public String pwChk() {
	
		
		return "pwCheck";
	}
	 
	
	@RequestMapping(value ="/passwardChk.do")
	public String pwChk(@RequestParam String pwChk, Model model,HttpSession session) {
		String page = "";
		String loginId = (String) session.getAttribute("loginId");
		int pwchk = service.pwChk(loginId,pwChk);

		if (pwchk == 1) {
			page = "changePW";
		}else {
			page = "pwCheck";
			model.addAttribute("msg","비밀번호가 일치하지 않습니다.");
		}
		
		return page;
	}
	
	 @RequestMapping(value = "/delUser.do")
		public String del( Model model, HttpSession session,@RequestParam String idx ) {
		 logger.info("del idx:"+idx);
		 
		 if (session.getAttribute("loginId") != null) {
			 if (service.del(idx)==1) {
				String msg="탈퇴에 성공했습니다.";
				 model.addAttribute("msg", msg);
				 session.removeAttribute("loginId");
			}
		 }
		 
			return "login";
		}
	 
	 @RequestMapping(value = "/changePW.do")
		public String newPW( Model model, HttpSession session,@RequestParam String newPW,@RequestParam String confirm ) {
		 //logger.info("del idx:"+idx);
		 String page ="";
		 String loginId = (String) session.getAttribute("loginId");
		 if (session.getAttribute("loginId") != null && newPW.equals(confirm)) {
			 if (service.changePW(loginId,newPW)==1) {
				String msg="비밀번호가 변경되었습니다.";
				 session.setAttribute("msg", msg);
				 page = "redirect:/profileDetail.do";
			}
		 }else {
			 model.addAttribute("msg", "비밀번호가 일치하지 않습니다.");
			 page = "changePW";
		 }
		 
			return page;
		}
	 
	 
	 @RequestMapping(value="/myClassList.do")
		public String ClassList(Model model, HttpSession session) {
			String page = "";
			if (session.getAttribute("loginId") != null) {
				page ="myClassList";
				String loginId = String.valueOf(session.getAttribute("loginId"));
				logger.info("myClasslist call");
				ArrayList<ClassesDTO> list = service.mclist(loginId);		
				logger.info("list cnt : "+list.size());
				System.out.println("list cnt "+list.size());
				model.addAttribute("list", list);
				
				
			}else {
				page = "main";
				model.addAttribute("msg","로그인을 해주세요");
			}
			return page;
		}
	 
	 @RequestMapping(value="/myRecipeList.do")
		public String myRecipeList(Model model, HttpSession session) {
			
		
				String loginId = String.valueOf(session.getAttribute("loginId"));
				ArrayList <RecipeDTO> recipelist = service.rlist(loginId);
				model.addAttribute("recipelist",recipelist);
				
				ArrayList <RecipeDTO> photos = service.listPhoto(loginId);
				Map<String, String> pho = new HashMap<>();
				 int x=0;
				for (RecipeDTO photo : photos) {

			    	String val = photo.getPhoto_name();
			    	 logger.info(val);
			    	pho.put("photo_name"+x, val);
			    	x++;
				}
				 model.addAttribute("photo", pho);
		
				String page = "myRecipeList2";
				
			
			return page;
		}
	 
}
