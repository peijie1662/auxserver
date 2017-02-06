package pj.com.cn.web.controller;

import java.io.File;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import Utils.ConvertUtils;
import pj.com.cn.web.model.RequestResult;

@Controller
public class UploadController {
	private static Logger logger = LoggerFactory
			.getLogger(UploadController.class);

	@RequestMapping(value = "/saveuploads", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	public @ResponseBody
	RequestResult upload(
			@RequestParam(value = "file", required = false) MultipartFile file,
			HttpServletRequest request) {

		String path = request.getSession().getServletContext()
				.getRealPath("lupload");
		String fileName = file.getOriginalFilename();
		File targetFile = new File(path, fileName);
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}
        //上传
		try {
			file.transferTo(targetFile);
			logger.info(" IP:" + request.getRemoteAddr()
					+ " Upload_New_File_Success: FileName = " + fileName);
			//转换格式为mp3
			fileName = ConvertUtils.convertFilename(fileName);
			ConvertUtils.changeToMp3(targetFile.getAbsolutePath(), "d:\\convert-mp3\\"+fileName+".mp3");
			return new RequestResult(true);
		} catch (Exception e) {
			logger.info(" IP:" + request.getRemoteAddr()
					+ " Upload_New_File_Failed: FileName = " + fileName);
			e.printStackTrace();
			return new RequestResult(false, e.getMessage());
		}
	}
}