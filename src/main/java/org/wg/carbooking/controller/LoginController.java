package org.wg.carbooking.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.wg.carbooking.model.result;
import org.wg.carbooking.service.managerService;
import org.wg.carbooking.vo.admin;
import org.wg.carbooking.vo.user;

@Controller
@RequestMapping("/Login")
@SessionAttributes({"admin","user"})
public class LoginController {

	private managerService ms;
	private result rs = result.getInstance();
	
	@Autowired
	public void setMs(managerService ms) {
		this.ms = ms;
	}
	
	@ModelAttribute("admin")
	public admin populateUser(){
		return new admin();
	}
	
	@ModelAttribute("user")
	public user populateNormalUser(){
		return new user();
	}
	
	public void removeSession(SessionStatus sessionStatus){
		sessionStatus.setComplete();
	}
	
	public admin getAdmin(HttpSession session) {
		return (admin) session.getAttribute("admin");
	}
	
	public user getUser(HttpSession session) {
		return (user) session.getAttribute("user");
	}
	
	@RequestMapping(value = "/access")
	public ModelAndView adminLogin(admin admin,HttpSession session){
		ModelAndView view = new ModelAndView();
		if (ms.Access(admin) != null){
			view.addObject("admin", admin);
			view.setViewName("/admin/cms/admin");
			return view;
		} else if(admin == null && ms.Access(this.getAdmin(session)) != null){
			view.setViewName("/admin/cms/admin");
			return view;
		} else {
			view.setViewName("/admin/login/login");
			view.addObject("msg", "信息输入错误，请重新登录");
			return view;
		}
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody result normalUserLogin(user user, HttpSession session, SessionStatus sessionStatus){
		ModelAndView view = new ModelAndView();
		if (ms.Login(user)){
			view.addObject("user",user);
			rs.setMsg("true");
		} else {
			this.removeSession(sessionStatus);
			rs.setMsg("false");
		}
		return rs;
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public @ResponseBody result normalUserLogin(user user, SessionStatus sessionStatus){
		ModelAndView view = new ModelAndView();
		if (ms.Register(user)){
			rs.setMsg("true");
			view.addObject("user",user);
		} else {
			this.removeSession(sessionStatus);
			rs.setMsg("false");
		}
		return rs;
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView Logout(SessionStatus sessionStatus){
		ModelAndView view = new ModelAndView();
		sessionStatus.setComplete();
		view.setViewName("redirect:/index.html");
		return view;
	}
}
