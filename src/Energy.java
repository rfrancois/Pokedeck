
public class Energy extends Card {
	
	public Energy() {
		name = EnergyTypes.Grass.toString();
	}
	
	public String toString() {
		return name;
	}
	
	public static enum EnergyTypes {
		Grass {
			@Override
			public String toString() {
				return "Grass";
			}
		},
		Fire {
			@Override
			public String toString() {
				return "Fire";
			}
		}, 
		Water {
			@Override
			public String toString() {
				return "Water";
			}
		}, 
		Lighting {
			@Override
			public String toString() {
				return "Lighting";
			}
		}, 
		Psychic {
			@Override
			public String toString() {
				return "Psychic";
			}
		}, 
		Fighting {
			@Override
			public String toString() {
				return "Fighting";
			}
		}, 
		Darkness {
			@Override
			public String toString() {
				return "Darkness";
			}
		}, 
		Metal {
			@Override
			public String toString() {
				return "Metal";
			}
		}, 
		Fairy {
			@Override
			public String toString() {
				return "Fairy";
			}
		}, 
		Dragon {
			@Override
			public String toString() {
				return "Dragon";
			}
		}, 
		Colorless {
			@Override
			public String toString() {
				return "Colorless";
			}
		};
	}

}
