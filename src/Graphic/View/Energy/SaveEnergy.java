package Graphic.View.Energy;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import Graphic.Controller.EnergyController;
import Graphic.View.Card.SaveCard;
import Model.Energy.EnergyTypes;

public class SaveEnergy extends SaveCard {

	protected EnergyController controller;
	
	protected JLabel labelInfoMessage = new JLabel();
	protected JLabel labelType = new JLabel("Energie");
	protected JButton buttonLeave = new JButton("Retour");
	protected DefaultListModel<EnergyTypes> listModel = new DefaultListModel<EnergyTypes>();
	protected JList<EnergyTypes> listTypes = new JList<EnergyTypes>(listModel);
	protected JScrollPane scrollPaneTypes = new JScrollPane(listTypes);
	protected ArrayList<JButton> buttons = new ArrayList<JButton>();
	protected JLabel labels[] = new JLabel[] {
		labelType
	};
	protected JComponent texts[] = new JComponent[] {
		scrollPaneTypes
	};
	
	public void constructGUI() {
		super.constructGUI();
		// To horizontally and vertically center panel
		setLayout(new GridBagLayout());
		
		buttons.add(buttonLeave);
		
		// Types of Trainers
		for(EnergyTypes energy : EnergyTypes.values()) {
			listModel.addElement(energy);
		}
		
		// Visible rows
		listTypes.setVisibleRowCount(5);
		
		// Do not allow mutliple selection
		listTypes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		// Panel
		JPanel panel = new JPanel();
		GridBagLayout gridLayout = new GridBagLayout();
		panel.setLayout(gridLayout);
		
		// Panel of fields and libels
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
		
		c.fill = GridBagConstraints.VERTICAL;
		
		c.gridx = 0;
		c.gridy = 0;
		panel.add(panelFields, c);
		
		// Build buttons Panel
		JPanel panelButtons = new JPanel();
		GridLayout gridLayoutButtons = new GridLayout(1 , buttons.size());
		gridLayoutButtons.setHgap(10);
		panelButtons.setLayout(gridLayoutButtons);
		for(JButton button : buttons) {
			panelButtons.add(button);
			button.addActionListener(controller);
		}
		buttonLeave.setActionCommand("leave");
		
		c.gridx = 0;
		c.gridy = 1;
		panel.add(panelButtons, c);
		
		c.gridx = 0;
		c.gridy = 2;
		panel.add(labelInfoMessage, c);
		
		add(panel);
	}

	public JList<EnergyTypes> getListTypes() {
		return listTypes;
	}

	public JLabel getLabelInfoMessage() {
		return labelInfoMessage;
	}

}
