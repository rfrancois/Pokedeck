package Terminal.View.Pokemon;

import java.util.ArrayList;
import java.util.Scanner;

import Model.Attack;
import Model.Energy;
import Model.Pokemon;
import Terminal.Controller.PokemonController;

public class UpdatePokemon extends SavePokemon {

	public UpdatePokemon(Pokemon pokemon) {
		pokemonController = new PokemonController(pokemon, this);
	}

	public void constructGUI() {
		Scanner sc = new Scanner(System.in);
		int choice;
		System.out.println(pokemonController.getPokemon());
		System.out.println("Apporter une modification sur :\n"
				+ "1 - Le nom\n"				
				+ "2 - La santé\n"
				+ "3 - Les energies du Pokemon\n"
				+ "4 - Les attaques\n"
				+ "5 - L'evolution précédente du Pokémon\n"
				+ "6 - L'évolutiones suivante du Pokémon\n"
				+ "7 - Le numéro de carte collector\n"
				+ "8 - Le numéro d'expansion\n"
				+ "9 - Supprimer le Pokemon\n"
				+ "0 - Quitter la modification");
		choice = sc.nextInt();
		pokemonController.updatePokemon(choice);
	}

}
