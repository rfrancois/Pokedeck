package View.Energy;

import Controller.EnergyController;
import Controller.PokemonController;
import Model.Energy;

public class UpdateEnergy extends SaveEnergy {
	
	public UpdateEnergy(Energy energy) {
		energyController = new EnergyController(energy, this);
	}
	
	public void constructGUI() {
		energyController.updateEnergy(super.getEnergy());
	}

}
