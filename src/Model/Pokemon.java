package Model;
import java.util.ArrayList;

import Model.Energy.EnergyTypes;

public class Pokemon extends Card {
	
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
	}
	

}
