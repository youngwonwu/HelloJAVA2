package card;

public class DGCard extends Card{
	
	final String company = "대구은행";
	String cardStaff;

	public DGCard(String cardNo, int validDate, int cvc, String cardStaff) {
		super(cardNo, validDate, cvc);
		this.cardStaff = cardStaff;
	}

	@Override
	public void showCardInfo() {
		System.out.println("Card NO : " + this.cardNo + "담당직원 : " + cardStaff + ", " + company);
	}
	
	

}
