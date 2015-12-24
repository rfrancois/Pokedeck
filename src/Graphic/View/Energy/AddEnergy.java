package Graphic.View.Energy;

import javax.swing.JButton;

import Graphic.Controller.EnergyController;

public class AddEnergy extends SaveEnergy {
	
	private JButton buttonAdd = new JButton("Ajouter");

	public AddEnergy() {
		controller = new EnergyController(this);
		constructGUI();
	}
	
	public void constructGUI() {
		setTitle("Ajouter une energie");
		buttons.add(buttonAdd);
		buttonAdd.setActionCommand("addEnergy");
		super.constructGUI();
	}
}
