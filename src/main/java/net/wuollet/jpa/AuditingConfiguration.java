package net.wuollet.jpa;

import org.springframework.context.annotation.*;
import org.springframework.data.jpa.repository.config.*;

import net.wuollet.jpa.security.*;

@Configuration
@EnableJpaAuditing
public class AuditingConfiguration {

	@Bean
	SpringSecurityAuditorAware auditorAware() {
		return new SpringSecurityAuditorAware();
	}

}
