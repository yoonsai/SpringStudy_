package com.sist.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

// 화면 변경 => router
/*
 *    <route "/recipe/list" component="RecipeList"/>
 */
@Controller //JSP (자바) => EL/JSTL
public class RecipeController {
   @GetMapping("recipe/recipe_list.do")
   public String recipe_list()
   {
	   return "recipe/recipe_list";
   }
   @GetMapping("recipe/chef_list.do")
   public String chef_list()
   {
	   return "recipe/chef_list";
   }
   @GetMapping("recipe/chef_detail.do")
   public String chef_detail(int cno,Model model)
   {
	   model.addAttribute("cno", cno);
	   return "recipe/chef_detail";
   }
   @GetMapping("recipe/recipe_detail.do")
   public String recipe_detail(int no,Model model,HttpSession session)
   {
	   model.addAttribute("no", no);
	   model.addAttribute("sessionId", session.getAttribute("userId"));
	   return "recipe/recipe_detail";
   }
}