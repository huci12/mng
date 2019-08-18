package com.mng.common.service;

import com.mng.common.dto.MemberDto;

public interface MemberService {
	public MemberDto authenticate(String id, String password);

}
