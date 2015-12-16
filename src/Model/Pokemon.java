package Model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

import Model.Energy.EnergyTypes;

public class Pokemon extends Card implements Serializable {

	private static ArrayList<Pokemon> pokemons = new ArrayList<Pokemon>();
	private int health;
	private int stage;
	private ArrayList<Energy.EnergyTypes> energies;
	private Attack attacks[] = new Attack[2];
	private Pokemon prevEvolve;
	private Pokemon nextEvolve;
	private int collectorCardNumber;
	private int expansionSymbol;

	public Pokemon(String name, int health,
			ArrayList<EnergyTypes> energies, Attack[] attacks,
			Pokemon prevEvolve, Pokemon nextEvolve, int collectorCardNumber,
			int expansionSymbol) {
		super(name);
		this.health = health;
		this.energies = energies;
		this.attacks = attacks;
		this.prevEvolve = prevEvolve;
		if(prevEvolve != null) {
			prevEvolve.nextEvolve = this;
		}
		this.stage = setStage();
		this.nextEvolve = nextEvolve;
		if(nextEvolve != null) {
			nextEvolve.prevEvolve = this;
			setNextStages();
		}
		this.collectorCardNumber = collectorCardNumber;
		this.expansionSymbol = expansionSymbol;
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
		String str = "Pokemon name=" + name + "\n"
				+ "attacks=" + Arrays.toString(attacks) + "\n"
				+ "health="	+ health + "\n"
				+ "stage="	+ stage + "\n";
		if(prevEvolve != null) str += "prevEvolve=" + prevEvolve.getName() + "\n";
		if(nextEvolve != null) str += "nextEvolve="	+ nextEvolve.getName() + "\n";
		str += "collectorCardNumber=" + collectorCardNumber + "\n"
				+ "expansionSymbol=" + expansionSymbol + "\n"
				+ "energies=" + energies + "";
		return str;
	}

	/**
	 * Determinate stage by exploring all previous evolves of the pokemon
	 * @return Pokemon's stage
	 */
	private int setStage() {
		Pokemon p = this;
		int stage = 1;
		while(p.prevEvolve != null) {
			p = prevEvolve;
			stage++;
		}
		return stage;
	}
	
	/**
	 * Increment all stage of next evolves
	 */
	private void setNextStages() {
		Pokemon p = this;
		while(p.nextEvolve != null) {
			p = p.nextEvolve;
			p.stage++;
		}
	}

}
