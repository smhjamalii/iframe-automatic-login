package ir.encoding.data.entities;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "USERS")
@Getter @Setter
public class User implements UserDetails {

	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;
	
	private String fullname; 
	private String username;
	private String email;
	private String password;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {		
		return null;
	}
}
