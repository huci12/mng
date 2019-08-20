package com.mng.common.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class MemberDto {

	private String memberId;
	private int memberNumber;
	private String memberPhoneNumber;
	private String memberCountry;
	private String memberCity;
	private String memberAddress;
	private String memberEmail;
	private String memberCompany;
	private String memberCompany_unit;
	private String memberNickname;
	private String memberUse;
	private char memberGroup;
	private Timestamp createTime;
	private String password;
}
