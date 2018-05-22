/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ai;

import java.util.LinkedList;

import game.*;
import objects.Direction;
import objects.Ghost;

/**
 *
 * @author Vlad-Adrian Moglan
 */
public abstract class Ai {
    
	/* attributes */
	
	protected Handler handler;
	protected Ghost ghost;
	protected LinkedList<Direction> moves;
	
	/* methods */
	
	public Ai(Handler handler, Ghost ghost) {
		this.handler = handler;
		this.ghost = ghost;
		moves = new LinkedList<>();
	}
	
	/**
	 * 
	 * @return and removes the head of the queue
	 */
	public Direction nextMove() { return moves.pop(); }
	
	/**
	 * 
	 * @return the head of the queue without removing it
	 */
	public Direction head() { if (!moves.isEmpty()) return moves.getFirst(); else return null; }
	
	/**
	 * 
	 * @return the tail of the queue without removing it
	 */
	public Direction tail() { if (!moves.isEmpty()) return moves.getLast(); else return null; }
	
	/**
	 * 
	 * @brief reset resets the ai
	 */
	public void clear() {
		moves.clear(); 
		moves = null;
		moves = new LinkedList<>();
	}
	
	/**
	 * @brief
	 */
	public abstract void calculate();
	
	public abstract void reset();
	
}
