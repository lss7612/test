package test.gsonTest;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

public class GsonTest01 {

	public static void main(String[] args) {
		
		Gson gson = new Gson();
		
		Map<String, Object> raw_promoted_obj= new HashMap<>();
		raw_promoted_obj.put("page_id", "101150715276202");
		
		Map<String,Object> raw_targeting = new HashMap<>();
		String[] facebook_position = {"feed"};
		raw_targeting.put("facebook_positions", facebook_position);
		raw_targeting.put("age_max" , 24);
		raw_targeting.put("age_min" , 20);
		
		Map<String, Object> param_of_behaviors01 = new HashMap<>();
		param_of_behaviors01.put("id", 6002714895372l);
		param_of_behaviors01.put("name", "All travelers");
		Map[] behaviors = {param_of_behaviors01};
		raw_targeting.put("behaviors", behaviors);
		
		int[] genders = {1};
		raw_targeting.put("genders",genders);
		
		Map<String,Object> param_of_cities01= new HashMap<>();
		param_of_cities01.put("key", 1280954);
//		param_of_cities01.put("radius", 10);
//		param_of_cities01.put("distance_unit", "kilometer");
		Map[] cities = {param_of_cities01};
		Map<String, Object> geo_locations = new HashMap<>();
		geo_locations.put("cities", cities);
		raw_targeting.put("geo_locations", geo_locations);
		
		Map<String,Object> param_of_interests01 = new HashMap<>();
		param_of_interests01.put("id", 6003087413192l);
		param_of_interests01.put("name", "야구");
		
		Map[] interests = {param_of_interests01};
		raw_targeting.put("interests", interests);
		
		Map<String,Object> param_of_life_events01 = new HashMap<>();
		param_of_life_events01.put("id", 6002714398172l);
		param_of_life_events01.put("name", "Newlywed (1 year)");
		
		Map[] life_events = {param_of_life_events01};
		raw_targeting.put("life_events", life_events);
		
		String[] publisher_platform = {"facebook", "audience_network"};
		raw_targeting.put("publisher_platforms", publisher_platform);
		
		
		
		
		Map<String, Object> parameter = new HashMap<>();
		parameter.put("name", "test_Adset");
		parameter.put("daily_budget", "100");
//		parameter.put("bid_amount", "100");
		parameter.put("billing_event", "CLICKS");
		parameter.put("optimization_goal", "REACH");
		parameter.put("campaign_id", "23847286566860471");
		parameter.put("promoted_object", gson.toJson(raw_promoted_obj));
		parameter.put("targeting", gson.toJson(raw_targeting));
		
		
		System.out.println(gson.toJson(parameter));
		
	}
	
}
