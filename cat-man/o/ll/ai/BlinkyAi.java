package ai;

import java.util.*;
import java.util.stream.Collectors;

import game.*;
import objects.Direction;
import objects.Ghost;
import objects.Grid;
import objects.Id;
import objects.Position;
import objects.Walkable;

public class BlinkyAi extends Ai {
	
	/* attributes */
	
	private ArrayList<Position> graph;
	private LinkedList<Position> queue;
	private HashMap<Position, Position> prev;
	private HashMap<Position, Integer> dist;
	private Position source;
	private Position destination;
	private long startTime;
	private static final long T = 500;
	
	/* methods */

	public BlinkyAi(Handler handler, Ghost ghost) {
		super(handler, ghost);
		graph = new ArrayList<Position>();
		reset();
	}

	@Override
	public void calculate() {
		long currentTime = System.currentTimeMillis();
		
		if ((currentTime - startTime) > T) {
			reset();
			Position prevNode;
			Position crtNode;
			Direction direction;
			
			clear();
			generateGraph();
			dijkstra();
			
			crtNode = Position.get(destination.x(), destination.y());
			prevNode = prev.get(destination);
			
			while (crtNode != source) {
				direction = Grid.translate(prevNode, crtNode);
				moves.add(direction);
				crtNode = prevNode;
				prevNode = prev.get(prevNode);
			}
			
			moves = reverse();
		}
	}
	
	public void reset() {
		startTime = System.currentTimeMillis();
	}
	
	public long getStartTime() {
		return startTime;
	}
	
	/**
	 * @return true if there is a change between the position of PacMan at the start of the algorithm and its position 
	 * at the time of the call
	 */
	public boolean pacManHasMoved() {
		if (!destination.equals(handler.pacMan().gridPos()))
			return false;
		
		else return true;
	}
	
	/**
	 * @brief initializes dijktra's algorithm
	 */
	private void initialize() {
		queue = new LinkedList<>();
		prev = new HashMap<>();
		dist = new HashMap<>();
		
                
                System.out.println(ghost.gridPos().x() + " " + ghost.gridPos().y());
                
		for (Position node : graph) {
			prev.put(node, null);
			dist.put(node, Integer.MAX_VALUE);
			
			if (node.equals(ghost.gridPos()))
				source = node;
			
			if (node.equals(handler.pacMan().gridPos()))
				destination = node;
		}
		
		dist.put(source, 0);
		
		for (Position node : graph) {
			queue.add(node);
		}
	}
	
	/**
	 * @brief the implementation of the popular path-finding algorithm
	 */
	private void dijkstra() {
		initialize();
		
		while (!queue.isEmpty()) {
			Position u = minDist();
			ArrayList<Position> neighbours = getNeighbours(u);
			queue.remove(u);
			
			for (Position v : neighbours) {
				int alt = dist.get(u) + distTo(v);
				
				if (alt < dist.get(v)) {
					dist.put(v, alt);
					prev.put(v, u);
				}
			}
		}
	}
	
	/**
	 * @brief generates a graph made up of Walkable tiles
	 */
	private void generateGraph() {
		for (int y = 0; y < handler.grid().numRows(); y++) {
			for (int x = 0; x < handler.grid().numCols(); x++) {

				if (handler.grid().at(x, y).getId() != Id.Wall) {
					graph.add(Position.get(x, y));
				}
			}
		}
	}

	/**
	 * 
	 * @return returns the unvisited node with the smallest distance from source
	 */
	private Position minDist() {
		Position minDist = queue.getFirst();
		
		for (Position node : queue) {
			if (dist.get(node) < dist.get(minDist)) {
				minDist = node;
			}
		}
		
		return minDist;
	}
	
	/**
	 * 
	 * @param targetPosition is the target node
	 * @return the weight of the edge leading to the node
	 */
	private int distTo(Position targetPosition) {
		return ((Walkable)handler.grid().at(targetPosition.x(), targetPosition.y())).weight();
	}
	
	/**
	 * 
	 * @param u is the node for which to get the neighbours
	 * @return the neighbors of u
	 */
	private ArrayList<Position> getNeighbours(Position u) {
		ArrayList<Position> neighbours = new ArrayList<>();
		
		for (Position v : queue) {
			if (Grid.areAdjacent(u, v)) {
				neighbours.add(v);
			}
		}
		
		return neighbours;
	}
	
	/**
	 * @brief reverse is a method that puts the moves queue in order
	 * @return the reversed queue
	 */
	private LinkedList<Direction> reverse() {
        List<Direction> collect = moves.stream()
                .collect(Collectors.toList());
        Collections.reverse(collect);
        
        return new LinkedList<>(collect);
    }
	
}
