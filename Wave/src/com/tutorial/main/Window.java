package com.tutorial.main;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

// defines the window properties

public class Window extends Canvas{

	private static final long serialVersionUID = -240840600533728354L;
	
	//Constructor
	public Window(int width, int height, String title, Game game) {
		JFrame frame = new JFrame(title);
		
		frame.setPreferredSize(new Dimension(width, height));
		frame.setMaximumSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit button
		frame.setResizable(false); //resize the window, can make some problems
		frame.setLocationRelativeTo(null);// window starts in the middle of screen
		frame.add(game);
		frame.setVisible(true); //we can see the frame
		game.start();
	}

}
