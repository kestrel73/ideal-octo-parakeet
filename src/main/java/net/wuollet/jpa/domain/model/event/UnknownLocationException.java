package net.wuollet.jpa.domain.model.event;

import net.wuollet.jpa.domain.model.location.*;

public class UnknownLocationException extends CantCreateWorkEventException {

	private static final long serialVersionUID = -3555545401389141908L;

	private final LocationNumber locationNumber;

	public UnknownLocationException(final LocationNumber locationNumber) {
		this.locationNumber = locationNumber;
	}

	@Override
	public String getMessage() {
		return "No location with number " + locationNumber + " exists in the system";
	}
}
