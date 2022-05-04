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
import com.yedam.movie.vo.MovieInfo;

public class MovieService {
	
	private static final String key = "52f615f15ee0aa4e98144a3d2ca0eec5";	//내가 발급받은 키값
	
	
	//일별 박스 오피스
	public static List<MovieInfo> getDailyBoxOfficeResult() {	//반환
		//url 구성
		
		//요청할려는 url가져오기
		String serviceURL = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?";		//get방식이라 ?를 붙여야한다
		
		//map을 사용해도 된다
		List<PropertiesPair> params = new ArrayList<PropertiesPair>();
		params.add(new PropertiesPair("key", key));
		params.add(new PropertiesPair("targetDt", "20220429"));	//4월 마지막 박스오피스 가져온다
		
		//데이터 정보
		String paramURL ="";
		
		StringBuilder sb = new StringBuilder();
		//객체 형성
		try {
			paramURL = PropertiesPair.getQuery(params);
			
			String requestURL = serviceURL + paramURL;
			URL url = new URL(requestURL);	//url은 인터넷 주소 정보를 가지는 것
			
			HttpURLConnection con = (HttpURLConnection)url.openConnection();	//강제형변환해줘야한다
			
			//연결을 하고 나서 헤더 바디 정보를 구상해야함
			if (con.getResponseCode() == HttpURLConnection.HTTP_OK) {	//url를 이용해서 위치를 확인하고 getResponseCode()사용하면 서버를 반환했을때 응답을 받아온다? 잘모르겠...
				BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(),"UTF-8"));
				String line;
				while((line = br.readLine()) != null) {
					sb.append(line);
				}
				br.close();	//통신을 열였으면 닫아야함
			} else {
				System.out.println(con.getResponseMessage());
			}
			con.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String jsonResult = sb.toString();
		
		//System.out.println(jsonResult);	//파싱하기전 출력
		//return null;
		
		//gson으로 만들기
		BoxOfficeResult result = new Gson().fromJson(jsonResult, BoxOfficeResult.class);
		
		return result.getBoxOfficeResult().getDailyBoxOfficeList();
		//BoxOfficeInfo = result.getBoxOfficeResult();
		//List<MovieInfo> list = info.getDailyBoxOfficeList();
		
	}

}
