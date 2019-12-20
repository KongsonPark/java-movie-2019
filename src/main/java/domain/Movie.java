package domain;

import java.util.ArrayList;
import java.util.List;

public class Movie {
	private static final char NEW_LINE = '\n';

	private final int id;
	private final String name;
	private final int price;

	private List<PlaySchedule> playSchedules = new ArrayList<>();

	public Movie(int id, String name, int price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public boolean containId(int movieId) {
		return this.id == movieId;
	}

	void addPlaySchedule(PlaySchedule playSchedule) {
		playSchedules.add(playSchedule);
	}

	public PlaySchedule getPlaySchedule(int scheduleIndex) {
		return playSchedules.get(scheduleIndex - 1);
	}

	public boolean isAvailableSchedule(int scheduleIndex) {
		return playSchedules.size() >= scheduleIndex && scheduleIndex != 0;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (PlaySchedule playSchedule : playSchedules) {
			sb.append(playSchedule);
		}
		return id + " - " + name + ", " + price + "원" + NEW_LINE
			+ sb.toString();
	}
}
