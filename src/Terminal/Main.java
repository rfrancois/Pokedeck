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
					+ "2 - Afficher le jeu\n"
					+ "0 - Quitter le programme");
			choice = sc.nextInt();
			switch(choice) {
				case 0:
					System.out.println("Le programme est quitté.");
					break;
				case 1:
					add();
					break;
				case 2:
					display();
					break;
				default:
					System.out.println("Une erreur est survenue.");
					break;
			}
		} while(choice != 0);
	}
	
	/**
	 * Actions when user chooses to add a pokemon
	 */
	public static void add() {
		AddPokemon add = new AddPokemon();
		update(add.getData());
	}
	
	/**
	 * Actions when user chooses to display all the deck
	 */
	public static void display() {
		DisplayPokemons display = new DisplayPokemons();
		display.constructGUI();
		Pokemon pokemon = display.getData();
		if(pokemon != null)	update(pokemon);
	}
	
	public static void update(Pokemon pokemon) {
		UpdatePokemon up = new UpdatePokemon(pokemon);
		up.constructGUI();
	}

}
