package net.wuollet.jpa.domain.model.event;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.jpa.domain.AbstractAuditable;

import net.wuollet.jpa.domain.model.device.Device;
import net.wuollet.jpa.domain.model.location.Location;
import net.wuollet.jpa.domain.model.operation.Operation;
import net.wuollet.jpa.domain.model.user.User;

@Entity
public class WorkEvent extends AbstractAuditable<User, Long>{

	private static final long serialVersionUID = -179442652596759026L;

	@ManyToOne
	@JoinColumn(name="DEVICE_ID")
	private Device device;

	@Basic
	@Enumerated(EnumType.STRING)
	private Type type;

	@ManyToOne
	@JoinColumn(name="OPERATION_ID")
	private Operation operation;

	@ManyToOne
	@JoinColumn(name="LOCATION_ID")
	private Location locationOf;

	@Basic
	@Temporal(TemporalType.TIMESTAMP)
	private Date timeOf;

	public WorkEvent(final Device d, final Date timeOf, final Type type, final Operation o, final Location l) {
		this.device = d;
		this.timeOf = (Date) timeOf.clone();
		this.type = type;
		this.operation = o;
		this.locationOf = l;
	}

	public Date getTimeOf() {
		return timeOf;
	}

	public Device getDevice() {
		return device;
	}

	public Location getLocationOf() {
		return locationOf;
	}

	public Operation getOperation() {
		return operation;
	}

	public static enum Type {
		Start,
		End
	}

	protected WorkEvent() {
		// required by persistence
	}
}
