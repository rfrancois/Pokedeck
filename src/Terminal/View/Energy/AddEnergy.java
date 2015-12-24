package Terminal.View.Energy;

import Terminal.Controller.EnergyController;

public class AddEnergy extends SaveEnergy {

	public AddEnergy() {
		energyController = new EnergyController(this);
		energyController.addEnergy();
	}
}
