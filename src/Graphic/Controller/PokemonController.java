package Graphic.Controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;

import Graphic.View.Pokemon.SavePokemon;
import Model.Attack;
import Model.Energy;
import Model.Energy.EnergyTypes;
import Model.Pokemon;

public class PokemonController implements ActionListener {

	SavePokemon v;

	public PokemonController(SavePokemon v) {
		this.v = v;
	}

	/**
	 * Check if fields are not empty
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		v.getLabelInfoMessage().setText("");
		String name = v.getTextName().getText();
		if(name.isEmpty()) {
			v.getLabelInfoMessage().setText("Le nom du Pokemon est obligatoire");
			return ;
		}
		int collectorCardNumber = tryParseInt(v.getTextCollectorCardNumber().getText());
		if(collectorCardNumber <= 0) {
			v.getLabelInfoMessage().setText("Le numéro de carte du Pokemon doit être une valeur numérique");
			return ;
		}
		int health = tryParseInt(v.getTextHealth().getText());
		if(health <= 0) {
			v.getLabelInfoMessage().setText("La santé du Pokemon doit être une valeur numérique");
			return ;
		}
		ArrayList<EnergyTypes> energies = (ArrayList<EnergyTypes>) v.getListEnergies().getSelectedValuesList();
		if(energies.size() <= 0) {
			v.getLabelInfoMessage().setText("Au moins une energie doit être sélectionnée");
			return ;
		}
		String attackName1 = v.getTextAttackName1().getText(); 
		if(attackName1.isEmpty()) {
			v.getLabelInfoMessage().setText("Le nom de la première attaque est obligatoire");
			return ;
		}
		int attackDamage1 = tryParseInt(v.getTextAttackDamage1().getText());
		if(attackDamage1 <= 0) {
			v.getLabelInfoMessage().setText("Le nombre de dommage de la première doit être une valeur numérique");
			return ;
		}
		String attackName2 = v.getTextAttackName2().getText();
		if(attackName2.isEmpty()) {
			v.getLabelInfoMessage().setText("Le nom de la deuxième attaque est obligatoire");
			return ;
		}
		int attackDamage2 = tryParseInt(v.getTextAttackDamage2().getText());
		if(attackDamage2 <= 0) {
			v.getLabelInfoMessage().setText("Le nombre de dommage de la deuxième doit être une valeur numérique");
			return ;
		}
		v.leave();
		new Pokemon(
			name, 
			health, 
			energies, 
			new Attack[] {
				new Attack(attackName1, attackDamage1), 
				new Attack(attackName2, attackDamage2)
			},
			null, 
			null, 
			collectorCardNumber, 
			0
		);
	}

	private int tryParseInt(String value) {
		int number;
		try {  
			number = Integer.parseInt(value);  
			return number;  
		} catch (NumberFormatException e) {  
			return 0;  
		}  
	}

}
