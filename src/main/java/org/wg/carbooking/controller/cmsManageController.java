package org.wg.carbooking.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.wg.carbooking.model.result;
import org.wg.carbooking.service.managerService;
import org.wg.carbooking.vo.typeOfCar;

@Controller
@RequestMapping(value = "cmsMg")
public class cmsManageController {

	private managerService ms;

	@Autowired
	public void setMs(managerService ms) {
		this.ms = ms;
	}

	@RequestMapping(value = "/getType")
	public @ResponseBody List<typeOfCar> typeOfCar() {
		return ms.GetTypeOfCar();
	}
	
	@RequestMapping(value = "/addType")
	public @ResponseBody result addType(String type_detail) {
		result rs = result.getInstance();
		if (ms.AddType(type_detail)){
			rs.setMsg("true");
		}
		return rs;
	}
	
	@RequestMapping(value = "/delType")
	public @ResponseBody result delType(String type_id) {
		result rs = result.getInstance();
		if (ms.DelType(Integer.parseInt(type_id))){
			rs.setMsg("true");
		}
		return rs;
	}
}
