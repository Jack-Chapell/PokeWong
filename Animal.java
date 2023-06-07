
public class Animal {
	private String name;
	private double health, attack, defense, fear, strength;
	
	public Animal(String name, double health, double attack, double defense, double fear, double strength) {
		super();
		this.name = name;
		this.health = health;
		this.attack = attack;
		this.defense = defense;
		this.fear = fear;
		this.strength = strength;
	}
	
	public Animal() {
		name = "";
		health = 0;
		attack = 0;
		defense = 0;
		fear = 0;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getHealth() {
		return health;
	}

	public void setHealth(double health) {
		this.health = health;
	}

	public double getAttack() {
		return attack;
	}

	public void setAttack(double attack) {
		this.attack = attack;
	}

	public double getDefense() {
		return defense;
	}

	public void setDefense(double defense) {
		this.defense = defense;
	}

	public double getFear() {
		return fear;
	}

	public void setFear(double fear) {
		this.fear = fear;
	}
	
	
	public double getStrength() {
		return strength;
	}

	public void setStrength(double strength) {
		this.strength = strength;
	}

	public void damage(double damage) {
		health = health - (damage*defense);
	}
	
	public void addFear(double fearAdd) {
		fear = fear + fearAdd;
	}

	@Override
	public String toString() {
		return name + ", health: " + health + ", attack: " + attack + ", defense: " + defense + ", fear: "
				+ fear + ", strength: " + strength;
	}
	
	
}
