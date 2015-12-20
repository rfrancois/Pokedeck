package Controller;

import Model.Trainer;
import View.Trainer.SaveTrainer;

public class TrainerController {

	private SaveTrainer v;
	private Trainer trainer;
	
	public TrainerController(SaveTrainer v) {
		this.v = v; 
	}

	public void addTrainer() {
		new Trainer(v.getName(), v.getText(), v.getRule(), v.getType());
	}
	
	public Trainer getData() {
		return trainer;
	}
}
