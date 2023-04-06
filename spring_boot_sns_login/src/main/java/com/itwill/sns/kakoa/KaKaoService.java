package com.itwill.sns.kakoa;

import java.io.IOException;
import java.net.URI;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class KaKaoService {
	/***************************************************
	 * 인가코드로 토큰받기
	 *****************************************************/
	@Value("${api.kakao.rest_api_key}")
	private String kakaoRestApiKey;

	@Value("${api.kakao.javascript_key}")
	private String kakaoJavascriptApiKey;
	
	@Value("${api.kakao.redirect_url}")
	private String redirect_url;

	public String getToken(String code) throws IOException {
		String kakaoAuthUrl = "https://kauth.kakao.com";
		String reqUrl = "/oauth/token";
		String accessToken = "";

		RestTemplate restTemplate = new RestTemplate();
		URI uri = URI.create(kakaoAuthUrl + reqUrl);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		headers.add("Accept", "application/json");
		MultiValueMap<String, Object> parameters = new LinkedMultiValueMap<String, Object>();
		parameters.set("grant_type", "authorization_code");
		parameters.set("client_id", kakaoRestApiKey);
		parameters.set("redirect_uri", redirect_url);
		parameters.set("code", code);
		HttpEntity<MultiValueMap<String, Object>> restRequest = new HttpEntity<>(parameters, headers);
		//http요청
		ResponseEntity<JSONObject> apiResponse = restTemplate.postForEntity(uri, restRequest, JSONObject.class);
		JSONObject responseBody = apiResponse.getBody();
		System.out.println(responseBody);
		
		accessToken = (String) responseBody.get("access_token");
		return accessToken;
	}

	/*********************************************
	 * 카카오아이디얻기
	 *********************************************/
	public String getKakaoId(String accessToken) throws Exception {
		String kakaoUniqueNo = "";
		String kakaoApiUrl = "https://kapi.kakao.com";
		// restTemplate을 사용하여 API 호출
		RestTemplate restTemplate = new RestTemplate();
		String reqUrl = "/v2/user/me";
		URI uri = URI.create(kakaoApiUrl + reqUrl);

		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "bearer " + accessToken);
		headers.set("KakaoAK", kakaoRestApiKey);

		MultiValueMap<String, Object> parameters = new LinkedMultiValueMap<String, Object>();

		HttpEntity<MultiValueMap<String, Object>> restRequest = new HttpEntity<>(parameters, headers);
		ResponseEntity<JSONObject> apiResponse = restTemplate.postForEntity(uri, restRequest, JSONObject.class);
		JSONObject responseBody = apiResponse.getBody();
		kakaoUniqueNo = (Long) responseBody.get("id") + "";
		return kakaoUniqueNo;
	}

	/*********************************************
	 * 카카오유저정보얻기
	 *********************************************/
	public KakaoProfile getKakaoProfile(String accessToken) throws Exception {
		String kakaoApiUrl = "https://kapi.kakao.com";
		
		RestTemplate restTemplate = new RestTemplate();
		String reqUrl = "/v2/user/me";
		URI uri = URI.create(kakaoApiUrl + reqUrl);
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "bearer " + accessToken);
		headers.set("KakaoAK", kakaoRestApiKey);
		MultiValueMap<String, Object> parameters = new LinkedMultiValueMap<String, Object>();
		HttpEntity<MultiValueMap<String, Object>> entity = new HttpEntity<>(parameters, headers);
		ResponseEntity<String> kakaoResponseEntity = restTemplate.postForEntity(uri, entity, String.class);
		
		String kakaoProfileStr= kakaoResponseEntity.getBody();
		System.out.println(">>>"+kakaoProfileStr);
		
		ObjectMapper objectMapper = new ObjectMapper();
		KakaoProfile kakaoProfile = objectMapper.readValue(kakaoProfileStr, KakaoProfile.class);
		System.out.println("카카오 아이디(번호) : " + kakaoProfile.getId());
		System.out.println("카카오 이메일 : " + kakaoProfile.getKakao_account().getEmail());

		/*****************
		 * { "id":2717242759, "connected_at":"2023-03-22T06:20:29Z", "kakao_account":{
		 * "profile_nickname_needs_agreement":false,
		 * "profile_image_needs_agreement":false, "profile":{ "nickname":"김경호",
		 * "thumbnail_image_url":"http:\/\/k.kakaocdn.net\/dn\/dRK0M7\/btrYsai9oLx\/xXgccXzE3jBZfDEryf9Z8K\/img_110x110.jpg",
		 * "profile_image_url":"http:\/\/k.kakaocdn.net\/dn\/dRK0M7\/btrYsai9oLx\/xXgccXzE3jBZfDEryf9Z8K\/img_640x640.jpg",
		 * "is_default_image":false }, "has_email":true, "email_needs_agreement":false,
		 * "is_email_valid":true, "is_email_verified":true,
		 * "email":"guard884@gmail.com"}, "properties":{ "nickname":"김경호",
		 * "profile_image":"http:\/\/k.kakaocdn.net\/dn\/dRK0M7\/btrYsai9oLx\/xXgccXzE3jBZfDEryf9Z8K\/img_640x640.jpg"
		 * ,"thumbnail_image":"http:\/\/k.kakaocdn.net\/dn\/dRK0M7\/btrYsai9oLx\/xXgccXzE3jBZfDEryf9Z8K\/img_110x110.jpg"
		 * } }
		 ***********************/
		return kakaoProfile;
	}

}
