package Controller;

import java.util.ArrayList;

import Model.*;
import Model.Energy.EnergyTypes;
import View.Pokemon.*;

public class PokemonController {

	SavePokemon v;
	
	public PokemonController(SavePokemon savePokemon) {
		// TODO Auto-generated constructor stub
		v = savePokemon;
	}
	
	public void actionPerformed() {
		ArrayList<EnergyTypes> energies = new ArrayList<EnergyTypes>();
		Pokemon pokemon = new Pokemon(v.getName(), new Attack[]{new Attack(v.getAttackName(), v.getAttackDamage()), new Attack(v.getAttackName(), v.getAttackDamage())}, v.getHealth(), null, null, v.getCollectorCardNumber(), v.getExpansionSymbol(), energies);
	}
}
