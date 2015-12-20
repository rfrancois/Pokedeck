package View.Trainer;

import java.util.Scanner;

import Controller.TrainerController;
import Model.Card;
import Model.Pokemon;
import Model.Trainer;
import Model.View;
import Model.Trainer.TrainerTypes;
import View.Pokemon.AddPokemon;

public class SaveTrainer implements View {
	
	protected TrainerController trainerController;

	public TrainerTypes getType() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Sélectionnez le type :");
		for(int i=0; i<Trainer.TrainerTypes.values().length; i++) {
			System.out.println(i + " - " + Trainer.TrainerTypes.values()[i]);
		}
		int index = sc.nextInt();
		if(index < 0 || index > Trainer.TrainerTypes.values().length) return getType();
		return Trainer.TrainerTypes.values()[index];
	}

	public String getText() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Saisissez la description :");
		return sc.next();
	}

	public String getName() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Entrez le nom de la carte entraineur :");
		return sc.next();
	}

	public String getRule() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Saisissez la règle :");
		return sc.next();
	}
	
	private Trainer getData() {
		return trainerController.getData();
	}

	@Override
	public void add() {
		// TODO Auto-generated method stub
		SaveTrainer add = new SaveTrainer();
		//update(add.getData());
	}

	@Override
	public void list() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Card card) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void search() {
		// TODO Auto-generated method stub
		
	}

}
