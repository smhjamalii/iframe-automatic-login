package ir.encoding.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

	//private final AuthenticationManager authenticationManager;
	private final AuthenticationProvider authenticationProvider;
	
	@Bean
	SecurityFilterChain springFilterChain(HttpSecurity http) throws Exception {
		
		http
			.headers(h -> {
				h.frameOptions(f -> f.disable());
			})
			.csrf(c -> c.disable())
			.formLogin(c -> {
				c				
				.defaultSuccessUrl("/index")				
				.loginPage("/login")				
				;
			})
			.httpBasic(c -> {
				Customizer.withDefaults();
			})			
			.logout(c -> {
				c.logoutUrl("/logout").permitAll();
			})
			;
			
		http.authenticationProvider(authenticationProvider);
		
		http.authorizeHttpRequests(c -> {	
			c.requestMatchers("/index").authenticated();
			c.requestMatchers("/login").permitAll();			
		});
		
		return http.build();
	}
	
}
