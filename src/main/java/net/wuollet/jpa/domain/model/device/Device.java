package net.wuollet.jpa.domain.model.device;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@AttributeOverride(name = "id", column=@Column(name="DEVICE_ID"))
public class Device extends AbstractPersistable<Long>{

	private static final long serialVersionUID = 9189774775916208857L;

	@Embedded
	private SerialNumber serialNumber;

	@Embedded
	private TrackingId trackingId;

	public Device(final TrackingId trackingId) {
		this.trackingId = trackingId;
	}

	protected Device() {
		// required for persistence
	}

	public SerialNumber getSerialNumber() {
		return serialNumber;
	}

	public TrackingId getTrackingId() {
		return trackingId;
	}
}
