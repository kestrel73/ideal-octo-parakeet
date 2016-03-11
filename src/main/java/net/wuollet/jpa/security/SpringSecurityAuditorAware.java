package net.wuollet.jpa.security;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.data.domain.*;
import org.springframework.security.core.*;
import org.springframework.security.core.context.*;
import org.springframework.security.core.userdetails.*;

import net.wuollet.jpa.domain.model.user.*;
import net.wuollet.jpa.domain.model.user.User;


public class SpringSecurityAuditorAware implements AuditorAware<User> {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User getCurrentAuditor() {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		if (authentication == null || !authentication.isAuthenticated()) {
			return null;
		}

		UserDetails userDetails = (UserDetails)authentication.getPrincipal();

		User u = findUser(userDetails.getUsername());
		if (u == null) {
			return null;
		}

		return u;
	}

	private User findUser(String username) {
		List<User> users = userRepository.findByUsername(username);
		if (users.size() < 1) {
			return null;
		}
		return users.get(0);
	}

}
