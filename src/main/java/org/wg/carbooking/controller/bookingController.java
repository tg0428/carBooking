package org.wg.carbooking.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.wg.carbooking.service.managerService;
import org.wg.carbooking.utils.webGetDate;
import org.wg.carbooking.vo.carbook;
import org.wg.carbooking.vo.user;

@Controller
@RequestMapping(value = "booking")
public class bookingController {
	private managerService ms;

	@Autowired
	public void setMs(managerService ms) {
		this.ms = ms;
	}

	@RequestMapping(value = "/settime", method = RequestMethod.POST)
	public ModelAndView setTime(carbook mcar, HttpSession session) {

		ModelAndView view = new ModelAndView();
		if (session.getAttribute("user") != null) {
			if (ms.Login((user) session.getAttribute("user"))) {
				session.setAttribute("carbook", mcar);
				view.setViewName("redirect:/chosecar.html?pageNum=1");
			} else {
				view.setViewName("redirect:/lerror.html");
			}
		} else {
			view.setViewName("redirect:/lerror.html");
		}
		return view;
	}

	@RequestMapping(value = "/bookcar", method = RequestMethod.POST)
	public ModelAndView bookCar(int carBookId, HttpSession session) {
		ModelAndView view = new ModelAndView();
		if (session.getAttribute("user") != null) {
			carbook mcar = (carbook) session.getAttribute("carbook");
			mcar.setCarBookId(carBookId);
			session.setAttribute("carbook", mcar);
			view.setViewName("redirect:/perinfo.html?a=" + webGetDate.systemCurrentTimeMills());
		} else {
			view.setViewName("redirect:/lerror.html");
		}
		return view;
	}

	@RequestMapping(value = "/firmorder", method = RequestMethod.POST)
	public ModelAndView firmorder(carbook carbook, HttpSession session) {
		ModelAndView view = new ModelAndView();
		if (session.getAttribute("user") != null && session.getAttribute("carbook") != null) {
			carbook mcar = (carbook) session.getAttribute("carbook");
			user user = (user) session.getAttribute("user");
			user.setId(ms.GetUserBean(user).getId());
			mcar.setBookNum(carbook.getBookNum());
			mcar.setUserId(ms.GetUserBean(user).getId());
			mcar.setTips(carbook.getTips());
			mcar.setContact(carbook.getContact());
			ms.BookCar(mcar);
			session.removeAttribute("carbook");
			view.setViewName("/gateway/alert/alert");
			view.addObject("msg", "订单编号为 ：" + mcar.getBookNum() + "  车辆编号：" + mcar.getCarBookId() + " 稍后我们将会与您联系！");
		} else if (session.getAttribute("carbook") == null) {
			view.setViewName("/gateway/error/car_error");
		} else if (session.getAttribute("user") == null) {
			view.setViewName("redirect:/lerror.html");
		}
		return view;
	}

}
