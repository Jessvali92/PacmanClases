/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Graphics;
import java.util.ArrayList;

import objects.GameObject;
import objects.Grid;
import objects.Id;
import objects.PacMan;

/**
 *
 * @author Vlad-Adrian Moglan
 */
public class Handler {
	
    /* attributes */
    
    private final ArrayList<GameObject> objects;
    private final Grid grid;
    private PacMan pacMan;
    private int score;
    
    /* methods */
    
    // constructor
    public Handler(int windowWidth, int windowHeight, int tileEdge) {
        objects = new ArrayList<>();
        grid = new Grid(windowWidth, windowHeight, tileEdge);
        score = 0;
    }
    
    public PacMan pacMan() {
    	return pacMan;
    }
    
    public void setPacMan(PacMan p) {
    	pacMan = p;
    }
    
    public Grid grid() {
    	return this.grid;
    }
    
    public int score() { return score; }
    
    public void incrementScore() { score++; }
    
    public boolean isOver() { return pacMan.isAlive(); }
    
    /**
     * @brief tick is a method that calls the tick() method of each object
     * in the GameObject array for the current iteration of the run() loop in the
     * Game class
     */
    public void tick() {
        objects.forEach((o) -> {
            o.tick();
        });
    }
    
    /**
     * @brief render renders each of the objects on the scene
     * @param g is the Graphics object to which the sprites of the game objects
     * are to be drawn
     */
    public void render(Graphics g) {
    	objects.forEach((o) -> {
    		o.render(g);
    	});
    }
    
    public ArrayList<GameObject> objects() { return objects; }
    
    public void add(GameObject object) {
        if (object.getId() == Id.PacMan) {
            pacMan = (PacMan)object;
        }
        
        objects.add(object);
    }
    
    public void remove(GameObject object) {
        if (object.getId() == Id.PacMan) 
            pacMan = null;
        
        objects.remove(object);
    }
    
}
