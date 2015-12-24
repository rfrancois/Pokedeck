package Terminal.View.Energy;

import java.util.Scanner;

import Model.Card;
import Model.Energy;
import Model.Energy.EnergyTypes;
import Terminal.Controller.EnergyController;
import Terminal.View.Card.SaveCard;

/**
 * Get informations of an energy
 * @author Romain
 *
 */
public class SaveEnergy extends SaveCard {

	protected EnergyController energyController;
	
	public EnergyTypes getEnergy() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Sélectionnez une energie pour la carte :");
		for(int i=0; i<Energy.EnergyTypes.values().length; i++) {
			System.out.println(i+1 + " - " + Energy.EnergyTypes.values()[i]);
		}
		System.out.println("0 - Quitter la selection");
		int index = sc.nextInt();
		if(index < 0 || index > Energy.EnergyTypes.values().length) return getEnergy();
		if(index == 0) return null;
		return Energy.EnergyTypes.values()[index-1];
	}
	
	/**
	 * Add an energy
	 */
	public void add() {
		AddEnergy add = new AddEnergy();
	}
	
	/**
	 * Update an energy
	 */
	public void update(Card card) {
		UpdateEnergy update = new UpdateEnergy((Energy) card);
		update.constructGUI();
	}
	
	public Energy getData() {
		return energyController.getEnergy();
	}
}
