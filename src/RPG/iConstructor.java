package RPG;

import java.util.ArrayList;

public class iConstructor {
	
	static ArrayList<Weapon> weapon = new ArrayList<>();
	static ArrayList<Potion> potion = new ArrayList<>();
	
	static ArrayList<Weapon> w_slot = new ArrayList<>();
	static ArrayList<Potion> p_slot = new ArrayList<>();
	
	static ArrayList<Weapon> inven = new ArrayList<>();
	
	public iConstructor() {
		
		Weapon bronzeW = new Weapon("Bronze Sword", 1000);
		bronzeW.setDam(4);
		weapon.add(bronzeW);
		
		Weapon ironW = new Weapon("Iron Sword", 2500);
		ironW.setDam(6);
		weapon.add(ironW);
		
		Weapon steelW = new Weapon("Steel Sword", 4000);
		steelW.setDam(11);
		weapon.add(steelW);
		
		Weapon blackW = new Weapon("Black Sword", 5000);
		blackW.setDam(14);
		weapon.add(blackW);
		
		Weapon mithrilW = new Weapon("Mithril Sword", 5900);
		mithrilW.setDam(16);
		weapon.add(mithrilW);
		
		Weapon adamantW = new Weapon("Adamant Sword", 7000);
		adamantW.setDam(23);
		weapon.add(adamantW);
		
		Weapon runeW = new Weapon("Rune Sword", 10000);
		runeW.setDam(38);
		weapon.add(runeW);
		
		Weapon dragonW = new Weapon("Dragon Sword", 20000);
		dragonW.setDam(65);
		weapon.add(dragonW);
		
		Potion shrimp = new Potion("Shrimp", 100);
		shrimp.setHeal(3); 
		potion.add(shrimp);
		
		Potion chicken = new Potion("Chicken", 150);
		chicken.setHeal(8); 
		potion.add(chicken);
		
		Potion salmon = new Potion("Salmon", 240);
		salmon.setHeal(15); 
		potion.add(salmon);
		
		Potion lobster = new Potion("Lobster", 350);
		lobster.setHeal(26); 
		potion.add(lobster);
		
		Potion mantray = new Potion("Mantray", 420);
		mantray.setHeal(33); 
		potion.add(mantray);
		
		Potion karambwan = new Potion("Karambwan", 490);
		karambwan.setHeal(40); 
		potion.add(karambwan);
		
		Potion shark = new Potion("Shark", 570);
		shark.setHeal(48); 
		potion.add(shark);
		
		Potion angler = new Potion("Angler fish", 700);
		angler.setHeal(65);
		potion.add(angler);
		
		Potion full = new Potion("Full restore", 1000);
		full.setHeal(0);
		potion.add(full);
	}
	
	public void viewInven() {
		while(true) {
			System.out.println("1. Equip | 2. Use food | 3. Toss | 0. Back");
			int sel = Game.checkInt();
			if(sel == 0) break;
			if(sel == 1) {
				equipView();
			}else if(sel == 2) {
				useView();
			}else if(sel == 3) {
				viewToss();
			}else if(sel == 4) {
				break;
			}
		}
	}
	
	public void equipView() {
		while(true) {
			if(inven.size() == 0) {
				System.out.println("Currently equipped: nothing");
			}else {
				System.out.println("Currently equipped: " + inven.get(0).getName());
			}
			for(int i = 0; i < w_slot.size(); i++) {
				System.out.println("["+(i+1)+"] " + w_slot.get(i).getName() + " | Damage: " + w_slot.get(i).getDam());
			}
			System.out.println("[0] Back");
			System.out.println("Select an item you would like to equip");
			int sel = Game.checkInt();
			if(sel == 0) break;
			if(w_slot.size() == 0) continue;
			sel -=1;
			if(inven.size() == 0) {
				inven.add(w_slot.get(sel));
				w_slot.remove(sel);
				System.out.println("Weapon equipped!");
			}else {
				Weapon temp = inven.get(0);
				inven.remove(0);
				inven.add(w_slot.get(sel));
				w_slot.remove(sel);
				w_slot.add(temp);
				System.out.println("Weapon changed!");
			}
		}
	}
	
