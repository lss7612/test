package tests.googleAPITest;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Controller;

import googleAPITest.send_request_to_Google.Get_Auth_Token_retrofit;
import okhttp3.OkHttpClient;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Controller
public class TestMain {

	OkHttpClient okHttpClient = new OkHttpClient.Builder().readTimeout(90, TimeUnit.SECONDS).build();
	

	Retrofit getting_auth_token_url_retrofit = new Retrofit.Builder()
															.baseUrl("https://accounts.google.com/o/oauth2/v6/")
															.client(okHttpClient)
															.addConverterFactory(GsonConverterFactory.create())
															.build();
	private Get_Auth_Token_retrofit getAuthToken = getting_auth_token_url_retrofit.create(Get_Auth_Token_retrofit.class);
	
	private static final String client_id = "624023799723-ftk48aaq2m6bg9tpt5p1ig2mf8gjm6a5.apps.googleusercontent.com";
	private static final String client_secret = "cVZJBNb9BaAsNYffaYKriPdp";
	private static final String code = "4/1AY0e-g5XHSnl2v5bx9MifU0sasznD5iRyeEK8QFieS6hbw41mhEwnD7nDGg";
	private static final String redirect_uri = "urn:ietf:wg:oauth:2.0:oob";
	private static final String grant_type = "authorization_code";
	
	public static void main(String[] args) {
		
		TestMain main = new TestMain();
		
		try {
			Map<String,Object> authObj = main.getAuthObj();
			Response<Map<String,Object>> auth_token_obj = main.getAuthToken.get(authObj).execute();
			System.out.println("body: " + auth_token_obj);
			System.out.println(auth_token_obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}


	private Map<String, Object> getAuthObj() {
		
		Map<String, Object> authObj = new HashMap<>();
		authObj.put("code", code);
		authObj.put("client_id", client_id);
		authObj.put("client_secret", client_secret);
		authObj.put("redirect_url", redirect_uri);
		authObj.put("grant_type", grant_type);
		
		return authObj;
	}
	
}
