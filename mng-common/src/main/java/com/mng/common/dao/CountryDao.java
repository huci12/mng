package com.mng.common.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mng.common.dto.CountryDto;

@Repository
public class CountryDao {
	@Autowired
	private SqlSession sqlSession;
	
	public List<CountryDto> selectCountryList(){
		return sqlSession.selectList("countryMapper.selectCountryList");
	}
}
