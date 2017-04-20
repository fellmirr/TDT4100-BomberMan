package application;

import java.util.ArrayList;

import entities.Box;
import entities.Entity;
import entities.Player;
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
		ArrayList<Player> players = new ArrayList<Player>();
		
		players.add(new Player(48*5,48,0,64, "SandakerStanding.png"));
		
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
			
			board[5][0] = new Box(0,0,0,64,"Wall.png");
			board[5][2] = new Box(0,0,0,64,"Wall.png");
			//board[6][2] = new Box(0,0,0,64,"SandakerStanding.png");
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
					double t = (currentNanoTime - startNanoTime) / 1000000000.0; 
					
					//Handle input
					ArrayList<KeyCode> keyboard1Input = keyboardInput.getKeys();
					
					//Draw floor
					for (int i = 0; i < 15; i++) {
						for (int j = 0; j < 15; j++) {
							if (board[i][j] == null) {
								gc.drawImage(new Image("sprites/FloorTile.png"), i*48, j*48);
							}
						}
					}
					
					//Draw board
					for (int i = 0; i < 15; i++) {
						ArrayList<Player> playersOnRow = new ArrayList<Player>();
						
						for (int j = 0; j < 15; j++) {
							gc.drawImage(new Image("sprites/FloorTile.png"), i*48, j*48);

							if (board[i][j] != null) {
								Entity ent = board[i][j];
								gc.drawImage(ent.getSprite(), i*48, j*48 - (ent.getHeight() - 48));
							}
<<<<<<< HEAD
						}
						
						for (int j = 0; j < players.toArray().length; j++) {
							Player playerToCheck = players.get(j);
=======
							
>>>>>>> origin/master
							
							if (Math.floor(playerToCheck.getY()/48) == i) {
								System.out.println(i);
								gc.drawImage(
											playerToCheck.getSprite(), 
											playerToCheck.getX(), 
											playerToCheck.getY() - (playerToCheck.getHeight()-48));
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
