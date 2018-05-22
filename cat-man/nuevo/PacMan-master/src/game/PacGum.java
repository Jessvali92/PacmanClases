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
public class PacGum extends GameObject {

	/* methods */
	
	public PacGum(Id id, String path, int x, int y, int width, int height, Handler handler) throws IOException {
		super(id, path, x, y, width, height, handler);
	}

	@Override
	public void tick() {
		collision();
	}

	@Override
	public void collision() {
		
		for (GameObject o : handler.objects()) {
			if (o.getId() == Id.PacMan) {
				if (getBounds().intersects(o.getBounds())) {
					destroy();
				}
			}
		}
		
	}
    
}
