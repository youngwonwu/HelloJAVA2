package payment;

public class SimplePayment implements Payment{
	
	double simplePaymentRatio;
	double sum1;
	double sum2;

	public SimplePayment(double simplePaymentRatio) {
		super();
		this.simplePaymentRatio = simplePaymentRatio;
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
		System.out.println("*** 간편결제로 결제 시 할인정보");
		sum1 = ONLINE_PAYMENT_RATIO + simplePaymentRatio;
		System.out.println("온라인 결제시 총 할인율 : " + sum1);
		sum2 = OFFLINE_PAYMENT_RATIO + simplePaymentRatio;
		System.out.println("오프라인 결제시 총 할인율 : " + sum2);
		
	}

}
