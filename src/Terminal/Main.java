package Terminal;

import java.util.Scanner;

import Controller.*;
import Model.*;
import View.Pokemon.*;

public class Main {

	public static void main(String[] args) {
		
		int choice;
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.println("Choisissez une action :\n"
					+ "1 - Ajouter un Pokémon\n"
					+ "0 - Quitter le programme\n");
			choice = sc.nextInt();
			switch(choice) {
				case 0:
					System.out.println("Le programme est quitté.");
					break;
				case 1:
					SavePokemon v = new SavePokemon();
					v.constructGUI();
					v.getData();
					break;
				default:
					System.out.println("Une erreur est survenue.");
					break;
			}
		} while(choice != 0);
	}

}
