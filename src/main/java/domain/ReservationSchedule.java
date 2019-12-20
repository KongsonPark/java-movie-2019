package domain;

import static utils.DateTimeUtils.*;

import java.time.LocalDateTime;

public class ReservationSchedule extends PlaySchedule {

	public ReservationSchedule(LocalDateTime startDateTime, int capacity) {
		super(startDateTime, capacity);
	}

	@Override
	public String toString() {
		return "시작시간: " + format(super.getStartDateTime()) + "\n" + "예약인원: " + super.getCapacity() + "\n";
	}
}
