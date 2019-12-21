package pay;

public class Pay {
	private static final double CREDIT_CARD_DISCOUNT = 0.95;
	private static final double CASH_DISCOUNT = 0.98;
	private static final double CREDIT_CARD = 1;
	private static final double CASH = 2;

	private static double getPayment(int paymentType, double payMoney, int point) {
		double payment = 0;

		if (paymentType == CREDIT_CARD) {
			payment = (payMoney - point) * CREDIT_CARD_DISCOUNT;
		}
		if (paymentType == CASH) {
			payment = (payMoney - point) * CASH_DISCOUNT;
		}
		if (payment < 0) {
			return 0;
		}
		return payment;
	}

	public static void printPaymentResult(int paymentType, double payMoney, int point) {
		double payment = getPayment(paymentType, payMoney, point);
		System.out.println("최종 결제한 금액은 " + (int)payment + "원 입니다.");
		System.out.println("예매를 완료했습니다. 즐거운 영화 관람되세요");
	}

}
