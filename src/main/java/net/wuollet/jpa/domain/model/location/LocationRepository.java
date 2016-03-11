package net.wuollet.jpa.domain.model.location;

import org.springframework.data.jpa.repository.*;

public interface LocationRepository extends JpaRepository<Location, Integer> {
	Location findByLocationNumber(LocationNumber locationNumber);
}
