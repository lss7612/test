package googleAPITest.controller;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.auth.oauth2.ClientId;
import com.google.auth.oauth2.UserAuthorizer;
import com.google.common.collect.ImmutableList;

@Controller
public class GoogleTestController {
	private static final ImmutableList<String> SCOPES =
			      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/adwords").build();
	private static final String CALLBACK_URI = "urn:ietf:wg:oauth:2.0:oob";
	
	@GetMapping("/")
	public String home() {
		return "/home/home";
	}
	
	@GetMapping("/google/tokens/auth_token")
	public void googleTestService() {}
	
	@PostMapping("/google/tokens/auth_token")
	public @ResponseBody Map<String,Object> runExample(String clientId, String clientSecret) throws IOException {
		
	    UserAuthorizer userAuthorizer =
            UserAuthorizer.newBuilder()
                .setClientId(ClientId.of(clientId, clientSecret))
                .setScopes(SCOPES)
                .setCallbackUri(URI.create(CALLBACK_URI))
                .build();
        URL authorizationUrl = userAuthorizer.getAuthorizationUrl(null, null, null);
        Map<String, Object> result = new HashMap<>();
        result.put("authorizationUrl", ""+authorizationUrl);
        
        return result;
  }
	
}
