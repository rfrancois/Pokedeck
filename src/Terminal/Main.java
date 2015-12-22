package Terminal;

import java.util.Scanner;

import Model.*;
import Terminal.Controller.*;
import Terminal.View.Card.SaveCard;
import Terminal.View.Pokemon.*;
import Terminal.View.Trainer.SaveTrainer;

public class Main {

	public static void main(String[] args) {
		
		Card.deserialize();
		
		int choice, type;
		Scanner sc = new Scanner(System.in);
		SaveCard view;
		
		do {
			System.out.println("Choisissez une action :\n"
					+ "1 - Ajouter une carte\n"
					+ "2 - Afficher le jeu\n"
					+ "3 - Rechercher une carte\n"
					+ "0 - Quitter le programme");
			choice = sc.nextInt();
			view = new SaveCard();
			switch(choice) {
				case 0:
					System.out.println("Le programme est quitté.");
					break;
				case 1:
					view.add();
					break;
				case 2:
					view.list();
					break;
				case 3:
					view.search();
					break;
				default:
					System.out.println("Une erreur est survenue.");
					break;
			}
		} while(choice != 0);
		
		Card.serialize();
	}

}
