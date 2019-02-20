package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;

import javax.sql.DataSource;

@SpringBootApplication
@EnableWebSecurity
@Configuration
public class DemoApplication extends WebSecurityConfigurerAdapter {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http

				.csrf().disable()
				.authorizeRequests()
				.antMatchers("/basket").authenticated()
				.antMatchers(HttpMethod.POST, "/products").hasRole("ADMIN")
				.antMatchers(HttpMethod.GET, "/users", "/orders").hasRole("ADMIN")
				.antMatchers("/", "/js/**", "/css/**", "/api/**").permitAll()
				.antMatchers("/basket.html", "/myorders.html", "/myprofile.html").hasAnyRole("ADMIN", "USER")
				.antMatchers( "/adminproducts.html", "/orders.html",
						"/adminusers.html", "/dashboard.html", "/reports.html", "/categories.html").hasRole("ADMIN")
				.and()
				.formLogin()
				.loginPage("/login.html").permitAll()
				.defaultSuccessUrl("/index.html")
				.failureUrl("/error.html")
				.and()
				.logout().logoutSuccessUrl("/products.html");
	}

	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth, DataSource dataSource, PasswordEncoder passwordEncoder) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(passwordEncoder)
				.usersByUsernameQuery("select name as principal, password as credentials, true from user where name = ?")
				.authoritiesByUsernameQuery("select name, role from User where name = ?")
				.rolePrefix("ROLE_");
	}

}

