package com.yedam.movie.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.yedam.app.common.PropertiesPair;
import com.yedam.movie.vo.BoxOfficeResult;
import com.yedam.movie.vo.BoxOfficeinfo;
import com.yedam.movie.vo.Movieinfo;

public class MovieService {
	// 공공데이터를 사용하기 위한 키값.
	private static final String key = "1e7ba5cd8396ae0199bc32c01ba52861";
	//http.get방식으로 가져오기
	
	//일별 박스 오피스
	public static List<Movieinfo> getDailyBoxOfficeResult() {
		//PropertiesPair타입 ArrayList생성
		List<PropertiesPair> params = new ArrayList<PropertiesPair>();
		// PropertiesPair 인스턴스 생성후 초기화하여 ArrayList에 추가.
		params.add(new PropertiesPair("key", key));
		params.add(new PropertiesPair("targetDt", "20220429"));
		// 요청하려는 서비스 URL
		String serviceURL = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?";
		// 문자열 처리의 속도를 높이기위해서 StringBuilder를 사용
		StringBuilder sb = new StringBuilder();
		
		
		
		try {
			//paramURL 
			String paramURL = PropertiesPair.getQuery(params);
			//두개를 합치면 요청할 URL이 됨.
			String requestURL = serviceURL + paramURL;

			URL url = new URL(requestURL);  // URL객체를 이용하여 URL 주소를 나타냄.
			// 통신에 필요한 스트림 
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			// getResponseCode() 응답 코드확인  200 = OK
			if(con.getResponseCode() == HttpURLConnection.HTTP_OK) {
				BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
				String line;
				while((line=br.readLine()) != null) {
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
		BoxOfficeResult result = new Gson().fromJson(jsonResult,BoxOfficeResult.class);
		
		//BoxOfficeinfo info = result.getBoxOfficeResult();
		//List<MovieInfo> list = info.getDailyBoxOfficeList();
		return result.getBoxOfficeResult().getDailyBoxOfficeList();
	}
}
