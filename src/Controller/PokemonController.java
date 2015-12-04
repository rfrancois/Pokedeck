package Controller;

import java.util.ArrayList;

import Model.*;
import Model.Energy.EnergyTypes;
import View.Pokemon.*;

public class PokemonController {

	public void add() {
		Add add = new Add();
		Add attack = new Add();
		//Attack[] attacks = new Attack[]{new Attack(add.getAttackName(), add.getAttackDamage()), new Attack(add.getAttackName(), add.getAttackDamage())};
		//int[] tests = new int[]{1, 2};
		ArrayList<EnergyTypes> energies = new ArrayList<EnergyTypes>();
		Pokemon pokemon = new Pokemon(add.getName(), new Attack[]{new Attack(add.getAttackName(), add.getAttackDamage()), new Attack(add.getAttackName(), add.getAttackDamage())}, add.getHealth(), null, null, add.getCollectorCardNumber(), add.getExpansionSymbol(), energies);
	}
}
