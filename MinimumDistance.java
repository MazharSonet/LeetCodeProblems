package interview.amazon;

public class MinimumDistance {
	
	
	public static int distance = Integer.MAX_VALUE;

	public static int findShortestRoute(int[][] island) {
		if (island == null) {
			return -1;
		}
		boolean[][] visited = new boolean[island.length][island[0].length];
		dfs(island, 0, 0, visited, 0);
		
		return distance;
	}

	public static void dfs(int[][] grid, int i, int j, boolean[][] visited, int levelDistance) {
		if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0 || visited[i][j]) {
			return;
		}
		if (grid[i][j] == 1) {
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
//		System.out.print(distance);
		// TODO Auto-generated method stub
		int [][] grid= {{1,0,0},{1,1,9},{1,0,0}};//new int[3][3];
		findShortestRoute(grid);
		System.out.print(distance);

	}

}
