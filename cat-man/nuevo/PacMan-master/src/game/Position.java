/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import java.util.ArrayList;

/**
 *
 * @author Vlad-Adrian Moglan
 */
public class Position {
	
    /* attributes */
    
    private static ArrayList<Position> positions = new ArrayList<>();
    private int x;
    private int y;
    
    /* methods */
    
    private Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public static Position get(int x, int y) {
    	for (Position p : positions) {
    		if (p.equals(x, y)) {
    			return p;
    		}
    	}
    	
    	return new Position(x, y);
    }
    
    public int x() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int y() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public boolean equals(int x, int y) {
        return (this.x == x && this.y == y);
    }
    
    public boolean equals(Position p) {
        return (this.x == p.x()) && (this.y == p.y());
    }
    
    public static boolean equals(int x1, int y1, int x2, int y2) {
    	return ((x1 == x2) && (y1 == y2));
    }
}
