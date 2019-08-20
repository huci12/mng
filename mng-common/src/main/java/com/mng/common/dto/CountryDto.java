package com.mng.common.dto;

import lombok.Data;

@Data
public class CountryDto {
	private int country_id;
	private String country_name; 
	private String country_kor_name;
	private String country_nick_name_1;
	private String country_nick_name_2;
	private String country_language;
	
}
