package application;

import java.util.ArrayList;

import entities.Box;
import entities.Entity;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.input.KeyCode;



public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		Entity[][] board = new Entity[15][15];
		
		
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,720,720);
			
			InputHandler keyboardInput = new KeyboardInputHandler(scene);
			
			primaryStage.setScene(scene);
			
			Canvas canvas = new Canvas(720,720);
			root.getChildren().add(canvas);
			
			GraphicsContext gc = canvas.getGraphicsContext2D();
			
			final long startNanoTime = System.nanoTime();
			
			board[0][0] = new Box(0,0,0,64,"Wall.png");
			board[0][1] = new Box(0,0,0,64,"Wall.png");
			//board[0][2] = new Box(0,0,0,64,"Wall.png");
			board[0][3] = new Box(0,0,0,64,"Wall.png");
			board[0][4] = new Box(0,0,0,64,"Wall.png");
			
			board[1][0] = new Box(0,0,0,64,"Brick.png");
			board[1][1] = new Box(0,0,0,64,"Brick.png");
			board[2][2] = new Box(0,0,0,64,"SandakerStanding.png");
			board[2][3] = new Box(0,0,0,64,"Brick.png");
			board[3][4] = new Box(0,0,0,64,"Brick.png");
			board[5][6] = new Box(0,0,0,64,"Brick.png");
			board[5][7] = new Box(0,0,0,64,"Brick.png");
			board[5][8] = new Box(0,0,0,64,"Brick.png");
			board[6][6] = new Box(0,0,0,64,"Brick.png");
			board[6][7] = new Box(0,0,0,64,"Brick.png");
			board[6][8] = new Box(0,0,0,64,"Brick.png");
			
			new AnimationTimer() {
				@Override
				public void handle(long currentNanoTime) {
					// TODO Auto-generated method stub
					double t = (currentNanoTime - startNanoTime) / 1000000000.0; 
					
					//Handle input
					ArrayList<KeyCode> keyboard1Input = keyboardInput.getKeys();
					/*for (int i = 0; i < ) {
						
					}*/
					
					//Draw board
					for (int i = 0; i < 15; i++) {
						for (int j = 0; j < 15; j++) {
							gc.drawImage(new Image("sprites/FloorTile.png"), i*48, j*48);

							if (board[i][j] != null) {
								Entity ent = board[i][j];
								gc.drawImage(ent.getSprite(), i*48, j*48 - (ent.getHeight() - 48));
							}
							
							
						}
					}
					
				}
			}.start();
			
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
