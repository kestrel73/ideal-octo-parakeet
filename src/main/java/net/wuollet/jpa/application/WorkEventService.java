package net.wuollet.jpa.application;

import net.wuollet.jpa.domain.model.device.*;
import net.wuollet.jpa.domain.model.event.*;
import net.wuollet.jpa.domain.model.location.*;
import net.wuollet.jpa.domain.model.operation.*;

public interface WorkEventService {

	void registerWorkEvent(TrackingId trackingId, OperationName operationName,
			LocationNumber locationNumber, WorkEvent.Type type) throws CantCreateWorkEventException;
}
