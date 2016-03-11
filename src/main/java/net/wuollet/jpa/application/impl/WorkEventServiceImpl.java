package net.wuollet.jpa.application.impl;

import java.util.*;

import javax.transaction.*;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import net.wuollet.jpa.application.*;
import net.wuollet.jpa.domain.model.device.*;
import net.wuollet.jpa.domain.model.event.*;
import net.wuollet.jpa.domain.model.event.WorkEvent.*;
import net.wuollet.jpa.domain.model.location.*;
import net.wuollet.jpa.domain.model.operation.*;

@Service
public class WorkEventServiceImpl implements WorkEventService {

	private final WorkEventRepository workEventRepository;
	private final WorkEventFactory workEventFactory;

	private final Logger log = LoggerFactory.getLogger(WorkEventServiceImpl.class);


	@Autowired
	public WorkEventServiceImpl(final WorkEventRepository workEventRepository,
								final WorkEventFactory workEventFactory) {
		this.workEventRepository = workEventRepository;
		this.workEventFactory = workEventFactory;
	}



	@Override
	@Transactional
	public void registerWorkEvent(TrackingId trackingId, OperationName operationName,
			LocationNumber locationNumber, Type type) throws CantCreateWorkEventException {

		final Date eventTime = new Date();

		final WorkEvent workEvent = workEventFactory.createWorkEvent(eventTime, trackingId, operationName,
				locationNumber, type);

		workEventRepository.save(workEvent);

		log.info("Registered work event");

	}

}
