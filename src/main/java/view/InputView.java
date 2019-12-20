package view;

import java.util.List;
import java.util.Scanner;

import domain.Movie;

public class InputView {
	private static final Scanner scanner = new Scanner(System.in);

	public static int inputMovieId(List<Movie> movies) {
		System.out.println("## 예약할 영화를 선택하세요.");
		try {
			int movieId = validateNumber(scanner.nextLine().trim());
			validateMovieId(movies, movieId);
			return movieId;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return inputMovieId(movies);
		}
	}

	private static void validateMovieId(List<Movie> movies, int movieId) {
		if (!movies.stream().anyMatch(movie -> movie.containId(movieId))) {
			throw new IllegalArgumentException("목록에 없는 영화입니다.");
		}
	}

	public static int inputMovieSchedule(Movie selectedMovie) {
		System.out.println("예약할 시간표를 선택하세요");
		try {
			int movieTime = validateNumber(scanner.nextLine().trim());
			validateSchedule(selectedMovie, movieTime);
			return movieTime;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return inputMovieSchedule(selectedMovie);
		}
	}

	private static void validateSchedule(Movie selectedMovie, int time) {
		if (!selectedMovie.isAvailableSchedule(time)) {
			throw new IllegalArgumentException("상영 시간표에 없는 시간입니다.");
		}
	}

	public static int inputMovieTickets(Movie selectedMovie, int time) {
		System.out.println("예약할 인원을 입력하세요");
		try {
			int movieTickets = validateNumber(scanner.nextLine().trim());
			isPositiveNumber(movieTickets);
			checkAvailableTicket(selectedMovie, time, movieTickets);
			return movieTickets;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return inputMovieTickets(selectedMovie, time);
		}
	}

	public static boolean inputPayOrReserve() {
		System.out.println("예약을 종료하고 결제를 진행하려면 1번, 추가 예약을 진행하려면 2번");
		try {
			int input = validateNumber(scanner.nextLine().trim());
			validateOneOrTwo(input);
			return input == 2;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return inputPayOrReserve();
		}
	}

	public static int inputPoint() {
		System.out.println("결제를 진행합니다.");
		System.out.println("포인트 사용금액을 입력하세요. 포인트가 없으면 0 입력");
		try {
			int input = validateNumber(scanner.nextLine().trim());
			isPositiveNumber(input);
			return input;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return inputPoint();
		}
	}

	public static int inputPaymentType() {
		System.out.println("신용카드는 1번, 현금은 2");
		try {
			int input = validateNumber(scanner.nextLine().trim());
			validateOneOrTwo(input);
			return input;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return inputPaymentType();
		}
	}

	private static void validateOneOrTwo(int input) {
		if (input != 1 && input != 2) {
			throw new IllegalArgumentException("올바른 입력값이 아닙니다.");
		}
	}

	private static void checkAvailableTicket(Movie selectedMovie, int time, int tickets) {
		selectedMovie.getPlaySchedule(time).reduceCapacity(tickets);
	}

	private static void isPositiveNumber(int input) {
		if (input < 0) {
			throw new IllegalArgumentException("유효하지 않은 입력값입니다.");
		}
	}

	private static int validateNumber(String input) {
		try {
			return Integer.parseInt(input);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("숫자가 아닙니다.");
		}
	}
}
