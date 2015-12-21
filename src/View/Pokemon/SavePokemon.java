package View.Pokemon;

import java.util.ArrayList;
import java.util.Scanner;

import Controller.PokemonController;
import Model.Attack;
import Model.Card;
import Model.Energy;
import Model.Energy.EnergyTypes;
import Model.Pokemon;
import Model.View;
import Terminal.Main;
import View.Card.SaveCard;

public class SavePokemon extends SaveCard implements View {

	protected PokemonController pokemonController;
	
	/**
	 * Actions when user chooses to add a pokemon
	 */
	public void add() {
		AddPokemon add = new AddPokemon();
		update(add.getData());
	}
	
	/**
	 * Actions when user chooses to display all the deck
	 */
	public void list() {
		ListPokemons display = new ListPokemons();
		display.constructGUI();
		Pokemon pokemon = display.getData();
		if(pokemon != null)	update(pokemon);
	}
	
	/**
	 * Update pokemon
	 * @param pokemon Pokemon to update
	 */
	public void update(Card card) {
		UpdatePokemon up = new UpdatePokemon((Pokemon) card);
		up.constructGUI();
	}
	
	public void search() {
		SearchPokemon search = new SearchPokemon();
		search.constructGUI();		
	}

	/**
	 * Ask pokemon name and check if the string is correct
	 * @return Pokemon name
	 */
	public String getName() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Quel est le nom du Pokémon ?");
		String name = sc.next();
		if(name.isEmpty()) {
			System.out.println("Erreur.");
			return getName();
		}
		return name;
	}

	public String getAttackName() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nom de l'attaque :");
		return sc.nextLine();
	}

	public int getAttackDamage() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nombre de dommage de l'attaque :");
		return sc.nextInt();
	}

	public int getHealth() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Points de vie :");
		return sc.nextInt();
	}

	public int getCollectorCardNumber() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Numéro de carte collector :");
		return sc.nextInt();
	}

	public int getExpansionSymbol() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Symbole d'expansion :");
		return sc.nextInt();
	}

	public void constructGUI() {
		// TODO Auto-generated method stub	
	}

	public Pokemon getData() {
		return pokemonController.getPokemon();
	}

	/**
	 * Select attack user wants to update
	 * @return Updated attack
	 */
	public Attack[] selectAttack() {
		Scanner sc = new Scanner(System.in);
		int choice;
		Attack attacks[] = pokemonController.getPokemon().getAttacks();
		System.out.println("Sélectionnez l'attaque à modifier :");
		// Display all the attacks
		for(int i=0; i<attacks.length; i++) {
			System.out.println(i+1 + " - " + attacks[i]);
		}
		System.out.println("0 - Quitter");
		choice = sc.nextInt();
		// If choice doesn't exist in the array
		if(choice < 0 || choice > attacks.length) return null;
		// Leave function
		if(choice == 0) return attacks; 
		// Update
		attacks[choice-1] = new Attack(getAttackName(), getAttackDamage());
		// Recall function
		selectAttack();
		return attacks;
	}
	
	/**
	 * Ask user about Pokemon energy types
	 * @return List of energy types
	 */
	public ArrayList<Energy.EnergyTypes> getEnergyType() {
		return getEnergyType(new ArrayList<Energy.EnergyTypes>());
	}

	/**
	 * Ask user about Pokemon energy types
	 * @return List of energy types
	 */
	public ArrayList<Energy.EnergyTypes> getEnergyType(ArrayList<Energy.EnergyTypes> energies) {
		Scanner sc = new Scanner(System.in);
		int choice;
		// A pokemon can have further energy types
		// A loop is implemented to ask for energy
		do {
			System.out.println("Modifier les energies du Pokemon :");
			for(int i=0; i<Energy.EnergyTypes.values().length; i++) {
				// Show an information if energy is already in the list
				if(!energies.contains(Energy.EnergyTypes.values()[i])) {
					System.out.println(i+1 + " - " + Energy.EnergyTypes.values()[i]);
				}
				else {
					System.out.println(i+1 + " - " + Energy.EnergyTypes.values()[i] + " (équipé)");
				}
			}
			System.out.println("0 - Quitter la selection");
			choice = sc.nextInt();
			// If user didn't decide to end his selection, add choice to the list
			// Check if he didn't enter a wrong id
			if(choice > 0 && choice <= Energy.EnergyTypes.values().length) {
				// If id is already entered, remove Energy from the list
				if(energies.contains(Energy.EnergyTypes.values()[choice-1])) {
					energies.remove(Energy.EnergyTypes.values()[choice-1]);
				}
				else {
					energies.add(Energy.EnergyTypes.values()[choice-1]);
				}
			}
			// If user selected choice 0 when list is empty
			else if(energies.size() <= 0) {
				choice = -1;
				System.out.println("Vous devez séléctionner au moins un type d'energie.");
			}
			// Don't leave until there is at least 1 energy in the list
			// and user selects choice 0
		} while (choice != 0 || energies.size() <= 0);
		return energies;
	}

	/**
	 * Choose pokemon's previous evolve
	 * @return A pokemon
	 */
	public Pokemon getPrevEvolve() {
		Scanner sc = new Scanner(System.in);
		ArrayList<Pokemon> pokemons = getPokemonsFromCards();
		// If no pokemon was created, return null
		if(pokemons.size() == 0) return null;
		int index;		
		System.out.println("Choisissez l'évolution précédente de votre pokemon :");
		for(int i=0; i<pokemons.size(); i++) {
			System.out.println(i+1 + " - " + pokemons.get(i).getName());
		}
		System.out.println("0 - Pas d'évolution précédente");
		index = sc.nextInt();
		// If index is correct
		if(index < 0 || index > pokemons.size()) {
			System.out.println("Le numéro que vous avez entré ne correspond à aucun Pokemon.");
			// Recall function
			return getPrevEvolve();
		}
		if(index == 0) return null;
		return pokemons.get(index-1);
	}

	/**
	 * Choose previous pokemon's next evolve
	 * @param preEvolve Pokemon's previous evolve
	 * @return A pokemon
	 */
	public Pokemon getNextEvolve(Pokemon preEvolve) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Pokemon> pokemons = getPokemonsFromCards();
		// If no pokemon was created, return null
		if(pokemons.size() == 0) return null;
		int index;
		Pokemon pokemon;
		System.out.println("Choisissez l'évolution suivante de votre pokemon :");
		for(int i=0; i<pokemons.size(); i++) {
			pokemon = pokemons.get(i);
			System.out.print(i+1 + " - " + pokemon.getName());
			// If the pokemon was already selected as previous evolve, show it
			if(pokemon.equals(preEvolve)) {
				System.out.println(" (Evolution précédente)");
			}
			else {
				System.out.println();
			}
		}
		System.out.println("0 - Pas d'évolution suivante");
		index = sc.nextInt();
		// check if index is correct
		if(index < 0 || index > pokemons.size()) {
			System.out.println("Le numéro que vous avez entré ne correspond à aucun Pokemon.");
			// Recall function
			return getNextEvolve(preEvolve);
		}
		if(index == 0) return null;
		// Set pokemon by its index
		pokemon = pokemons.get(index-1);
		// check if user didn't select a previous evolve
		if(pokemon.equals(preEvolve)) {
			System.out.println("Vous ne pouvez pas selectionner un Pokemon qui est déjà une évolution précédente.");
			// Recall function
			return getNextEvolve(preEvolve);
		}
		return pokemon;
	}
	
	/**
	 * Choose previous pokemon's next evolve
	 * @param type Next or previous evolve
	 * @return A pokemon
	 */
	public Pokemon getEvolve(boolean type) {
		ArrayList<Pokemon> prevEvolves = pokemonController.getPokemon().getPrevEvolves();
		ArrayList<Pokemon> nextEvolves = pokemonController.getPokemon().getNextEvolves();
		Scanner sc = new Scanner(System.in);
		ArrayList<Pokemon> pokemons = (ArrayList<Pokemon>) Pokemon.getCards().clone();
		// If no pokemon was created, return null
		if(pokemons.size() == 0) return null;
		int index;
		Pokemon pokemon;
		System.out.print("Choisissez l'évolution");
		if(type) System.out.print(" suivante ");
		else System.out.print(" précédente ");
		System.out.println("de votre pokemon :");
		for(int i=0; i<pokemons.size(); i++) {
			pokemon = pokemons.get(i);
			// If it's the pokemon we are updating
			if(!pokemon.equals(pokemonController.getPokemon())) {
				System.out.print(i+1 + " - " + pokemon.getName());
				// If the pokemon was already selected as evolve, show it
				if(prevEvolves.contains(pokemon) || nextEvolves.contains(pokemon)) {
					System.out.println(" (Stage " + pokemon.getStage() + ")");
				}
				else {
					System.out.println();
				}
			}
			else {
				pokemons.remove(i);
				i--;
			}
		}
		System.out.println("0 - Quitter");
		index = sc.nextInt();
		// check if index is correct
		if(index < 0 || index > pokemons.size()) {
			System.out.println("Le numéro que vous avez entré ne correspond à aucun Pokemon.");
			// Recall function
			return getEvolve(type);
		}
		if(index == 0) return null;
		// Set pokemon by its index
		pokemon = pokemons.get(index-1);
		// check if user didn't select a previous evolve
		/*if(prevEvolves.contains(pokemon) || nextEvolves.contains(pokemon)) {
			System.out.println("Vous ne pouvez pas selectionner un Pokemon qui est déjà une évolution.");
			// Recall function
			return getNextEvolve();
		}*/
		return pokemon;
	}
	
	/**
	 * Display message when pokemon was not found
	 */
	public void notFound() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Aucun Pokemon ne correspond à ce nom.\n"
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
	public void found(ArrayList<Pokemon> pokemons) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Sélectionnez le Pokemon :");
		int i;
		for(i=0; i<pokemons.size(); i++) {
			System.out.println(i+1 + " - " + pokemons.get(i).getName());
		}
		// Add a choice to do another search
		i++;
		System.out.println(i + " - Refaire une recherche");
		System.out.println("0 - Quitter la recherche");
		int index = sc.nextInt();
		if(index < 0 || index > pokemons.size()+1) {
			System.out.println("Une erreur est survenue.");
			found(pokemons);
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
		update(pokemons.get(index-1));
	}
	
	/**
	 * Get Pokemon cards from the deck
	 * @return List of poekmons
	 */
	public ArrayList<Pokemon> getPokemonsFromCards() {
		ArrayList<Pokemon> pokemons = new ArrayList<Pokemon>();
		for(Card card : Card.getCards()) {
	        if(card instanceof Pokemon) {
	            pokemons.add((Pokemon) card);
	        }
	    }
		return pokemons;
	}
}
