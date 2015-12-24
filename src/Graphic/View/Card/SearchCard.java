package Graphic.View.Card;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Graphic.Controller.CardController;

public class SearchCard extends SaveCard {
	
	protected JButton buttonSearch = new JButton("Rechercher");
	protected JButton buttonLeave = new JButton("Retour");
	protected JTextField textSearch = new JTextField(textFieldSize);

	public SearchCard() {
		controller = new CardController(this);
		constructGUI();
	}
	
	public SearchCard(String search) {
		this();
		textSearch.setText(search);
	}
	
	public void constructGUI() {
		setTitle("Rechercher une carte");
		// To horizontally and vertically center panel
		setLayout(new GridBagLayout());
		super.constructGUI();
		
		// Panel
		JPanel panel = new JPanel();
		FlowLayout gridLayout = new FlowLayout();
		panel.setLayout(gridLayout);
		
		panel.add(textSearch);
		panel.add(buttonSearch);
		panel.add(buttonLeave, BorderLayout.SOUTH);
		
		add(panel);
		
		buttonSearch.setActionCommand("searchCard");
		buttonLeave.setActionCommand("leave");
		
		buttonSearch.addActionListener(controller);
		buttonLeave.addActionListener(controller);
	}

	public JTextField getTextSearch() {
		return textSearch;
	}
}
