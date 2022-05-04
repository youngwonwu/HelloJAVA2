package com.yedam.forecast.service;

import lombok.Data;

@Data
public class WeatherInfo {
	
	//발표시간 - 필수값
	private long announceTime;
	//발표번호 - 옵션
	private long numEf;
	//예보구역코드 - 필수값
	private String regId;
	//강수활률 - 옵션
	private double rnSt;
	//강수형태 - 필수
	private long rnYn;
	//예상기온 - 옵션
	private String ta;
	//날씨 - 필수
	private String wf;
	//하늘상태 - 필수
	private String wfCd;
	//풍속 강도코드 - 필수
	private String wsIt;

}
