package com.products.domain.entities;

import com.products.application.dto.Users;
import java.util.Collection;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
@AllArgsConstructor
public class CustomUserDetails implements UserDetails {

  private final Users users;

  public final Users getUsers(){
    return  users;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return users.getAuthorities().stream().map(a->
        new SimpleGrantedAuthority(a.getName())
    ).collect(Collectors.toList());
  }

  @Override
  public String getPassword() {
    return users.getPassword();
  }

  @Override
  public String getUsername() {
    return users.getUsername();
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}
