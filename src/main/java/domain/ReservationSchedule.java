package domain;

import java.time.LocalDateTime;

public class ReservationSchedule extends PlaySchedule {

	public ReservationSchedule(LocalDateTime startDateTime, int capacity) {
		super(startDateTime, capacity);
	}
}
