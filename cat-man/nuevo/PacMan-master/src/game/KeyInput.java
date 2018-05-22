/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import objects.Direction;

/**
 *
 * @author Vlad-Adrian Moglan
 */
public class KeyInput extends KeyAdapter {
	
	/* attributes */
	
	private Handler handler;
	
	/* methods */
	
	public KeyInput(Handler handler) {
		this.handler = handler;
	}
	
	/**
	 * @brief action when key is pressed
	 */
    public void keyPressed(KeyEvent e) {
    	int key = e.getKeyCode();
    	
    	if (key == KeyEvent.VK_UP) handler.pacMan().setDirection(Direction.Up);
    	if (key == KeyEvent.VK_DOWN) handler.pacMan().setDirection(Direction.Down);
    	if (key == KeyEvent.VK_LEFT) handler.pacMan().setDirection(Direction.Left);
    	if (key == KeyEvent.VK_RIGHT) handler.pacMan().setDirection(Direction.Right);
    }
    
    /**
     * @brief action when key is released
     */
    public void keyReleased(KeyEvent e) {
    	
    }
    
}
