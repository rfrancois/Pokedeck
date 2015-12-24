package Graphic.View.Energy;

import javax.swing.JButton;

import Graphic.Controller.EnergyController;
import Graphic.View.Card.SaveCard;
import Model.Energy;
import Model.Energy.EnergyTypes;

public class UpdateEnergy extends SaveEnergy {
	private JButton buttonUpdate = new JButton("Modifier");
	private JButton buttonDelete = new JButton("Supprimer");
	
	public UpdateEnergy(Energy energy, SaveCard prevView) {
		controller = new EnergyController(this, energy);
		this.prevView = prevView;
		constructGUI();
	}
	
	public UpdateEnergy(Energy energy, SaveCard prevView, String infoMessage) {
		this(energy, prevView);
		labelInfoMessage.setText(infoMessage);
		constructGUI();
	}
	
	public void constructGUI() {
		setTitle("Mettre à jour une energie");
		
		// Add buttons
		buttonUpdate.setActionCommand("updateEnergy");
		buttonDelete.setActionCommand("deleteEnergy");
		buttons.add(buttonUpdate);
		buttons.add(buttonDelete);
		
		super.constructGUI();
		
		// Field inputs
		Energy energy = controller.getEnergy();
		int index = 0;
		for(int i=0; i<EnergyTypes.values().length; i++) {
			if(EnergyTypes.values()[i] == energy.getType()) {
				index = i;
			}
		}
		listTypes.setSelectedIndex(index);

	}
}
