package com.artivistas.config;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityWebConfig extends WebSecurityConfigurerAdapter{
	
	private static final String USER_BY_MAIL = "SELECT  mail, password, enabled FROM user WHERE mail=?";
	
	private static final String PERMISSION_BY_USER = "SELECT u.mail, a.role FROM user_auth ua "
			+ "JOIN user u ON u.id_user = ua.user_id "
			+ "JOIN authority a ON a.id_auth = ua.auth_id "
			+ "WHERE u.mail=?";
	
	@Autowired
	private DataSource dataSource;
	
	@Override
	public void configure (HttpSecurity http) throws Exception{
		http
		.authorizeRequests()
			.antMatchers("/resources/**/*","/css/**","/javax.faces.resource/**","/template.jsf", "/account/signup.jsf","/account/signup**").permitAll()
			.anyRequest().authenticated()
		.and()
			.formLogin()
			.loginPage("/login.jsf")
			.loginProcessingUrl("/login")
			.permitAll()
			.defaultSuccessUrl("/index.jsf",true)
			.failureUrl("/login.jsf?error=true")
		.and()
		.logout().logoutSuccessUrl("/login.jsf")
		.and()
			.csrf().disable();
		
	}
	
	@Override
	public void configure(AuthenticationManagerBuilder builder) throws Exception{
		builder
			.jdbcAuthentication()
			.dataSource(dataSource)
			.passwordEncoder(new BCryptPasswordEncoder())
			.usersByUsernameQuery(USER_BY_MAIL)
			.authoritiesByUsernameQuery(PERMISSION_BY_USER)
			.rolePrefix("ROLE_");
		
	}
	
	@Bean(name = BeanIds.AUTHENTICATION_MANAGER)
	@Override
	public AuthenticationManager authenticationManager()throws Exception{
		return super.authenticationManager();
	}
	
	
	public static void main(String[] args) {
	    System.out.println(new BCryptPasswordEncoder().encode("1234"));
	  }
	
	

}
