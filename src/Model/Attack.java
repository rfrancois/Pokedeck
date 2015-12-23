package Model;

import java.io.Serializable;

public class Attack implements Serializable {
	private String name;
	private int damage;
	
	public Attack(String name, int damage) {
		super();
		this.name = name;
		this.damage = damage;
	}

	public String getName() {
		return name;
	}

	public int getDamage() {
		return damage;
	}

	@Override
	public String toString() {
		return "Attack [name=" + name + ", damage=" + damage + "]";
	}
}