	public void useView() {
		while(true) {
			System.out.println(uConstructor.p.getName() + "'s HP: " + uConstructor.p.getHP());
			for(int i = 0; i < p_slot.size(); i++) {
				if(p_slot.get(i).getHeal() == 0) {
					System.out.println("["+(i+1)+"] " + p_slot.get(i).getName() + " | Heal: Full restore" + " | Quantity: " + p_slot.get(i).getQ());
				}else {
					System.out.println("["+(i+1)+"] " + p_slot.get(i).getName() + " | Heal: " + p_slot.get(i).getHeal() + " | Quantity: " + p_slot.get(i).getQ());
				}
			}
			System.out.println("[0] Back");
			System.out.println("Select a food you would like to use");
			int sel = Game.checkInt();
			if(sel == 0) break;
			sel -=1;
			if(p_slot.size() == 0) {
				System.out.println("There's no food to use!");
			}
			if(sel >= 0 && sel < p_slot.size()) {
				if(uConstructor.p.getHP() == uConstructor.p.getMaxHP()) {
					System.out.println("You are already in full health!");
				}else {
					System.out.println("Used +1" + p_slot.get(sel).getName());
					uConstructor.p.setHP(uConstructor.p.getHP() + p_slot.get(sel).getHeal());
					if(uConstructor.p.getHP() > uConstructor.p.getMaxHP()) {
						uConstructor.p.setHP(uConstructor.p.getMaxHP());
					}
					p_slot.get(sel).setQ(p_slot.get(sel).getQ() - 1);
					if(p_slot.get(sel).getQ() == 0) {
						p_slot.remove(sel);
					}
				}
			}
		}
	}
	
	public void viewToss() {
		while(true) {
			System.out.println("1. Toss weapons | 2. Toss food | 0. Back");
			int sel = Game.checkInt();
			if(sel == 0) break;
			if(sel == 1) {
				wToss();
			}else if(sel == 2) {
				pToss();
			}
		}
	}
	public void wToss() {
		while(true) {
			for(int i = 0; i < w_slot.size(); i++) {
				System.out.println("[" + (i+1) + "] " + w_slot.get(i).getName());
			}
			System.out.println("[0] Back");
			System.out.println("Choose an item to toss");
			int sel = Game.checkInt();
			if(sel == 0) break;
			sel -=1;
			if(w_slot.size() == 0){
				System.out.println("There is no weapon to toss!");
			}else if(sel >= 0 && sel < w_slot.size()){
				w_slot.remove(sel);
				System.out.println("Item removed!");
			}
		}
	}
	
	public void pToss() {
		while(true) {
			for(int i = 0; i < p_slot.size(); i++) {
				System.out.println("[" + (i+1) + "] " + p_slot.get(i).getName() + " quantity: " + p_slot.get(i).getQ());
			}
			System.out.println("[0] Back");
			System.out.println("Choose a food to toss");
			int sel = Game.checkInt();
			if(sel == 0) break;
			sel -= 1;
			if(p_slot.size() == 0) {
				System.out.println("There is no food to toss!");
			}else if(sel >= 0 && sel < p_slot.size()) {
				if(p_slot.get(sel).getQ() == 1) {
					System.out.println("Food removed!");
					p_slot.remove(sel);
				}else {
					while(true) {
						System.out.println("[" + p_slot.get(sel).getName() + "]" + " Current amount: " + p_slot.get(sel).getQ());
						System.out.println("[0] Back");
						System.out.println("Select an amount you would like to toss");
						int sel2 = Game.checkInt();
						if(sel2 == 0) break;
						if(sel2 > 0 && sel2 <= p_slot.get(sel).getQ()) {
							p_slot.get(sel).setQ(p_slot.get(sel).getQ() - sel2);
							System.out.println("Tossed " + sel2 + " " + p_slot.get(sel).getName() + " away");
							if(p_slot.get(sel).getQ() == 0) {
								p_slot.remove(sel);
								break;
							}
						}
					}
				}
			}
		}
	}
}
