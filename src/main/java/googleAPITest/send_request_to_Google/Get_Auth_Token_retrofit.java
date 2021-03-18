package googleAPITest.send_request_to_Google;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Get_Auth_Token_retrofit {

	@FormUrlEncoded
	@POST("token")
	public Call<Map<String, Object>> get(@FieldMap(encoded = true) Map<String, Object> authObj);

	@GET("token")
	public Call<Map<String, Object>> getStrings(@Query("clientId") String clientId,@Query("clientSecret") String clientSecret,@Query("code") String code,@Query("redirectUrl") String redirectUrl,
			@Query("grantType") String grantType);

	
	
}
