package net.wuollet.jpa.domain.model.device;

import javax.persistence.*;

@Embeddable
public class SerialNumber {

	@Column(name="SERIAL_NUMBER")
	private String number;

	public SerialNumber(String number) {
		this.number = number;
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
		SerialNumber other = (SerialNumber) obj;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		return true;
	}



	SerialNumber() {
		// needed by persistence
	}

}
