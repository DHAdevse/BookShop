package org.example.bookshoponlinewebsite.security;

import org.example.bookshoponlinewebsite.services.impl.CustomUserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
public class WebSecurityConfig {
    @Autowired
    private AuthenticationSuccessHandler authenticationSuccessHandler;
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(CustomUserDetailsServiceImpl customUserDetailsService, PasswordEncoder passwordEncoder) {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(customUserDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder);
        return authProvider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
//                .authenticationProvider(authenticationProvider(null, null))  // Spring sẽ tự động inject các dependencies
                .authorizeHttpRequests(config -> config
                        .requestMatchers("admin/**","/login","cart/**","/index","book/**","detail/**","/css/**", "/img/**", "/js/**", "/lib/**", "/loginpage/**", "/mail/**", "/scss/**", "/registerpage/**", "/bootstrap-shop-template.jpg").permitAll()
//                        .requestMatchers("admin/**").permitAll()
                        .anyRequest().permitAll()
                )
                .formLogin(loginPage -> loginPage
                        .loginPage("/login")
                        .loginProcessingUrl("/authenticate-user")
                        .successHandler(authenticationSuccessHandler)
                        .failureUrl("/login?error=true")
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/")
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID")
                )
                .rememberMe(rememberMe -> rememberMe
                        .tokenValiditySeconds(60) // không có tác dụng nếu k sài token
                        .rememberMeParameter("remember-me")
                )
                .exceptionHandling(
                        exception -> exception.accessDeniedPage("/")
                );
        return httpSecurity.build();
    }
}
