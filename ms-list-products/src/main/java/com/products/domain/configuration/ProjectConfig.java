package com.products.domain.configuration;

import com.products.domain.service.AuthenticationProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
public class ProjectConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  private AuthenticationProviderService authenticationProviderService;

  @Autowired
  private RequestValidationFilter filter;
  @Bean
  public BCryptPasswordEncoder bCryptPasswordEncoder(){
    return new BCryptPasswordEncoder();
  }

  @Bean
  public SCryptPasswordEncoder sCryptPasswordEncoder(){
    return new SCryptPasswordEncoder();
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
   auth.authenticationProvider(authenticationProviderService);
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable()
        .addFilterBefore(filter, BasicAuthenticationFilter.class)//Adding filter before authentication
        .addFilterAfter(new AuthenticationLoggingFilter(), BasicAuthenticationFilter.class)//Adding filter after authentication
        .addFilterAt(filter, BasicAuthenticationFilter.class)//Adding filter at authentication
        .authorizeRequests()
        //.mvcMatchers("/updateProduct/**").hasAuthority("ADMIN")
        .mvcMatchers("/updateProduct/**").hasRole("ADMIN")
        .mvcMatchers(HttpMethod.GET, "/products/{id:[0-9]+}").hasRole("MANAGER")
        //.anyRequest().hasRole("MANAGER") //this is a way to allow access
        .and()
        .httpBasic();


  }
}
