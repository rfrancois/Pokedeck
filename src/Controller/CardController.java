package Controller;

import java.util.ArrayList;

import Model.Card;
import Model.Pokemon;
import Model.Trainer;
import Model.View;
import View.Card.SaveCard;
import View.Energy.SaveEnergy;
import View.Pokemon.SavePokemon;
import View.Trainer.SaveTrainer;

public class CardController {

	private SaveCard v;
	private Card card;

	public CardController(SaveCard v) {
		this.v = v;
	}
	
	public CardController(Card card, SaveCard v) {
		this.card = card;
		this.v = v;
	}

	/**
	 * Fill card variable if index is correct
	 * @param choice Selected Card
	 */
	public void displayCards(int choice) {
		ArrayList<Card> cards = Card.getCards();
		if(choice >= 0 && choice < cards.size()) {
			if(Card.getCards().get(choice) instanceof Pokemon) {
				v = new SavePokemon();
			}
			else if(Card.getCards().get(choice) instanceof Trainer) {
				v = new SaveTrainer();
			}
			else {
				v = new SaveEnergy();
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

	/**
	 * Take cards which macth with search
	 * @param search Value of the search
	 */
	public void searchCard(String search) {
		ArrayList<Card> cards = Card.getCards();
		ArrayList<Card> match = new ArrayList<Card>();
		int compare;
		for(Card card : cards) {
			compare = search.compareToIgnoreCase(card.getName());
			// Allow mistakes in the search
			if(compare >= -5 && compare <= 5) {
				match.add(card);
			}
		}
		if(match.size() == 0) { 
			v.notFound();
			return ;
		}
		v.found(match);
	}

	/**
	 * Delete card from the deck
	 */
	public void deleteCard() {
		// TODO Auto-generated method stub
		Card.getCards().remove(card);
		System.out.println("La carte a été supprimée.");
	}
}
