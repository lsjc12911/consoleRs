package RPG;

public class Battle {
	
		int ran;
		String name;
		int hp;
		int max;
		int damage;
		int drop;
		int exp;
		
		int wdamage;

	public void pAttack() {
		int pgen = Game.ran.nextInt((uConstructor.p.getDam() + wdamage) + 1);
		if(pgen == 0) {
			System.out.println("You miss and hit nothing! - 0");
		}else {
			System.out.println("You take a swing, you damage the " + name + " : -" + pgen);
			hp -= pgen;
		}
	}
	
	public void eAttack() {
		int egen = Game.ran.nextInt(damage + 1);
		if(egen == 0) {
			System.out.println(name + " missed and hits nothing! - 0");
		}else {
			System.out.println(name + " takes a swing at you, damages you : -" + damage);
			uConstructor.p.setHP(uConstructor.p.getHP() - egen);
		}
	}
	
	public int pCheck(int check) {
		if(uConstructor.p.getHP() <= 0) {
			check = 2;
		}
		return check;
	}
	
	public int eCheck(int check) {
		if(hp <= 0) {
			check = 1;
		} 
		return check; 
	}
	
	public void fight() {
		int check = 0;
		int unit = Game.ran.nextInt(uConstructor.enemy.size());
		 name = uConstructor.enemy.get(unit).getName();
		 hp = uConstructor.enemy.get(unit).getHp();
		 max = uConstructor.enemy.get(unit).getMaxHp();
		 damage = uConstructor.enemy.get(unit).getDam();
		 drop = uConstructor.enemy.get(unit).getDrop();
		 exp = uConstructor.enemy.get(unit).getExp();
		 
		 if(iConstructor.inven.size() != 0) {
			 wdamage = iConstructor.inven.get(0).getDam();
		 }
		 
		System.out.println("[" + name + "]" + "Has appeared!");
		try {
			Thread.sleep(2000);
			Game.c.clear();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		while(true) {
			System.out.println("[" + name + "]");
			System.out.println("[HP: " + hp + "/" + max + "]");
			System.out.println("=====================");
			System.out.println("[" + uConstructor.p.getName() + "]");
			System.out.println("[HP: " + uConstructor.p.getHP() + "/" + uConstructor.p.getMaxHP() + "]\n");
			System.out.println();
			System.out.println("1. Attack | 2. Potion | 3. Run");
			int sel = Game.checkInt();
			Game.c.clear();
			if(sel == 1) {
				pAttack();
				Game.s.sleep();
				check = eCheck(check);
					if(check == 1) {
						int ranDrop = Game.ran.nextInt(drop) + 1;
						Game.c.clear();
						System.out.println("You defeat the " + name);
						System.out.println("You recieve " + ranDrop + " coins, " + exp + " EXP");
						Game.s.sleep2();
						Game.c.clear();
						uConstructor.p.setCoins(uConstructor.p.getCoins() + ranDrop);
						uConstructor.p.setExp(uConstructor.p.getExp() + exp);
						uConstructor.p.lvlCheck();
						break;
					}
				eAttack();
				Game.s.sleep();
				Game.c.clear();
				check = pCheck(check);
					if(check == 2) {
						Game.c.clear();
						System.out.println("GAME OVER");
						System.exit(0);
					}
			}else if(sel == 2) {
				while(true) {
					for(int i = 0; i < iConstructor.p_slot.size(); i++) {
						System.out.println("["+(i+1)+"] " + iConstructor.p_slot.get(i).getName() + " | Heal: " + iConstructor.p_slot.get(i).getHeal() + " | Quantity: " + iConstructor.p_slot.get(i).getQ());
					}
					System.out.println("[0] Back");
					System.out.println("Select a food you would like to use");
					int sel2 = Game.checkInt();
					if(sel2 == 0) break;
					sel2 -=1;
					if(iConstructor.p_slot.size() == 0) {
						System.out.println("There's no food to use!");
					}
					if(sel2 >= 0 && sel2 < iConstructor.p_slot.size()) {
						if(uConstructor.p.getHP() == uConstructor.p.getMaxHP()) {
							System.out.println("You are already in full health!");
						}else {
							System.out.println("Used +1 " + iConstructor.p_slot.get(sel2).getName());
							uConstructor.p.setHP(uConstructor.p.getHP() + iConstructor.p_slot.get(sel2).getHeal());
							if(uConstructor.p.getHP() > uConstructor.p.getMaxHP()) {
								uConstructor.p.setHP(uConstructor.p.getMaxHP());
							}
							iConstructor.p_slot.get(sel2).setQ(iConstructor.p_slot.get(sel2).getQ() - 1);
							if(iConstructor.p_slot.get(sel2).getQ() == 0) {
								iConstructor.p_slot.remove(sel2);
							}
							Game.s.sleep2();
							eAttack();
							Game.s.sleep();
							Game.c.clear();
							check = pCheck(check);
							break;
						}
					}
				}
				if(check == 2) {
					Game.c.clear();
					System.out.println("GAME OVER");
					System.exit(0);
				}
			}else if(sel == 3) {
				System.out.println("You cowardly run away.");
				break;
			}
		}
	}
}
