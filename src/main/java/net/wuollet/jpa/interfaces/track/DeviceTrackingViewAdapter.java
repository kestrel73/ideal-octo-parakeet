package net.wuollet.jpa.interfaces.track;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import org.springframework.context.MessageSource;

import net.wuollet.jpa.domain.model.device.Device;
import net.wuollet.jpa.domain.model.event.WorkEvent;

public final class DeviceTrackingViewAdapter {

	private final Device device;
	private final MessageSource messageSource;
	private final Locale locale;
	private final List<WorkEventViewAdapter> events;
	private final TimeZone timeZone;


	public DeviceTrackingViewAdapter(Device device, MessageSource messageSource, Locale locale, List<WorkEvent> workEvents) {
		this(device, messageSource, locale, workEvents, TimeZone.getDefault());
	}

	public DeviceTrackingViewAdapter(Device device, MessageSource messageSource, Locale locale,
			List<WorkEvent> workEvents, TimeZone timeZone) {
		this.messageSource = messageSource;
		this.device = device;
		this.locale = locale;
		this.timeZone = timeZone;

		this.events = new ArrayList<WorkEventViewAdapter>(workEvents.size());
		for (WorkEvent workEvent : workEvents) {
			events.add(new WorkEventViewAdapter(workEvent));
		}
	}

	public String getTrackingId() {
		return this.device.getTrackingId().toString();
	}

	public List<WorkEventViewAdapter> getEvents() {
		return Collections.unmodifiableList(this.events);
	}

	public String getSerialNumber() {
		return device.getSerialNumber().toString();
	}

	public final class WorkEventViewAdapter {

		private final WorkEvent event;

		public WorkEventViewAdapter(WorkEvent event) {
			this.event = event;
		}

		public String getLocation() {
			return event.getLocationOf().getLocationNumber().toString();
		}

		public String getOperation() {
			return event.getOperation().getOperationName().toString();
		}

		public String getTimeOf() {
			// New Java 8 Time support new to me.  Review this.
			DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
			ZonedDateTime zdt = ZonedDateTime.ofInstant(event.getTimeOf().toInstant(), timeZone.toZoneId());

			return dtf.format(zdt);
		}

		public String getCreatedBy() {
			return event.getCreatedBy().getUsername();
		}
	}

}
