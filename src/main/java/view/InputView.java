package view;

import java.util.Scanner;

import domain.Movie;

public class InputView {
	private static final Scanner scanner = new Scanner(System.in);

	public static int inputMovieId() {
		System.out.println("## 예약할 영화를 선택하세요.");
		try {
			int movieId = validateNumber(scanner.nextLine().trim());
			return movieId;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return inputMovieId();
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
			checkAvailableTicket(selectedMovie, time, movieTickets);
			return movieTickets;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return inputMovieTickets(selectedMovie, time);
		}
	}

	private static void checkAvailableTicket(Movie selectedMovie, int time, int tickets) {
		selectedMovie.getPlaySchedule(time).reduceCapacity(tickets);
	}

	private static int validateNumber(String input) {
		try {
			return Integer.parseInt(input);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("숫자가 아닙니다.");
		}
	}
}
