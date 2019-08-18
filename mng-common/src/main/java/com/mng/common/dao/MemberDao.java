package com.mng.common.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mng.common.dto.CountryDto;
import com.mng.common.dto.MemberDto;

@Repository
public class MemberDao {
	@Autowired
	private SqlSession sqlSession;

	public MemberDto selectMemeber(String member_id) {

		//Map map = new HashMap<>();
		//map = sqlSession.selectOne("memberMapper.selectMember",member_id);
		//System.out.println(map);
		
		 MemberDto member = sqlSession.selectOne("memberMapper.selectMember",member_id);
		 System.out.println("Mybatis 설정을 잘못 했네"); 
		 System.out.println(member);
		 
		//MemberDto member = new MemberDto();
		
		return member;
	}
}
