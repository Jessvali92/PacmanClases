package objects;

/**
 * 
 * @author Vlad-Adrian Moglan
 *
 */
public class Grid {
	
	/* attributes */
	
	private Tile[][] tiles;
	private int tileEdge;
	
	/* methods */
	
	public Grid(int windowWidth, int windowHeight, int tileEdge) {
		tiles = new Tile[(windowHeight - tileEdge) / tileEdge][(windowWidth - tileEdge) / tileEdge];
		this.tileEdge = tileEdge;
	}
	
	public Tile[][] tiles() { return tiles; }
	
	public int tileEdge() { return tileEdge; }
	
	public void add(Tile tile, int x, int y) throws IndexOutOfBoundsException {
		tiles[y][x] = tile;
	}
	
	public void remove(int x, int y) {
		tiles[y][x] = null;
	}
	
	public void remove(Tile tile) {
		for (int y = 0; y < tiles.length; y++) {
			for (int x = 0; x < tiles[y].length; x++) {
				if (tiles[y][x] == tile) {
					tiles[y][x] = null;
					break;
				}
			}
		}
	}
	
	public Tile at(int x, int y) {
		return tiles[y][x];
	}
	
	public int size() { return tiles.length * tiles[0].length; }
	
	public int numRows() { return tiles.length; }
	
	public int numCols() { return tiles[0].length; }
	
	public Position position(Tile tile) {
		Position position = null;
		
		boolean found = false;
		int y = 0, x = 0;
		
		while (!found && (y < tiles.length)) {
			while (!found && (x < tiles[y].length)) {
				if (tiles[y][x] == tile) {
					position = Position.get(tiles[y][x].x(), tiles[y][x].y());
					found = true;
				} else {
					x++;
				}
			}
			
			x = 0;
			y++;
		}
		
		return position;
	}
	
	/**
	 * @brief gridToWindow converts a grid position to a window position
	 * @param x
	 * @param y
	 * @return window position
	 */
	public int gridToWindowX(int x) {
		return ((x + 1) * tileEdge) - (tileEdge/2);
	}
	
	public int gridToWindowY(int y) {
		return ((y + 1) * tileEdge) - (tileEdge/2);
	}
	
	/**
	 * @brief windowToGrid converts a window position to a grid position
	 * @param x
	 * @param y
	 * @return grid position
	 */
	public Position windowToGrid(int x, int y) {
		return Position.get((((2 * x) + tileEdge)/(2 * tileEdge)) - 1, (((2 * y) + tileEdge)/(2 * tileEdge)) - 1);
	}
	
	/**
	 * 
	 * @param u is the first position
	 * @param v is the second position
	 * @return true if u and v are adjacent
	 */
	public static boolean areAdjacent(Position u, Position v) {
		if (Math.sqrt(Math.pow(v.x() - u.x(), 2) + Math.pow(v.y() - u.y(), 2)) == 1) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * @brief translate translates a movement to a target position
	 * @param initialPosition
	 * @param direction
	 * @return target position
	 */ 
	public static Position translate(Position initialPosition, Direction direction) {
		Position targetPosition;
		
		switch (direction) {
		case Up:
			targetPosition = Position.get(initialPosition.x(), initialPosition.y() - 1);
			break;
		case Down:
			targetPosition = Position.get(initialPosition.x(), initialPosition.y() + 1);
			break;
		case Left:
			targetPosition = Position.get(initialPosition.x() - 1, initialPosition.y());
			break;
		case Right:
			targetPosition = Position.get(initialPosition.x() + 1, initialPosition.y());
			break;
		default:
			targetPosition = null;
		}
		
		return targetPosition;
	}
	
	/**
	 * @brief translate translates a target position into a movement
	 * @param initialPosition
	 * @param targetPosition
	 * @return movement
	 */
	public static Direction translate(Position initialPosition, Position targetPosition) {
		if (targetPosition.equals(initialPosition.x(), initialPosition.y() + 1)) {
			return Direction.Down;
		} else if (targetPosition.equals(initialPosition.x(), initialPosition.y() - 1)) {
			return Direction.Up;
		} else if (targetPosition.equals(initialPosition.x() + 1, initialPosition.y())) {
			return Direction.Right;
		} else if (targetPosition.equals(initialPosition.x() - 1, initialPosition.y())) {
			return Direction.Left;
		} else {
			return null;
		}
	}
	
}
