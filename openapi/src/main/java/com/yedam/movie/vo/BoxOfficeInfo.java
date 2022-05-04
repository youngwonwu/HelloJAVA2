package com.yedam.movie.vo;

import java.util.List;

import lombok.Data;

@Data
public class BoxOfficeInfo {
	
	//내부 객체1(또 다른 객체)
	private String boxofficeType;
	private String showRange;
	private List<MovieInfo> dailyBoxOfficeList;

}
