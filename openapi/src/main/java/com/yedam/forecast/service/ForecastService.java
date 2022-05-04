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

import com.yedam.app.common.PropertiesPair;

public class ForecastService {
	// 동네예보 - 육상예보조회(GET방식)
	public static List<WeatherInfo> getWeatherForecast() {
		// key 값복사
		String key = "060g7WLomkuSC7A4SJM6hRf4jmZBMeriB/yUVpuMVN0oUhV84xJhM9M3ByAPGLoI/Fso6tlexL8OOtViiHaEBw==";
		// 요청 URL 주소
		String serviceURL = "http://apis.data.go.kr/1360000/VilageFcstMsgService/getLandFcst?";
		
		//PropertiesPair타입에 Arraylist에 각 키와 값들을 추가한다.
		List<PropertiesPair> params = new ArrayList<PropertiesPair>();
					
		params.add(new PropertiesPair("ServiceKey", key));
		params.add(new PropertiesPair("pageNo", "1"));
		params.add(new PropertiesPair("numOfRows", "10"));
		params.add(new PropertiesPair("dataType", "JSON"));
		params.add(new PropertiesPair("regId", "11A00101"));
		
		//문자열 빠른 처리
		StringBuilder sb = new StringBuilder();
		
		try {
			// 읽어올 key와 value가 저장된 값들을 읽어와 paramURL에 저장.
			String paramURL = PropertiesPair.getQuery(params);
			// 최종 URL을 생성
			String requestURL = serviceURL + paramURL;
			// URL 인스턴스를 생성하여 요청 URL을 읽어옴.  실제 사용될 URL
			URL url = new URL(requestURL);
			// 통신 연결.
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			//요청방법을 GET으로 설정
			con.setRequestMethod("GET");
			// 응답형식설정.
			con.setRequestProperty("Content-type", "application/json"); 
			
			if(con.getResponseCode() == 200) {
				//inputsteam을 통해 데이터가 들어옴.
				BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
				String line; // 임시로 받을 변수
				while((line=br.readLine()) != null) {
					sb.append(line);
					
				}
				br.close();
			} else {
				// 연결이 안될 시 메세지 출력.
				System.out.println(con.getResponseMessage());
			}
			con.disconnect(); // 통신을 끊음.
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String jsonResult = sb.toString();
		return getWeatherdata(jsonResult);
	}
	
	private static List<WeatherInfo> getWeatherdata(String jsonData) {
		List<WeatherInfo> list = new ArrayList<WeatherInfo>();
		try {
			JSONParser parser = new JSONParser();
			JSONObject forecastData = (JSONObject)parser.parse(jsonData);
			JSONObject response = (JSONObject)forecastData.get("response");
			JSONObject body = (JSONObject)response.get("body");
			JSONObject items = (JSONObject)body.get("items");
			JSONArray item = (JSONArray)items.get("item");
			
			for(int i = 0; i < item.size(); i++) {
				JSONObject data = (JSONObject)item.get(i);
				WeatherInfo info = new WeatherInfo();
				
				// 발표시간 - 필수
				info.setAnnounceTime(Long.parseLong(data.get("announceTime").toString()));
				// 발표번호 - 옵션 
				info.setNumEf((data.get("numEf") == null) ? 0 : Long.parseLong(data.get("numEf").toString()));
				//예보구역코드 - 필수
				info.setRegId((String)data.get("regId"));
				//강수확률 -옵션
				info.setRnSt((data.get("rnSt")==null) ? 0.0 : Double.parseDouble(data.get("rnSt").toString()));
				//강수형태  - 필수
				info.setRnYn(Long.parseLong(data.get("rnYn").toString()));
				//예상기온 - 옵션
				info.setTa((data.get("ta") == null) ? 0.0 : Double.parseDouble(data.get("ta").toString()));
				//날씨 - 필수
				info.setWf((String)data.get("wf"));
				//하늘상태 - 필수
				info.setWfCd((String)data.get("wfCd"));
				//풍속강도 - 필수
				info.setWsIt(Long.parseLong(data.get("wsIt").toString()));
				
				list.add(info);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return list;
	}
}
