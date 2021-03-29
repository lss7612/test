package facebookTest.main;
import java.io.File;

import facebookTest.service.FacebookService;

public class TestMain {

	public static void main(String[] args) {
		
		FacebookService facebookService = new FacebookService();
		
		long addAccountId = 2879139602343254l;
//		facebookService.getTarget(addAccountId);
//		facebookService.makeTarget(addAccountId);
		String path = "C:\\Users\\이상성\\Desktop\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp3\\wtpwebapps\\Test\\resources\\repository\\";
		File uploadFile = new File(path+"Dog - 49330.mp4");
		System.out.println(uploadFile.getName());
		System.out.println(uploadFile.length());
		facebookService.uploadVideo("start",""+uploadFile.length(),null,null,null);
		
	}
	
}
