package facebookTest.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

import okhttp3.OkHttpClient;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Service
public class FacebookService {

	OkHttpClient okHttpClient = new OkHttpClient.Builder().callTimeout(300, TimeUnit.SECONDS).build();
	Retrofit retrofit = new Retrofit.Builder().baseUrl(" https://graph.facebook.com/v9.0/").addConverterFactory(GsonConverterFactory.create()).client(okHttpClient).build();
	FacebookConnect conn = retrofit.create(FacebookConnect.class);
	String access_token = "EAAF0ICKIe54BAJZCky5XXRh3MIiSFjHcPPbO6g7cZBuxpYkDW9ZCp0vPqeGwwPvVbQZAuksvmQF4unZB0nGm5XzV9NpoYoAxtACIAenr2pDPYv4tgbZAM4yZAIK3h3FnsIfWs2vxI1DtCXt8gVrDnmZBtUsgz58DjcItbHhAUJ0gAY01UwhuldVo2xKyIVbZBKZCDsPMWrOgtxmzGOpK4wTvWsYnB5hCIkgXI7OgKPAjL4blFC30eLc6UUw6IjYbDK5CUZD";
	String page_id = "110801257752999";
	Gson gson = new Gson();
	
	public boolean uploadVideo(
			String upload_phase
			, String file_size
			, String start_offset
			, String end_offset
			, String upload_session_id) {
		Map<String,Object> fields = new HashMap<>();
		//매개변수가 null이 아닐때만 fields에 put한다.
		if(upload_phase!=null) fields.put("upload_phase", upload_phase);
		if(file_size!=null) fields.put("file_size", file_size);
		if(start_offset!=null) fields.put("start_offset", start_offset);
		if(end_offset!=null) fields.put("end_offset", end_offset);
		if(upload_session_id!=null) fields.put("upload_session_id", upload_session_id);
		fields.put("access_token", access_token); //access_token은 필수
		System.out.println(fields);
		
		try {
			if(start_offset!=null&&end_offset!=null&&start_offset==end_offset) {
				Response<Map<String,Object>> result = conn.uploadVideo(page_id, fields).execute();
				if(result.body().get("success")=="true") {
					return true;
				};
			}
			Response<Map<String,Object>> result = conn.uploadVideo(page_id, fields).execute();
			System.out.println("+ + + + + + + + + + + + 페이스북 서버와 통신합니다. + + + + + + + + + + + +");
			System.out.println("+ + + + + + + + + + + + fields는 아래와 같습니다.+ + + + + + + + + + + +");
			System.out.println(fields);
			System.out.println("+ + + + + + + + + + + +result입니다 : "+result);
			System.out.println("+ + + + + + + + + + + +result.body입니다 : "+result.body());
			System.out.println("+ + + + + + + + + + + +result.errorBody().string()입니다 : "+result.errorBody().string());
			System.out.println();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return false;
	};
	
	public void getTarget(long adAccountId) {
		
		try {
			Response<Map<String,Object>> result = conn.getTarget(adAccountId,access_token).execute();
			System.out.println(gson.toJson(result.body()));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/*
	 * 맞춤 타겟을 생성하기위한 연습코드
	 */
	public void makeTarget(long adAccountId) {
		
		String name = "My Adset";
		String optimization_goal = "REACH";
		String billing_event = "IMPRESSIONS";
		String bid_amount = "2";
		String daily_budget = "1000";
		String campaign_id = "23847328233710471";
		String status = "ACTIVE";
		
		Map<String,Object> custom_location_param01 = new HashMap<>();
		custom_location_param01.put("latitude", "36");
		custom_location_param01.put("longitude", "-121.0");
		custom_location_param01.put("radius", "5");
		custom_location_param01.put("distance_unit", "kilometer");
		Map[] custom_locations = {custom_location_param01};
		String[] location_types = {"recent","home"};
		Map<String, Object> targeting = new HashMap<>();
		Map<String,Object> geo_locations = new HashMap<>();
		geo_locations.put("custom_locations", custom_locations);
		geo_locations.put("location_types",location_types);
		targeting.put("geo_locations", geo_locations);
		
		Map<String,Object> fields = new HashMap<>();
		fields.put("name",name);
		fields.put("optimization_goal",optimization_goal);
		fields.put("billing_event",billing_event);
		fields.put("bid_amount",bid_amount);
		fields.put("daily_budget",daily_budget);
		fields.put("campaign_id",campaign_id);
		fields.put("status",status);
		fields.put("targeting",targeting);
		
		System.out.println(gson.toJson(fields));
		
		try {
			Response<Map<String,Object>> result = conn.makeAdset(adAccountId, fields, access_token).execute();
			System.out.println(result);
			System.out.println(result.body());
			System.out.println(result.errorBody().string());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
