package com.adnane.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.util.AntPathMatcher;

@Configuration
@EnableWebSecurity
//@EnableOAuth2Sso
public class AppSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	  
	  @Override
	  protected void configure(AuthenticationManagerBuilder auth)
	    throws Exception {
		  auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
		  
	      //auth.authenticationProvider(authenticationProvider());
	  }
	  
	  
	  @Override
		protected void configure(HttpSecurity http) throws Exception {
			
			http.csrf().disable();
			http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
			http.authorizeRequests()
			.antMatchers(HttpMethod.GET, "/profils/**").permitAll()
			.antMatchers(HttpMethod.GET, "/appUsers/**").permitAll()
			.antMatchers("/login/**", "/register/**").permitAll()
			.antMatchers("/appUsers/**", "/appRoles/**")
			.hasAuthority("ADMIN");
			http.authorizeRequests().anyRequest().authenticated();
			http.addFilter(new JWTAuthenticationFilter(authenticationManager()))
			.addFilterBefore(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);

		}

//	  @Bean
//	  public DaoAuthenticationProvider authenticationProvider() {
//	      DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//	      authProvider.setUserDetailsService(userDetailsService);
//	      //authProvider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
//	      authProvider.setPasswordEncoder(bCryptPasswordEncoder());
//	      return authProvider;
//	  }
	 
	
	
		
//		http.cors();
//		http
//        .httpBasic()
//        .and()
//        	.authorizeRequests()
//            .antMatchers("/", "/login").permitAll()
//            .anyRequest().authenticated()
//        .and()
//			.logout().invalidateHttpSession(true)
//			.clearAuthentication(true)
//			.logoutRequestMatcher(new AntPathRequestMatcher("/logout")).permitAll()
//        .and()
//        	.csrf()
//            .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
			
		
	
//	@Bean
//	public AuthenticationProvider authProvider() {
//		
//		DaoAuthenticationProvider provider = new DaoAuthenticationProvider ();
//		//set the service name:
//		provider.setUserDetailsService(userDetailsService);
//		provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
//		//provider.setPasswordEncoder(new BCryptPasswordEncoder());
//		return provider;
//	}
	
	
}
