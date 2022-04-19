package com.greatlearning.EmployeeRest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.greatlearning.EmployeeRest.service.UserDetailsServiceImpl;

@Configuration
public class SecurityConfigurationWithJDBC extends WebSecurityConfigurerAdapter {
	@Bean
	public UserDetailsService userDetailsService() {
		return new UserDetailsServiceImpl();
	}

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

//	@Bean
//	public DaoAuthenticationProvider authenticationProvider() {
//		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//		authProvider.setUserDetailsService(userDetailsService());
//		authProvider.setPasswordEncoder(getPasswordEncoder());
//		return authProvider;
//	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService()).passwordEncoder(getPasswordEncoder());
	}

	@Override
	public void configure(WebSecurity web) throws Exception {

		web.ignoring().antMatchers("/h2-console/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/h2-console/").permitAll()
				.antMatchers(HttpMethod.DELETE, "/employees/{employeeId}").hasAuthority("admin")
				.antMatchers(HttpMethod.GET, "/employees/{employeeId}").hasAuthority("admin")
				.antMatchers(HttpMethod.POST, "/employees/save").hasAuthority("admin")

				.antMatchers(HttpMethod.GET, "/employees/list", "/employees/sort", "/employees/search")
				.hasAnyAuthority("admin", "user").antMatchers("/users").hasAnyAuthority("admin", "user")
				.antMatchers(HttpMethod.PUT, "/employees/**").hasAnyAuthority("admin", "user")
				.antMatchers(HttpMethod.POST, "/roles/save", "/roles/list").hasAuthority("admin").and().httpBasic()
				.and().cors().and().csrf().disable().formLogin().disable();
		http.headers().frameOptions().disable();

	}

}
