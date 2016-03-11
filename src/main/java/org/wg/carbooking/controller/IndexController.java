package org.wg.carbooking.controller;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.wg.carbooking.model.pager;
import org.wg.carbooking.service.managerService;
import org.wg.carbooking.utils.constant;
import org.wg.carbooking.utils.webGetDate;
import org.wg.carbooking.vo.article;
import org.wg.carbooking.vo.typeOfCar;
import org.wg.carbooking.vo.user;

/**
 * test beetl and spring mvc controller
 * */
@Controller
public class IndexController {
	
	private managerService ms;
	
	@Autowired
	public void setMs(managerService ms) {
		this.ms = ms;
	}
	
	@RequestMapping("/index.html")
	public ModelAndView index(HttpSession session) {
		ModelAndView view = new ModelAndView();
		/*获取公司新闻列表前五条*/
		List<Map<String,Object>> news = ms.getArticleList(4,5);
		/*获取公司公告列表前五条*/
		List<Map<String,Object>> notices = ms.getArticleList(3,5);
		/*获取公司活动列表前五条*/
		List<Map<String,Object>> acticities = ms.getArticleList(5,5);
		pager<Map<String,Object>> carlist = ms.GetCarList(1, 5);
        view.addObject("carlist",carlist);
		view.addObject("news", news);
		view.addObject("notices", notices);
		view.addObject("activities", acticities);
		if (session.getAttribute("user") != null){
			if (ms.Login((user)session.getAttribute("user"))){
				view.addObject("path", "/gateway/user/success.btl");
			} else {
				view.addObject("path", "/gateway/index/user.btl");
			}
		} else {
			view.addObject("path", "/gateway/index/user.btl");
		}
		view.setViewName("/gateway/index/index");
		return view;
		
	}
	
	@RequestMapping(value = "/detail.html", method = RequestMethod.GET)
	public ModelAndView detail(int type, int id){
		
		ModelAndView view = new ModelAndView();
		article bean = null;
		if (id == 0) {
			List<Map<String,Object>> al = ms.getArticleList(type);
			if (al.size() != 0){
				bean = ms.GetArticle((int)al.get(0).get("article_type"),(int)al.get(0).get("article_id"));
			}
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
	
	@RequestMapping(value="/carlist.html", method = RequestMethod.GET)
    public ModelAndView carlist(int pageNum) {        
		 ModelAndView view = new ModelAndView(); 
		 pager<Map<String,Object>> carlist = ms.GetCarList(pageNum, constant.DEFAULT_PAGE_SIZE);
         view.addObject("carlist",carlist);
         view.setViewName("/gateway/list/car/car_list");
         return view;
    } 
	
	@RequestMapping(value="/chosecar.html", method = RequestMethod.GET)
    public ModelAndView chosecar(int pageNum) {        
		 ModelAndView view = new ModelAndView(); 
		 pager<Map<String,Object>> carlist = ms.GetCarList(pageNum, constant.DEFAULT_PAGE_SIZE);
         view.addObject("carlist",carlist);
         view.setViewName("/gateway/online/chose_car");
         return view;
    } 
	
	@RequestMapping(value="/cardiscount.html", method = RequestMethod.GET)
    public ModelAndView cardiscount(int pageNum, int type) {        
		 ModelAndView view = new ModelAndView(); 
		 typeOfCar discount = null;
		 List<typeOfCar> discounts = ms.GetTypeOfCar();
		 if (type == 0){
			 if (discounts.size() != 0){
				 type = discounts.get(0).getType_id();
				 discount = discounts.get(0);
			 } 
		 } else {
			 for (typeOfCar typeOfCar : discounts) {
				if (typeOfCar.getType_id() == type){
					discount = typeOfCar;
				}
			}
		 }
		 pager<Map<String,Object>> carlist = ms.GetCarList(pageNum, constant.DEFAULT_PAGE_SIZE, type);
         view.addObject("carlist",carlist);
         view.addObject("discount",discount);
         view.addObject("discounts",discounts);
         view.setViewName("/gateway/list/car/car_discount_list");
         return view;
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
	
	@RequestMapping(value="/rentcar.html")
    public ModelAndView rent() {   
		 ModelAndView view = new ModelAndView(); 
		 view.setViewName("/gateway/online/rent_car");
         return view;
    } 
	
	@RequestMapping(value="/error.html")
    public ModelAndView error() {   
		 ModelAndView view = new ModelAndView(); 
		 view.setViewName("/gateway/error/error");
         return view;
    } 
	
	@RequestMapping(value="/nerror.html")
    public ModelAndView nerror() {   
		 ModelAndView view = new ModelAndView(); 
		 view.setViewName("/gateway/error/r_error");
         return view;
    }
	
	@RequestMapping(value="/success.html")
    public ModelAndView success() {   
		 ModelAndView view = new ModelAndView(); 
		 view.setViewName("/gateway/user/success");
         return view;
    }
	
	@RequestMapping(value="/user.html")
    public ModelAndView user() {   
		 ModelAndView view = new ModelAndView(); 
		 view.setViewName("/gateway/index/user");
         return view;
    }
	
	@RequestMapping(value="/lerror.html")
    public ModelAndView lerror() {   
		 ModelAndView view = new ModelAndView(); 
		 view.setViewName("/gateway/error/l_error");
         return view;
    }
	
	@RequestMapping(value="/perinfo.html")
    public ModelAndView perInfo(long a) {   
		 ModelAndView view = new ModelAndView();
		 System.out.println("页面传值 ： "+a);
		 System.out.println("实际值 : "+webGetDate.systemCurrentTimeMills());
		 System.out.println("相差 ： "+Math.abs(a - webGetDate.systemCurrentTimeMills()));
		 if (Math.abs(a - webGetDate.systemCurrentTimeMills()) < 300){
			 view.setViewName("/gateway/user/perinfo");
			 view.addObject("bookId",webGetDate.systemCurrentTimeMills());
		 } else {
			 view.setViewName("/gateway/error/normal_error");
			 view.addObject("msg","页面已超时，请重新预定车辆");
		 }
         return view;
    }
	
	@RequestMapping(value="/detaillist.html")
    public ModelAndView detailList(HttpSession session) {   
		 ModelAndView view = new ModelAndView();
		 user user = (user)session.getAttribute("user");
		 if (user != null){
			 int userId = ms.GetUserBean(user).getId();
			 user userForView = new user(ms.GetUserInfo(userId), userId, user.getName(), "", ms.GetUserBean(user).getPhone());
			 view.addObject("infos",userForView);
			 view.setViewName("/gateway/user/detaillist");
		 } else {
			 view.setViewName("/gateway/error/l_error");
		 }
         return view;
    }
}
