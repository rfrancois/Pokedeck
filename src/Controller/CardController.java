package Controller;

import java.util.ArrayList;

import Model.Card;
import Model.Pokemon;
import Model.Trainer;
import Model.View;
import View.Card.SaveCard;
import View.Pokemon.SavePokemon;
import View.Trainer.SaveTrainer;

public class CardController {

	private SaveCard v;
	private Card card;

	public CardController(SaveCard v) {
		this.v = v;
	}

	/**
	 * Fill card variable if index is correct
	 * @param choice Selected Card
	 */
	public void displayCards(int choice) {
		ArrayList<Card> cards = Card.getCards();
		if(choice >= 0 && choice < cards.size()) {
			if(card instanceof Pokemon) {
				v = new SavePokemon();
			}
			else {
				v = new SaveTrainer();
			}
			card = cards.get(choice);
			return ;
		}
		v.constructGUI();
	}

	public Card getCard() {
		return card;
	}
	
	public SaveCard getV(Card card) {
		return v;
	}
}
