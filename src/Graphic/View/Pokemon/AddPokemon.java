package Graphic.View.Pokemon;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
