package facebookTest.controller;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import facebookTest.service.FacebookService;

@Controller
public class FileChunkTest {
	@Autowired FacebookService facebookService;
	@GetMapping("/facebook/sendfile")
	public void sendFilePage() {}
	
	@PostMapping("/facebook/sendfile")
	@ResponseBody
	public Map<String,Object> sendfile(){
		
		String path = "C:\\Users\\이상성\\Desktop\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp3\\wtpwebapps\\Test\\resources\\repository\\";
		File uploadFile = new File(path+"Dog - 49330.mp4");
		
		Map<String,Object> result = new HashMap<>();
		result.put("success", facebookService.uploadVideo("start",""+uploadFile.length(),null,null,null));
		return result;
	}
	
}
