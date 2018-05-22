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
public class PacMan extends Entity {

	/* methods */
	
	public PacMan(Id id, String path, int x, int y, int width, int height, Handler handler) throws IOException {
		super(id, path, x, y, width, height, handler);
	}

	@Override
	public void tick() {
		move();
		collision();
	}

	@Override
	public void collision() {
		for (GameObject o : handler().objects()) {
			if (getBounds().intersects(o.getBounds())) {
				switch (o.getId()) {
				case Blinky:
				case Pinky:
				case Inky:
				case Clyde:
					if (getNumLives() > 0) {
						setNumLives(getNumLives() - 1);
						reset();
						((Entity)o).reset();
					} else {
						destroy();
						setAlive(false);
					}
					break;
				case PacGum:
					
					break;
				case Banana:
					break;
				case Cherry:
					break;
				case Path:
					if (!isMoving()) {
						if (isSlowed()) {
							setSpeed(baseSpeed());
							setSlowed(false);
						}
					}
					break;
				case Fog:
					if (!isMoving()) {
						if (!isSlowed()) {
							setSpeed(this.getSpeed()/((Walkable)o).weight());
							setSlowed(true);
						}
					}
					break;
				default:
				}
			}
		}
	}
    
}
