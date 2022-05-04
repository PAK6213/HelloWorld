package com.yedam.app;

import java.util.List;

import com.yedam.forecast.service.ForecastService;
import com.yedam.forecast.service.WeatherInfo;
import com.yedam.movie.vo.Movieinfo;

public class App {
	public static void main(String[] args) {
		/*
		List<Movieinfo> list = MovieService.getDailyBoxOfficeResult();
		for(Movieinfo info : list) {
			System.out.println(info);

		}*/



		List<WeatherInfo> list = ForecastService.getWeatherForecast();
		for(WeatherInfo info : list) {
			System.out.println(info);
		}
	}
}
