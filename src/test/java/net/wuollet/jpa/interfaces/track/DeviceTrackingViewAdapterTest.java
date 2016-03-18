package net.wuollet.jpa.interfaces.track;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import org.junit.Test;
import org.springframework.context.support.StaticApplicationContext;

import net.wuollet.jpa.domain.model.device.Device;
import net.wuollet.jpa.domain.model.device.TrackingId;
import net.wuollet.jpa.domain.model.event.WorkEvent;
import net.wuollet.jpa.domain.model.event.WorkEvent.Type;
import net.wuollet.jpa.domain.model.location.Location;
import net.wuollet.jpa.domain.model.location.LocationNumber;
import net.wuollet.jpa.domain.model.operation.Operation;
import net.wuollet.jpa.domain.model.operation.OperationName;

public class DeviceTrackingViewAdapterTest {

	@Test
	public void testDeviceTrackingViewAdapterDeviceMessageSourceLocaleListOfWorkEventTimeZone() {

		Operation op1 = new Operation(new OperationName("Op1"));
		Operation op2 = new Operation(new OperationName("Op2"));
		Operation op3 = new Operation(new OperationName("Op3"));

		Location loc1 = new Location(new LocationNumber("Loc1"), "Location 1");
		Location loc2 = new Location(new LocationNumber("Loc2"), "Location 2");
		Location loc3 = new Location(new LocationNumber("Loc3"), "Location 3");

		Device device = new Device(new TrackingId("XXX"));

		List<WorkEvent> events = new ArrayList<>();
		events.add(new WorkEvent(device, new Date(1), Type.Start, op1, loc1));
		events.add(new WorkEvent(device, new Date(2), Type.Start, op2, loc2));
		events.add(new WorkEvent(device, new Date(3), Type.Start, op3, loc3));

		StaticApplicationContext applicationContext = new StaticApplicationContext();
		//applicationContext.addM

		DeviceTrackingViewAdapter adapter = new DeviceTrackingViewAdapter(device, applicationContext, Locale.US, events, TimeZone.getTimeZone("US/Central"));

		assertEquals("XXX", adapter.getTrackingId());

		Iterator<DeviceTrackingViewAdapter.WorkEventViewAdapter> it = adapter.getEvents().iterator();

		DeviceTrackingViewAdapter.WorkEventViewAdapter event = it.next();
		assertEquals("Op1", event.getOperation());
		assertEquals("Loc1", event.getLocation());
		assertEquals("Dec 31, 1969 6:00:00 PM", event.getTimeOf());

		event = it.next();
		assertEquals("Op2", event.getOperation());
		assertEquals("Loc2", event.getLocation());
		assertEquals("Dec 31, 1969 6:00:00 PM", event.getTimeOf());



	}

}
