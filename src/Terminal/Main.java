package Terminal;

import java.util.Scanner;

import Controller.*;
import Model.*;
import View.Pokemon.*;

public class Main {

	public static void main(String[] args) {
		
		//new Pokemon("test", 20, null, null, null, null, 0, 0);
		//new Pokemon("test2", 20, null, null, null, null, 0, 0);
		Pokemon.deserialize();
		
		int choice;
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.println("Choisissez une action :\n"
					+ "1 - Ajouter un Pokémon\n"
					+ "2 - Afficher le jeu\n"
					+ "3 - Rechercher un pokemon\n"
					+ "0 - Quitter le programme");
			choice = sc.nextInt();
			SavePokemon savePokemon = new SavePokemon();
			switch(choice) {
				case 0:
					System.out.println("Le programme est quitté.");
					break;
				case 1:
					savePokemon.add();
					break;
				case 2:
					savePokemon.list();
					break;
				case 3:
					savePokemon.search();
					break;
				default:
					System.out.println("Une erreur est survenue.");
					break;
			}
		} while(choice != 0);
		
		Pokemon.serialize();
	}

}
