package springsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


@Deprecated(since = "I want to use InMemoryuser")
public class ProjectConfig extends WebSecurityConfigurerAdapter {
   @Autowired
    private CustomAuthenticationProvider authenticationProvider;

   @Override
   protected void configure(AuthenticationManagerBuilder auth){
      auth.authenticationProvider(authenticationProvider);
   }

   @Override
    protected void configure(HttpSecurity http) throws Exception{
       http.httpBasic();
       http.authorizeRequests().anyRequest().authenticated();
   }

}
