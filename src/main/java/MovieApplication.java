import pay.Pay;
import domain.Movie;
import domain.MovieRepository;
import domain.Reservation;
import view.InputView;
import view.OutputView;

import java.util.List;

public class MovieApplication {
	public static void main(String[] args) {
		Reservation reservation = new Reservation();
		do {
			List<Movie> movies = MovieRepository.getMovies();
			OutputView.printMovies(movies);
			int movieId = InputView.inputMovieId(movies);
			reservation.reserveMovie(movies, movieId);
		} while (InputView.inputPayOrReserve());

		double totalTickets = reservation.getTotalTicketMoney();
		int point = InputView.inputPoint();
		int paymentType = InputView.inputPaymentType();
		Pay.printPaymentResult(paymentType, totalTickets, point);
	}
}
