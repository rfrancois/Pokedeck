package Model;

import java.util.ArrayList;

public class Trainer extends Card {
	
	public Trainer(String name) {
		super(name);
	}
	private String text;
	private String rule;
	private static ArrayList<Trainer> trainers;
	private TrainerTypes type;
	
	public Trainer(String name, String text, String rule, TrainerTypes type) {
		super(name);
		this.text = text;
		this.rule = rule;
		this.type = type;
	}
	
	public String getText() {
		return text;
	}
	public String getRule() {
		return rule;
	}
	
	public static enum TrainerTypes {
		Item {
			@Override
			public String toString() {
				return "Item";
			}
		}		
	}
	
}
