package net.wuollet.jpa.domain.model.event;

import net.wuollet.jpa.domain.model.device.*;

public interface WorkEventRepositoryCustom {

	WorkEventHistory lookupEventHistory(Device device);
}
