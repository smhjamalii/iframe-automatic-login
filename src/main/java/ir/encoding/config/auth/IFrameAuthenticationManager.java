package ir.encoding.config.auth;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

//@Component
@RequiredArgsConstructor
public class IFrameAuthenticationManager implements AuthenticationManager {

	private final IFrameAuthenticationProvider authenticationProvider;

	@Override
	public Authentication authenticate(Authentication authentication) {
		return authenticationProvider.authenticate(authentication);		
	}
		
}
