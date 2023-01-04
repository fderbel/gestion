package com.fatma.gestiondestock.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.fatma.gestiondestock.services.auth.ApplicationUserDetailService;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private ApplicationUserDetailService applicationUserDetailService;

	@Autowired
	private ApplicationRequestFilter applicationRequestFilter;

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable().authorizeRequests()
				.antMatchers("/swagger-ui/**", "/swagger-ui.html", "/authenticate", "/v3/**").permitAll().anyRequest()
				.authenticated().and().httpBasic();

		/*
		 * http.csrf().disable().authorizeRequests() .antMatchers("/swagger-ui/**",
		 * "/swagger-ui.html", "/authenticate", "/v3/**").permitAll().anyRequest()
		 * .authenticated().and().sessionManagement().sessionCreationPolicy(
		 * SessionCreationPolicy.STATELESS);
		 * 
		 * http.addFilterBefore(applicationRequestFilter,
		 * UsernamePasswordAuthenticationFilter.class);
		 */

	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// auth.inMemoryAuthentication().withUser("javainuse").password(passwordEncoder().encode("javainuse"))
		// .authorities("ADMIN");

		auth.userDetailsService(applicationUserDetailService);
	}

	@Bean(name = "password")
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	@Bean
	public AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}
}
