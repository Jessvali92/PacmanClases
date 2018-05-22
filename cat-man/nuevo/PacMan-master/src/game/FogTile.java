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
public class FogTile extends Tile implements Walkable {
	
	/* methods */
	
    public FogTile(Id id, String path, int x, int y, int width, int height, Handler handler) throws IOException {
		super(id, path, x, y, width, height, handler);
	}

    @Override
	public int weight() { return 2; }

	@Override
	public void tick() {
		// TODO animation
	}

	@Override
	public void collision() {
		// TODO nothing
	}
	
}
