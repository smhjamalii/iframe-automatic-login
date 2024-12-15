package ir.encoding.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ir.encoding.data.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);
	
}
