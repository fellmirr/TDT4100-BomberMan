package entities;

public class Player extends Entity {
	
	public Player(float x, float y, int width, int height, String fileName) {
		super(x, y, width, height, fileName);
	}
	
	private double speed;
	private int bombCapacity;
	private int currentBombs;
	private boolean hasLF;
	private int bombPower;
	
	public void move(char[] inputs){
		//some logic
	}
	
	public void placeBomb(){
		currentBombs -= 1;
		Bomb bomb = new Bomb(this.x,this.y);
	}
	
	public void powerUp(char type){
		
		if (type == 'P'){//bombPower
			bombPower += 1;
		}
		else if (type == 'L'){//LF
			hasLF = true;
		}
		else if (type == 'S'){//Speedup
			speed = speed*1.1;
		}
		else if (type == 'C'){//Capacity
			bombCapacity += 1;
			currentBombs += 1;
		}
		else{
			throw new IllegalArgumentException("This is not a valid powerUp type");
		}
	
	}
	public void inExplosion(){
		//sjekker om i explosion
	}
	

}
