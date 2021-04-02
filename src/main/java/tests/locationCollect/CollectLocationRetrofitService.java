package tests.locationCollect;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface CollectLocationRetrofitService {

	@FormUrlEncoded
	@POST("/restorantfind/find")
	Call<Map<String, Object>> getLocationInfo(@Field("query_location")String query_location, @Field("query_food")String query_food, @Field("sort")String sort);

	@FormUrlEncoded
	@POST("/customer/test/coordinate")
	Call<Map<String, Object>> insertCoordinate(@Field("name")String name, @Field("latitude")double latitude, @Field("longitude")double longitude);
	
}
