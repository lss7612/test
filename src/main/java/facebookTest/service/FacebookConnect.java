package facebookTest.service;

import java.util.Map;


import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface FacebookConnect {

	@GET("act_{ad_account_id}/adsets?fields=targeting")
	public Call<Map<String, Object>> getTarget(@Path("ad_account_id")long adAccountId, @Query("access_token") String access_token);

	@FormUrlEncoded
	@POST("act_{ad_account_id}/adsets")
	public Call<Map<String,Object>> makeAdset(@Path("ad_account_id")long adAccountId, @FieldMap Map<String, Object> fields, @Field("access_token") String access_token);
	
}
