package Graphic.View.Card;

import Graphic.Controller.CardController;

public class AllCards extends DisplayCards {

	public AllCards() {
		controller = new CardController(this);
		constructGUI();
	}
}
