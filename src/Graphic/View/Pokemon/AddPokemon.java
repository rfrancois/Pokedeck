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

	private PokemonController controller;
	
	private JButton buttonAdd = new JButton("Ajouter");
	
	public AddPokemon() {
		controller = new PokemonController(this);
		constructGUI();
	}
	
	public void constructGUI() {
		setTitle("Ajouter un Pokemon");
		super.constructGUI();
		
		// To horizontally and vertically center panel
		setLayout(new GridBagLayout());
		
		// Action Listener
		buttonAdd.addActionListener(controller);
		
		// Panel
		JPanel panel = new JPanel();
		GridBagLayout gridLayout = new GridBagLayout();
		panel.setLayout(gridLayout);
		
		// Panel for form fields
		JPanel panelFields = new JPanel();
		panelFields.setLayout(gridLayout);
		GridBagConstraints c = new GridBagConstraints();
		
		c.fill = GridBagConstraints.HORIZONTAL;
		// Margins
		c.insets = new Insets(5,5,5,5);
		
		// Build form
		for(int y=0; y<texts.length; y++) {
			for(int x=0; x<2; x++) {
				c.gridx = x;
				c.gridy = y;
				if(x==0) {
					panelFields.add(labels[y], c);
				}
				else {
					panelFields.add(texts[y], c);
				}
			}
		}
			
		// Build button
		c.fill = GridBagConstraints.VERTICAL;
		c.gridx = 0;
		c.gridy = 0;
		panel.add(panelFields, c);
		c.gridx = 0;
		c.gridy = 1;
		panel.add(buttonAdd, c);
		c.gridx = 0;
		c.gridy = 2;
		panel.add(labelInfoMessage, c);
		
		add(panel);
	}
}
