package View.Card;

import java.util.Scanner;

import Controller.CardController;
import Controller.TrainerController;
import Model.Card;
import Model.Pokemon;
import Model.View;
import View.Pokemon.ListPokemons;
import View.Pokemon.SavePokemon;
import View.Trainer.SaveTrainer;

public class SaveCard implements View {

	protected CardController cardController;

	@Override
	public void add() {
		askType().add();
	}


	/**
	 * Actions when user chooses to display all the deck
	 */
	@Override
	public void list() {
		ListCards display = new ListCards();
		cardController = display.cardController;
		display.constructGUI();
		Card card = display.getData();
		if(card != null) update(card);
	}

	@Override
	public void update(Card card) {
		cardController.getV(card).update(card);
	}

	@Override
	public void search() {
		
	}

	/**
	 * Ask type of Card
	 * @return Card's view
	 */
	private View askType() {
		Scanner sc = new Scanner(System.in);
		int choice;
		System.out.println("Sélectionnez le type de carte :\n"
				+ "1 - Pokemon\n"
				+ "2 - Trainer");
		choice = sc.nextInt();
		switch(choice) {
		case 1:
			return new SavePokemon();
		case 2:
			return new SaveTrainer();
		default:
			System.out.println("Une erreur s'est produite.");
			break ;
		}
		return askType();
	}


	public void constructGUI() {
		// TODO Auto-generated method stub
		
	}

}
