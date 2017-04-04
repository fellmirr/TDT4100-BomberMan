package application;

import java.util.ArrayList;

import javafx.scene.input.KeyEvent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;

public class KeyboardInputHandler implements InputHandler {
	private ArrayList<KeyCode> input;
	
	public KeyboardInputHandler(Scene mainScene) {
		input = new ArrayList<KeyCode>();
		
		mainScene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
			if (!input.contains(key.getCode())) {
				input.add(key.getCode());
			}
		});
		
		mainScene.addEventHandler(KeyEvent.KEY_RELEASED, (key) -> {
			if (!input.contains(key.getCode())) {
				input.remove(key.getCode());
			}
		});
	}

	public ArrayList<KeyCode> getKeys() {
		return this.input;
	}
}
