package RPG;

public class Shop {
	
	static iConstructor iC = new iConstructor();
	
	public void viewShop() {
		while(true) {
			System.out.println("1. Buy | 2. Sell | 0. Back");
			int sel = Game.checkInt();
			if(sel == 0) break;
			if(sel == 1) {
				buyView();
			}else if(sel == 2) {
				
			}
		}
	}
	
	public void buyView() {
		while(true) {
			System.out.println("1. Weapon | 2. Potion | 0. Back");
			int sel = Game.checkInt();
			if(sel == 0) break;
			while(sel == 1) {
				System.out.println("=Weapons=");
				System.out.println("Coins: " + uConstructor.p.getCoins());
				for(int i = 0; i < iConstructor.weapon.size(); i++) {
					System.out.println("[" + (i+1) + "] " + iConstructor.weapon.get(i).getName() + " | Damage: " + iConstructor.weapon.get(i).getDam() + " | Cost: " + iConstructor.weapon.get(i).getCost());
				}
				System.out.println("[0] Back");
				System.out.println("Select a weapon you would like to buy");
				int wSel = Game.checkInt();
				if(wSel == 0) break;
				wSel -= 1;
				if(wSel < 0 || wSel > iConstructor.weapon.size()) continue;
				if(iConstructor.weapon.get(wSel).getCost() > uConstructor.p.getCoins()) {
					System.out.println("insufficient coins!");
				}else {
					System.out.println(iConstructor.weapon.get(wSel).getName() + " Bought for " + iConstructor.weapon.get(wSel).getCost());
					uConstructor.p.setCoins(uConstructor.p.getCoins() - iConstructor.weapon.get(wSel).getCost());
					iConstructor.w_slot.add(iConstructor.weapon.get(wSel));
				}
			}
			while(sel == 2) {
				System.out.println("=Potion=");
				System.out.println("Coins: " + uConstructor.p.getCoins());
				for(int i = 0; i < iConstructor.potion.size(); i++) {
					if(iConstructor.potion.get(i).getHeal() == 0) {
						System.out.println("[" + (i+1) + "] " + iConstructor.potion.get(i).getName() + " | Heal: full heal"  + " | Cost: " + iConstructor.potion.get(i).getCost());
					}else {
						System.out.println("[" + (i+1) + "] " + iConstructor.potion.get(i).getName() + " | Heal: " + iConstructor.potion.get(i).getHeal() + " | Cost: " + iConstructor.potion.get(i).getCost());
					}
				}
				System.out.println("[0] Back");
				System.out.println("Select a potion you would like to buy");
				int pSel = Game.checkInt();
				if(pSel == 0) break;
				pSel -= 1;
				if(pSel < 0 || pSel > iConstructor.potion.size()) continue;
				if(iConstructor.potion.get(pSel).getCost() > uConstructor.p.getCoins()) {
					System.out.println("insufficient coins!");
				}else {
					String name = iConstructor.potion.get(pSel).getName();
					int heal = iConstructor.potion.get(pSel).getHeal();
					int cost = iConstructor.potion.get(pSel).getCost();
					System.out.println("Bought +1 " + name + " for -" + cost + " coins");
					uConstructor.p.setCoins(uConstructor.p.getCoins() - cost);
					if(iConstructor.p_slot.size() == 0) {
						Potion potion = new Potion(name, cost);
						potion.setHeal(heal);
						potion.setQ(1);
						iConstructor.p_slot.add(potion);
					}else {
						int count = 0;
						int indx = 0;
						for(int i = 0; i < iConstructor.p_slot.size(); i++) {
							if(iConstructor.p_slot.get(i).getName().equals(name)) {
								count = 1;
								indx = i;
								break;
							}else {
								count = 2;
							}
						}
						if(count == 1) {
							iConstructor.p_slot.get(indx).setQ(iConstructor.p_slot.get(indx).getQ() + 1);
						}else if(count == 2) {
							Potion potion = new Potion(name, cost);
							potion.setHeal(heal);
							potion.setQ(1);
							iConstructor.p_slot.add(potion);
						}
					}
				}
			}
		}
	}
	
	public void sellView() {
		while(true) {
			
		}
	}
	
	
}
