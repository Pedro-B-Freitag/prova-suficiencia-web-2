package pedro.freitag.RestApiFurb.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import pedro.freitag.RestApiFurb.model.AuthUsuario;
import pedro.freitag.RestApiFurb.repository.AuthUsuarioRepository;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authz -> authz
                        .requestMatchers(
                                "/swagger-ui/**",
                                "/v3/api-docs/**",
                                "/swagger-resources/**",
                                "/webjars/**",
                                "/configuration/**",
                                "/swagger-ui.html/",
                                "/index.html","/index.html/"
                        ).permitAll()
                        .anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public CommandLineRunner initUsuarioPadrao(AuthUsuarioRepository repository, PasswordEncoder encoder) {
        return args -> {
            String username = "admin";
            String senha = "admin123";

            if (repository.findByUsername(username).isEmpty()) {
                AuthUsuario admin = new AuthUsuario();
                admin.setUsername(username);
                admin.setPassword(encoder.encode(senha));
                admin.setRole("ADMIN");

                repository.save(admin);
            }
        };
    }
}