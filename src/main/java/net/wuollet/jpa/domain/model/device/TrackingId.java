package net.wuollet.jpa.domain.model.device;

import javax.persistence.Basic;
import javax.persistence.Embeddable;

@Embeddable
public final class TrackingId {

	@Basic
	private String id;

	public TrackingId(String id) {
		this.id = id;
	}

	TrackingId() {
		// required for persistence
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TrackingId other = (TrackingId) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return id;
	}


}

