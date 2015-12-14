package Controller;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import Model.*;
import Model.Energy.EnergyTypes;
import View.Pokemon.*;

public class PokemonController {

	SavePokemon v;
	Pokemon pokemon;

	public PokemonController(SavePokemon savePokemon) {
		v = savePokemon;
	}

	public PokemonController(Pokemon pokemon, SavePokemon savePokemon) {
		v = savePokemon;
		this.pokemon = pokemon;
	}

	/*public void actionPerformed(ActionEvent evt) {
		Object source = evt.getSource();
		if (source == v.getUpdateRef()) {
			updateModel();
		}
	}*/

	public void addPokemon() {
		pokemon = new Pokemon(v.getName(), new Attack[]{new Attack(v.getAttackName(), v.getAttackDamage()), new Attack(v.getAttackName(), v.getAttackDamage())}, v.getHealth(), null, null, v.getCollectorCardNumber(), v.getExpansionSymbol(), v.getEnergyType());
	}

	public void updatePokemon(int choice) {
		//do {
		switch(choice) {
		case 0:
			System.out.println("Vous quittez la modification de Pokemon");
			return ;
		case 1:
			v.getName();
			break;
		case 2:
			v.selectAttack();
			break;
		case 3:
			v.getHealth();
			break;
		case 4:
			System.out.println("En construction");
			break;
		case 5:
			System.out.println("En construction");
			break;
		case 6:
			v.getCollectorCardNumber();
			break;
		case 7:
			v.getExpansionSymbol();
			break;
		case 8:
			v.getEnergyType(pokemon.getEnergiesTypes());
			break;
		default:
			System.out.println("Une erreur s'est produite.");
			break;
		}
		v.constructGUI();
		//} while(choice != 0);
	}

	public Pokemon getPokemon() {
		return pokemon;
	}

	/**
	 * Fill pokemon variable if index is correct
	 * @param choice Selected Pokemon
	 */
	public void displayPokemons(int choice) {
		ArrayList<Pokemon> pokemons = Pokemon.getPokemons();
		if(choice >= 0 && choice < pokemons.size()) {
			pokemon = pokemons.get(choice);
			return ;
		}
		v.constructGUI();
	}
}
