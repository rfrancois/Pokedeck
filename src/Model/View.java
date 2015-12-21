package Model;

import Terminal.View.Pokemon.AddPokemon;
import Terminal.View.Pokemon.UpdatePokemon;

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
	
	public void delete(Card card);
	
}
