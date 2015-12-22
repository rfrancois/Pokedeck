package Graphic.View.Card;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Graphic.Controller.CardController;

public class AskType extends SaveCard {

	private JButton buttonPokemon = new JButton("Pokemon");
	private JButton buttonTrainer = new JButton("Entraineur");
	private JButton buttonEnergy = new JButton("Energie");
	private JLabel label1 = new JLabel("Sélectionnez le type de carte :");
	
	public AskType() {
		controller = new CardController(this);
		setTitle("Type du Pokemon");
		init();
		
		// To horizontally and vertically center panel
		setLayout(new GridBagLayout());
		
		// Center label
		label1.setHorizontalAlignment(JLabel.CENTER);
		
		// Panel
		JPanel panel = new JPanel();
		GridLayout gridLayout = new GridLayout(2, 1);
		gridLayout.setVgap(10);
		panel.setLayout(gridLayout);
		
		// PanelButtons
		JPanel panelButtons = new JPanel();
		gridLayout = new GridLayout(1, 3);
		// Horizontal space between buttons
		gridLayout.setHgap(10);
		panelButtons.setLayout(gridLayout);
		panelButtons.add(buttonPokemon);
		panelButtons.add(buttonTrainer);
		panelButtons.add(buttonEnergy);
		// Add all to panel
		panel.add(label1);
		panel.add(panelButtons);
		
		add(panel);
		
		// Action to call
		buttonPokemon.setActionCommand("addPokemon");
		buttonTrainer.setActionCommand("addTrainer");
		buttonEnergy.setActionCommand("addEnergy");
		
		// Event Listener
		buttonPokemon.addActionListener(controller);
		buttonTrainer.addActionListener(controller);
		buttonEnergy.addActionListener(controller);
	}
	
}
