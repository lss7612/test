package facebookTest.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

import okhttp3.OkHttpClient;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FacebookService {

	OkHttpClient okHttpClient = new OkHttpClient.Builder().callTimeout(300, TimeUnit.SECONDS).build();
	Retrofit retrofit = new Retrofit.Builder().baseUrl(" https://graph.facebook.com/v9.0/").addConverterFactory(GsonConverterFactory.create()).client(okHttpClient).build();
	FacebookConnect conn = retrofit.create(FacebookConnect.class);
	String access_token = "EAAF0ICKIe54BAJ55d0G7H2ZAothZBZB2VZBr1VVEeGcOGAj13UHq9yQp81ibSgCHZCMKZA7lhe24MBjZC2unntsBQJ1Illa5N5BLZByMukkOpOcU0P8Cj8ZAOQQkZApSwWUb5Tk1scnlNJCTw4v8bZBaF7Om2EkGxWMUZASlFHCyjFo15EnBo0uzIhmhvgSgfUCHMNSwKYh0V6P88iFZCG5MWO8IS";
	Gson gson = new Gson();
	
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
