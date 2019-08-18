package com.mng.common.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.mng.common.dao.MemberDao;
import com.mng.common.dto.MemberDto;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberDao memberDao;
	
	public MemberDto authenticate(String id, String password) {
		// TODO Auto-generated method stub
		return memberDao.selectMemeber(id);
	}

}
