package net.wuollet.jpa.application;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.*;
import org.mockito.*;

import net.wuollet.jpa.application.impl.*;
import net.wuollet.jpa.domain.model.device.*;
import net.wuollet.jpa.domain.model.event.*;
import net.wuollet.jpa.domain.model.event.WorkEvent.*;
import net.wuollet.jpa.domain.model.location.*;
import net.wuollet.jpa.domain.model.operation.*;

public class WorkEventServiceTest {

	private WorkEventServiceImpl service;
	private DeviceRepository deviceRepository;
	private OperationRepository operationRepository;
	private LocationRepository locationRepository;
	private WorkEventRepository workEventRepository;

	private final Device device = new Device(new TrackingId("123"));
	private final Operation op1 = new Operation(new OperationName("Op1"));
	private final Location loc1 = new Location(new LocationNumber("Loc1"), "Location 1");


	@Before
	public void setUp() throws Exception {
		deviceRepository = mock(DeviceRepository.class);
		operationRepository = mock(OperationRepository.class);
		locationRepository = mock(LocationRepository.class);
		workEventRepository = mock(WorkEventRepository.class);

		WorkEventFactory workEventFactory = new WorkEventFactory(deviceRepository, operationRepository, locationRepository);
		service = new WorkEventServiceImpl(workEventRepository, workEventFactory);

	}

	@After
	public void tearDown() throws Exception {

	}

	@Test
	public void testRegisterWorkEvent() throws Exception {

		when(deviceRepository.findByTrackingId(device.getTrackingId())).thenReturn(device);
		when(operationRepository.findByOperationName(op1.getOperationName())).thenReturn(op1);
		when(locationRepository.findByLocationNumber(loc1.getLocationNumber())).thenReturn(loc1);

		service.registerWorkEvent(device.getTrackingId(), op1.getOperationName(), loc1.getLocationNumber(), Type.Start);

		ArgumentCaptor<WorkEvent> argument = ArgumentCaptor.forClass(WorkEvent.class);
		verify(workEventRepository).save(argument.capture());
		assertEquals(device, argument.getValue().getDevice());
		assertEquals(op1, argument.getValue().getOperation());
		assertEquals(loc1, argument.getValue().getLocationOf());
		assertNotNull(argument.getValue().getTimeOf());

	}

}
