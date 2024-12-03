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

@Configuration
public class ProjectConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  private AuthenticationProviderService authenticationProviderService;
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
    http.httpBasic();
    /*http.authorizeRequests()
        .anyRequest().hasAuthority("READ"); 'it's a way'*/
    http.authorizeRequests().anyRequest().hasAuthority("READ");

  }
}
