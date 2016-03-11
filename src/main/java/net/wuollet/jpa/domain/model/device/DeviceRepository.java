package net.wuollet.jpa.domain.model.device;

import java.util.*;

import org.springframework.data.jpa.repository.*;

public interface DeviceRepository extends JpaRepository<Device, Long> {
	List<Device> findBySerialNumber(SerialNumber serialNumber);

	Device findByTrackingId(TrackingId trackingId);
}
