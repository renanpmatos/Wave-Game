package com.tutorial.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import com.tutorial.main.Game.STATE;

//initial start menu

public class Menu extends MouseAdapter{

	private Game game;
	private Handler handler;
	private HUD hud;
	private Random r = new Random(); 
	
	public Menu(Game game, Handler handler, HUD hud) {
		this.game = game;
		this.hud = hud;
		this.handler = handler;
	}
	
	public void mousePressed(MouseEvent e) {
		int mx = e.getX(); 
		int my = e.getY();
		
		if(game.gameState == STATE.Menu) {
			//play button
			if(mouseOver(mx, my, 290, 150, 200, 64)) {
				game.gameState = STATE.Select;
				return;
			}
			
			//help button
			if(mouseOver(mx, my, 290, 250, 200, 64)) {
				game.gameState = STATE.Help;
			}
			
			//exit button
			if(mouseOver(mx, my, 290, 350, 200, 64)) {
				System.exit(1);
			}	
		}
		
		if(game.gameState == STATE.Select) {
			//normal button
			if(mouseOver(mx, my, 290, 150, 200, 64)) {
				game.gameState = STATE.Game;
				handler.addObject(new Player(Game.WIDTH/2-32, Game.HEIGHT/2-32, ID.Player, handler));
				handler.clearEnemys();
				//handler.addObject(new Player(WIDTH/2+64, HEIGHT/2-32, ID.Player2, handler));
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.BasicEnemy, handler));	
				
				game.diff = 0;
			}
			
			//hard button
			if(mouseOver(mx, my, 290, 250, 200, 64)) {
				game.gameState = STATE.Game;
				handler.addObject(new Player(Game.WIDTH/2-32, Game.HEIGHT/2-32, ID.Player, handler));
				handler.clearEnemys();
				//handler.addObject(new Player(WIDTH/2+64, HEIGHT/2-32, ID.Player2, handler));
				handler.addObject(new HardEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.BasicEnemy, handler));	
				
				game.diff = 1;
			}
			
			//back button
			if(mouseOver(mx, my, 290, 350, 200, 64)) {
				game.gameState = STATE.Menu;
				return;
			}	
		}
		
		//back button for help
		if(game.gameState == STATE.Help) {
			if(mouseOver(mx, my, 290, 350, 200, 64)) {
				game.gameState = STATE.Menu;
				return;
			}
		}
		//try again button
		if(game.gameState == STATE.End) {
			if(mouseOver(mx, my, 290, 350, 200, 64)) {
				game.gameState = STATE.Menu;
				hud.setLevel(1);
				hud.setScore(0);
				
			}
		}
	}
	
	public void mouseReleased(MouseEvent e) {
		
	}
	
	private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
		if(mx > x && mx < x + width) {
			if(my > y && my < y + height) {
				return true;
			}
			else return false;
		}else
			return false;
	}
	
	public void tick()
	{	
		
	}
	public void render(Graphics g) {
		
		if(game.gameState == STATE.Menu) {
			Font fnt = new Font("arial", 1, 50);
							//font-name, style, size
			Font fnt2 = new Font("arial", 1, 30);
			
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("Wave", 320, 80);
						//name, x, y

			g.setFont(fnt2);
			g.setColor(Color.white);
			g.drawRect(290,150, 200, 64);
			g.drawString("Play", 350, 190);
			
			g.setColor(Color.white);
			g.drawRect(290,250, 200, 64);
			g.drawString("Help", 350, 290);
			
			g.setColor(Color.white);
			g.drawRect(290,350, 200, 64);
			g.drawString("Exit", 350, 390);	
		}
		else if(game.gameState == STATE.Help)
		{
			Font fnt = new Font("arial", 1, 50);
			//font-name, style, size
			Font fnt2 = new Font("arial", 1, 30);
			Font fnt3 = new Font("arial", 1, 20);
			
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("Help", 320, 80);

			g.setFont(fnt3);
			g.setColor(Color.white);
			g.drawString("Use AWSD to move player and dodge enemies", 200, 200);
			
			g.setFont(fnt3);
			g.setColor(Color.white);
			g.drawString("Press P for pause the game", 200, 240);
			
			g.setFont(fnt3);
			g.setColor(Color.white);
			g.drawString("Press SPACE to access the Shop menu ", 200, 280);

			g.setFont(fnt2);
			g.drawRect(290,350, 200, 64);
			g.drawString("Back", 350, 390);	
		}
		else if(game.gameState == STATE.End)
		{
			Font fnt = new Font("arial", 1, 50);
			//font-name, style, size
			Font fnt2 = new Font("arial", 1, 30);
			Font fnt3 = new Font("arial", 1, 20);
			
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("Game Over", 270, 80);

			g.setFont(fnt3);
			g.setColor(Color.white);
			g.drawString("You lost with a score of: " +  hud.getScore(), 250, 200);

			g.setFont(fnt2);
			g.drawRect(290,350, 200, 64);
			g.drawString("Try Again", 330, 390);	
		}
		else if(game.gameState == STATE.Select) {
			Font fnt = new Font("arial", 1, 50);
							//font-name, style, size
			Font fnt2 = new Font("arial", 1, 30);
			
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("SELECT DIFFICULTY", 200, 80);
						//name, x, y

			g.setFont(fnt2);
			g.setColor(Color.white);
			g.drawRect(290,150, 200, 64);
			g.drawString("Normal", 350, 190);
			
			g.setColor(Color.white);
			g.drawRect(290,250, 200, 64);
			g.drawString("Hard", 350, 290);
			
			g.setColor(Color.white);
			g.drawRect(290,350, 200, 64);
			g.drawString("Back", 350, 390);	
		}
		
	}
	
}
