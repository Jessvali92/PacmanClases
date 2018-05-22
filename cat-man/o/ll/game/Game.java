/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.io.IOException;

/**
 *
 * @author Vlad-Adrian Moglan
 */
public class Game extends Canvas implements Runnable {
	
    /* attributes */
    
	private static final long serialVersionUID = 2866775525019440765L;
	private final int tileEdge = 64;
	private final int objectEdge = tileEdge / 4;
	private int windowWidth;
	private int windowHeight;
    GameWindow gameWindow;
    Thread thread;
    Handler handler;
    boolean running;
    boolean gameOver;
    
    /* methods */
    
    // constructor
    public Game() {
    	init();
    	this.addKeyListener(new KeyInput(handler));
        gameWindow = new GameWindow(windowWidth, windowHeight, "PacMan", this);
    }
    
    public static long getSerialVersionUID() { return serialVersionUID; }
    
    public int getWindowWidth() { return windowWidth; }
    
    public void setWindowWidth(int numCols) {
    	windowWidth = tileEdge * numCols;
    }
    
    public int getWindowHeight() { return windowHeight; }
    
    public void setWindowHeight(int numRows) {
    	windowHeight = tileEdge * numRows;
    }
    
    public int tileEdge() { return tileEdge; }
    
    public int objectEdge() { return objectEdge; }
    
    void setGame(boolean over) { gameOver = over; }
    
    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }
    
    public synchronized void stop() {
        try {
            thread.join();
            running = false;
        } catch (InterruptedException e) {
            System.err.print(e.getMessage());
        }
    }
    
    public void init() {
    	try {
    		GameLoader.loadGame(this);
    	} catch (IOException ioe) {
    		System.err.println(ioe.getMessage());
    	}
    }
    
    public void tick() {
        handler.tick();
    }
    
    public void render() {
        BufferStrategy bs = this.getBufferStrategy();
        
        if (bs == null) {
            this.createBufferStrategy(3);
        } else {
            Graphics g = bs.getDrawGraphics();

            g.setColor(Color.BLUE);
            g.fillRect(0, 0, windowWidth, windowHeight);
            handler.render(g);
            g.dispose();
            bs.show();
        }
    }
    
    @Override
    /**
     * @brief run is the main loop
     */
    public void run() {
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        
        while(running) {
                long now = System.nanoTime();
                delta += (now - lastTime) / ns;
                lastTime = now;
                
                while(delta >= 1) {
                        tick();
                        delta--;
                }
                
                if(running)
                        render();
                
                frames++;
                
                if(System.currentTimeMillis() - timer > 1000) {
                        timer += 1000;
                        frames = 0;
                }
        }
        
        stop();
    }
    
    public static void main(String args[]) {
        try {
            new Game();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
