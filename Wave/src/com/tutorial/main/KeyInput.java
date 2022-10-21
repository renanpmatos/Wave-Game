package com.tutorial.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.tutorial.main.Game.STATE;

// the command keys to the player

public class KeyInput extends KeyAdapter{
	
	private Handler handler;
	private boolean[] keyDown = new boolean[4];
	
	Game game;
	
	public KeyInput(Handler handler, Game game ) {
		this.handler = handler;
		this.game = game;
		
		keyDown[0]=false;
		keyDown[1]=false;
		keyDown[2]=false;
		keyDown[3]=false;
	} 
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();//gets the code of a keyboard key
		
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Player) {
				//key events for Player 1
				
				if(key == KeyEvent.VK_W) { tempObject.setVelY(-handler.spd); keyDown[0]=true; }
				if(key == KeyEvent.VK_S) { tempObject.setVelY(handler.spd); keyDown[1]=true; }
				if(key == KeyEvent.VK_D) { tempObject.setVelX(handler.spd); keyDown[2]=true; }
				if(key == KeyEvent.VK_A) { tempObject.setVelX(-handler.spd); keyDown[3]=true; }
				
				
			}
			
			//if a Player2 is added to the game, use the inputs bellow
			
			//basic player 2 moves
			if(tempObject.getId() == ID.Player2) {
				//key events for Player 2
				

				if(key == KeyEvent.VK_UP) { tempObject.setVelY(-8); keyDown[0]=true; }
				if(key == KeyEvent.VK_DOWN) { tempObject.setVelY(8); keyDown[1]=true; }
				if(key == KeyEvent.VK_RIGHT) { tempObject.setVelX(8); keyDown[2]=true; }
				if(key == KeyEvent.VK_LEFT) { tempObject.setVelX(-8); keyDown[3]=true; }
			}
		}
		
		if(key == KeyEvent.VK_P) {
			if(game.gameState == STATE.Game) {
				if(Game.paused)Game.paused = false;
				else Game.paused = true;
			}
		}
		if(key == KeyEvent.VK_SPACE) {
			if(Game.gameState == STATE.Game) Game.gameState = STATE.Shop;
			else if(Game.gameState == STATE.Shop) Game.gameState = STATE.Game;
		}
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();//gets the code of a keyboard key
		
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Player) {
				//key events for Player 1
				
				if(key == KeyEvent.VK_W) keyDown[0]=false; //tempObject.setVelY(0);
				if(key == KeyEvent.VK_S) keyDown[1]=false; //tempObject.setVelY(0);
				if(key == KeyEvent.VK_D) keyDown[2]=false; //tempObject.setVelX(0);
				if(key == KeyEvent.VK_A) keyDown[3]=false; //tempObject.setVelX(0);
				
				//vertical movement
				if(!keyDown[0] && !keyDown[1]) {
					tempObject.setVelY(0);
				}
				//horizontal movement
				if(!keyDown[2] && !keyDown[3]) {
					tempObject.setVelX(0);
				}
			}
			
			
			if(tempObject.getId() == ID.Player2) {
				//key events for Player 2

				if(key == KeyEvent.VK_UP) keyDown[0]=false; //tempObject.setVelY(0);
				if(key == KeyEvent.VK_DOWN) keyDown[1]=false; //tempObject.setVelY(0);
				if(key == KeyEvent.VK_RIGHT) keyDown[2]=false; //tempObject.setVelX(0);
				if(key == KeyEvent.VK_LEFT) keyDown[3]=false; //tempObject.setVelX(0);
				
				//vertical movement
				if(!keyDown[0] && !keyDown[1]) {
					tempObject.setVelY(0);
				}
				//horizontal movement
				if(!keyDown[2] && !keyDown[3]) {
					tempObject.setVelX(0);
				}
			}
		}
		
	}
}
