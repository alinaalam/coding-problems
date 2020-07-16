import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://www.udemy.com/course/data-structure-and-algorithms-analysis/learn/lecture/17421964#questions
 * @author alinaalam
 *
 */
public class RecursiveStaircase {
	
	public static void main(String[] args) {
		int steps = 4;
		
		// Approach 1:
		List<List<Integer>> paths = new ArrayList<>();
		generatePossiblePaths(0, steps, new ArrayList<Integer>(), paths);
		
		System.out.println(paths);
		
		// Approach 2:
		Stack<Stair> stairCase = new Stack<>();
		stairCase.add(new Stair(0, new ArrayList<>()));
		
		while (!stairCase.isEmpty()) {
			Stair currentStair = stairCase.pop();
			
			if (currentStair.getStep() == steps) {
				System.out.println(currentStair.getVisited());
				continue;
			}
			
			if (currentStair.getStep() + 1 <= steps) {
				stairCase.push(new Stair(currentStair.getStep() + 1, currentStair.getVisited()));
			}
			if (currentStair.getStep() + 2 <= steps) {
				stairCase.push(new Stair(currentStair.getStep() + 2, currentStair.getVisited()));
			}
		}
	}
	
	private static void generatePossiblePaths(int step, int steps, List<Integer> path, List<List<Integer>> paths) {
		List<Integer> newPath = new ArrayList<>(path);
		newPath.add(step);
		
		if (step == steps) {
			paths.add(newPath);
			return;
		}
		
		if (step + 1 <= steps) {
			generatePossiblePaths(step + 1, steps, newPath, paths);
		}
		if (step + 2 <= steps) {
			generatePossiblePaths(step + 2, steps, newPath, paths);
		}
	}
}

class Stair {
	private int step;
	private List<Integer> visited = new ArrayList<>();
	
	public Stair(int step, List<Integer> visited) {
		this.step = step;
		this.visited.addAll(visited);
		this.visited.add(step);
	}
	
	public List<Integer> getVisited() {
		return visited;
	}
	
	public int getStep() {
		return step;
	}
}
