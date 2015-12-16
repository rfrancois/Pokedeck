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
					+ "1 - Ajouter un Pok�mon\n"
					+ "2 - Afficher le jeu\n"
					+ "3 - Rechercher un pokemon\n"
					+ "0 - Quitter le programme");
			choice = sc.nextInt();
			switch(choice) {
				case 0:
					System.out.println("Le programme est quitt�.");
					break;
				case 1:
					add();
					break;
				case 2:
					list();
					break;
				case 3:
					search();
					break;
				default:
					System.out.println("Une erreur est survenue.");
					break;
			}
		} while(choice != 0);
		
		Pokemon.serialize();
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
	public static void list() {
		ListPokemons display = new ListPokemons();
		display.constructGUI();
		Pokemon pokemon = display.getData();
		if(pokemon != null)	update(pokemon);
	}
	
	/**
	 * Update pokemon
	 * @param pokemon Pokemon to update
	 */
	public static void update(Pokemon pokemon) {
		UpdatePokemon up = new UpdatePokemon(pokemon);
		up.constructGUI();
	}
	
	public static void search() {
		SearchPokemon search = new SearchPokemon();
		search.constructGUI();		
	}

}
