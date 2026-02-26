package _DAM.Cine_V2.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // 1. Desactivar CSRF (no se necesita en APIs REST stateless)
                .csrf(csrf -> csrf.disable())

                // 2. No crear sesiones — cada petición se autentica con el token JWT
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))

                // 3. Desactivar formLogin y httpBasic (no usamos formularios ni Basic Auth)
                .formLogin(form -> form.disable())
                .httpBasic(basic -> basic.disable())

                // 4. Reglas de autorización
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/auth/**").permitAll()
                        .anyRequest().authenticated());

        return http.build();
    }
}