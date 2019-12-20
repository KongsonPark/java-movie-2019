package domain;

public class ReservationMovie extends Movie {
	private static final char NEW_LINE = '\n';

	private PlaySchedule playSchedule;

	public ReservationMovie(int id, String name, int price, ReservationSchedule schedule) {
		super(id, name, price);
		this.playSchedule = schedule;
	}

	public PlaySchedule getPlaySchedule() {
		return playSchedule;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(playSchedule);
		return super.getId() + " - " + super.getName() + ", " + super.getPrice() + "원" + NEW_LINE
			+ sb.toString();
	}

}
