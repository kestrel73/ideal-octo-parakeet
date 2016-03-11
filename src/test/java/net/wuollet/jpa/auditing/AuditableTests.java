package net.wuollet.jpa.auditing;

import static org.junit.Assert.fail;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class AuditableTests {

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
