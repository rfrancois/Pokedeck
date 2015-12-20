package Model;

import View.Pokemon.AddPokemon;
import View.Pokemon.ListPokemons;
import View.Pokemon.SearchPokemon;
import View.Pokemon.UpdatePokemon;

public interface View {

	/**
	 * Actions when user chooses to add a pokemon
	 */
	public void add();
	
	/**
	 * Actions when user chooses to display all the deck
	 */
	public void list();
	
	/**
	 * Update pokemon
	 * @param pokemon Pokemon to update
	 */
	public void update(Card card);
	
	public void search();
	
}
