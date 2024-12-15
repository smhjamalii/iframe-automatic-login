package ir.encoding.config.auth;

import java.util.Arrays;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import ir.encoding.services.UserService;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class IFrameAuthenticationProvider implements AuthenticationProvider {

	private final UserService userService;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		var password = String.valueOf(authentication.getCredentials());
		var username = String.valueOf(authentication.getPrincipal());
		var user = userService.loadUserByUsername(username);
		if(user == null) return null;
		PasswordEncoder passEncoder = new BCryptPasswordEncoder();
		if(passEncoder.matches(password, user.getPassword())) {
			GrantedAuthority auth = () -> "USER";
			return new UsernamePasswordAuthenticationToken(username, password, Arrays.asList(auth));
		}
		return null;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);		
	}

}
