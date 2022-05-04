package com.yedam.forecast.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.yedam.app.common.PropertiesPair;

public class ForecastService {
	
	//동네예보 - 육상예보조회
	public static List<WeatherInfo> getWeatherForecast(){
		
		String key ="e6j1jMjniVoGOfHvxnb29lR8sTAW5BeDbd/s7BOgwHA6tEEPhf4zmrG3T6QUPWuwTHFV/ubJCtJvSdSPKA40Fg==";
		
		//요청URL
		String servicesURL ="http://apis.data.go.kr/1360000/VilageFcstMsgService/getLandFcst?";		//get방식
		
		List<PropertiesPair> params = new ArrayList<PropertiesPair>();
		
		params.add(new PropertiesPair("ServiceKey", key));
		params.add(new PropertiesPair("pageNo", "1"));
		params.add(new PropertiesPair("numOfRows", "10"));
		params.add(new PropertiesPair("dataType", "JSON"));
		params.add(new PropertiesPair("regId", "11A00101"));
		
		StringBuilder sb = new StringBuilder();
		
		try {
			String paramURL = PropertiesPair.getQuery(params);	//인코딩때문에 try catch문....
			
			String requestURL = servicesURL + paramURL;
			URL url = new URL(requestURL);
			
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("GET");	//무슨 방식으로 할지 지정하는 것
			con.setRequestProperty("content-type", "application/json");		//content-type 뭐로 보낼지(json인지 xml인지 등등) application/json json형태로 보낼꺼다
			
			if(con.getResponseCode() == HttpURLConnection.HTTP_OK) {
				BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
				String line;
				while((line = br.readLine()) != null) {
					sb.append(line);
				}
				br.close();
			} else {
				System.out.println(con.getResponseMessage());
			}
			con.disconnect();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String jsonResult = sb.toString();
//		System.out.println(jsonResult);
//		return null;
		
		return getWeatherData(jsonResult);
		
	}
	
	//jsonSimple
	private static List<WeatherInfo> getWeatherData(String jsonData) {
		List<WeatherInfo> list = new ArrayList<>();
		
		//파싱
		try {
			JSONParser	parser = new JSONParser();
			
			JSONObject forecastData = (JSONObject)parser.parse(jsonData);
			JSONObject response = (JSONObject)forecastData.get("response");
			JSONObject body = (JSONObject)response.get("body");
			JSONObject items = (JSONObject)body.get("items");
			JSONArray item = (JSONArray)items.get("item");
			
			for(int i=0; i<item.size(); i++) {
				JSONObject data = (JSONObject)item.get(i);
				WeatherInfo info = new WeatherInfo();
				
				//발표시간 - 필수값
				//info.setAnnounceTime((long)data.get("announceTime"));
				info.setAnnounceTime(Long.parseLong(data.get("announceTime").toString()));
				//발표번호 - 옵션
				info.setNumEf((data.get("numEf") == null)? 0 : (long)data.get("numEf"));
				//예보구역코드 - 필수값
				info.setRegId((String)data.get("regId"));
				//강수활률 - 옵션
				//info.setRnSt((data.get("rnSt") == null)? 0.0 : (double)data.get("rnst"));
				info.setRnSt(Double.parseDouble(data.get("announceTime").toString()));
				//강수형태 - 필수
				info.setRnYn((long)data.get("rnYn"));
				//예상기온 - 옵션
				info.setTa((data.get("ta") == null)? null : (String)data.get("ta"));
				//날씨 - 필수
				info.setWf((String)data.get("wf"));
				//하늘상태 - 필수
				info.setWfCd((String)data.get("wfCd"));
				//풍속 강도코드 - 필수
				info.setWsIt((String)data.get("wsIt"));
				
				list.add(info);
			}
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return list;
	}

}
