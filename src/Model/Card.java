package Model;

import java.io.Serializable;
import java.util.ArrayList;

public class Card implements Serializable {
	
	protected String name;
	
	public Card(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public void changeName(String newName) {
		name = newName;
	}
	
}
