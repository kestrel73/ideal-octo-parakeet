package net.wuollet.jpa.domain.model.location;

import javax.persistence.*;

import org.apache.commons.lang3.*;

@Embeddable
public class LocationNumber {

	@Column(name="LOCATION_NUMBER")
	private String number;

	public LocationNumber(String number) {
		Validate.notNull(number, "Location number may not be null");

		this.number = number;
	}

	LocationNumber() {
		// required by persistence
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((number == null) ? 0 : number.hashCode());
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
		LocationNumber other = (LocationNumber) obj;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return number;
	}



}
