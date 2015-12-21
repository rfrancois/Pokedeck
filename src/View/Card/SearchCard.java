package View.Card;

import java.util.Scanner;

import Controller.CardController;

public class SearchCard extends SaveCard {
	
	public SearchCard() {
		cardController = new CardController(this);
	}
	
	public void constructGUI() {
		Scanner sc = new Scanner(System.in);
		String name;
		System.out.println("Tapez le nom de la carte à chercher :");
		name = sc.next();
		cardController.searchCard(name);
	}

}
