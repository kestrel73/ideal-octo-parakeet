package net.wuollet.jpa.domain.model.event;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import net.wuollet.jpa.domain.model.device.*;
import net.wuollet.jpa.domain.model.location.*;
import net.wuollet.jpa.domain.model.operation.*;

@Component
public class WorkEventFactory {

	private final DeviceRepository deviceRepository;
	private final OperationRepository operationRepository;
	private final LocationRepository locationRepository;


	@Autowired
	public WorkEventFactory(final DeviceRepository deviceRepository,
							final OperationRepository operationRepository,
							final LocationRepository locationRepository) {
		this.deviceRepository = deviceRepository;
		this.operationRepository = operationRepository;
		this.locationRepository = locationRepository;
	}

	public WorkEvent createWorkEvent(Date timeOf, TrackingId trackingId, OperationName operationName,
			LocationNumber locationNumber, WorkEvent.Type type) throws CantCreateWorkEventException {

		final Device device = findDevice(trackingId);
		final Operation operation = findOperation(operationName);
		final Location location = findLocation(locationNumber);

		try {
			return new WorkEvent(device, timeOf, type, operation, location);
		} catch (Exception e) {
			throw new CantCreateWorkEventException(e);
		}

	}

	private Device findDevice(TrackingId trackingId) throws UnknownDeviceException {
		Device device = deviceRepository.findByTrackingId(trackingId);
		if (device == null) {
			throw new UnknownDeviceException(trackingId);
		}
		return device;
	}

	private Operation findOperation(OperationName operationName) throws UnknownOperationException {
		Operation operation = operationRepository.findByOperationName(operationName);
		if (operation == null) {
			throw new UnknownOperationException(operationName);
		}
		return operation;
	}

	private Location findLocation(LocationNumber locationNumber) throws UnknownLocationException {
		Location location = locationRepository.findByLocationNumber(locationNumber);
		if (location == null) {
			throw new UnknownLocationException(locationNumber);
		}
		return location;
	}

}
