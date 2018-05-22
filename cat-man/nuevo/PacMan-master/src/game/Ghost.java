/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import java.io.IOException;
import ai.*;
import game.Handler;

/**
 *
 * @author Vlad
 */
public class Ghost extends Entity {
	
	/* attributes */
	
	Ai ai;
	
	/* methods */
	
	public Ghost(Id id, String path, int x, int y, int width, int height, Handler handler)
			throws IOException {
		super(id, path, x, y, width, height, handler);

		switch (id) {
		case Blinky:
			ai = new BlinkyAi(handler(), this);
			break;
		case Pinky:
			ai = new PinkyAi(handler(), this);
			break;
		case Inky:
			ai = new InkyAi(handler(), this);
			break;
		case Clyde:
			ai = new ClydeAi(handler(), this);
			break;
		default:
			ai = new RandomAi(handler(), this);	
		}
		
		setSpeed(baseSpeed()/2);
	}
	
	public Ai getAi() { return ai; }
	
	public void setAi(Ai ai) { this.ai = ai; }

	@Override
	public void tick() {
		if (!isMoving()) {
			if ((ai.head() != null)) {
				setDirection(ai.head());
				ai.nextMove();
			} else {
				if (!handler.pacMan().isMoving()) {
					ai.calculate();
				}
			}
		}
		
		move();
		collision();
	}

	@Override
	public void collision() {
		for (GameObject o : handler.objects()) {
			if (getBounds().intersects(o.getBounds())) {
				switch (o.getId()) {
				case Path:
					if (!isMoving()) {
						if (isSlowed()) {
							setSpeed(baseSpeed()/2);
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
					
					break;
				}
			}
		}
	}
    
}
