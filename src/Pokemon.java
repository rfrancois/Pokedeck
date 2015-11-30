import java.util.ArrayList;

public class Pokemon extends Card {
	
	private int health;
	private int stage;
	private ArrayList<Evolve> evolve = new ArrayList<Evolve>();
	private int collectorCardNumber;
	private int expansionSymbol;
	private Energy.EnergyTypes Energy;
	
	public int getHealth() {
		return health;
	}
	
	public int getStage() {
		return stage;
	}
	
	public int getCollectorCardNumber() {
		return collectorCardNumber;
	}
	
	public int getExpansionSymbol() {
		return expansionSymbol;
	}
	
}
