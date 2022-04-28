package card;

public class TossCard extends Card {

	final String company = "Toss";
	String cardStaff;

	public TossCard(String cardNo, String cardStaff) {
		super(cardNo);
		this.cardStaff = cardStaff;
	}

	@Override
	public void showCardInfo() {
//		super.showCardInfo();
		System.out.println("Card NO : " + this.cardNo + ", 담당직원 : " + cardStaff + ", " + company);
	}
	
	

}
