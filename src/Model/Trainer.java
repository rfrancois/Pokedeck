package Model;

import java.io.Serializable;

public class Trainer extends Card implements Serializable {
	
	public Trainer(String name) {
		super(name);
	}
	private String text;
	private String rule;
	private TrainerTypes type;
	
	public Trainer(String name, String text, String rule, TrainerTypes type) {
		super(name);
		this.text = text;
		this.rule = rule;
		this.type = type;
		cards.add(this);
	}
	
	public String getText() {
		return text;
	}
	
	public String getRule() {
		return rule;
	}
	
	public TrainerTypes getType() {
		return type;
	}

	public static enum TrainerTypes {
		Item {
			@Override
			public String toString() {
				return "Item";
			}
		},
		Bonus {
			@Override
			public String toString() {
				return "Bonus";
			}
		}	
	}

	public void changeText(String text) {
		this.text = text;
	}

	public void changeRule(String rule) {
		this.rule = rule;
	}

	public void changeType(TrainerTypes type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return "Trainer " + super.getName() +  " [text=" + text + ", rule=" + rule + ", type=" + type
				+ "]";
	}
	
}
