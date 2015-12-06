package View.Pokemon;

import java.util.ArrayList;

import Controller.PokemonController;
import Model.Pokemon;

public class DisplayPokemons extends SavePokemon {
	
	public DisplayPokemons() {
		pokemonController = new PokemonController(this);
	}
	
	/**
	 * Ask user which Pokemon select
	 */
	public void constructGUI() {
		ArrayList<Pokemon> pokemons = Pokemon.getPokemons();
		System.out.println("Sélectionnez le Pokemon à modifier :");
		for(int i=0; i<pokemons.size(); i++) {
			System.out.println(i+1 + " - " + pokemons.get(i).getName());
		}
		System.out.println("0 - Quitter le tas");
		int choice = sc.nextInt();
		if(choice != 0)	pokemonController.displayPokemons(choice-1);
	}
	
	public Pokemon getData() {
		return pokemonController.getPokemon();
	}
}
