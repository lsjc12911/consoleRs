package RPG;

public class Sleep {
	
	public void sleep() {
		try {
			Thread.sleep(1000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void sleep2() {
		for(int i = 0; i < 2; i++) {
			sleep();
		}
	}
}
