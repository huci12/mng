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
		 // 로그인 설정
        //http.authorizeRequests()
            // ROLE_USER, ROLE_ADMIN으로 권한 분리 유알엘 정의
            //.antMatchers("/", "/user/login", "/error**").permitAll()
            //.antMatchers("/**").access("ROLE_USER")
            //.antMatchers("/**").access("ROLE_ADMIN")
            //.antMatchers("/admin/**").access("ROLE_ADMIN")
            //.antMatchers("/**").authenticated()
        //.and()
            // 로그인 페이지 및 성공 url, handler 그리고 로그인 시 사용되는 id, password 파라미터 정의
            //.formLogin()
            //.loginPage("/user/login")
            //.defaultSuccessUrl("/")
            //.failureHandler(authFailureHandler)
            //.successHandler(authSuccessHandler)
            //.usernameParameter("id")
            //.passwordParameter("password")
        //.and()    
            // 로그아웃 관련 설정
            //.logout().logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"))
            //.logoutSuccessUrl("/")
            //.invalidateHttpSession(true)
        //.and()
            // csrf 사용유무 설정
            // csrf 설정을 사용하면 모든 request에 csrf 값을 함께 전달해야한다.
            //.csrf()
        //.and()
            // 로그인 프로세스가 진행될 provider
            //.authenticationProvider(authProvider);
		
		http.authorizeRequests()
		.antMatchers("/", "/error/**").permitAll()
		.antMatchers("/**").access("ROLE_USER")
        .antMatchers("/**").access("ADMIN")
        .antMatchers("/**").authenticated()
        .and()
        .formLogin()
        .loginPage("/")
        .defaultSuccessUrl("/view/main/main")
        .failureUrl("/")
        .loginProcessingUrl("/authenticate")
        .and()
        .httpBasic();

	
				
	}
	
	//@Override
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
