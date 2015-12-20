package View.Trainer;

import Controller.TrainerController;

public class AddTrainer extends SaveTrainer {

	public AddTrainer() {
		trainerController = new TrainerController(this);
		trainerController.addTrainer();
	}
	
}
