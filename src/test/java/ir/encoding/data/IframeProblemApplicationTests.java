package ir.encoding.data;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class IframeProblemApplicationTests {

	@Test
	void contextLoads() {
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		System.out.printf("password: %s%n", encoder.encode("abcd1234"));
	}

}
