package entities;

import javafx.scene.image.Image;

public class Entity {
	private float x;
	private float y;
	private int width;
	private int height;
	private Image sprite;
	
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
}
