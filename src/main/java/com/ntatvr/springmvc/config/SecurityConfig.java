package com.ntatvr.springmvc.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  DataSource dataSource;

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    auth.inMemoryAuthentication().withUser("ntatvr").password(passwordEncoder().encode("123456")).roles("USER");
    auth.inMemoryAuthentication().withUser("admin").password(passwordEncoder().encode("123456")).roles("ADMIN");
    auth.inMemoryAuthentication().withUser("dba").password(passwordEncoder().encode("123456")).roles("DBA");
//    auth.jdbcAuthentication().dataSource(dataSource)
//        .usersByUsernameQuery("SELECT username, password, enabled FROM users where username=?")
//        .authoritiesByUsernameQuery("SELECT username, role FROM user_roles where username=?");

  }


  
  @Override
  protected void configure(HttpSecurity http) throws Exception {

    http.authorizeRequests()
        .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
        .antMatchers("/dba/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_DBA')")
        .and()
          .formLogin().loginPage("/login").failureUrl("/login?error")
          .usernameParameter("username").passwordParameter("password")
        .and().logout().logoutSuccessUrl("/login?logout")
        .and().exceptionHandling().accessDeniedPage("/eror/403")
        .and().csrf().disable(); 

  }
}
