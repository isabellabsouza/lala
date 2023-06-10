package com.eee.teste.lala;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig{
    
    @Autowired
    private DataSource dataSource;

    // @Override
    // protected void configure(HttpSecurity http) throws Exception {
    //     http
    //     .authorizeRequests()
    //         .antMatchers("/home").permitAll()
    //         .anyRequest().authenticated()
    //         .and()
    //     .formLogin()
    //         .loginPage("/login")
    //         .defaultSuccessUrl("/pesquisaIngresso", true)
    //         .permitAll()
    //         .and()
    //     .logout()
    //         .logoutUrl("/logout")
    //         .logoutSuccessUrl("/home")
    //         .and()
    //     .csrf().disable();
    // }
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
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

    //INMEMORY USER QUE FUNCIONA
    // @Bean
    // UserDetailsManager users(DataSource dataSource) {
    //     // PasswordEncoder encoder = new BCryptPasswordEncoder();
        
    //     UserDetails user = User.withDefaultPasswordEncoder()
    //         .username("admin")
    //         .password("admin")
    //         .roles("ADMINISTRADOR")
    //         .build();
        
        
    //     // JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
            
    //     return new InMemoryUserDetailsManager(user);
    // }

    @Bean
    public UserDetailsManager users(DataSource dataSource) {
        // UserDetails user = User.withDefaultPasswordEncoder()
        //     .username("user")
        //     .password("password")
        //     .roles("FUNCIONARIO")
        //     .build();
        JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
        // users.createUser(user);
        return users;
    }

    //salvar usuario no banco
    // @Bean
    // public void configure(AuthenticationManagerBuilder auth) throws Exception {

    //     UserDetails user = User.withDefaultPasswordEncoder()
    //         .username("admin")
    //         .password("admin")
    //         .roles("ADMINISTRADOR")
    //         .build();

    //     auth.jdbcAuthentication()
    //         .dataSource(dataSource)
    //         .withDefaultSchema()
    //         .withUser(user);
    // }

    // @Override
    // protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	// 	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    //     UserDetails user =
    //              User.builder()
    //                 .username("nico")
    //                 .password(encoder.encode("nico"))
    //                 .roles("ADMINISTRADOR")
    //                 .build();
	// 	auth
	// 		.jdbcAuthentication()
	// 		.dataSource(dataSource)
	// 		.passwordEncoder(encoder)
    //         .withUser(user);
		
	// }
}
