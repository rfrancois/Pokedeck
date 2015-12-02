package Model;
import java.util.ArrayList;

import Model.Energy.EnergyTypes;

public class Pokemon extends Card {
	
	private int health;
	private ArrayList<Evolve> evolves = new ArrayList<Evolve>();
	private int collectorCardNumber;
	private int expansionSymbol;
	private ArrayList<Energy.EnergyTypes> energies;
	
	public Pokemon(String name, int health, ArrayList<Evolve> evolves,
			int collectorCardNumber, int expansionSymbol,
			ArrayList<EnergyTypes> energies) {
		super(name);
		this.health = health;
		this.evolves = evolves;
		this.collectorCardNumber = collectorCardNumber;
		this.expansionSymbol = expansionSymbol;
		this.energies = energies;
	}
}
