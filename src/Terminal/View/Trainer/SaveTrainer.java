package Terminal.View.Trainer;

import java.util.Scanner;

import Model.Card;
import Model.Trainer;
import Model.Trainer.TrainerTypes;
import Terminal.Controller.TrainerController;
import Terminal.View.Card.SaveCard;

/**
 * Get Informations of a trainer
 * @author Romain
 *
 */
public class SaveTrainer extends SaveCard {
	
	protected TrainerController trainerController;

	public TrainerTypes getType() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Sélectionnez le type :");
		for(int i=0; i<Trainer.TrainerTypes.values().length; i++) {
			System.out.println(i+1 + " - " + Trainer.TrainerTypes.values()[i]);
		}
		int index = sc.nextInt();
		if(index < 0 || index > Trainer.TrainerTypes.values().length) return getType();
		return Trainer.TrainerTypes.values()[index-1];
	}

	public String getText() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Saisissez la description :");
		return sc.nextLine();
	}

	public String getName() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Entrez le nom de la carte entraineur :");
		return sc.nextLine();
	}

	public String getRule() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Saisissez la règle :");
		return sc.nextLine();
	}
	
	private Trainer getData() {
		return trainerController.getData();
	}

	@Override
	public void add() {
		AddTrainer add = new AddTrainer();
	}

	@Override
	public void list() {

	}

	@Override
	public void update(Card card) {
		UpdateTrainer up = new UpdateTrainer((Trainer) card);
		up.constructGUI();
	}

	@Override
	public void search() {
		// TODO Auto-generated method stub
	}

}
