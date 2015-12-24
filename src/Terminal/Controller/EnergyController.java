package Terminal.Controller;

import Model.Energy;
import Model.Energy.EnergyTypes;
import Terminal.View.Energy.SaveEnergy;

public class EnergyController {

	SaveEnergy v;
	Energy energy;
	
	public EnergyController(SaveEnergy v) {
		this.v = v;
	}

	public EnergyController(Energy energy, SaveEnergy v) {
		this.v = v;
		this.energy = energy;
	}

	/**
	 * Add a new energy
	 */
	public void addEnergy() {
		EnergyTypes energy = v.getEnergy();
		if(energy != null) {
			new Energy(v.getEnergy());
		}
	}

	public Energy getEnergy() {
		return energy;
	}
	
	public SaveEnergy getV() {
		return v;
	}

	/**
	 * Update an energy
	 * @param energy An energy
	 */
	public void updateEnergy(EnergyTypes energy) {
		if(energy != null) {
			this.energy.changeEnergy(energy);
		}
	}
}
