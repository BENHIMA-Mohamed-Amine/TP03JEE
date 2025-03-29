package ma.enset.security;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager(){
        return new InMemoryUserDetailsManager(
            User.withUsername("user")
                .password(passwordEncoder().encode("1234"))
                .roles("USER")
                .build(),
            User.withUsername("admin")
                .password(passwordEncoder().encode("1234"))
                .roles("USER", "ADMIN")
                .build()
        );
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .authorizeHttpRequests(auth -> auth
                .requestMatchers("/formPatient", "/save", "/delete", "/editPatient").hasRole("ADMIN")
                .requestMatchers("/index").hasRole("USER")
                .requestMatchers("/webjars/**", "/css/**", "/images/**", "/js/**").permitAll()
                .anyRequest().authenticated())
                .formLogin(form -> form.loginPage("/login").loginProcessingUrl("/login").defaultSuccessUrl("/index").permitAll())
                .logout(logout -> logout
                .logoutUrl("/logout")  // Custom logout URL
                .logoutSuccessUrl("/login?logout") // Redirect to login page after logout
                .permitAll()) // Allow anyone to access the logout URL
                .exceptionHandling((exception)-> exception.accessDeniedPage("/notAuthorized"))
                .rememberMe(Customizer.withDefaults())
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
