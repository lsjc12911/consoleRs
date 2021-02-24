package RPG;


public class Unit {
	
	private String name;
	private int hp;
	private int MAX_HP;
	private int damage;
	private int drop;
	private int exp;
	
	public Unit(String name, int hp, int maxHP, int d, int drop, int exp){
		this.name = name;
		this.hp = hp;
		this.MAX_HP = maxHP;
		this.damage = d;
		this.drop = drop;
		this.exp = exp;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getHp() {
		return hp;
	}
	
	public void setHp(int hp) {
		this.hp = hp;
	}
	
	public int getDam() {
		return damage;
	}
	
	public void setDam(int d) {
		this.damage = d;
	}
	
	public int getMaxHp() {
		return MAX_HP;
	}
	
	public void setMaxHp(int hp) {
		this.MAX_HP = hp;
	}
	
	public int getDrop() {
		return drop;
	}

	public void setDrop(int drop) {
		this.drop = drop;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

}
