package Graphic.View.Trainer;

import javax.swing.JButton;

import Graphic.Controller.TrainerController;

public class AddTrainer extends SaveTrainer {

	private JButton buttonAdd = new JButton("Ajouter");
	
	public AddTrainer() {
		controller = new TrainerController(this);
		constructGUI();
	}
	
	public void constructGUI() {
		setTitle("Ajouter un entraineur");
		buttons.add(buttonAdd);
		buttonAdd.setActionCommand("addTrainer");
		super.constructGUI();
	}
}
