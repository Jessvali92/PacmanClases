package objects;

import java.io.IOException;

import game.Handler;

public abstract class Tile extends GameObject {
	
	/* methods */
	
	public Tile(Id id, String path, int x, int y, int width, int height, Handler handler)
			throws IOException {
		super(id, path, x, y, width, height, handler);
	}
}
