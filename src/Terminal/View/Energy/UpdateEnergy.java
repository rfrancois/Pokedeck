package Terminal.View.Energy;

import Model.Energy;
import Terminal.Controller.EnergyController;
import Terminal.Controller.PokemonController;

public class UpdateEnergy extends SaveEnergy {
	
	public UpdateEnergy(Energy energy) {
		energyController = new EnergyController(energy, this);
	}
	
	public void constructGUI() {
		energyController.updateEnergy(super.getEnergy());
	}

}
