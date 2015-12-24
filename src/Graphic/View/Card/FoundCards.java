package Graphic.View.Card;

import java.util.ArrayList;

import Graphic.Controller.CardController;
import Model.Card;

public class FoundCards extends DisplayCards {
	
	public FoundCards(ArrayList<Card> cards) {
		controller = new CardController(this, cards);
		constructGUI();
		//buttonLeave.setActionCommand("returnSearch");
	}

}
