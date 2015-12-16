package Model;

import java.io.Serializable;

public class Card implements Serializable {
	
	protected String name;

	public Card(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
}
