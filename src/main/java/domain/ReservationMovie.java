package domain;

public class ReservationMovie extends Movie {

	private PlaySchedule schedules;

	public ReservationMovie(int id, String name, int price, ReservationSchedule schedule) {
		super(id, name, price);
		this.schedules = schedule;
	}

}
