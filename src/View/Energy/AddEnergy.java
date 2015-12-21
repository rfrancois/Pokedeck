package View.Energy;

import Controller.EnergyController;
import Model.Card;
import View.Card.SaveCard;

public class AddEnergy extends SaveEnergy {

	public AddEnergy() {
		energyController = new EnergyController(this);
		energyController.addEnergy();
	}
}
