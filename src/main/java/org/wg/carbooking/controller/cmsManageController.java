package org.wg.carbooking.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.wg.carbooking.model.result;
import org.wg.carbooking.service.managerService;
import org.wg.carbooking.vo.car;
import org.wg.carbooking.vo.typeOfCar;

@Controller
@RequestMapping(value = "cmsMg")
public class cmsManageController {

	private managerService ms;
	private result rs = result.getInstance();

	@Autowired
	public void setMs(managerService ms) {
		this.ms = ms;
	}

	@RequestMapping(value = "/getType")
	public @ResponseBody List<typeOfCar> typeOfCar() {
		return ms.GetTypeOfCar();
	}
	
	@RequestMapping(value = "/getCarList")
	public @ResponseBody List<Map<String,Object>> carOfList() {
		return ms.GetCarList();
	}
	
	@RequestMapping(value = "/getUserList")
	public @ResponseBody List<Map<String,Object>> userOfList() {
		return ms.GetUserList();
	}

	@RequestMapping(value = "/addType")
	public @ResponseBody result addType(String type_detail) {
		if (ms.AddType(type_detail)) {
			rs.setMsg("true");
		}
		return rs;
	}

	@RequestMapping(value = "/delType")
	public @ResponseBody result delType(String type_id) {
		result rs = result.getInstance();
		if (ms.DelType(Integer.parseInt(type_id))) {
			rs.setMsg("true");
		}
		return rs;
	}

	@RequestMapping(value = "/addCar", method = RequestMethod.POST)
	public @ResponseBody result addFile(car car, HttpServletRequest req) throws IOException {
		
		MultipartFile file = car.getFile();
		String destinationDir = req.getSession().getServletContext().getRealPath("/upload");
		
		if (!file.isEmpty()) {
			
			/**将获取到的多媒体文件流拷贝到项目本地upload目录中*/
			
			FileUtils.copyInputStreamToFile(file.getInputStream(), new File(destinationDir,
					System.currentTimeMillis() + file.getOriginalFilename()));
			car.setImage_url(destinationDir + System.currentTimeMillis() + file.getOriginalFilename());
			ms.AddCar(car);
			rs.setMsg("true");
			return rs;
		}
		
		rs.setMsg("false");
		return rs;
	}
}
