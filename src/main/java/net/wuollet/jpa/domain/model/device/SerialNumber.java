package net.wuollet.jpa.domain.model.device;

import java.util.regex.*;

import javax.persistence.*;

import org.apache.commons.lang3.*;

@Embeddable
public class SerialNumber {

	@Column(name="SERIAL_NUMBER")
	private String number;

	private static final Pattern VALID_PATTERN = Pattern.compile("^[0-9]{10}$|^[Ee][A-Za-z-0-9][0-9]{8}$");

	public SerialNumber(final String number) {
		Validate.notNull(number, "Number may not be null");
		Validate.isTrue(VALID_PATTERN.matcher(number).matches(), "%s is not a valid Serial Number (wrong pattern)", number);

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
