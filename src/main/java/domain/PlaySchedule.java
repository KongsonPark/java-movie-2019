package domain;

import java.time.LocalDateTime;

import static utils.DateTimeUtils.format;

public class PlaySchedule {
	private final LocalDateTime startDateTime;
	private int capacity;

	public PlaySchedule(LocalDateTime startDateTime, int capacity) {
		this.startDateTime = startDateTime;
		this.capacity = capacity;
	}

	public LocalDateTime getStartDateTime() {
		return startDateTime;
	}

	public int getCapacity() {
		return capacity;
	}

	public void reduceCapacity(int tickets) {
		if (capacity < tickets) {
			throw new IllegalArgumentException("인원 대비 자리가 부족합니다.");
		}
		capacity -= tickets;
	}

	@Override
	public String toString() {
		return "시작시간: " + format(startDateTime) + " 예약가능인원: " + capacity + "\n";
	}
}
