package View.Pokemon;

import Controller.PokemonController;
import Model.Pokemon;

public class AddPokemon extends SavePokemon {
	
	public AddPokemon() {
		pokemonController = new PokemonController(this);
		pokemonController.addPokemon();
	}

}
