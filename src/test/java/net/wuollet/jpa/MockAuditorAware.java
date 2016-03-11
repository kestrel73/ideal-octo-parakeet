package net.wuollet.jpa;

import org.springframework.data.domain.*;

import net.wuollet.jpa.domain.model.user.*;

//@Component
public class MockAuditorAware implements AuditorAware<User> {

	private User currentAuditor;

	@Override
	public User getCurrentAuditor() {
		return this.currentAuditor;
	}

	public void setCurrentAuditor(User user) {
		this.currentAuditor = user;
	}

}
