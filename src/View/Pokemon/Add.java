package View.Pokemon;

import java.util.Scanner;

public class Add {
	
	private Scanner sc = new Scanner(System.in);
	
	/**
	 * Ask pokemon name and check if the string is correct
	 * @return Pokemon name
	 */
	public String getName() {
		System.out.println("Quel est le nom du Pokémon ?");
		String name = sc.next();
		if(name.isEmpty()) {
			System.out.println("Erreur.");
			return getName();
		}
		return name;
	}
	
	public String getAttackName() {
		System.out.println("Nom de l'attaque :");
		return sc.next();
	}
	
	public int getAttackDamage() {
		System.out.println("Nombre de dommage de l'attaque :");
		return sc.nextInt();
	}
	
	public int getHealth() {
		System.out.println("Points de vie :");
		return sc.nextInt();
	}
	
	public int getCollectorCardNumber() {
		System.out.println("Numéro de carte collector :");
		return sc.nextInt();
	}
	
	public int getExpansionSymbol() {
		System.out.println("Symbole d'expansion :");
		return sc.nextInt();
	}
}
