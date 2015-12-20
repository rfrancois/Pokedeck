package View.Pokemon;

import java.util.ArrayList;
import java.util.Scanner;

import Controller.PokemonController;
import Model.Pokemon;

public class ListPokemons extends SavePokemon {
	
	public ListPokemons() {
		pokemonController = new PokemonController(this);
	}
	
	public Pokemon getData() {
		return pokemonController.getPokemon();
	}
}
