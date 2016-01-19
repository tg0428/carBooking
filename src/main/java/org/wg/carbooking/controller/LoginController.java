package org.wg.carbooking.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.wg.carbooking.model.admin;
import org.wg.carbooking.service.managerService;

@Controller
@RequestMapping("/Login")
@SessionAttributes({"admin"})
public class LoginController {

	private managerService ms;
	
	@Autowired
	public void setMs(managerService ms) {
		this.ms = ms;
	}
	
	@ModelAttribute("admin")
	public admin populateUser(){
		return new admin();
	}
	
	public admin getAdmin(HttpSession session) {
		return (admin) session.getAttribute("admin");
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
}
