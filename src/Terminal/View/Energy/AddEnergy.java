package Terminal.View.Energy;

import Model.Card;
import Terminal.Controller.EnergyController;
import Terminal.View.Card.SaveCard;

public class AddEnergy extends SaveEnergy {

	public AddEnergy() {
		energyController = new EnergyController(this);
		energyController.addEnergy();
	}
}
