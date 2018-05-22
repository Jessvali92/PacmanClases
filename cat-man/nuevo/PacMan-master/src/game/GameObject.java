/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import game.Handler;

/**
 *
 * @author Vlad-Adrian Moglan
 */
public abstract class GameObject {
	
    /* attributes */
    
    private final Id id;
    private String path;
    private BufferedImage sprite;
    private Rectangle bounds;
    protected Handler handler;
    
    int initialX;
    int initialY;
    int x;
    int y;
    
    /* methods */
    
    /**
     * @brief GameObject main constructor
     * @param id is the identifier of the object (its type)
     * @param path is the path of the sprite (image) of the object
     * @param x is the initial x position of the object
     * @param y is the initial y position of the object
     * @param width is the width of the object (normally the width of a tile)
     * @param height is the height of the object (normally the height of a tile)
     * @param handler is the game manager
     * @throws IOException
     */
    public GameObject(Id id, String path, int x, int y, int width, int height, Handler handler) throws IOException {
        this.id = id;
        this.path = path;
		bounds = new Rectangle();
        bounds.setSize(width, height);
        setSprite(path);
        setInitialPos(x, y);
        setPos(x, y);
        updateBounds();
        this.handler = handler;
    }
    
    public final Id getId() {
        return id;
    }

    public final String getPath() { return path; }
    
    public final BufferedImage getSprite() {
        return sprite;
    }

    public final void setSprite(String path) throws IOException {
    	if (path != null)
    		sprite = ImageIO.read(new File(path));
    }

    public final Rectangle getBounds() {
        return bounds;
    }

    private final void updateBounds() {
    	int x, y;
    	
    	x = this.x - (bounds.width/2);
    	y = this.y - (bounds.height/2);
    	
    	bounds.setLocation(x, y);
    }

    public final int initialX() { return initialX; }
    
    public final int initialY() { return initialY; }
    
    public final int x() { return x; }
    
    public final int y() { return y; }
    
    public final void setInitialPos(int x, int y) {
    	initialX = x;
    	initialY = y;
    }
    
    public final void setPos(int x, int y) { 
    	this.x = x;
    	this.y = y;
    	updateBounds();
    }
    
    /**
     * 
     * @return Object's position in grid coordinates
     */
    public final Position gridPos() { return handler().grid().windowToGrid(x, y); }

    public final Handler handler() {
        return handler;
    }
    
    /**
     * @brief destroy casts the Object outside of the game
     */
    public final void destroy() { 
    	x = -9999;
    	y = -9999;
    	sprite = null;
    	
    	updateBounds();
    }
   
    /**
     * @brief render draws the image to the game panel
     */
    public final void render(Graphics g) {
    	if (sprite != null)
    		g.drawImage(sprite, x, y, null);
    }
    
    /**
     * @throws InterruptedException 
     * @brief tick is the action of the object during any given iteration of the main loop
     */
    public abstract void tick();
    
    /**
     * @brief collision manages collision between the object and another object it comes into contact with
     */
    public abstract void collision();
    
}
