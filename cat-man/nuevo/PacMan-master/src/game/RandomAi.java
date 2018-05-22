package ai;

import java.util.ArrayList;
import java.util.Random;

import game.*;
import objects.Direction;
import objects.Ghost;
import objects.Grid;
import objects.Position;

public class RandomAi extends Ai {

	/* methods */
	
	public RandomAi(Handler handler, Ghost ghost) {
		super(handler, ghost);
	}
	
	@Override
	public void calculate() {
		clear();
		
		ArrayList<Direction> possibleMoves;
		Position currentPosition;
		Position targetPosition;
		int counter = 0;
		
		currentPosition = ghost.gridPos();
		
		while (counter < handler.grid().size()) {
			possibleMoves = new ArrayList<Direction>();
			targetPosition = Grid.translate(currentPosition, Direction.Up);
		
			if (ghost.canMove(targetPosition.x(), targetPosition.y())) {
				possibleMoves.add(Direction.Up);
			}
			
			targetPosition = Grid.translate(currentPosition, Direction.Down);
			
			if (ghost.canMove(targetPosition.x(), targetPosition.y())) {
				possibleMoves.add(Direction.Down);
			}
			
			targetPosition = Grid.translate(currentPosition, Direction.Left);
			
			if (ghost.canMove(targetPosition.x(), targetPosition.y())) {
				possibleMoves.add(Direction.Left);
			}
			
			
			targetPosition = Grid.translate(currentPosition, Direction.Right);
			
			if (ghost.canMove(targetPosition.x(), targetPosition.y())) {
				possibleMoves.add(Direction.Right);
				
			}
			
			Random r = new Random();
			int high = possibleMoves.size();
			
			if (high > 0) {
				int index = r.nextInt(high);
				moves.addLast(possibleMoves.get(index));
				targetPosition = Grid.translate(currentPosition,  possibleMoves.get(index));
				currentPosition = Position.get(targetPosition.x(), targetPosition.y());
			}
			
			possibleMoves.clear();
			counter++;
		}
	}
	
	public void reset() { }
}
