package card;

import java.util.Scanner;

public class CardExample {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Card cards = new Card("5732-4567-9534-3657", 20251203, 253);
		cards.showCardInfo();
		
		TossCard tossCards = new TossCard("5732-4567-9534-3657", "신빛용");
		tossCards.showCardInfo();
		
		DGCard dgCards = new DGCard("5732-4567-9534-3657", 20251203, 253, "신빛용");
		dgCards.showCardInfo();

	}

}
