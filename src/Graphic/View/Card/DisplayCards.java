package Graphic.View.Card;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import Graphic.Controller.CardController;
import Model.Card;

public class DisplayCards extends SaveCard {

	protected JLabel label = new JLabel("Sélectionnez une carte :");
	protected DefaultListModel<String> listModel = new DefaultListModel<String>();
	protected JList selectCards = new JList(listModel);
	protected JScrollPane scrollPane = new JScrollPane(selectCards);
	protected JButton buttonSelect = new JButton("Sélectionner");
	protected JButton buttonLeave = new JButton("Retour");
	protected ArrayList<JButton> buttons = new ArrayList<JButton>();
	
	public void constructGUI() {
		setTitle("Liste des cartes");
		super.constructGUI();
		// To horizontally and vertically center panel
		setLayout(new GridBagLayout());
		
		// Add button select to buttons list
		buttons.add(buttonSelect);
		buttons.add(buttonLeave);
		
		// Field list
		if(controller.getCards() != null) {
			for(Card card : controller.getCards()) {
				listModel.addElement(card.getName());
			}
		}
		// Number of pokemons before elevator
		selectCards.setVisibleRowCount(15);
		// Do not allow multiple selection
		selectCards.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		// Panel
		JPanel panel = new JPanel();
		GridBagLayout gridLayout = new GridBagLayout();
		panel.setLayout(gridLayout);
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(5,5,5,5);
		
		c.fill = GridBagConstraints.VERTICAL;
		
		c.gridx = 0;
		c.gridy = 0;
		panel.add(label, c);
		
		c.gridx = 0;
		c.gridy = 1;
		panel.add(scrollPane, c);
		
		c.gridx = 0;
		c.gridy = 2;
		JPanel panelButtons = new JPanel();
		GridLayout layoutButtons = new GridLayout(1, buttons.size());
		// Margin between buttons
		layoutButtons.setHgap(10);
		panelButtons.setLayout(layoutButtons);
		
		panel.add(panelButtons, c);
		for(JButton button : buttons) {
			panelButtons.add(button);
		}
		
		add(panel);
		
		buttonSelect.setActionCommand("selectCard");
		buttonLeave.setActionCommand("leave");
		buttonSelect.addActionListener(controller);
		buttonLeave.addActionListener(controller);
	}

	public int getSelectedCardIndex() {
		return selectCards.getAnchorSelectionIndex();
	}
}
