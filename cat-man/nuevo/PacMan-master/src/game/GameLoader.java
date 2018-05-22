/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.io.*;

import ai.*;
import objects.FogTile;
import objects.GameObject;
import objects.Ghost;
import objects.Grid;
import objects.Id;
import objects.PacGum;
import objects.PacMan;
import objects.PathTile;
import objects.Position;
import objects.Tile;
import objects.WallTile;

/**
 *
 * @author Vlad-Adrian Moglan
 */
public class GameLoader {
	
	/* methods */
	
	/**
	 * 
	 * @param game is the instance of the game to be loaded
	 * @throws IOException in case of file opening failure
	 */
    public static void loadGame(Game game) throws IOException {
    	boolean firstLine = true;
    	int row;
    	int col;
    	String line = new String();
    	BufferedReader br = new BufferedReader(new FileReader(new File("res/levels/test.txt")));
    	
    	row = 0;
    	
    	while ((line = br.readLine()) != null) {
    		if (firstLine) {
    			String[] splited = line.split("\\s+");
    			
    			game.setWindowHeight(Integer.parseInt(splited[0]) + 1);
    			game.setWindowWidth(Integer.parseInt(splited[1]) + 1);
    			game.handler = new Handler(game.getWindowWidth(), game.getWindowHeight(), game.tileEdge());
    	    	firstLine = false;
    		} else {
    			GameObject o = null;
    			
	    		for (col = 0; col < line.length(); col++) {
	    			int x = game.handler.grid().gridToWindowX(col);
	    			int y = game.handler.grid().gridToWindowY(row);
	    			
	    			switch (line.charAt(col)) {
	    			case ObjectConsts.PATH:
	    				o = new PathTile(Id.Path, null, x, y, game.objectEdge(), game.objectEdge(), game.handler);
	    				game.handler.grid().add((Tile)o, col, row);
	    				break;
	    			case ObjectConsts.FOG:
	    				o = new FogTile(Id.Fog, ImageRes.FOG, x, y, game.tileEdge(), game.tileEdge(), game.handler);
	    				game.handler.grid().add((Tile)o, col, row);
	    				break;
	    			case ObjectConsts.WALL:
	    				o = new WallTile(Id.Wall, ImageRes.WALL, x, y, game.objectEdge(), game.objectEdge(), game.handler);
	    				game.handler.grid().add((Tile)o, col, row);
	    				break;
	    			case ObjectConsts.GUM:
	    				o = new PathTile(Id.Path, null, x, y, game.objectEdge(), game.objectEdge(), game.handler);
	    				game.handler.grid().add((Tile)o, col, row);
	    				game.handler.add(o);
	    				o = new PacGum(Id.PacGum, ImageRes.GUM, x, y, game.objectEdge(), game.objectEdge(), game.handler);
	    				break;
	    			case ObjectConsts.PACMAN:
	    				o = new PathTile(Id.Path, null, x, y, game.objectEdge(), game.objectEdge(), game.handler);
	    				game.handler.grid().add((Tile)o, col, row);
	    				game.handler.add(o);
	    				o = new PacMan(Id.PacMan, ImageRes.PACMAN, x, y, game.objectEdge(), game.objectEdge(), game.handler); 
	    				break;
	    			case ObjectConsts.BLINKY:
	    				o = new PathTile(Id.Path, null, x, y, game.objectEdge(), game.objectEdge(), game.handler);
	    				game.handler.grid().add((Tile)o, col, row);
	    				game.handler.add(o);
	    				o = new Ghost(Id.Blinky, ImageRes.BLINKY, x, y, game.objectEdge(), game.objectEdge(), game.handler); 
	    				break;
	    			}
	    			
	    			game.handler.add(o);
	    		}
	    		
	    		row++;
    		}
    	}
    	
    	br.close();
    }
}
