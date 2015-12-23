package Model;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

import com.oracle.jrockit.jfr.Producer;

import Model.Energy.EnergyTypes;

public class Pokemon extends Card {

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
		setStage();
		this.nextEvolve = nextEvolve;
		if(nextEvolve != null) {
			nextEvolve.prevEvolve = this;
			setNextStages();
		}
		this.collectorCardNumber = collectorCardNumber;
		this.expansionSymbol = expansionSymbol;
		cards.add(this);
	}

	public int getStage() {
		return stage;
	}
	
	public int getHealth() {
		return health;
	}
	
	public int getCollectorCardNumber() {
		return collectorCardNumber;
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
	 */
	private void setStage() {
		Pokemon p = this;
		stage = 1;
		while(p.prevEvolve != null) {
			p = p.prevEvolve;
			stage++;
		}
	}

	/**
	 * Increment all stage of next evolves
	 * @param stage Current stage
	 */
	private void setNextStages(int stage) {
		Pokemon p = this;
		while(p.nextEvolve != null) {
			p = p.nextEvolve;
			stage++;
			p.stage = stage;
		}
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

	public void changeHealth(int newHealth) {
		this.health = newHealth;
	}

	public void changeEnergies(ArrayList<Energy.EnergyTypes> energies) {
		this.energies = energies;
	}

	public void changeAttacks(Attack[] attacks) {
		this.attacks = attacks;
	}

	/**
	 * Update pokemon's next evolve
	 * @param nextEvolve Next evolve pokemon
	 */
	public void changeNextEvolve(Pokemon nextEvolve) {
		checkInPrevEvolves(nextEvolve);
		checkInNextEvolves(nextEvolve);
		this.nextEvolve = nextEvolve;
		this.nextEvolve.prevEvolve = this;
		setNextStages(stage);
	}
	
	/**
	 * Update pokemon's previous evolve
	 * @param prevEvolve Previous evolve pokemon
	 */
	public void changePrevEvolve(Pokemon prevEvolve) {
		checkInPrevEvolves(prevEvolve);
		checkInNextEvolves(prevEvolve);
		this.prevEvolve = prevEvolve;
		prevEvolve.nextEvolve = this;
		prevEvolve.setNextStages(prevEvolve.stage);
	}

	/**
	 * Delete all links between Pokemons if new evolve is in previous evolves
	 * @param evolve A pokemon
	 */
	private void checkInPrevEvolves(Pokemon evolve) {
		if(!getPrevEvolves().contains(evolve)) return ;
		Pokemon p = this;
		while(p.prevEvolve != null) {
			p = p.prevEvolve;
			p.nextEvolve.prevEvolve = null;
			p.nextEvolve = null;
			p.stage = 1;
		}
		stage = 1;
		System.out.println("trol1 " + evolve.getName());
	}

	/**
	 * Delete all links between Pokemons if new evolve is in next evolves
	 * @param evolve A pokemon
	 */
	private void checkInNextEvolves(Pokemon evolve) {
		if(!getNextEvolves().contains(evolve)) return ; 
		Pokemon p = this;
		while(p.nextEvolve != null) {
			p = p.nextEvolve;
			p.prevEvolve.nextEvolve = null;
			p.prevEvolve = null;
			p.stage = 1;
		}
		stage = 1;
	}

	public void changeCollectorCardNumber(int collectorCardNumber) {
		this.collectorCardNumber = collectorCardNumber;
	}

	public void changeExpansionSymbol(int expansionSymbol) {
		this.expansionSymbol = expansionSymbol;
	}

	/**
	 * Get pokemon's previous evolves
	 * @return List of pokemons
	 */
	public ArrayList<Pokemon> getPrevEvolves() {
		ArrayList<Pokemon> evolves = new ArrayList<Pokemon>();
		Pokemon p = this;
		evolves.add(this);
		while(p.prevEvolve != null) {
			p = p.prevEvolve;
			evolves.add(p);
		}
		return evolves;
	}

	/**
	 * Get pokemon's next evolves
	 * @return List of pokemons
	 */
	public ArrayList<Pokemon> getNextEvolves() {
		ArrayList<Pokemon> evolves = new ArrayList<Pokemon>();
		Pokemon p = this;
		evolves.add(this);
		while(p.nextEvolve != null) {
			p = p.nextEvolve;
			evolves.add(p);
		}
		return evolves;
	}
	
	public ArrayList<Pokemon> getPokemons() {
		ArrayList<Pokemon> pokemons = new ArrayList<Pokemon>();
		for(Card card : Card.getCards()) {
	        if(card instanceof Pokemon) {
	            pokemons.add((Pokemon) card);
	        }
	    }
		return pokemons;
	}

}
