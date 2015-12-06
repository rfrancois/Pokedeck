package Model;

public class Attack {
	private String name;
	private int damage;
	
	public Attack(String name, int damage) {
		super();
		this.name = name;
		this.damage = damage;
	}

	@Override
	public String toString() {
		return "Attack [name=" + name + ", damage=" + damage + "]";
	}
}
