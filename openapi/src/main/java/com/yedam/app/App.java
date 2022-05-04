package com.yedam.app;

import java.util.List;

import com.yedam.forecast.service.ForecastService;
import com.yedam.forecast.service.WeatherInfo;
import com.yedam.movie.service.MovieService;
import com.yedam.movie.vo.MovieInfo;

public class App {

	public static void main(String[] args) {
		
		//영화
		//한줄로 나옴
		//MovieService.getDailyBoxOfficeResult();
		//개별로 나옴
//		List<MovieInfo> list =MovieService.getDailyBoxOfficeResult();
//		for(MovieInfo info : list) {
//			System.out.println(info);
//		}
		
		//날씨
		//ForecastService.getWeatherForecast();
		List<WeatherInfo> list = ForecastService.getWeatherForecast();
		for(WeatherInfo info : list) {
			System.out.println(info);
		}		

	}

}
