package Model;
import java.util.ArrayList;
import java.util.Arrays;

import Model.Energy.EnergyTypes;

public class Pokemon extends Card {

	private static ArrayList<Pokemon> pokemons = new ArrayList<Pokemon>();
	private Attack attacks[] = new Attack[2];
	private int health;
	private Pokemon prevEvolve;
	private Pokemon nextEvolve;
	private int collectorCardNumber;
	private int expansionSymbol;
	private ArrayList<Energy.EnergyTypes> energies;
	
	public Pokemon(String name, Attack[] attacks, int health,
			Pokemon prevEvolve, Pokemon nextEvolve, int collectorCardNumber,
			int expansionSymbol, ArrayList<EnergyTypes> energies) {
		super(name);
		this.attacks = attacks;
		this.health = health;
		this.prevEvolve = prevEvolve;
		this.nextEvolve = nextEvolve;
		this.collectorCardNumber = collectorCardNumber;
		this.expansionSymbol = expansionSymbol;
		this.energies = energies;
		pokemons.add(this);
	}
	
	/**
	 * All the deck
	 * @return List of pokemons
	 */
	public static ArrayList<Pokemon> getPokemons() {
		return pokemons;
	}
	
	public Attack[] getAttacks() {
		return attacks;
	}
	
	public ArrayList<Energy.EnergyTypes> getEnergiesTypes() {
		return energies;
	}
	
	@Override
	public String toString() {
		return "Pokemon [name=" + name + ", attacks=" + Arrays.toString(attacks) + ", health="
				+ health + ", prevEvolve=" + prevEvolve + ", nextEvolve="
				+ nextEvolve + ", collectorCardNumber=" + collectorCardNumber
				+ ", expansionSymbol=" + expansionSymbol + ", energies="
				+ energies + "]";
	}

}
