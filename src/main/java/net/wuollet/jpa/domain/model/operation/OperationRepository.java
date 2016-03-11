package net.wuollet.jpa.domain.model.operation;

import org.springframework.data.jpa.repository.*;

public interface OperationRepository extends JpaRepository<Operation, Integer> {

	Operation findByOperationName(OperationName operationName);

}
