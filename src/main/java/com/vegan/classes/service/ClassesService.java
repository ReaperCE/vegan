package com.vegan.classes.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vegan.classes.dao.ClassesDAO;
import com.vegan.classes.dto.ClassesDTO;

@Service
public class ClassesService {
	
	@Autowired ClassesDAO dao;
	
	Logger logger = LoggerFactory.getLogger(getClass());

	public String write(HashMap<String, String> params) {
		ClassesDTO dto = new ClassesDTO();
		dto.setUser_id(params.get("user_id"));
		dto.setCl_subject(params.get("cl_subject"));
		dto.setCl_period(params.get("cl_period"));
		dto.setCl_deadline(params.get("cl_deadline"));
		dto.setCl_teacher(params.get("cl_teacher"));
		dto.setCl_date(params.get("cl_date"));
		dto.setCl_ing_chk(Boolean.valueOf(params.get("cl_ing_chk")));
		dto.setCl_adress(params.get("cl_adress"));
		dto.setCl_content(params.get("cl_content"));
	
		int row = dao.write(dto);		
		logger.info("update row : "+row);
		String page = "redirect:/class.go";
		
		return page;
	}

	public ArrayList<ClassesDTO> list() {
		
		return dao.list();
	}

}
