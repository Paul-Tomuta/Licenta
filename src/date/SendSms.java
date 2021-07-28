package date;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.HashMap;
import java.net.http.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SendSMS {
	private String numar;
	private String mesaj;
	
	public SendSMS(String nr, String msg) {
		
		this.numar=nr;
		this.mesaj=msg;
		
	}

	public void send() {

		String authkey = "";
		String numar = this.numar;
		String senderId = "";
		String mesaj = this.mesaj;
		String route = "default";


		String mainUrl = "";

		
		var values = new HashMap<String, String>();
		values.put("content", mesaj);
		values.put("to", numar);
		values.put("country_code", "RO");
		values.put("device_id", senderId);

		var objectMapper = new ObjectMapper();
		String requestBody = null;
        try {
			requestBody = objectMapper.writeValueAsString(values);
		} catch (JsonProcessingException e1) {
			e1.printStackTrace();
		}
        
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
		        .uri(URI.create(mainUrl))
		        .setHeader("Content-Type", "application/json")
		        .setHeader("Authorization", "Token " + authkey)
		        .POST(HttpRequest.BodyPublishers.ofString(requestBody))
		        .build();
		
		HttpResponse<String> response = null;
		try {
			response = client.send(request,
			        HttpResponse.BodyHandlers.ofString());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

        System.out.println(response.body());
	}
}