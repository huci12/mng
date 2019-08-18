package com.mng.common.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class MemberDto {

	String member_id;
	int member_number;
	String member_Phone_number;
	String member_country;
	String member_city;
	String member_address;
	String member_email;
	String member_company;
	String member_company_unit;
	String member_nickname;
	String member_use;
	char member_group;
	Timestamp create_time;
	String password;
}
