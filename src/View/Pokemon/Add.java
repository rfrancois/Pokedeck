package View.Pokemon;

import java.util.Scanner;

public class Add {
	
	private Scanner sc = new Scanner(System.in);
	
	public String askName() {
		System.out.println("Quel est le nom du Pok�mon ?");
		return sc.next();
	}
}
