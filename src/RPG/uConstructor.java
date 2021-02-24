package RPG;

import java.util.ArrayList;

public class uConstructor {
	
	public String name;

	static ArrayList<Unit> enemy = new ArrayList<>();
							    //NAME HP MAXHP DAMAGE EXP MAPEXP LVL COINS
	static Player p = new Player(null, 10, 10, 3, 0, 10, 1, 1000);
	
	public uConstructor() {
							   //NAME    HP	 MAXHP  DAMAGE  DROP    EXP
		Unit goblin = new Unit("Goblin", 5,  5,     1,      24,     1);
		Unit ogre = new Unit  ("Ogre"  , 5,  5,     1,      24,     1);
		
		enemy.add(goblin);
		enemy.add(ogre);
	}
	
	public void Admin() {
		while(true) {
			System.out.println("1. Create normal unit");
			System.out.println("2. Delete normal unit");
			System.out.println("3. Set player Status");
			System.out.println("0. Back");
			int sel = Game.checkInt();
			Game.c.clear();
			if(sel == 0) break;
			if(sel == 1) {
				createUnit();
			}else if(sel == 2) {
				deleteUnit();
			}else if(sel == 3) {
				setPlayer();
			}
		}
	}
	
	public void deleteUnit() {
		while(true) {
			for(int i = 0; i < enemy.size(); i++) {
				System.out.println("["+(i+1)+"]" + enemy.get(i).getName());
			}
			System.out.println("[0] back");
			System.out.println("Select the number you would like to remove");
			int sel = Game.checkInt();
			if(sel == 0) break;
			sel -= 1;
			if(sel < 0 || sel > enemy.size()) continue;
			enemy.remove(sel);
			System.out.println("Removed Complete!");
			break;
		}
	}
	
	public void createUnit() {
		int hp;
		int MAX_HP;
		int damage;
		int drop;
		int exp;
		while(true) {
			System.out.println("Unit Creation");
			System.out.print("Set name: ");
			String u_name = Game.scan.next();
			this.name = u_name;
			System.out.println();
			System.out.print("Set HP: ");
			int u_hp = Game.scan.nextInt();
			hp = u_hp;
			MAX_HP = hp;
			System.out.println();
			System.out.print("Set damage: ");
			int u_damage = Game.scan.nextInt();
			damage = u_damage;
			System.out.println();
			System.out.print("Set drop: ");
			int u_drop = Game.scan.nextInt();;
			drop = u_drop;
			System.out.println();
			System.out.print("Set exp: ");
			int u_exp = Game.scan.nextInt();
			exp = u_exp;
			System.out.println();
			Unit name = new Unit(this.name, hp, MAX_HP, damage, drop, exp);
			System.out.println(name);
			System.out.println(this.name);
			System.out.println("Are you willing to create this Unit?");
			System.out.println("1. YES | 2. NO");
			int sel = Game.checkInt();
			Game.c.clear();
			if(sel == 1) {
				System.out.println("Creating Unit...");
				Game.s.sleep2();
				Game.c.clear();
				enemy.add(name);
				System.out.println("Unit Created!");
				break;
			}else if(sel == 2) {
				Game.c.clear();
				break;
			}
		}
	}
	
	public void setPlayer() {
		while(true) {
			//NAME HP MAXHP DAMAGE EXP MAPEXP LVL
			System.out.println("Name: " + p.getName());
			System.out.println("MAX HP: " + p.getHP() + "/" + p.getMaxHP());
			System.out.println("Damage: " + p.getDam());
			System.out.println("Level: " + p.getLvl());
			System.out.println("EXP: " + p.getMEXP());
			System.out.println("Coins: " + p.getCoins());
			System.out.println();
			System.out.println("[1] Name");
			System.out.println("[2] HP");
			System.out.println("[3] Damage");
			System.out.println("[4] Level");
			System.out.println("[5] Coins");
			System.out.println("[0] Back");
			System.out.println("Select the options you would like to set");
			int sel = Game.checkInt();
			Game.c.clear();
			if(sel == 0) break;
			if(sel == 1) {
				System.out.println("Current name: " + p.getName());
				System.out.println("Type in the name to change");
				String name_change = Game.scan.next();
				Game.c.clear();
				p.setName(name_change);
				System.out.println("Changing name...");
				Game.s.sleep2();
				Game.c.clear();
				System.out.println("Name Changed!");
			}else if(sel == 2) {
				System.out.println("Current HP: " + p.getMaxHP());
				System.out.println("Type in the HP to change");
				int hp_change = Game.checkInt();
				Game.c.clear();
				if(hp_change <= 0) continue;
				p.setMaxHP(hp_change);
				p.setHP(hp_change);
				System.out.println("Changing MAX HP...");
				Game.s.sleep2();
				Game.c.clear();
				System.out.println("HP Changed!");
			}else if(sel == 3) {
				System.out.println("Current damage: " + p.getDam());
				System.out.println("Type in the damage to change");
				int dam_change = Game.checkInt();
				Game.c.clear();
				if(dam_change <= 0) continue;
				p.setDam(dam_change);
				System.out.println("Changing damage...");
				Game.s.sleep2();
				Game.c.clear();
				System.out.println("Damage Changed!");
			}else if(sel == 4) {
				System.out.println("Current level: " + p.getLvl());
				System.out.println("Type in the level to change");
				int lvl_change = Game.checkInt();
				Game.c.clear();
				if(lvl_change <= 0) continue;
				else {
					//need fixing
					p.setLvl(lvl_change);
					p.setHP(10 + (lvl_change * 1));
					p.setMaxHP(10 + (lvl_change * 1));
					p.setDam(3 + (lvl_change * 1));
					p.setMEXP(5 + (lvl_change * 5));
					System.out.println("Changing level...");
					Game.s.sleep2();
					Game.c.clear();
					System.out.println("Level Changed!");
				}
			}else if(sel == 5) {
				System.out.println("Current coins: " + p.getCoins());
				System.out.println("Type in the coin value to change");
				int coin_change = Game.checkInt();
				Game.c.clear();
				if(coin_change <= 0) continue;
				p.setCoins(coin_change);
				System.out.println("Changing coin value...");
				Game.s.sleep2();
				Game.c.clear();
				System.out.println("Coin value Changed!");
			}
		}
	}
}
