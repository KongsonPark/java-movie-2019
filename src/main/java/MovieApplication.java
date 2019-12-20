import domain.Movie;
import domain.MovieRepository;
import domain.Reservation;
import view.InputView;
import view.OutputView;

import java.util.List;

public class MovieApplication {
	public static void main(String[] args) {
		List<Movie> movies = MovieRepository.getMovies();
        Reservation reservation = new Reservation();
		do {
			OutputView.printMovies(movies);
			int movieId = InputView.inputMovieId(movies);
			reservation.reserveMovie(movies, movieId);
		} while (InputView.inputPayOrReserve());

		reservation.printReservationResult();

		System.out.println("결제 진행");

		// TODO 구현 진행
	}
}
