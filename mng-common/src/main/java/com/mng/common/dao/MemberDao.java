package com.mng.common.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mng.common.dto.MemberDto;

@Repository
public class MemberDao {
	@Autowired
	private SqlSession sqlSession;

	public MemberDto selectMemeber(String member_id) {
		 MemberDto member = sqlSession.selectOne("memberMapper.selectMember",member_id);
		return member;
	}
}
