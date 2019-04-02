package com.everis.alicante.steward.steward;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class BasicAuthConfiguration extends WebSecurityConfigurerAdapter {
	
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		String password = passwordEncoder().encode("password");
		String password2 = passwordEncoder().encode("admin");
		
        auth
          .inMemoryAuthentication()
          .withUser("user")
          	.password(password)
            //.password("{noop}password")
            .roles("USER")
            .and()
          .withUser("admin")
          	.password(password2)
            //.password("{noop}admin")
            .roles("USER", "ADMIN");
        
//		auth
//		.ldapAuthentication()
//			.userDnPatterns("uid={0},ou=people")
//			.groupSearchBase("ou=groups")
//			.contextSource()
//				.url("ldap://localhost:8389/dc=springframework,dc=org")
//				.and()
//			.passwordCompare()
//				.passwordEncoder(new LdapShaPasswordEncoder())
//				.passwordAttribute("userPassword");
    }
 
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
          //.authorizeRequests()
          //.antMatchers(HttpMethod.POST).hasRole("ADMIN")
          //.antMatchers(HttpMethod.DELETE).hasRole("ADMIN")
          //.antMatchers(HttpMethod.PUT).hasRole("ADMIN")
          //.anyRequest()//.hasRole("USER")
          //.and()
          //.httpBasic();
        http
          .headers().frameOptions().sameOrigin();
    }
    
//    ldap:
//    	  host: usersad-ldap.usersad.everis.int
//    	  port: 389
//    	  principal: usersad\tu_usuario
//    	  credentials: tu_password_del_usuario
//    	  base: OU=everis,DC=usersad,DC=everis,DC=int

}