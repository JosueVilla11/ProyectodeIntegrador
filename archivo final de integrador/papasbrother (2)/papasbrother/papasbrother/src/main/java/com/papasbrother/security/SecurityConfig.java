package com.papasbrother.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.papasbrother.servicio.CustomUserDetailsService;

@Configuration
public class SecurityConfig {

    private final CustomUserDetailsService userDetailsService;

    public SecurityConfig(CustomUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    // Configuración para ADMIN con prioridad alta
    @Bean
    @Order(1)
    public SecurityFilterChain adminSecurityFilterChain(HttpSecurity http) throws Exception {
        http
          .securityMatcher("/admin/**")
          .authorizeHttpRequests(auth -> auth
              .requestMatchers("/admin/login").permitAll()
              .anyRequest().hasRole("ADMIN")
          )
          .formLogin(form -> form
              .loginPage("/admin/login")
              .loginProcessingUrl("/admin/login")
              .defaultSuccessUrl("/admin/administradorpanel", true)
              .permitAll()
          )
          .logout(logout -> logout
              .logoutUrl("/admin/logout")
              .logoutSuccessUrl("/admin/login?logout")
              .permitAll()
          )
          .csrf(csrf -> csrf.disable()); // Opcional, valora si lo necesitas
        return http.build();
    }

    // Configuración para usuarios normales con prioridad menor
    @Bean
    @Order(2)
    public SecurityFilterChain userSecurityFilterChain(HttpSecurity http) throws Exception {
        http
          .authorizeHttpRequests(auth -> auth
              .requestMatchers("/crearcuenta","/registro", "/css/**", "/js/**","/img/**", "/login", "/contacto", "/inicio", 
              "/nosotros", "/promociones", "/terminos", "/menualit", "/menuhambur", "/menupech", "/menusalchi", "/politicas").permitAll()
              .anyRequest().authenticated()
          )
          .formLogin(form -> form
              .loginPage("/login")
              .loginProcessingUrl("/login")
              .defaultSuccessUrl("/", true)
              .permitAll()
          )
          .logout(logout -> logout
              .logoutUrl("/logout")
              .logoutSuccessUrl("/login?logout")
              .permitAll()
          )
          .csrf(csrf -> csrf.disable()); // Opcional, valora si lo necesitas
        return http.build();
    }

    // Configura el AuthenticationManager con el provider
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }
}