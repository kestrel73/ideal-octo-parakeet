package net.wuollet.jpa;

import org.springframework.context.annotation.*;
import org.springframework.security.core.userdetails.*;

import net.wuollet.jpa.security.*;

@Configuration
//@EnableGlobalAuthentication
public class SecurityConfiguration {

//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//
//		auth
//			.inMemoryAuthentication()
//				.withUser("user").password("password").roles("ADMIN");
//
//		try {
//			auth.userDetailsService(userDetailsService())
//			.passwordEncoder(NoOpPasswordEncoder.getInstance());
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

	@Bean
	public UserDetailsService userDetailsService() {
		return new CustomUserDetailsService();
	}
}
