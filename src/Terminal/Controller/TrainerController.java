package Terminal.Controller;

import Model.Trainer;
import Terminal.View.Trainer.SaveTrainer;

public class TrainerController {

	private SaveTrainer v;
	private Trainer trainer;
	
	public TrainerController(SaveTrainer v) {
		this.v = v; 
	}

	public TrainerController(Trainer trainer, SaveTrainer saveTrainer) {
		this.trainer = trainer;
		v = saveTrainer;
		
	}

	/**
	 * Add a new trainer
	 */
	public void addTrainer() {
		new Trainer(v.getName(), v.getText(), v.getRule(), v.getType());
	}
	
	public Trainer getData() {
		return trainer;
	}
	
	/**
	 * Update a trainer
	 * @param choice Trainer's index
	 */
	public void updateTrainer(int choice) {
		switch(choice) {
		case 0:
			System.out.println("Vous quittez la modification de carte Entraineur.");
			return ;
		case 1:
			trainer.changeName(v.getName());
			break;
		case 2:
			trainer.changeText(v.getText());
			break;
		case 3:
			trainer.changeRule(v.getRule());
			break;
		case 4:
			trainer.changeType(v.getType());
			break;
		case 5:
			v.delete(trainer);
			return ;
		default:
			System.out.println("Une erreur s'est produite.");
			break;
		}
		v.constructGUI();
	}

	public Trainer getTrainer() {
		return trainer;
	}
}
