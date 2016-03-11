package net.wuollet.jpa.manufacturing;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.*;

import javax.transaction.*;

import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.*;
import org.springframework.security.test.context.support.*;
import org.springframework.test.context.junit4.*;

import net.wuollet.jpa.*;
import net.wuollet.jpa.domain.model.device.*;
import net.wuollet.jpa.domain.model.event.*;
import net.wuollet.jpa.domain.model.location.*;
import net.wuollet.jpa.domain.model.operation.*;

@WithUserDetails
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {JpaTestsApplication.class})
@Transactional
public class EventRespositoryTests {

	@Autowired OperationRepository operationRepository;
	@Autowired DeviceRepository deviceRepository;
	@Autowired LocationRepository locationRepository;
	@Autowired WorkEventRepository eventRepository;

	Operation wire, kit, trouble;
	Location locA, locB, locC;
	Device devA, devB, devC;
	WorkEvent event1, event2, event3;

	@Before
	public void setUp() throws Exception {
		wire = operationRepository.save(new Operation(new OperationName("wire")));
		kit = operationRepository.save(new Operation(new OperationName("kit")));
		trouble = operationRepository.save(new Operation(new OperationName("trouble")));

		locA = locationRepository.save(new Location(new LocationNumber("L1"),"Location A"));
		locB = locationRepository.save(new Location(new LocationNumber("L2"),"Location B"));
		locC = locationRepository.save(new Location(new LocationNumber("L3"),"Location C"));

		devA = deviceRepository.save(new Device(new TrackingId("A")));
		devB = deviceRepository.save(new Device(new TrackingId("B")));
		devC = deviceRepository.save(new Device(new TrackingId("C")));

		event1 = eventRepository.save(new WorkEvent(devA, new Date(), WorkEvent.Type.Start, wire, locA));
		event2 = eventRepository.save(new WorkEvent(devA, new Date(), WorkEvent.Type.Start, kit, locB));
		event3 = eventRepository.save(new WorkEvent(devA, new Date(), WorkEvent.Type.Start, trouble, locC));

		eventRepository.save(new WorkEvent(devB, new Date(), WorkEvent.Type.Start, trouble, locC));
		eventRepository.save(new WorkEvent(devB, new Date(), WorkEvent.Type.End, trouble, locC));

	}

	@Test
	public void findByDevice() {
		List<WorkEvent> events = eventRepository.findByDeviceOrderByTimeOfDesc(devA);
		assertThat(events, is(notNullValue()));
		assertThat(events.get(0), is(event3));
	}

	@Test
	public void findEventHistory() {
		WorkEventHistory eventHistory = eventRepository.lookupEventHistory(devA);

		assertThat(eventHistory, is(notNullValue()));

		WorkEvent e = eventHistory.mostRecentEvent();
		assertThat(e, is(event3));
	}
}
