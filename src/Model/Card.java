package Model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Card implements Serializable {
	
	protected String name;
	protected static ArrayList<Card> cards = new ArrayList<Card>();
	
	public Card(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public void changeName(String newName) {
		name = newName;
	}
	

	/**
	 * All the deck
	 * @return List of pokemons
	 */
	public static ArrayList<Card> getCards() {
		return cards;
	}
	
	/**
	 * Save the deck
	 * @return 3 which is the code to completly close program
	 */
	public static int serialize() {
		try
		{
			FileOutputStream fileOut = new FileOutputStream("data/pokemon.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(cards);
			out.close();
			fileOut.close();
		} catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
		return 3;
	}

	/**
	 * Set deck
	 */
	public static void deserialize() {
		try
		{
			FileInputStream fileIn = new FileInputStream("data/pokemon.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			cards = (ArrayList<Card>) in.readObject();
			in.close();
			fileIn.close();
		} catch(IOException ioe)
		{
			ioe.printStackTrace();
			return;
		} catch(ClassNotFoundException c)
		{
			System.out.println("Product class not found");
			c.printStackTrace();
			return;
		}
	}
	
	/**
	 * Search a card Name in the deck
	 * @param search Search request by user
	 * @return List of cards or null if no match was found
	 */
	public static ArrayList<Card> search(String search) {
		ArrayList<Card> match = new ArrayList<Card>();
		int compare;
		for(Card card : cards) {
			compare = search.compareToIgnoreCase(card.getName());
			// Allow mistakes in the search
			if(compare >= -5 && compare <= 5) {
				match.add(card);
			}
		}
		if(match.size() == 0) { 
			return null;
		}
		return match;
	}
	
}
