package com.mng.web.config;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.mng.common.dto.MemberDto;
import com.mng.common.service.MemberService;

@Component
public class UserAuthenticationProvider implements AuthenticationProvider{

	
	@Autowired
    MemberService memberService;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		 	System.out.println("authentication.toString");
			System.out.println(authentication.toString());
			System.out.println("authentication.getAuthorities()");
		 	System.out.println(authentication.getAuthorities());
		 	System.out.println("authentication.getDetails");
		 	System.out.println(authentication.getDetails());
		 	System.out.println("authentication.getPrincipal");
		 	System.out.println(authentication.getPrincipal());
		 	System.out.println("authentication.getCredentials"); //이게 패스워드
		 	System.out.println(authentication.getCredentials());
		 	System.out.println("authentication.getName");
		 	System.out.println(authentication.getName());
		 	
			String email = authentication.getName();
	        String password = passwordEncoder.encode((CharSequence) authentication.getCredentials());
	        
	        
	       
	        MemberDto memberDto = memberService.authenticate(email, password);
	       
	        if (memberDto == null) {
	        	throw new BadCredentialsException("Login Error !! NotFound User");
	        }
	        String credentials = (String) authentication.getCredentials();
	        boolean passMatch = passwordEncoder.matches(credentials , memberDto.getPassword());
	        
	        System.out.println(memberDto.getPassword());
	        System.out.println(password);
	        
	        if(!passMatch) {
	        	throw new BadCredentialsException("Login Error !! Password 를 확인 하시오");
	        }
	        
	        
	        
	        
	            
	        //memberDto.setPassword(null);
	 
	        ArrayList<SimpleGrantedAuthority> authorities = new ArrayList<>();
	        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
	        return new UsernamePasswordAuthenticationToken(memberDto, null, authorities);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
