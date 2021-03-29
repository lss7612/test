package facebookTest.controller;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileSaveTest {

	@Autowired ServletContext context;
	
	@GetMapping("/chunk_test")
	public String chunkFileTest() {
		return "/facebook/chunk_test";
	}
	
	@GetMapping("/video_repository")
	public String kubrickVideoRepository() {
		return "/facebook/video_repository";
	}
	
	@PostMapping("/chunk_test_ajax")
	@ResponseBody
	public Map<String,Object> getFileAjax(MultipartFile file) {
		System.out.println(file);
		System.out.println(file.getOriginalFilename());
		System.out.println(file.getSize());
		
		File getFile = ConvertMultipartFileToFile(file);
		File storedFile = saveFile(getFile);
		
		Map<String,Object> result = new HashMap<String, Object>();
		result.put("result", "success");
		return result;
	}
	
	@GetMapping("/repository/getfilelist")
	@ResponseBody
	public Map<String,Object> getFileList(){
		Map<String,Object> result = new HashMap<>();
		File repository = new File(context.getRealPath("resources/repository"));
		result.put("fileList", repository.listFiles());
		System.out.println(result);
		return result;
	}
	
	private File saveFile(File saveFile) {
		//디렉토리폴더 지정
		String storedPath = context.getRealPath("resources/repository");
		
		File repository = new File(storedPath);
		if(!repository.exists()) repository.mkdir();
		System.out.println(repository.getPath());
		
		
		File stored = new File(storedPath,saveFile.getName());
		
		try {
			FileInputStream fis = new FileInputStream(saveFile);
			FileOutputStream fos = new FileOutputStream(stored);
			int fileByte = 0;
			while((fileByte=fis.read())!=-1) {
				fos.write(fileByte);
			}
			fis.close();
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return stored;
	}
	
	
	
	private File ConvertMultipartFileToFile(MultipartFile file) {
		File get = new File(file.getOriginalFilename());
		if(file.getSize()!=0) {
			try {
				get.createNewFile();
				FileOutputStream fos = new FileOutputStream(get);
				fos.write(file.getBytes());
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return get;
	}
	
	
	
}
