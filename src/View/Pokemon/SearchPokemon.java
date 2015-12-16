package View.Pokemon;

import java.util.ArrayList;
import java.util.Scanner;

import Model.Pokemon;
import Terminal.Main;
import Controller.PokemonController;

public class SearchPokemon extends SavePokemon {
	
	public SearchPokemon() {
		pokemonController = new PokemonController(this);
	}
	
	public void constructGUI() {
		Scanner sc = new Scanner(System.in);
		String name;
		System.out.println("Tapez le nom du pokemon a chercher :");
		name = sc.next();
		pokemonController.searchPokemon(name);
	}

}
