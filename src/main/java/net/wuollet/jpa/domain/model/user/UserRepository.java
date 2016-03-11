package net.wuollet.jpa.domain.model.user;

import java.util.*;

import org.springframework.data.jpa.repository.*;

public interface UserRepository extends JpaRepository<User, Integer> {
	List<User> findByUsername(String username);
}
