package Terminal.View.Pokemon;

import Terminal.Controller.PokemonController;

public class AddPokemon extends SavePokemon {
	
	public AddPokemon() {
		pokemonController = new PokemonController(this);
		pokemonController.addPokemon();
	}

}
