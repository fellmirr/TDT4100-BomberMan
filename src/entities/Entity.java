package entities;

import javafx.scene.image.Image;

public class Entity {
	protected float x;
	protected float y;
	protected int width;
	protected int height;
	protected Image sprite;
	
	public Entity(float x, float y, int width, int height, String fileName) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.sprite = new Image("sprites/" + fileName);
	}
	
	public Image getSprite() {
		return sprite;
	}
	
	public int getHeight() {
		return this.height;
	}
	
	public float getY() {
		return this.y;
	}
	
	public float getX() {
		return this.x;
	}
}
