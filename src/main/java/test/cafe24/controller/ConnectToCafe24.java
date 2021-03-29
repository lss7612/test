package test.cafe24.controller;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ConnectToCafe24 {

	@FormUrlEncoded
	@POST("oauth/token")
	public Call<Map<String,Object>> getAccessCode(
				@Header("Authorization") String authorization
				,@Field("grant_type") String grant_type
				, @Field("code") String code
				, @Field("redirect_uri") String redirect_uri
			);


}
