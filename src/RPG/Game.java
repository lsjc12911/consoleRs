package RPG;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {
	
	static Scanner scan = new Scanner(System.in);
	static Random ran = new Random();
	static CLS c = new CLS();
	static Sleep s = new Sleep();
	static Battle b = new Battle();
	static Shop shop = new Shop();
	static uConstructor u = new uConstructor();
	
	
	boolean start = true;
	
	public Game() {
		Filedata fd = new Filedata();
		while(start) {
			int count = 0;
			System.out.println("Runescape v.0.1");
			System.out.println("1. New game | 2. Load | 0. Quit");
			int sel = checkInt();
			if(sel == 0) System.exit(0);
			if(sel == 1) {
				while(true) {
					System.out.print("Type in your name: ");
					String pName = inputS();
					System.out.println("Are you sure?");
					System.out.println("1. YES | 2. NO");
					int sel2 = checkInt();
					if(sel2 == 1) {
						uConstructor.p.setName(pName);
						start = false;
						break;
					}else if(sel2 == 2) {
						break;
					}
				}
			}else if(sel == 2) {
				try {
					count = fd.load();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(count < 4) {
					System.out.println("Unable to Load, File missing!");
				}else {
					System.out.println("Loading Player...");
					s.sleep2();
					System.out.println("Loading Unit...");
					s.sleep2();
					System.out.println("Loading Shop...");
					s.sleep2();
					System.out.println("Loading Inventory...");
					s.sleep2();
					System.out.println("Game Loaded!");
					s.sleep();
					c.clear();
					start = false;
					break;
				}
			}
		}
		System.out.println("Welcome to Town");
		while(true) {
			System.out.print("Name: " + uConstructor.p.getName());
			if(iConstructor.inven.size() == 0) {
				System.out.print(" Equipped: Nothing"
						+ " Damage: " + uConstructor.p.getDam());
			}else {
				System.out.print(" Equipped: " + iConstructor.inven.get(0).getName()
						+ " Damage: " + uConstructor.p.getDam() + " +(" + iConstructor.inven.get(0).getDam() + ")");
			}
			System.out.print(" HP: " + uConstructor.p.getHP() +"/" + uConstructor.p.getMaxHP()
			+ " EXP: " + uConstructor.p.getExp() + "/" + uConstructor.p.getMEXP()
			+ " Level: " + uConstructor.p.getLvl()
			+ " Coins: " + uConstructor.p.getCoins());
			System.out.println();
			System.out.println("1. Train | 2. Adventure | 3. Shop | 4. Inventory | 5. Modifier | 6. Save | 7. Exit");
			int sel = checkInt();
			c.clear();
			if(sel == 1) {
				b.fight();
			}else if(sel == 2) {
				
			}else if(sel == 3) {
				shop.viewShop();
			}else if(sel == 4) {
				Shop.iC.viewInven();
			}else if(sel == 5) {
				u.Admin();
			}else if(sel == 6) {
				try {
					fd.save();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}else if(sel == 7) {
				System.exit(0);
			}
		}
	}
	
	
	public static void main(String[] args) {
		
		new Game();
	}
	
	public static int checkInt() {
		int input = 0;
			try {
				System.out.print("Input: ");
				input = Integer.parseInt(scan.next());
				c.clear();
			}catch(Exception e) {
				c.clear();
				System.out.println("Please enter a number!");
				s.sleep2();
				c.clear();
			}
		return input;
	}
	
	public static String inputS() {
		String input = scan.next();
		c.clear();
		return input;
	}
}

