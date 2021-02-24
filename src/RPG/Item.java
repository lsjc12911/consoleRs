package RPG;

public class Item {
	
	private String name;
	private int cost;
	
	public Item(String name, int cost){
		this.name = name;
		this.cost = cost;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getCost() {
		return cost;
	}
	
	public void setCost(int cost) {
		this.cost = cost;
	}
}

class Weapon extends Item{
	
	private int damage;
	
	public Weapon(String name, int cost) {
		super(name, cost);
	}
	
	public int getDam() {
		return damage;
	}
	
	public void setDam(int d) {
		damage = d;
	}
	
}

class Potion extends Item{
	
	private int heal;
	private int quantity;

	public Potion(String name, int cost) {
		super(name, cost);
	}
	
	public int getHeal() {
		return heal;
	}
	
	public void setHeal(int heal) {
		this.heal = heal;
	}
	
	public int getQ() {
		return quantity;
	}
	
	public void setQ(int q) {
		quantity = q;
	}
}


