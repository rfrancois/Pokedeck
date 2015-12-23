package Graphic.Controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;

import Graphic.View.Home.Home;
import Graphic.View.Pokemon.SavePokemon;
import Graphic.View.Pokemon.UpdatePokemon;
import Model.Attack;
import Model.Energy;
import Model.Energy.EnergyTypes;
import Model.Pokemon;

public class PokemonController implements ActionListener {

	SavePokemon v;
	Pokemon pokemon;

	public PokemonController(SavePokemon v) {
		this.v = v;
	}
	
	public PokemonController(SavePokemon v, Pokemon pokemon) {
		this.v = v;
		this.pokemon = pokemon;
	}

	/**
	 * Check if fields are not empty
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// Leave if user pressed leave button
		if(e.getActionCommand() == "leave") {
			v.leave();
			new Home();
			return ;
		}
		// Erase info message
		v.getLabelInfoMessage().setText("");
		// Check all the fields
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
		ArrayList<EnergyTypes> energies = null;
		if(v.getListEnergies().getSelectedValuesList().size() <= 0) {
			v.getLabelInfoMessage().setText("Au moins une energie doit être sélectionnée");
			return ;
		}
		energies = (ArrayList<EnergyTypes>) v.getListEnergies().getSelectedValuesList();
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
		// Action delivered by button
		switch(e.getActionCommand()) {
			case "addPokemon":
				new UpdatePokemon(
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
					)
				);
				break;
			case "updatePokemon":
				System.out.println("PokemonController - updatePokemon");
				break;
			case "deletePokemon":
				System.out.println("PokemonController - deletePokemon");
				break;
			default:
				System.out.println("Une erreur est survenue sur la classe PokemonController.");
				break;
		}
		
	}

	private int tryParseInt(String value) {
		int number;
		try {  
			number = Integer.parseInt(value);  
		} catch (NumberFormatException e) {  
			return 0;  
		}
		return number;
	}
	
	public Pokemon getPokemon() {
		return pokemon;
	}

}
