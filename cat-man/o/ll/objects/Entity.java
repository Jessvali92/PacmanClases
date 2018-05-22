/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import java.io.IOException;

import game.Handler;

/**
 *
 * @author Vlad-Adrian Moglan
 */
public abstract class Entity extends GameObject {
	
    /* attributes */
	
	private int numLives;
	private boolean isAlive;
	private final int BASE_SPEED = handler.grid().tileEdge() / 8;
	private int speed;
	private boolean isMoving;
	private boolean isSlowed;
	private Direction direction;
	private Position targetPosition;
	
	/* methods */
	
	// constructor
	public Entity(Id id, String path, int x, int y, int width, int height, Handler handler) throws IOException {
		super(id, path, x, y, width, height, handler);
		isAlive = true;
		speed = BASE_SPEED;
		isMoving = false;
		direction = null;
		targetPosition = Position.get(gridPos().x(), gridPos().y());
		numLives = 9999999;
	}

	public final int getNumLives() {
		return numLives;
	}

	public final void setNumLives(int numLives) {
		this.numLives = numLives;
	}

	public final boolean isAlive() {
		return isAlive;
	}

	public final void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	public final int baseSpeed() { return BASE_SPEED; }
	
	public final int getSpeed() {
		return speed;
	}

	public final void setSpeed(int speed) {
		if (speed <= 0) this.speed = BASE_SPEED;
		
		this.speed = speed;
	}
	
	public final Direction getDirection() {
		return direction;
	}

	/**
	 * @brief setDirection sets the direction and changes the state of the entity to 'moving'
	 * @param direction
	 */
	public final void setDirection(Direction direction) {
		if (!isMoving) {
			this.direction = direction;
			
			targetPosition = Grid.translate(gridPos(), direction);
			
			if (canMove(targetPosition.x(), targetPosition.y())) {
				isMoving = true;
			}
		}
	}
	
	/**
	 * 
	 * @return true if Entity is moving
	 */
	public final boolean isMoving() {
		return isMoving;
	}
	
	/**
	 * 
	 * @return true if Entity is slowed
	 */
	public final boolean isSlowed() { return isSlowed; }
	
	public final void setSlowed(boolean isSlowed) { this.isSlowed = isSlowed; }

	/**
	 * @param x is the x coordinate of the target tile within the grid
	 * @param y is the y coordinate of the target tile within the grid 
	 * @return true if entity can move to target tile
	 */
	public boolean canMove(int x, int y) {
		boolean canMove = true;
		
		if ((y >= 0) && (y < handler.grid().tiles().length)) {
			if ((x >= 0) && (x < handler.grid().tiles()[y].length)) {
				if (handler.grid().at(x, y).getId() == Id.Wall) {
					canMove = false;
				}
			} else {
				canMove = false;
			}
		} else {
			canMove = false;
		}
		
		return canMove;
	}
	
	/**
	 * @brief move advances the Entity by its speed if it's moving
	 * @return end position
	 */
	public void move() {
		
		// cannot change direction while traveling between tiles
		if (isMoving) {
			if (!Position.equals(x(), y(), handler.grid().gridToWindowX(targetPosition.x()), handler.grid().gridToWindowY(targetPosition.y()))) {
				switch (direction) {
				case Up:
					setPos(x(), y() - speed);
					break;
				case Down:
					setPos(x(), y() + speed);
					break;
				case Left:
					setPos(x() - speed, y());
					break;
				case Right:
					setPos(x() + speed, y());
					break;
				}
			} else {
				isMoving = false;
				direction = null;
			}
		}
	}
	
	/**
	 * @brief reset reinitializes the position and states of the Entity
	 */
	public void reset() {
		setPos(initialX(), initialY());
		targetPosition = handler.grid().windowToGrid(x(), y());
		direction = null;
		isMoving = false;
	}
	
}
