package tests.csvTest;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TEST02_CSV_file_view {

	
	@Autowired
	ServletContext context;
	
	@GetMapping(value = "/csv_file_view")
	public String csv_file_view(Model model) {
	
		String path = context.getRealPath("resources/csvTest"); 
		File f = new File(path);
		File[] fileList = f.listFiles();
		Map<String,Object> fileMap = new HashMap<>();
		for(int i = 0; i < fileList.length; i++){
			System.out.println("name : " + fileList[i].getName() + ", path : " + fileList[i].getPath());
			String filePath = fileList[i].getPath().replace("\\", "/");
			fileMap.put(fileList[i].getName(), filePath);
		}
		model.addAttribute("fileList", fileMap);
		return "/csv/csv_file_view";
	}
	
}
