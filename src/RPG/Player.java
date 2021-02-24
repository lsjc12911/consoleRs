package RPG;

public class Player{
	//NAME HP MAXHP DAMAGE EXP MAPEXP LVL
	private String name;
	private int hp;
	private int MAX_HP;
	private int damage;
	private int exp;
	private int maxEXP;
	private int level;
	private int coins;
	
	public Player(String name, int hp, int maxHP, int d, int exp, int maxEXP, int lvl, int coins) {
		this.name = name;
		this.hp = hp;
		this.MAX_HP = maxHP;
		this.damage = d;
		this.exp = exp;
		this.maxEXP = maxEXP;
		this.level = lvl;
		this.coins = coins;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getHP() {
		return hp;
	}
	
	public void setHP(int hp) {
		this.hp = hp;
	}
	
	public int getMaxHP() {
		return MAX_HP;
	}
	
	public void setMaxHP(int MAX_HP) {
		this.MAX_HP = MAX_HP;
	}
	
	public int getDam() {
		return damage;
	}
	
	public void setDam(int d) {
		this.damage = d;
	}
	
	public int getExp() {
		return exp;
	}
	
	public void setExp(int exp) {
		this.exp = exp;
	}
	
	public int getMEXP() {
		return maxEXP;
	}
	
	public void setMEXP(int maxEXP) {
		this.maxEXP = maxEXP;
	}
	
	public int getLvl() {
		return level;
	}
	
	public void setLvl(int lvl) {
		this.level = lvl;
	}
	
	public int getCoins() {
		return coins;
	}
	
	public void setCoins(int coins) {
		this.coins = coins;
	}
	
	public void lvlCheck() {
		if(getExp() >= getMEXP()) {
			int leftover = 0;
			leftover = getExp() - getMEXP();
			System.out.println("[Level UP!]");
			System.out.println("Previous STATS");
			System.out.println("LEVEL: " + getLvl());
			System.out.println("HP: " + getMaxHP());
			System.out.println("DAMAGE: " + getDam());
			System.out.println("MAX EXP: " + getMEXP());
			System.out.print("1..");
			Game.s.sleep();
			System.out.print(" 2..");
			Game.s.sleep();
			System.out.print(" 3..");
			Game.s.sleep();
			Game.c.clear();
			System.out.println("Current STATS");
			setLvl(getLvl() + 1);
			System.out.println("LEVEL: " + getLvl() + " (+1)");
			setMaxHP(getMaxHP() + 1);
			setHP(getMaxHP());
			System.out.println("HP: " + getMaxHP() + " (+1)");
			setDam(getDam() + 1);
			System.out.println("DAMAGE: " + getDam() + " (+1)");
			setMEXP(getMEXP() + 5);
			System.out.println("MAX EXP: " + getMEXP() + " (+5)");
			setExp(leftover);
			System.out.println("TOTAL: " + getExp()+"/"+getMEXP());
			Game.s.sleep2();
		}
	}
}
