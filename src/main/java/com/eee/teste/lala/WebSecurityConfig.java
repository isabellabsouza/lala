package com.eee.teste.lala;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    
    @Autowired
    private DataSource dataSource;
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, UserDetailsService users) throws Exception {
        http
            .authorizeHttpRequests((authz) -> authz
                .requestMatchers("/home").permitAll()
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
                .loginPage("/login")
                .permitAll()
                .defaultSuccessUrl("/pesquisaIngresso", true)
            )
            .logout(logout -> logout.logoutUrl("/logout"))
            .rememberMe((rememberMe) -> rememberMe.userDetailsService(users))
            .csrf().disable();
               
        return http.build();
    }

    

    // @Bean
    // public void configure(AuthenticationManagerBuilder auth) throws Exception {
    //     BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    //     UserDetails user = User.builder()
    //         .username("admin")
    //         .password(encoder.encode("admin"))
    //         .roles("ADMINISTRADOR")
    //         .build();


    //     auth.jdbcAuthentication()
    //         .dataSource(dataSource)
    //         .passwordEncoder(encoder)
    //         .withUser(user);

    // }

    // @Autowired
    // public void configureGlobal(AuthenticationManagerBuilder auth)
    // throws Exception {
    //     auth.jdbcAuthentication()
    //     .dataSource(dataSource)
    //     .withDefaultSchema()
    //     .withUser(User.withUsername("user")
    //         .password(passwordEncoder().encode("pass"))
    //         .roles("USER"));
    // }

    // @Bean
    // public PasswordEncoder passwordEncoder() {
    //     return new BCryptPasswordEncoder();
    // }

    @Bean
    UserDetailsManager users(DataSource dataSource) {
        // PasswordEncoder encoder = new BCryptPasswordEncoder();
        
        UserDetails user = User.withDefaultPasswordEncoder()
            .username("admin")
            .password("admin")
            .roles("ADMINISTRADOR")
            .build();
        
        
        // JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
            
        return new InMemoryUserDetailsManager(user);
    }
   
}
