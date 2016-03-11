package net.wuollet.jpa.domain.model.event;

import net.wuollet.jpa.domain.model.operation.*;

public class UnknownOperationException extends CantCreateWorkEventException {

	private static final long serialVersionUID = 7859361837078271021L;

	private final OperationName operationName;

	public UnknownOperationException(final OperationName operationName) {
		this.operationName = operationName;
	}

	@Override
	public String getMessage() {
		return "No operation with name " + operationName + " exists in the system";
	}
}
