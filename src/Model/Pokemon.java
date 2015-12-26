package Model;
import java.util.ArrayList;
import java.util.Arrays;

import Model.Energy.EnergyTypes;

public class Pokemon extends Card {

	private int health;
	private int stage;
	private ArrayList<Energy.EnergyTypes> energies;
	private Attack attacks[] = new Attack[2];
	private Pokemon prevEvolve;
	private Pokemon nextEvolve;
	private int collectorCardNumber;
	/**
	 * Obsolete
	 */
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
		if(PrevEvolvePathIsCorrect(prevEvolve, nextEvolve)) {
			this.nextEvolve = nextEvolve;
			if(nextEvolve != null) {
				nextEvolve.prevEvolve = this;
				setNextStages(stage);
			}
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
	 * @param nextEvolve Pokemon Next Evolve
	 * @return nextEvolve Next evolve pokemon
	 */
	public boolean changeNextEvolve(Pokemon nextEvolve) {
		if(!PrevEvolvePathIsCorrect(this.prevEvolve, nextEvolve) || nextEvolve == this)  {
			return false;
		}
		this.nextEvolve = nextEvolve;
		this.nextEvolve.prevEvolve = this;
		setStage();
		setNextStages(stage);
		return true;
	}
	
	/**
	 * Update pokemon's previous evolve
	 * @param prevEvolve prevEvolve Previous evolve pokemon
	 * @return false if the requested next evolve is already in previous evolves
	 */
	public boolean changePrevEvolve(Pokemon prevEvolve) {
		if(!PrevEvolvePathIsCorrect(this.prevEvolve, nextEvolve) || prevEvolve == this)  {
			return false;
		}
		this.prevEvolve = prevEvolve;
		this.prevEvolve.nextEvolve = this;
		setStage();
		setNextStages(stage);
		return true;
	}
	
	/**
	 * Check if nextEvolve is not already in previous evolves
	 * @param prevEvolve Previous Evolves path to explore
	 * @param pokemon Next Evolve
	 * @return false if the requested next evolve is already in previous evolves
	 */
	private boolean PrevEvolvePathIsCorrect(Pokemon prevEvolve, Pokemon pokemon) {
		while(prevEvolve != null) {
			if(prevEvolve == pokemon) return false;
			prevEvolve = prevEvolve.prevEvolve;
		}
		return true;
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
	
	/**
	 * Get Pokemon cards from the deck
	 * @return List of poekmons
	 */
	public static ArrayList<Pokemon> getPokemons() {
		ArrayList<Pokemon> pokemons = new ArrayList<Pokemon>();
		for(Card card : Card.getCards()) {
	        if(card instanceof Pokemon) {
	            pokemons.add((Pokemon) card);
	        }
	    }
		return pokemons;
	}
	
	/**
	 * When a pokemon is deleting, do operation not to corrupt stages order
	 */
	public void beforeDeletePokemon() {
		if(nextEvolve != null && prevEvolve != null) {
			nextEvolve.prevEvolve = prevEvolve;
			prevEvolve.nextEvolve = nextEvolve;
			nextEvolve.setNextStages(stage);
		}
		else if(nextEvolve != null) {
			nextEvolve.prevEvolve = null;
			nextEvolve.setNextStages(1);
		}
		else if(prevEvolve != null) {
			prevEvolve.nextEvolve = null;
		}
	}

	public Pokemon getPrevEvolve() {
		return prevEvolve;
	}

	public Pokemon getNextEvolve() {
		return nextEvolve;
	}

}
