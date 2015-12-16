package View.Pokemon;

import java.util.ArrayList;
import java.util.Scanner;

import Controller.PokemonController;
import Model.Attack;
import Model.Energy;
import Model.Energy.EnergyTypes;
import Model.Pokemon;
import Terminal.Main;

public class SavePokemon {

	protected PokemonController pokemonController;

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

	/**
	 * Ask user about Pokemon energy types
	 * @return List of energy types
	 */
	public ArrayList<Energy.EnergyTypes> getEnergyType() {
		Scanner sc = new Scanner(System.in);
		ArrayList<Energy.EnergyTypes> energies = new ArrayList<Energy.EnergyTypes>();
		int choice;
		// A pokemon can have further energy types
		// A loop is implemented to ask for energy
		do {
			System.out.println("Choisir l'energie du Pokemon :");
			for(int i=0; i<Energy.EnergyTypes.values().length; i++) {
				// Don't display energy if it's already in the list
				if(!energies.contains(Energy.EnergyTypes.values()[i])) {
					System.out.println(i+1 + " - " + Energy.EnergyTypes.values()[i]);
				}
			}
			System.out.println("0 - Quitter la selection");
			choice = sc.nextInt();
			// If user didn't decide to end his selection, add choice to the list
			// Check if he didn't enter a wrong id
			// or an id alreayd entered
			if(choice > 0 && choice <= Energy.EnergyTypes.values().length && !energies.contains(Energy.EnergyTypes.values()[choice-1])) {
				energies.add(Energy.EnergyTypes.values()[choice-1]);
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

	public void constructGUI() {
		// TODO Auto-generated method stub	
	}

	public Pokemon getData() {
		return pokemonController.getPokemon();
	}

	public Attack selectAttack() {
		return null;
	}

	public ArrayList<Energy.EnergyTypes> getEnergyType(ArrayList<EnergyTypes> energiesTypes) {
		return energiesTypes;
	}

	/**
	 * Choose previous pokemon's previous evolve
	 * @return A pokemon
	 */
	public Pokemon getPrevEvolve() {
		Scanner sc = new Scanner(System.in);
		ArrayList<Pokemon> pokemons = Pokemon.getPokemons();
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
		ArrayList<Pokemon> pokemons = Pokemon.getPokemons();
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
		Main.update(pokemons.get(index-1));
	}
}
