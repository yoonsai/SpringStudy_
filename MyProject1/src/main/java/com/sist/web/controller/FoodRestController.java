package com.sist.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.web.dao.FoodDAO;
import com.sist.web.entity.Food;

@RestController
public class FoodRestController {
	@Autowired
	private FoodDAO dao;
	@GetMapping(value="/food/detail_vue",produces="text/align;charset=UTF-8")
	public String detail_vue(int no) throws Exception
	{
		Food vo=dao.findByNo(no);
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(vo);
		return json;
	}
}
