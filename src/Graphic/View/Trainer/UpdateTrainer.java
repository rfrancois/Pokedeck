package Graphic.View.Trainer;

import javax.swing.JButton;

import Graphic.Controller.TrainerController;
import Graphic.View.Card.SaveCard;
import Model.Trainer;
import Model.Trainer.TrainerTypes;

public class UpdateTrainer extends SaveTrainer {

	private JButton buttonUpdate = new JButton("Modifier");
	private JButton buttonDelete = new JButton("Supprimer");
	
	public UpdateTrainer(Trainer trainer, SaveCard prevView) {
		controller = new TrainerController(this, trainer);
		this.prevView = prevView;
		constructGUI();
	}
	
	public UpdateTrainer(Trainer trainer, SaveCard prevView, String infoMessage) {
		this(trainer, prevView);
		labelInfoMessage.setText(infoMessage);
		constructGUI();
	}
	
	public void constructGUI() {
		setTitle("Mettre à jour un entraineur");
		
		// Add buttons
		buttonUpdate.setActionCommand("updateTrainer");
		buttonDelete.setActionCommand("deleteTrainer");
		buttons.add(buttonUpdate);
		buttons.add(buttonDelete);
		
		super.constructGUI();
		
		// Field inputs
		Trainer trainer = controller.getTrainer();
		textName.setText(trainer.getName());
		textText.setText(trainer.getText());
		textRule.setText(trainer.getRule());
		int index = 0;
		for(int i=0; i<TrainerTypes.values().length; i++) {
			if(TrainerTypes.values()[i] == trainer.getType()) {
				index = i;
			}
		}
		listTypes.setSelectedIndex(index);
		

	}
}
