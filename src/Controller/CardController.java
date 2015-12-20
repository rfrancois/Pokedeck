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
		ArrayList<Pokemon> pokemons = Pokemon.getPokemons();
		ArrayList<Trainer> trainers = Trainer.getTrainers();
		if(choice >= 0 && choice < pokemons.size()) {
			v = new SavePokemon();
			card = pokemons.get(choice);
			return ;
		}
		else {
			choice -= pokemons.size();
			if(choice >= 0 && choice < trainers.size()) {
				v = new SaveTrainer();
				card = trainers.get(choice);
				return ;
			}
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
