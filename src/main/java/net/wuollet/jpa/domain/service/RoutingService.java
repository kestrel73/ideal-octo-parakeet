package net.wuollet.jpa.domain.service;

import net.wuollet.jpa.domain.model.device.TrackingId;

public interface RoutingService {
	void requestPossibleRoutesForJob(final TrackingId trackingId);
}
