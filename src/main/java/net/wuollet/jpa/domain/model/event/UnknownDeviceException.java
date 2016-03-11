package net.wuollet.jpa.domain.model.event;

import net.wuollet.jpa.domain.model.device.*;

public class UnknownDeviceException extends CantCreateWorkEventException {

	private static final long serialVersionUID = -7536278780220477717L;

	private final TrackingId trackingId;

	public UnknownDeviceException(TrackingId trackingId) {
		this.trackingId = trackingId;
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "Can't find Device with TrackingId: " + trackingId;
	}
}
