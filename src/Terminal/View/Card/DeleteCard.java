package Terminal.View.Card;

import java.util.Scanner;

import Model.Card;
import Terminal.Controller.CardController;

public class DeleteCard extends SaveCard {

	public DeleteCard(Card card) {
		cardController = new CardController(card, this);
	}
	
	/**
	 * Show messages on the terminal to invite user to make its choice on the keyboard
	 */
	public void constructGUI() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Etes vous s�r de vouloir supprimer la carte " + cardController.getCard().getName() + " ?\n"
				+ "1 - Oui\n"
				+ "0 - Non");
		int index = sc.nextInt();
		if(index == 0) return ;
		if(index != 1) constructGUI();
		cardController.deleteCard();
	}
}
