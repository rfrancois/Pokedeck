package Controller;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import Model.*;
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
		Pokemon prevEvolve;
		pokemon = new Pokemon(v.getName(), v.getHealth(), v.getEnergyType(), new Attack[]{new Attack(v.getAttackName(), v.getAttackDamage()), new Attack(v.getAttackName(), v.getAttackDamage())}, prevEvolve = v.getPrevEvolve(), v.getNextEvolve(prevEvolve), v.getCollectorCardNumber(), v.getExpansionSymbol());
	}

	public void updatePokemon(int choice) {
		switch(choice) {
		case 0:
			System.out.println("Vous quittez la modification de Pokemon.");
			return ;
		case 1:
			pokemon.changeName(v.getName());
			break;
		case 2:
			pokemon.changeHealth(v.getHealth());
			break;
		case 3:
			pokemon.changeEnergies(v.getEnergyType(pokemon.getEnergiesTypes()));
			break;
		case 4:
			pokemon.changeAttacks(v.selectAttack());
			break;
		case 5:
			Pokemon prevEvolve = v.getEvolve(false);
			if(prevEvolve != null) {
				pokemon.changePrevEvolve(prevEvolve);
			}
			break;
		case 6:
			Pokemon nextEvolve = v.getEvolve(true);
			if(nextEvolve != null) {
				pokemon.changeNextEvolve(nextEvolve);
			}
			break;
		case 7:
			pokemon.changeCollectorCardNumber(v.getCollectorCardNumber());
			break;
		case 8:
			pokemon.changeExpansionSymbol(v.getExpansionSymbol());
			break;
		case 9:
			v.delete(pokemon);
			return ;
		default:
			System.out.println("Une erreur s'est produite.");
			break;
		}
		v.constructGUI();
	}

	public Pokemon getPokemon() {
		return pokemon;
	}
}
