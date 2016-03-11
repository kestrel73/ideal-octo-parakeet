package net.wuollet.jpa.domain.model.operation;

import javax.persistence.*;

import org.springframework.data.jpa.domain.*;

import net.wuollet.jpa.domain.model.user.*;

@Entity
public class Operation extends AbstractAuditable<User, Integer>{

	private static final long serialVersionUID = -2999158292473167827L;

	@Embedded
	private OperationName operationName;

	public Operation(OperationName operationName) {
		this.operationName = operationName;
	}

	Operation() {
		// required by persistence
	}

	public OperationName getOperationName() {
		return operationName;
	}


	@Override
	public String toString() {
		return "Operation: " + operationName;
	}



}
