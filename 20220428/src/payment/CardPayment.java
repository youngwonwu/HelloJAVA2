package payment;

public class CardPayment implements Payment{
	
	double cardRatio;
	double sum1;
	double sum2;

	public CardPayment(double cardRatio) {
		super();
		this.cardRatio = cardRatio;
	}

	@Override
	public int online(int price) {
		price = (int) (price * (1-sum1));
		return price;
	}

	@Override
	public int offline(int price) {
		price = (int) (price * (1-sum2));
		return price;
	}

	@Override
	public void showInfo() {
		System.out.println("*** 카드로 결제 시 할인정보");
		sum1 = ONLINE_PAYMENT_RATIO + cardRatio;
		System.out.println("온라인 결제시 총 할인율 : " + sum1);
		sum2 = OFFLINE_PAYMENT_RATIO + cardRatio;
		System.out.println("오프라인 결제시 총 할인율 : " + sum2);
	}

}
