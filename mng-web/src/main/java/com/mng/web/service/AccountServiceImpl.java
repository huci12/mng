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
import org.springframework.stereotype.Service;

import com.mng.common.dao.MemberDao;
import com.mng.common.dto.MemberDto;

@Service
public class AccountServiceImpl {

	@Autowired
	MemberDao memberDao;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	//@Override
	//public UserDetails loadUserByUsername(String member_id) throws UsernameNotFoundException {
		//MemberDto member = memberDao.selectMemeber(member_id);
		//if(member.getMemberId().equals("") || member.getMemberId() == null) {
			//new UsernameNotFoundException("해당 유저를 찾을수 없습니다.");
		//}
		//return new User(member.getMemberId(),member.getPassword(),authorities(member));
	//}
	
	
	//private Collection<? extends GrantedAuthority> authorities(MemberDto member){
		//String role = "";
		//관리자 사이트에서는 ADMIN만이 로그인 할수 있어야 한다.
		//switch(member.getMemberGroup()) {
			//case 'A' : 
				//admin
				//role = "ADMIN";
				//break;
			//case 'U' : 
				//user
				//role = "ROLE_USER";
				//break;
		//}
		
		//return Arrays.asList(new SimpleGrantedAuthority(role.toString()));
	//}


	
	//public MemberDto createMember(String memberId, String password) {
		// TODO Auto-generated method stub
		//MemberDto member = new MemberDto();
		//member.setMemberId(memberId);
		//member.setPassword(passwordEncoder.encode(password));
		//return member;
	//}
	

}
