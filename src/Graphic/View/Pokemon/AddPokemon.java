package Graphic.View.Pokemon;

import javax.swing.JButton;

import Graphic.Controller.PokemonController;

public class AddPokemon extends SavePokemon {
	
	private JButton buttonAdd = new JButton("Ajouter");
	
	public AddPokemon() {
		controller = new PokemonController(this);
		constructGUI();
	}
	
	public void constructGUI() {
		setTitle("Ajouter un Pokemon");
		buttonAdd.setActionCommand("addPokemon");
		buttons.add(buttonAdd);
		super.constructGUI();
	}
}
