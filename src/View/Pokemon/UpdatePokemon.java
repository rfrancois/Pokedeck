package View.Pokemon;

import java.util.ArrayList;

import Controller.PokemonController;
import Model.Attack;
import Model.Energy;
import Model.Pokemon;

public class UpdatePokemon extends SavePokemon {

	public UpdatePokemon(Pokemon pokemon) {
		pokemonController = new PokemonController(pokemon, this);
	}

	public void constructGUI() {
		int choice;
		//do {
		System.out.println(pokemonController.getPokemon());
		System.out.println("Apporter une modification sur :\n"
				+ "1 - Le nom\n"
				+ "2 - Les attaques\n"
				+ "3 - La santé\n"
				+ "4 - L'evolution précédente du Pokémon\n"
				+ "5 - L'évolutiones suivante du Pokémon\n"
				+ "6 - Le numéro de carte collector\n"
				+ "7 - Le numéro d'expansion\n"
				+ "8 - Les energies du Pokémon\n"
				+ "0 - Quitter la modification");
		choice = sc.nextInt();
		pokemonController.updatePokemon(choice);
		//} while(choice != 0);
	}

	/**
	 * Select attack user wants to update
	 * @return Updated attack
	 */
	public Attack selectAttack() {
		int choice;
		Attack attacks[] = pokemonController.getPokemon().getAttacks();
		// Display all the attacks
		for(int i=0; i<attacks.length; i++) {
			System.out.println(i+1 + " - " + attacks[i]);
		}
		System.out.println("0 - Ne pas modifier d'attaque");
		choice = sc.nextInt();
		// If choice doesn't exist in the array
		if(choice < 0 || choice > attacks.length) return null;
		// Update
		return new Attack(getAttackName(), getAttackDamage());
	}

	/**
	 * Ask user about Pokemon energy types
	 * @return List of energy types
	 */
	public ArrayList<Energy.EnergyTypes> getEnergyType(ArrayList<Energy.EnergyTypes> energies) {
		int choice;
		// A pokemon can have further energy types
		// A loop is implemented to ask for energy
		do {
			System.out.println("Modifier les energies du Pokemon :");
			for(int i=0; i<Energy.EnergyTypes.values().length; i++) {
				// Don't display energy if it's already in the list
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

}
