package org.wg.carbooking.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.wg.carbooking.model.result;
import org.wg.carbooking.service.managerService;
import org.wg.carbooking.utils.pictureCatch;
import org.wg.carbooking.vo.article;
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
	public @ResponseBody List<Map<String, Object>> carOfList() {
		return ms.GetCarList();
	}

	@RequestMapping(value = "/getUserList")
	public @ResponseBody List<Map<String, Object>> userOfList() {
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
		List<car> mcl = ms.GetCarOfType(Integer.parseInt(type_id));

		/** 删除优惠类型车辆图片存盘信息 */
		for (car car : mcl) {
			delFile(car.getImage_url());
		}
		if (ms.DelType(Integer.parseInt(type_id))) {
			rs.setMsg("true");
		}
		return rs;
	}

	@RequestMapping(value = "/addCar", method = RequestMethod.POST)
	public @ResponseBody result addFile(car car, HttpServletRequest req) throws IOException {

		MultipartFile file = car.getFile();
		String destinationDir = req.getSession().getServletContext().getRealPath("/upload");
		long timeStamp = System.currentTimeMillis();

		if (file != null) {

			/** 将获取到的多媒体文件流拷贝到项目本地upload目录中 */

			FileUtils.copyInputStreamToFile(file.getInputStream(),
					new File(destinationDir, timeStamp + file.getContentType().replace("image/", ".")));
			car.setImage_url(destinationDir + "\\" + timeStamp + file.getContentType().replace("image/", "."));
			car.setImage_server_url(req.getSession().getServletContext().getContextPath() + "/upload/" + timeStamp
					+ file.getContentType().replace("image/", "."));
		}

		ms.AddCar(car);
		rs.setMsg("true");
		return rs;
	}

	@RequestMapping(value = "/updataCar", method = RequestMethod.POST)
	public @ResponseBody result updataCar(car car, HttpServletRequest req) throws IOException {
		MultipartFile file = car.getFile();
		String destinationDir = req.getSession().getServletContext().getRealPath("/upload");
		long timeStamp = System.currentTimeMillis();

		if (file != null) {

			/** 1.删除旧图片 */
			delFile(ms.GetCarBean(car.getCar_id()).getImage_url());
			/** 2.将获取到的多媒体文件流拷贝到项目本地upload目录中 */

			FileUtils.copyInputStreamToFile(file.getInputStream(),
					new File(destinationDir, timeStamp + file.getContentType().replace("image/", ".")));
			car.setImage_url(destinationDir + "\\" + timeStamp + file.getContentType().replace("image/", "."));
			car.setImage_server_url(req.getSession().getServletContext().getContextPath() + "/upload/" + timeStamp
					+ file.getContentType().replace("image/", "."));
		}
		ms.UpdCar(car);
		rs.setMsg("true");
		return rs;
	}

	@RequestMapping(value = "/getPictures")
	public ModelAndView getPictures(HttpServletRequest req) throws IOException {
		String url = req.getSession().getServletContext().getRealPath("/ueditor");
		List<String> fileUrls = pictureCatch.getServerPicturePaths(url);
		List<String> serverPictures = new ArrayList<String>();
		for (String s : fileUrls) {
			String str = s.substring(s.indexOf("\\ueditor"), s.length()).replace("\\", "/");
			serverPictures.add(req.getSession().getServletContext().getContextPath() + str);
		}
		ModelAndView view = new ModelAndView();
		view.addObject("pictures", serverPictures);
		view.setViewName("/template/cms/picList");
		return view;
	}

	@RequestMapping(value = "/delPic", method = RequestMethod.POST)
	public @ResponseBody result delPic(String url, HttpServletRequest req) throws IOException {
		String filePath = req.getSession().getServletContext().getRealPath(url);
		System.out.println(filePath);
		if (delFile(filePath)) {
			rs.setMsg("true");
		}
		return rs;
	}

	@RequestMapping(value = "/delCar", method = RequestMethod.POST)
	public @ResponseBody result delCar(car car) {
		String url = ms.GetCarBean(car.getCar_id()).getImage_url();
		if (ms.DelCar(car) && delFile(url)) {
			rs.setMsg("true");
		}
		return rs;
	}

	@RequestMapping(value = "/delArticle", method = RequestMethod.POST)
	public @ResponseBody result delArticle(article article) {
		if (ms.delArticle(article.getArticle_id())) {
			rs.setMsg("true");
		}
		return rs;
	}

	@RequestMapping(value = "/publish", method = RequestMethod.POST)
	public @ResponseBody result publish(article article) {
		if (ms.addArticle(article)) {
			rs.setMsg("true");
		}
		return rs;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody result update(article article) {
		if (ms.updateArticle(article)) {
			rs.setMsg("true");
		}
		return rs;
	}

	@RequestMapping(value = "/getList", method = RequestMethod.GET)
	public @ResponseBody List<Map<String, Object>> getList(int type) {
		return ms.getArticleList(type);
	}

	public boolean delFile(String url) {
		File file = new File(url);
		return file.delete();
	}

	/**
	 * 捕获图片上传异常信息，以json对象的形式返回result对象
	 */
	@ExceptionHandler(Exception.class)
	public @ResponseBody result handleException(Exception ex, HttpServletRequest request) {
		if (ex instanceof org.springframework.web.multipart.MaxUploadSizeExceededException) {
			rs.setMsg("图片上传大小不能超过2M");
		}
		return rs;
	}
}
