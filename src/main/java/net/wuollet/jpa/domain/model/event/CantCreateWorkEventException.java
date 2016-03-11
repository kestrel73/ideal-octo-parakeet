package net.wuollet.jpa.domain.model.event;

public class CantCreateWorkEventException extends Exception {

	private static final long serialVersionUID = 27505047921418805L;

	public CantCreateWorkEventException(Exception e) {
		super(e);
	}

	public CantCreateWorkEventException() {
		super();
	}

}
