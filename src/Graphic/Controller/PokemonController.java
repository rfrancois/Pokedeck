package Graphic.Controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import Graphic.View.Pokemon.SavePokemon;
import Graphic.View.Pokemon.UpdatePokemon;
import Model.Attack;
import Model.Energy.EnergyTypes;
import Model.Pokemon;

public class PokemonController extends SuperController implements ActionListener {

	SavePokemon v;
	Pokemon pokemon;

	public PokemonController(SavePokemon v) {
		this.v = v;
	}
	
	public PokemonController(SavePokemon v, Pokemon pokemon) {
		this.v = v;
		this.pokemon = pokemon;
	}

	/**
	 * Check if fields are not empty
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(returnPrevPage(e, v)) return ;
		// Erase info message
		v.getLabelInfoMessage().setText("");
		// Check all the fields
		String name = v.getTextName().getText();
		if(name.isEmpty()) {
			v.getLabelInfoMessage().setText("Le nom du Pokemon est obligatoire");
			return ;
		}
		int collectorCardNumber = tryParseInt(v.getTextCollectorCardNumber().getText());
		if(collectorCardNumber <= 0) {
			v.getLabelInfoMessage().setText("Le num�ro de carte du Pokemon doit �tre une valeur num�rique");
			return ;
		}
		int health = tryParseInt(v.getTextHealth().getText());
		if(health <= 0) {
			v.getLabelInfoMessage().setText("La sant� du Pokemon doit �tre une valeur num�rique");
			return ;
		}
		ArrayList<EnergyTypes> energies = null;
		if(v.getListEnergies().getSelectedValuesList().size() <= 0) {
			v.getLabelInfoMessage().setText("Au moins une energie doit �tre s�lectionn�e");
			return ;
		}
		energies = (ArrayList<EnergyTypes>) v.getListEnergies().getSelectedValuesList();
		String attackName1 = v.getTextAttackName1().getText(); 
		if(attackName1.isEmpty()) {
			v.getLabelInfoMessage().setText("Le nom de la premi�re attaque est obligatoire");
			return ;
		}
		int attackDamage1 = tryParseInt(v.getTextAttackDamage1().getText());
		if(attackDamage1 <= 0) {
			v.getLabelInfoMessage().setText("Le nombre de dommage de la premi�re doit �tre une valeur num�rique");
			return ;
		}
		String attackName2 = v.getTextAttackName2().getText();
		if(attackName2.isEmpty()) {
			v.getLabelInfoMessage().setText("Le nom de la deuxi�me attaque est obligatoire");
			return ;
		}
		int attackDamage2 = tryParseInt(v.getTextAttackDamage2().getText());
		if(attackDamage2 <= 0) {
			v.getLabelInfoMessage().setText("Le nombre de dommage de la deuxi�me doit �tre une valeur num�rique");
			return ;
		}
		int prevEvolve = v.getPrevEvolve().getSelectedIndex();
		int nextEvolve = v.getNextEvolve().getSelectedIndex();
		if(prevEvolve > 0 && nextEvolve > 0 && prevEvolve == nextEvolve) {
			v.getLabelInfoMessage().setText("Les �volutions ne peuvent pas �tre les m�mes");
			return ;
		}
		// Action delivered by button
		switch(e.getActionCommand()) {
			case "addPokemon":
				v.leave();
				new UpdatePokemon(
					new Pokemon(
							name, 
							health, 
							energies, 
							new Attack[] {
								new Attack(attackName1, attackDamage1), 
								new Attack(attackName2, attackDamage2)
							},
							getEvolve(prevEvolve), 
							getEvolve(nextEvolve), 
							collectorCardNumber, 
							0
					),
					"Le Pokemon a �t� ajout�",
					v
				);
				break;
			case "updatePokemon":
				pokemon.changeName(name);
				pokemon.changeHealth(health);
				pokemon.changeEnergies(energies);
				pokemon.changeAttacks(
					new Attack[] {
						new Attack(attackName1, attackDamage1), 
						new Attack(attackName2, attackDamage2)
					}
				);
				pokemon.changeCollectorCardNumber(collectorCardNumber);
				// Check evolves path
				boolean problemEvolve = false;
				if(prevEvolve != 0 && !pokemon.changePrevEvolve(getEvolve(prevEvolve))) {
					v.getLabelInfoMessage().setText("Un probl�me sur l'�volution pr�c�dente emp�che le Pokemon de se mettre � jour correctement");
					problemEvolve = true;
				}
				if(nextEvolve != 0 && !pokemon.changeNextEvolve(getEvolve(nextEvolve))) {
					v.getLabelInfoMessage().setText("Un probl�me sur l'�volution suivante emp�che le Pokemon de se mettre � jour correctement");
					problemEvolve = true;
				}
				if(!problemEvolve) {
					v.getLabelInfoMessage().setText("Le Pokemon a �t� modifi�");
				}
				break;
			case "deletePokemon":
				v.leave();
				pokemon.beforeDeletePokemon();
				v.delete(pokemon);
				afterDelete(v);
				break;
			default:
				System.out.println("Une erreur est survenue sur la classe PokemonController.");
				break;
		}
		
	}

	/**
	 * Try to parse String to int
	 * @param value String number
	 * @return 0 if it failed
	 */
	private int tryParseInt(String value) {
		int number;
		try {  
			number = Integer.parseInt(value);  
		} catch (NumberFormatException e) {  
			return 0;  
		}
		return number;
	}
	
	/**
	 * Convert given index to evolve of Pokemon
	 * @param index Pokemon id
	 * @return A pokemon
	 */
	private Pokemon getEvolve(int index) {
		ArrayList<Pokemon> pokemons = Pokemon.getPokemons();
		if(index <= 0 || index > pokemons.size()) return null;
		return pokemons.get(index-1);
	}
	
	public Pokemon getPokemon() {
		return pokemon;
	}

}
