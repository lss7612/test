package test.cafe24.controller;

import java.io.IOException;
import java.util.Base64;
import java.util.Base64.Encoder;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import okhttp3.OkHttpClient;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Controller
public class Oauth {

	private final String client_id = "YIx19lL9FFhkX3Xu0XQEPC";
	private final String client_secret = "gauEdbNXMtqpS0t1cx6qCB";
	
	
	private OkHttpClient okHttpClient = new OkHttpClient.Builder()
			.readTimeout(90, TimeUnit.SECONDS)
			.build();
	
	private Retrofit cafe24Rest = new Retrofit.Builder()
			.baseUrl("https://armyring.cafe24api.com/api/v2/")
			.client(okHttpClient)
			.addConverterFactory(GsonConverterFactory.create())
			.build();
	ConnectToCafe24 conn = cafe24Rest.create(ConnectToCafe24.class);
	
	@GetMapping("/cafe24/authorization_code")
	public void getOauthCode() {}
	
	@PostMapping("/cafe24/authorization_code")
	@ResponseBody
	public String getAccessCode(String code) {
		
		Encoder encoder = Base64.getEncoder();
		String Authorization = "Basic " + new String(encoder.encode((client_id+":"+client_secret).getBytes()));
		String grant_type = "authorization_code";
		String redirect_uri = "https://www.optimize-mkt.kr/customer/test/cafe24/finished";
		System.out.println(Authorization);
		System.out.println(grant_type);
		System.out.println(redirect_uri);
		System.out.println(code);
		try {
			Response<Map<String,Object>> result = conn.getAccessCode(Authorization,grant_type,code,redirect_uri).execute();
			System.out.println(result);
			if(result.errorBody()!=null) {
				System.out.println("error : "+result.errorBody().string());
				return "{\"isSucess\":\"false\"}";
			}
			System.out.println("result : " + result.body());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "{\"isSucess\":\"true\"}";
	}
	
}
;