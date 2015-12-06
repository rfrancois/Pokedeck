package View.Pokemon;

import java.util.ArrayList;
import java.util.Scanner;

import Controller.PokemonController;
import Model.Attack;
import Model.Energy;
import Model.Energy.EnergyTypes;
import Model.Pokemon;

public class SavePokemon {
	
	protected PokemonController pokemonController;
	protected Scanner sc = new Scanner(System.in);
	
	/**
	 * Ask pokemon name and check if the string is correct
	 * @return Pokemon name
	 */
	public String getName() {
		System.out.println("Quel est le nom du Pokémon ?");
		String name = sc.next();
		if(name.isEmpty()) {
			System.out.println("Erreur.");
			return getName();
		}
		return name;
	}
	
	public String getAttackName() {
		System.out.println("Nom de l'attaque :");
		return sc.next();
	}
	
	public int getAttackDamage() {
		System.out.println("Nombre de dommage de l'attaque :");
		return sc.nextInt();
	}
	
	public int getHealth() {
		System.out.println("Points de vie :");
		return sc.nextInt();
	}
	
	public int getCollectorCardNumber() {
		System.out.println("Numéro de carte collector :");
		return sc.nextInt();
	}
	
	public int getExpansionSymbol() {
		System.out.println("Symbole d'expansion :");
		return sc.nextInt();
	}
	
	/**
	 * Ask user about Pokemon energy types
	 * @return List of energy types
	 */
	public ArrayList<Energy.EnergyTypes> getEnergyType() {
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
		// Don't leave until there is at least 1 energy in the least
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
}
