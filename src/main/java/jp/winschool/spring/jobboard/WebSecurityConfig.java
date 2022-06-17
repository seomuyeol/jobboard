package jp.winschool.spring.jobboard;


import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	public void configure(WebSecurity web) {
		web.ignoring().antMatchers("/h2-console/**");
		web.ignoring().antMatchers("/css/**", "/html/**");
	}
	
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/account/**").hasRole("ADMINISTRATOR")
			.antMatchers("/company/**").hasRole("COMPANY")
			.antMatchers("/person/**").hasRole("PERSON")
		.and()
			.formLogin().loginPage("/login").permitAll()
		.and()
			.logout().logoutSuccessUrl("/");
	}
	
	@Bean
	public UserDetailsManager userDetailsManager(DataSource dataSource) {
		return new JdbcUserDetailsManager(dataSource);
	}

}
