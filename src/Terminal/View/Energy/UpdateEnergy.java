package Terminal.View.Energy;

import java.util.Scanner;

import Model.Energy;
import Terminal.Controller.EnergyController;
import Terminal.Controller.PokemonController;

public class UpdateEnergy extends SaveEnergy {
	
	public UpdateEnergy(Energy energy) {
		energyController = new EnergyController(energy, this);
	}
	
	public void constructGUI() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Sélectionnez une energie pour la carte :");
		int i;
		for(i=0; i<Energy.EnergyTypes.values().length; i++) {
			System.out.println(i+1 + " - " + Energy.EnergyTypes.values()[i]);
		}
		i++;
		System.out.println(i + " - Supprimer la carte");
		System.out.println("0 - Quitter la selection");
		int index = sc.nextInt();
		if(index < 0 || index > Energy.EnergyTypes.values().length+1) constructGUI();
		if(index == 0) return ;
		if(index == i) {
			delete(energyController.getEnergy());
			return ;
		}
		energyController.updateEnergy(Energy.EnergyTypes.values()[index-1]);
	}

}
