package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import view.InputView;

public class Reservation {

	List<ReservationMovie> reservationMovieList = new ArrayList<>();

	public void reserveMovie(List<Movie> movies, int movieId) {
		try {
			checkDuplicatedMovie(movieId);
			Movie selectedMovie = selectMovie(movies, movieId);
			System.out.println(selectedMovie);
			int time = InputView.inputMovieSchedule(selectedMovie, reservationMovieList);
			int tickets = InputView.inputMovieTickets(selectedMovie, time);
			addToReservedMovieList(selectedMovie, time, tickets);
			printReservationResult();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}

	private void addToReservedMovieList(Movie selectedMovie, int time, int tickets) {
		reservationMovieList.add(
			new ReservationMovie(selectedMovie.getId(), selectedMovie.getName(), selectedMovie.getPrice(),
				new ReservationSchedule(selectedMovie.getPlaySchedule(time).getStartDateTime(), tickets)));
	}

	private Movie selectMovie(List<Movie> movies, int movieId) {
		Movie selectedMovie = movies.stream()
			.filter(movie -> movie.containId(movieId))
			.collect(Collectors.toList())
			.get(0);
		return selectedMovie;
	}

	private void printReservationResult() {
		for (ReservationMovie reservationMovie : reservationMovieList) {
			System.out.println(reservationMovie);
		}
	}

	public double getTotalTicketMoney() {
		double total = 0;
		for (ReservationMovie reservationMovie : reservationMovieList) {
			total += reservationMovie.getPrice() * (reservationMovie.getPlaySchedule().getCapacity());
		}
		return total;
	}

	public void checkDuplicatedMovie(int movieId) {
		if (reservationMovieList.stream().anyMatch(reservationMovie -> reservationMovie.containId(movieId))) {
			throw new IllegalArgumentException("일행과 같은 영화를 선택할 수 없습니다.");
		}
	}

}
