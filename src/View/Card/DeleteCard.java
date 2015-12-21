package View.Card;

import java.util.Scanner;

import Controller.CardController;
import Model.Card;

public class DeleteCard extends SaveCard {

	public DeleteCard(Card card) {
		cardController = new CardController(card, this);
	}
	
	public void constructGUI() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Etes vous sûr de vouloir supprimer la carte " + cardController.getCard().getName() + " ?\n"
				+ "1 - Oui\n"
				+ "0 - Non");
		int index = sc.nextInt();
		if(index == 0) return ;
		if(index != 1) constructGUI();
		cardController.deleteCard();
	}
}
