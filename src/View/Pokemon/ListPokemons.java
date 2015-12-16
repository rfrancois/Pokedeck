package View.Pokemon;

import java.util.ArrayList;

import Controller.PokemonController;
import Model.Pokemon;

public class ListPokemons extends SavePokemon {
	
	public ListPokemons() {
		pokemonController = new PokemonController(this);
	}
	
	/**
	 * Ask user which Pokemon select
	 */
	public void constructGUI() {
		ArrayList<Pokemon> pokemons = Pokemon.getPokemons();
		System.out.println("Sélectionnez un Pokemon pour le modifier :");
		for(int i=0; i<pokemons.size(); i++) {
			System.out.println(i+1 + " - " + pokemons.get(i).getName());
		}
		System.out.println("0 - Quitter la liste");
		int choice = sc.nextInt();
		if(choice != 0) {
			pokemonController.displayPokemons(choice-1);
		}
	}
	
	public Pokemon getData() {
		return pokemonController.getPokemon();
	}
}
