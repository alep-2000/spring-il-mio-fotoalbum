package org.lessons.java.auth.conf;

import org.lessons.java.auth.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class AuthConf {

	@Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http.cors().disable()
			.csrf().disable()
			.authorizeHttpRequests()
	        .requestMatchers("/**").permitAll()
	        .and().formLogin()
	        .and().logout()
	    ;
		
		return http.build();
	}
	
	 @Bean
	    UserDetailsService userDetailsService() {
		    return new UserService();
		}
	    
	    @Bean
		public static PasswordEncoder passwordEncoder() {
	      return new BCryptPasswordEncoder();
	    }
	    
	    @Bean
	    DaoAuthenticationProvider authenticationProvider() {
	      
	    	DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
	   
	    	authProvider.setUserDetailsService(userDetailsService());
	    	authProvider.setPasswordEncoder(passwordEncoder());
	   
	    	return authProvider;
	    }
}


