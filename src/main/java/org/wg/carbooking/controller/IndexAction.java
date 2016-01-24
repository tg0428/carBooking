package org.wg.carbooking.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.wg.carbooking.vo.user;

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
	
	@RequestMapping("/edit")
	public ModelAndView resource() {
		ModelAndView view = new ModelAndView();
		view.addObject("TITLE", "ÐÂÎÅ");
		view.setViewName("/template/cms/edit");
		return view;
	}
	
	@RequestMapping(value="/model.html")
    public String say(Model model) {        
         model.addAttribute("hello", "hello world");  
         model.addAttribute("a");
         return "/template/model";
    } 
	
	
	@RequestMapping(value="/admin.html")
    public String admin(Model model) {        
         model.addAttribute("hello", "hello world");  
         model.addAttribute("a");
         return "/admin/cms/admin";
    } 
	
	@RequestMapping(value="/cms/login.html")
    public String login(Model model) {        
         model.addAttribute("hello", "hello world");  
         model.addAttribute("a");
         return "/admin/login/login";
    } 

}
