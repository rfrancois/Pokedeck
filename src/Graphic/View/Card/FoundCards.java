package Graphic.View.Card;

import java.util.ArrayList;

import Graphic.Controller.CardController;
import Model.Card;

public class FoundCards extends DisplayCards {
	
	public FoundCards(ArrayList<Card> cards) {
		controller = new CardController(this, cards);
		constructGUI();
	}
	
	public FoundCards(ArrayList<Card> cards, SaveCard prevView) {
		this(cards);
		this.prevView = prevView;
	}

}
