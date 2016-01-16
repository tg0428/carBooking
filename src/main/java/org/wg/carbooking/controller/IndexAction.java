package org.wg.carbooking.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.wg.carbooking.model.user;

/**
 * test beetl and spring mvc controller
 * */
@Controller
public class IndexAction {
	@RequestMapping("/index.html")
	public ModelAndView index() {
		user user = new user();
		user user1 = new user();
		user user2 = new user();
		List<user> list = new ArrayList<user>();
		user.setName("111");
		user1.setName("222");
		user2.setName("333");
		list.add(user);
		list.add(user1);
		list.add(user2);
		ModelAndView view = new ModelAndView();
		view.addObject("userList", list);
		view.setViewName("/template/index");
		return view;
		
	}
	
	@RequestMapping("/resource.html")
	public String resource(
			HttpServletRequest request) {
		return "/template/index";
	}
	
	@RequestMapping(value="/model.html")
    public String say(Model model) {        
         model.addAttribute("hello", "hello world");  
         model.addAttribute("a");
         return "/template/model";
    } 
	

}