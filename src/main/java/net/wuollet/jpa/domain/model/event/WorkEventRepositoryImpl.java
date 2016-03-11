package net.wuollet.jpa.domain.model.event;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import net.wuollet.jpa.domain.model.device.*;

@Component
public class WorkEventRepositoryImpl implements WorkEventRepositoryCustom {

	@Autowired
	private WorkEventRepository eventRepository;

	@Override
	public WorkEventHistory lookupEventHistory(Device device) {
		List<WorkEvent> events = eventRepository.findByDeviceOrderByTimeOfDesc(device);
		return new WorkEventHistory(events);
	}
}
