package net.wuollet.jpa.domain.model.event;

import static java.util.Collections.*;

import java.util.*;

public class WorkEventHistory {

	private final List<WorkEvent> events;

	public WorkEventHistory(Collection<WorkEvent> events) {
		this.events = new ArrayList<>(events);
	}

	public WorkEvent mostRecentEvent() {
		final List<WorkEvent> distinctEvents = distinctEventsByTimeOf();
		if (distinctEvents.isEmpty()) {
			return null;
		} else {
			return distinctEvents.get(distinctEvents.size() - 1);
		}
	}

	public List<WorkEvent> distinctEventsByTimeOf() {
		final List<WorkEvent> ordered = new ArrayList<>(
				new HashSet<>(this.events));
		sort(ordered, BY_TIME_OF_COMPARATOR);
		return Collections.unmodifiableList(ordered);
	}

	private static final Comparator<WorkEvent> BY_TIME_OF_COMPARATOR =
			(e1, e2) -> e1.getTimeOf().compareTo(e2.getTimeOf());
}
