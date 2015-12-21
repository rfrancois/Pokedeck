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
				+ "2 - La sant�\n"
				+ "3 - Les energies du Pokemon\n"
				+ "4 - Les attaques\n"
				+ "5 - L'evolution pr�c�dente du Pok�mon\n"
				+ "6 - L'�volutiones suivante du Pok�mon\n"
				+ "7 - Le num�ro de carte collector\n"
				+ "8 - Le num�ro d'expansion\n"
				+ "9 - Supprimer le Pokemon\n"
				+ "0 - Quitter la modification");
		choice = sc.nextInt();
		pokemonController.updatePokemon(choice);
	}

}
