package View.Card;

import java.util.ArrayList;
import java.util.Scanner;

import Controller.CardController;
import Model.Card;
import Model.Pokemon;
import Model.Trainer;

public class ListCards extends SaveCard {

	public ListCards() {
		cardController = new CardController(this);
	}
	
	/**
	 * Ask user which Card select
	 */
	public void constructGUI() {
		Scanner sc = new Scanner(System.in);
		ArrayList<Card> cards = Card.getCards();
		System.out.println("Sélectionnez un Pokemon pour le modifier :");
		for(int i=0; i<cards.size(); i++) {
			System.out.println(i+1 + " - " + cards.get(i).getName());
		}
		System.out.println("0 - Quitter la liste");
		int choice = sc.nextInt();
		if(choice != 0) {
			cardController.displayCards(choice-1);
		}
	}
	
	public Card getData() {
		return cardController.getCard();
	}
}
