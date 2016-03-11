package net.wuollet.jpa.security;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.security.core.authority.*;
import org.springframework.security.core.userdetails.*;

import net.wuollet.jpa.domain.model.user.*;
import net.wuollet.jpa.domain.model.user.User;

public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		List<User> users = userRepository.findByUsername(username);
		if (users.size() < 1) {
			throw new UsernameNotFoundException("User " + username + " not found");
		}

		User u = users.get(0);

		org.springframework.security.core.userdetails.User sUser = new org.springframework.security.core.userdetails.User(
				u.getUsername(), u.getPassword(), AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_ADMIN"));

		return sUser;
	}

}
