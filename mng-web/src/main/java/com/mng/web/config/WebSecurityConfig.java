package com.mng.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	
	@Autowired
    private UserAuthenticationProvider authenticationProvider;
	
	
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/css/**", "/js/**", "/img/**", "/font/**", "/lib/**");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//http.authorizeRequests().antMatchers("/css/**" , "/js/**","/img/**").permitAll()
		//.antMatchers("/auth/admin/**").hasRole("ADMIN")
		//.antMatchers("/auth/**").hasAnyRole("ADMIN","USER")
		//.anyRequest().authenticated()
		//;
		
		
		//http.formLogin()
		//.loginPage("/")
		//.loginProcessingUrl("/authenticate")
		//.failureUrl("/")
		//.defaultSuccessUrl("/view/main/main")
		//.usernameParameter("member_id")
		//.passwordParameter("password")
		//.permitAll();
		
		//http.logout()
		//.logoutUrl("/logout")
		//.logoutSuccessUrl("/")
		//.permitAll();
		
		
		// guest 페이지와 account 페이지를 제외 하고 로그인 페이지와 로그인 url 실패시 로그인 url 성공시 기본 url을 설정해준다.
		http.authorizeRequests()
		.antMatchers("/**").permitAll().anyRequest().authenticated()
		.and().formLogin().loginPage("/")
		.loginProcessingUrl("/authenticate")
		.failureUrl("/")
		.defaultSuccessUrl("/view/main/main")
		.and().httpBasic();
				
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider);
	}
	
	// password 인코딩 사용방법
	// NoOpPasswordEncoder 암호화를 사용하지 않음
	// PasswordEncoderFactories 를 권장함
	@Bean
	public PasswordEncoder passwordEncoder() {
		//return NoOpPasswordEncoder.getInstance();
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
}
