package com.vegan.admin.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vegan.admin.dto.AdminDTO;
import com.vegan.admin.service.AdminService;
import com.vegan.member.dto.MemberDTO;



@Controller
public class AdminController {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired AdminService service;


	@RequestMapping(value="/admin.go", method = RequestMethod.GET)
	public String AdminPage(Model model) {

		return "adminPage";
	}
	@RequestMapping(value="/admin.userList", method = RequestMethod.GET)
	public String UserList(Model model) {
		logger.info("list call");
		ArrayList<AdminDTO> userList = service.userList();		
		logger.info("list cnt : "+userList.size());
		model.addAttribute("userList", userList);
		return "userList";
	}
	@RequestMapping(value="/admin.reportList", method = RequestMethod.GET)
	public String ReportList(Model model) {
		ArrayList<AdminDTO> reportList = service.reportList();		
		logger.info("list cnt : "+reportList.size());
		model.addAttribute("reportList", reportList);
		return "reportList";
	}
	@RequestMapping(value="/admin.blindList", method = RequestMethod.GET)
	public String BlindList(Model model) {

		return "blindList";
	}
	@RequestMapping(value="/admin.category", method = RequestMethod.GET)
	public String Category(Model model) {

		return "category";
	}
	@RequestMapping(value="/admin.adminLetterList", method = RequestMethod.GET)
	public String AdminLetterList(Model model) {

		return "adminLetterList";
	}
	

    
}