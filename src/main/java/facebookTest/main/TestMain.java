package facebookTest.main;
import facebookTest.service.FacebookService;

public class TestMain {

	public static void main(String[] args) {
		
		FacebookService facebookService = new FacebookService();
		
		long addAccountId = 2879139602343254l;
//		facebookService.getTarget(addAccountId);
		facebookService.makeTarget(addAccountId);
		
	}
	
}
