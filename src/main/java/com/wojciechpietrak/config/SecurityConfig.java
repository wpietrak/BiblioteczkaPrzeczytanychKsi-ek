package com.wojciechpietrak.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.wojciechpietrak.service.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	

	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private UserService userService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.userDetailsService(userService)
		.passwordEncoder(new BCryptPasswordEncoder());
		//auth.inMemoryAuthentication().withUser("admin@wp.pl").password("1234").roles("ADMIN");

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http
		.authorizeRequests()
			.antMatchers("/login").permitAll()
			.antMatchers("/register").permitAll()
			.antMatchers("/resources/**").permitAll()
			.antMatchers("/users","/user/**", "/admin/**").hasRole("ADMIN")
			.antMatchers("/**").authenticated()
		.and()
		.formLogin()
			.usernameParameter("email")
			.passwordParameter("password")
			.loginPage("/login")
			.loginProcessingUrl("/login")
			
		.and()
		.csrf()
			.disable()
		.logout()
			.logoutUrl("/logout")
			.logoutSuccessUrl("/login?logout")
			
			;
		//.invalidateHttpSession(true)
	}
}
