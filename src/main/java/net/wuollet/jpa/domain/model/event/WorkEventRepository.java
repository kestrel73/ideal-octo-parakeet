package net.wuollet.jpa.domain.model.event;

import java.util.*;

import org.springframework.data.jpa.repository.*;

import net.wuollet.jpa.domain.model.device.*;

public interface WorkEventRepository extends JpaRepository<WorkEvent, Long>, WorkEventRepositoryCustom {

	List<WorkEvent> findByDeviceOrderByTimeOfDesc(Device d);

}
