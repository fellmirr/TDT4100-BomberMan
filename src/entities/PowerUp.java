package entities;

import java.util.concurrent.ThreadLocalRandom;

public class PowerUp {
	
	char type;
	
	public PowerUp(){
		
		int randomNum = ThreadLocalRandom.current().nextInt(0,4);
		
		if (randomNum <= 1){//Power
			this.type = 'P';
		}
		else if (randomNum <= 2){//LF
			this.type = 'L';
		}
		
		else if (randomNum <= 3){//Capacity
			this.type = 'C';
		}
		else if (randomNum <= 4){//speed
			this.type = 'S';
		}
		else{
			//Future powerups?
		}
		
	}

}
