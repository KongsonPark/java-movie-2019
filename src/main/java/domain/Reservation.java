package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import view.InputView;

public class Reservation {

	List<ReservationMovie> reservationMovieList = new ArrayList<>();

	public void reserveMovie(List<Movie> movies, int movieId) {
		Movie selectedMovie = selectMovie(movies, movieId);
		System.out.println(selectedMovie);

		int time = InputView.inputMovieSchedule(selectedMovie);
		int tickets = InputView.inputMovieTickets(selectedMovie, time);

		reservationMovieList.add(
			new ReservationMovie(selectedMovie.getId(), selectedMovie.getName(), selectedMovie.getPrice(),
				new ReservationSchedule(selectedMovie.getPlaySchedule(time).getStartDateTime(), tickets)));

		System.out.println(selectedMovie);
	}

	private Movie selectMovie(List<Movie> movies, int movieId) {
		Movie selectedMovie = movies.stream()
			.filter(movie -> movie.containId(movieId))
			.collect(Collectors.toList())
			.get(0);
		return selectedMovie;
	}

	public void printReservationResult() {
		for (ReservationMovie reservationMovie : reservationMovieList) {
			System.out.println(reservationMovie);
		}
	}

}
