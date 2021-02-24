package RPG;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Filedata {
	
	public void save() throws IOException {
		
		FileWriter fw = null;
		
		String player_path = "playerData.txt";
		String shop_path = "shopData.txt";
		String slot_path = "slotData.txt";
		String u_path = "unitData.txt";
		
		
		String playerData = "";
		String shopData = "";
		String slotData = "";
		String uData = "";
		
		//Shop items
		ArrayList<Weapon> weapon = iConstructor.weapon;
		ArrayList<Potion> potion = iConstructor.potion;
		//Inventory
		ArrayList<Weapon> w = iConstructor.w_slot;
		ArrayList<Potion> p = iConstructor.p_slot;
		ArrayList<Weapon> inven = iConstructor.inven;
		//Enemy
		ArrayList<Unit> enemy = uConstructor.enemy;
		
		//Player Data
		playerData += uConstructor.p.getName();
		playerData += "/";
		playerData += uConstructor.p.getCoins();
		playerData += "/";
		playerData += uConstructor.p.getDam();
		playerData += "/";
		playerData += uConstructor.p.getHP();
		playerData += "/";
		playerData += uConstructor.p.getMaxHP();
		playerData += "/";
		playerData += uConstructor.p.getExp();
		playerData += "/";
		playerData += uConstructor.p.getMEXP();
		playerData += "/";
		playerData += uConstructor.p.getLvl();
		
		//Shop Data
		shopData += weapon.size();
		shopData += "\n";
		
		for(int i = 0; i < weapon.size(); i++) {
			shopData += weapon.get(i).getName();
			shopData += "/";
			shopData += weapon.get(i).getDam();
			shopData += "/";
			shopData += weapon.get(i).getCost();
			shopData += "\n";
		}
		
		shopData += potion.size();
		shopData += "\n";
		
		for(int i = 0; i < potion.size(); i++) {
			shopData += potion.get(i).getName();
			shopData += "/";
			shopData += potion.get(i).getHeal();
			shopData += "/";
			shopData += potion.get(i).getCost();
			if(i != potion.size() - 1) {
				shopData += "\n";
			}
		}
		
		//Slot Data, Inven Data
		slotData += w.size();
		slotData += "\n";
		
		for(int i = 0; i < w.size(); i++) {
			slotData += w.get(i).getName();
			slotData += "/";
			slotData += w.get(i).getDam();
			slotData += "/";
			slotData += w.get(i).getCost();
			slotData += "\n";
		}
		
		slotData += p.size();
		slotData += "\n";
		
		for(int i = 0; i < p.size(); i++) {
			slotData += p.get(i).getName();
			slotData += "/";
			slotData += p.get(i).getHeal();
			slotData += "/";
			slotData += p.get(i).getCost();
			slotData += "/";
			slotData += p.get(i).getQ();
			slotData += "\n";
		}
		
		slotData += inven.size();
		slotData += "\n";
		
		if(inven.size() != 0) {
			slotData += inven.get(0).getName();
			slotData += "/";
			slotData += inven.get(0).getDam();
			slotData += "/";
			slotData += inven.get(0).getCost();
		}
		
		//Unit Data (Enemy)
		
		uData += enemy.size();
		uData += "\n";
		
		 //NAME    HP	 MAXHP  DAMAGE  DROP    EXP
		for(int i = 0; i < enemy.size(); i++) {
			uData += enemy.get(i).getName();
			uData += "/";
			uData += enemy.get(i).getHp();
			uData += "/";
			uData += enemy.get(i).getMaxHp();
			uData += "/";
			uData += enemy.get(i).getDam();
			uData += "/";
			uData += enemy.get(i).getDrop();
			uData += "/";
			uData += enemy.get(i).getExp();
			if(i != enemy.size() - 1) {
				uData += "\n";
			}
		}
		
		try {
			fw = new FileWriter(player_path);
			fw.write(playerData);
			fw.close();
			fw = new FileWriter(shop_path);
			fw.write(shopData);
			fw.close();
			fw = new FileWriter(slot_path);
			fw.write(slotData);
			fw.close();
			fw = new FileWriter(u_path);
			fw.write(uData);
			fw.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public int load()throws IOException {
		
		//for return
		int count = 0;
		
		String player_path = "playerData.txt";
		String shop_path = "shopData.txt";
		String slot_path = "slotData.txt";
		String u_path = "unitData.txt";
		
		String playerData = "";
		String shopData = ""; //weapons
		String shopData2 = ""; //potions
		String slotData = ""; //weapon slot
		String slotData2 = ""; //potion slot
		String slotData3 = ""; //inven slot
		String uData = ""; 
		
		File file = null;
		FileReader fr = null;
		BufferedReader br = null;
		
		file = new File(player_path);
		if(file.exists()) {
			count += 1;
		}
		file = new File(shop_path);
		if(file.exists()) {
			count += 1;
		}
		file = new File(slot_path);
		if(file.exists()) {
			count += 1;
		}
		file = new File(u_path);
		if(file.exists()) {
			count += 1;
		}
		
		if(count == 4) {
			
			//Player Load
			file = new File(player_path);
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			String playerLine = br.readLine();
			playerData += playerLine;
			//name, coins, damage, hp, maxhp, exp, maxexp, lvl
			String[] info = playerData.split("/");
			uConstructor.p.setName(info[0]);
			uConstructor.p.setCoins(Integer.parseInt(info[1]));
			uConstructor.p.setDam(Integer.parseInt(info[2]));
			uConstructor.p.setHP(Integer.parseInt(info[3]));
			uConstructor.p.setMaxHP(Integer.parseInt(info[4]));
			uConstructor.p.setExp(Integer.parseInt(info[5]));
			uConstructor.p.setMEXP(Integer.parseInt(info[6]));
			
			//Shop load
			//Load Weapon Shop
			iConstructor.weapon.clear();
			file = new File(shop_path);
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			
			String wLine = br.readLine();
			int wSize = Integer.parseInt(wLine);
			
			int cnt = 0;
			while(cnt < wSize) {
				wLine = br.readLine();
				shopData += wLine;
				shopData += "\n";
				cnt += 1;
			}
			
			String[] wtemp = shopData.split("\n");
			
			System.out.println(wSize);
			for(int i = 0; i < wtemp.length; i++) {
				System.out.println(wtemp[i]);
			}
			
			//name damage cost
			for(int i = 0; i < wSize; i++) {
				String[] winfo = wtemp[i].split("/");
				String name = winfo[0];
				int damage = Integer.parseInt(winfo[1]);
				int cost = Integer.parseInt(winfo[2]);
				Weapon w = new Weapon(name, cost);
				w.setDam(damage);
				iConstructor.weapon.add(w);
			}
			
			//Load Potion shop
			iConstructor.potion.clear();
			String pLine = br.readLine();
			int pSize = Integer.parseInt(pLine);
			
			cnt = 0;
			while(cnt < pSize) {
				pLine = br.readLine();
				shopData2 += pLine;
				shopData2 += "\n";
				cnt += 1;
			}
			
			String[] ptemp = shopData2.split("\n");
			System.out.println(pSize);
			for(int i = 0; i < ptemp.length; i++) {
				System.out.println(ptemp[i]);
			}
			
			//name heal cost
			for(int i = 0; i < pSize; i++) {
				String[] pinfo = ptemp[i].split("/");
				String name = pinfo[0];
				int heal = Integer.parseInt(pinfo[1]);
				int cost = Integer.parseInt(pinfo[2]);
				Potion p = new Potion(name, cost);
				p.setHeal(heal);
				iConstructor.potion.add(p);
			}
			
			//Slot load
			//weapon
			iConstructor.w_slot.clear();
			file = new File(slot_path);
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			
			String wsLine = br.readLine();
			int wsSize = Integer.parseInt(wsLine);
			
			if(wsSize != 0) {
				cnt = 0;
				while(cnt < wsSize) {
					wsLine = br.readLine();
					slotData += wsLine;
					slotData += "\n";
					cnt += 1;
				}
				
				String[] wstemp = slotData.split("\n");
				System.out.println(wsSize);
				for(int i = 0; i < wstemp.length; i++) {
					System.out.println(wstemp[i]);
				}
				
				//name damage cost
				for(int i = 0; i < wsSize; i++) {
					String[] wsinfo = wstemp[i].split("/");
					String name = wsinfo[0];
					int damage = Integer.parseInt(wsinfo[1]);
					int cost = Integer.parseInt(wsinfo[2]);
					Weapon ws = new Weapon(name, cost);
					ws.setDam(damage);
					iConstructor.w_slot.add(ws);
				}
			}
			
			//potion
			iConstructor.p_slot.clear();
			
			String psLine = br.readLine();
			int psSize = Integer.parseInt(psLine);
			
			if(psSize != 0) {
				cnt = 0;
				while(cnt < psSize) {
					psLine = br.readLine();
					slotData2 += psLine;
					slotData2 += "\n";
					cnt += 1;
				}
				
				String[] pstemp = slotData2.split("\n");
				
				System.out.println(psSize);
				for(int i = 0; i < pstemp.length; i++) {
					System.out.println(pstemp[i]);
				}
				
				for(int i = 0; i < psSize; i++) {
					String[] psinfo = pstemp[i].split("/");
					String name = psinfo[0];
					int heal = Integer.parseInt(psinfo[1]);
					int cost = Integer.parseInt(psinfo[2]);
					int quantity = Integer.parseInt(psinfo[3]);
					Potion ps = new Potion(name, cost);
					ps.setHeal(heal);
					ps.setQ(quantity);
					iConstructor.p_slot.add(ps);
				}
			}
			
			//inven
			iConstructor.inven.clear();
			
			String iLine = br.readLine();
			int iSize = Integer.parseInt(iLine);
			
			if(psSize != 0) {
				cnt = 0;
				while(cnt < iSize) {
					iLine = br.readLine();
					slotData3 += iLine;
					slotData3 += "\n";
					cnt += 1;
				}
				
				String[] itemp = slotData3.split("\n");
				
				System.out.println(iSize);
				for(int i = 0; i < itemp.length; i++) {
					System.out.println(itemp[i]);
				}
				
				String[] iinfo = itemp[0].split("/");
				String name = iinfo[0];
				int damage = Integer.parseInt(iinfo[1]);
				int cost = Integer.parseInt(iinfo[2]);
				Weapon inven = new Weapon(name, cost);
				inven.setDam(damage);
				iConstructor.inven.add(inven);
			}
			
			//Normal Unit
			uConstructor.enemy.clear();
			file = new File(u_path);
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			
			String uLine = br.readLine();
			int uSize = Integer.parseInt(uLine);
			
			if(uSize != 0) {
				cnt = 0;
				while(cnt < uSize) {
					uLine = br.readLine();
					uData += uLine;
					uData += "\n";
					cnt += 1;
				}
				
				String[] utemp = uData.split("\n");
				
				System.out.println(utemp.length);
				for(int i = 0; i < utemp.length; i++) {
					System.out.println(utemp[i]);
				}
				
				 //NAME    HP	 MAXHP  DAMAGE  DROP    EXP
				for(int i = 0; i < uSize; i++) {
					String[] uinfo = utemp[i].split("/");
					String name = uinfo[0];
					int hp = Integer.parseInt(uinfo[1]);
					int maxhp = Integer.parseInt(uinfo[2]);
					int damage = Integer.parseInt(uinfo[3]);
					int drop = Integer.parseInt(uinfo[4]);
					int exp = Integer.parseInt(uinfo[5]);
					Unit e = new Unit(name, hp, maxhp, damage, drop, exp);
					uConstructor.enemy.add(e);
				}
			}
		}
		return count;
	}
}
