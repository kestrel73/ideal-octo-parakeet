package net.wuollet.jpa.domain.model.device;

import javax.persistence.*;

import org.springframework.data.jpa.domain.*;

@Entity
@AttributeOverride(name = "id", column=@Column(name="DEVICE_ID"))
public class Device extends AbstractPersistable<Long>{

	private static final long serialVersionUID = 9189774775916208857L;

	@Embedded
	private SerialNumber serialNumber;

	@Embedded
	private final TrackingId trackingId;

	public Device(final TrackingId trackingId) {
		this.trackingId = trackingId;
	}

	public SerialNumber getSerialNumber() {
		return serialNumber;
	}

	public TrackingId getTrackingId() {
		return trackingId;
	}
}
