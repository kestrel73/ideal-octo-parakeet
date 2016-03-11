package net.wuollet.jpa;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import javax.transaction.*;

import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.*;
import org.springframework.data.jpa.domain.support.*;
import org.springframework.security.test.context.support.*;
import org.springframework.test.context.junit4.*;
import org.springframework.test.util.*;

import net.wuollet.jpa.domain.model.operation.*;
import net.wuollet.jpa.domain.model.user.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {JpaTestsApplication.class})
public class JpaTestsApplicationTests {


	@Autowired private UserRepository userRepository;
	@Autowired private OperationRepository operationRepository;
//	@Autowired private MockAuditorAware auditorAware;
	@Autowired private AuditingEntityListener listener;

	@Test
	@Transactional
	@WithUserDetails
	public void createOperation() {

		assertThat(ReflectionTestUtils.getField(listener, "handler"), is(notNullValue()));

		User u = userRepository.findOne(1);

		Operation op1 = new Operation(new OperationName("op1"));

		op1 = operationRepository.save(op1);

		assertEquals(u, op1.getCreatedBy());

		System.out.println(op1.toString());

	}
}

