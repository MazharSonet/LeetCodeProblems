package interview.amazon;

public class TreasureIsland {
	private int distance = Integer.MAX_VALUE;

	public int findShortestRoute(char[][] island) {
		if (island == null) {
			return -1;
		}
		boolean[][] visited = new boolean[island.length][island[0].length];
		dfs(island, 0, 0, visited, 0);
		
		return distance;
	}

	public void dfs(char[][] grid, int i, int j, boolean[][] visited, int levelDistance) {
		if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 'D' || visited[i][j]) {
			return;
		}
		if (grid[i][j] == 'X') {
			distance = Math.min(distance, levelDistance);
			return;
		}
		visited[i][j] = true;
		
		dfs(grid, i, j - 1, visited, levelDistance + 1); // back
		dfs(grid, i - 1, j, visited, levelDistance + 1);// up
		dfs(grid, i, j + 1, visited, levelDistance + 1);// forward
		dfs(grid, i + 1, j, visited, levelDistance + 1);// downward
		
		visited[i][j] = false;
	}	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreasureIsland obj = new TreasureIsland();
		char[][] input = {{'O', 'O', 'O', 'O'},
						  {'D', 'O', 'D', 'O'},
						  {'X', 'O', 'O', 'O'},
						  {'O', 'D', 'D', 'O'}};
				
		System.out.println(obj.findShortestRoute(input));

	}

}
