package Terminal.View.Card;

import java.util.ArrayList;
import java.util.Scanner;

import Model.Card;
import Model.Pokemon;
import Model.Trainer;
import Terminal.Controller.CardController;
import Terminal.Controller.TrainerController;
import Terminal.View.Energy.SaveEnergy;
import Terminal.View.Pokemon.SavePokemon;
import Terminal.View.Trainer.SaveTrainer;

public class SaveCard {

	protected CardController cardController;

	public void add() {
		askType().add();
	}


	/**
	 * Actions when user chooses to display all the deck
	 */
	public void list() {
		ListCards display = new ListCards();
		cardController = display.cardController;
		display.constructGUI();
		Card card = display.getData();
		if(card != null) update(card);
	}

	public void update(Card card) {
		cardController.getV(card).update(card);
	}

	public void search() {
		SearchCard search = new SearchCard();
		search.constructGUI();
	}
	
	public void delete(Card card) {
		DeleteCard delete = new DeleteCard(card);
		delete.constructGUI();
	}

	/**
	 * Ask type of Card
	 * @return Card's view
	 */
	private SaveCard askType() {
		Scanner sc = new Scanner(System.in);
		int choice;
		System.out.println("Sélectionnez le type de carte :\n"
				+ "1 - Pokemon\n"
				+ "2 - Trainer\n"
				+ "3 - Energie");
		choice = sc.nextInt();
		switch(choice) {
		case 1:
			return new SavePokemon();
		case 2:
			return new SaveTrainer();
		case 3:
			return new SaveEnergy();
		default:
			System.out.println("Une erreur s'est produite.");
			break ;
		}
		return askType();
	}

	/**
	 * Display message when pokemon was not found
	 */
	public void notFound() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Aucune carte ne correspond à ce nom.\n"
				+ "1 - Refaire une recherche\n"
				+ "0 - Quitter la recherche");
		int index = sc.nextInt();
		if(index != 1 && index != 0) {
			System.out.println("Une erreur est survenue.");
			notFound();
			return ;
		}
		if(index == 1) {
			constructGUI();
		}
	}
	
	/**
	 * Display list of pokemons when search matched pokemons
	 * @param pokemons List of pokemons
	 */
	public void found(ArrayList<Card> cards) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Sélectionnez le Pokemon :");
		int i;
		for(i=0; i<cards.size(); i++) {
			System.out.println(i+1 + " - " + cards.get(i).getName());
		}
		// Add a choice to do another search
		i++;
		System.out.println(i + " - Refaire une recherche");
		System.out.println("0 - Quitter la recherche");
		int index = sc.nextInt();
		if(index < 0 || index > cards.size()+1) {
			System.out.println("Une erreur est survenue.");
			found(cards);
			return ;
		}
		if(index == 0) {
			return ;
		}
		// If index isn't equal to "Refaire une recherche"
		else if(index == i) {
			constructGUI();
			return ;
		}
		cardController.displayCards(index-1);
		update(cardController.getCard());
	}

	public void constructGUI() {
		// TODO Auto-generated method stub
		
	}

}
