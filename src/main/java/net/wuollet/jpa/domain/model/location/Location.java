package net.wuollet.jpa.domain.model.location;

import javax.persistence.*;

import org.springframework.data.jpa.domain.*;

import net.wuollet.jpa.domain.model.user.*;

@Entity
public class Location extends AbstractAuditable<User, Integer>{

	private static final long serialVersionUID = 6400602422538850871L;

	@Embedded
	private LocationNumber locationNumber;

	@Column(nullable = false, unique = true)
	private String name;

	public Location(LocationNumber locationNumber, String name) {
		this.locationNumber = locationNumber;
		this.name = name;
	}

	Location() {
		// required by persistence
	}

	public LocationNumber getLocationNumber() {
		return locationNumber;
	}

	public String getName() {
		return name;
	}

}
