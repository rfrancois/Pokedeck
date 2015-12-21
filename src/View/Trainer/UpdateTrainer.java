package View.Trainer;

import java.util.Scanner;

import Controller.PokemonController;
import Controller.TrainerController;
import Model.Trainer;

public class UpdateTrainer extends SaveTrainer {

	public UpdateTrainer(Trainer trainer) {
		trainerController = new TrainerController(trainer, this);
	}
	
	public void constructGUI() {
		Scanner sc = new Scanner(System.in);
		int choice;
		System.out.println(trainerController.getTrainer());
		System.out.println("Apporter une modification sur :\n"
				+ "1 - Le nom\n"				
				+ "2 - La description\n"
				+ "3 - La règle\n"
				+ "4 - Le type\n"
				+ "5 - Supprimer la carte entraineur\n"
				+ "0 - Quitter la modification");
		choice = sc.nextInt();
		trainerController.updateTrainer(choice);
	}

}
