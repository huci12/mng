package com.mng.web.service;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.mng.common.dao.MemberDao;
import com.mng.common.dto.MemberDto;

public class AccountServiceImpl implements AccountService {

	@Autowired
	MemberDao memberDao;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String member_id) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		// TODO Auto-generated method stub
		//log.info(TimeUtil.getNowStr() +" : " + username +" is login access");
		System.out.println(member_id + "로그인 시도중");
		MemberDto member = memberDao.selectMemeber(member_id);
		if(member.getMember_id().equals("") || member.getMember_id() == null) {
			//에러 발생
			//log.error(member_id + " is login Failed");
			new UsernameNotFoundException("해당 유저를 찾을수 없습니다.");
		}
		
		//멤버 잠김 확인
		//if(member.getMember_use() == 'N') {
			//이런 잠궈버린 멤버다. 활성화를 시킬수 있도록 하는 걸 고민 해보자
			
		//}
		
		//if(member.getMember_group() == 'U') {
			//new Exception("일반 유저는 로그인 할수 없습니다.");
		//}
		
		//성공시 각 USER의 권한 별로 다른 authorities 권한을 제공 해줘야 한다.
		return new User(member.getMember_id(),member.getPassword(),authorities(member));
	}
	
	
	private Collection<? extends GrantedAuthority> authorities(MemberDto member){
		String role = "";
		//관리자 사이트에서는 ADMIN만이 로그인 할수 있어야 한다.
		switch(member.getMember_group()) {
			case 'A' : 
				//admin
				role = "ADMIN";
				break;
			case 'U' : 
				//user
				role = "ROLE_USER";
				break;
		}
		
		return Arrays.asList(new SimpleGrantedAuthority(role.toString()));
	}
	

}
