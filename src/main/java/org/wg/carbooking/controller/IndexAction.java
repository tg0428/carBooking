package org.wg.carbooking.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.wg.carbooking.service.managerService;
import org.wg.carbooking.vo.article;

/**
 * test beetl and spring mvc controller
 * */
@Controller
public class IndexAction {
	
	private managerService ms;
	
	@Autowired
	public void setMs(managerService ms) {
		this.ms = ms;
	}
	
	@RequestMapping("/index.html")
	public ModelAndView index() {
		ModelAndView view = new ModelAndView();
		/*获取公司新闻列表前五条*/
		List<Map<String,Object>> news = ms.getArticleList(4,5);
		/*获取公司公告列表前五条*/
		List<Map<String,Object>> notices = ms.getArticleList(3,5);
		/*获取公司活动列表前五条*/
		List<Map<String,Object>> acticities = ms.getArticleList(5,5);
		view.addObject("news", news);
		view.addObject("notices", notices);
		view.addObject("activities", acticities);
		view.setViewName("/gateway/index/index");
		return view;
		
	}
	
	@RequestMapping(value = "/detail.html", method = RequestMethod.GET)
	public ModelAndView detail(int type, int id){
		
		ModelAndView view = new ModelAndView();
		article bean = null;
		if (id == 0) {
			List<Map<String,Object>> al = ms.getArticleList(type);
			bean = ms.GetArticle((int)al.get(0).get("article_type"),(int)al.get(0).get("article_id"));
		} else {
			bean = ms.GetArticle(type, id);
		}
		List<Map<String,Object>> recentList = ms.getArticleList(type, 10);
		view.addObject("recentlist",recentList);
		view.addObject("bean",bean);
		view.setViewName("/gateway/detail/detail");
		return view;
	}
	
	@RequestMapping(value = "/edit")
	public ModelAndView resource(article article) {
		ModelAndView view = new ModelAndView();
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
