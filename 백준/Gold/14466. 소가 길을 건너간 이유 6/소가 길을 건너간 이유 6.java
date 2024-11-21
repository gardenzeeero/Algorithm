import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	static boolean[][] visited;
	static ArrayList<Node>[][] arr;
	static LinkedList<Node> cows;
	static int n, k, r;

	static class Node {
		int x;
		int y;
		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public boolean equals(Object object) {
			Node node = (Node)object;

			return this.x == node.x && this.y == node.y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		n = input[0];
		k = input[1];
		r = input[2];

		arr = new ArrayList[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				arr[i][j] = new ArrayList<>();
			}
		}

		for(int i=0; i<r; i++) {
			input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int r1 = input[0]-1, c1 = input[1]-1, r2 = input[2]-1, c2 = input[3]-1;
			arr[r1][c1].add(new Node(r2, c2));
			arr[r2][c2].add(new Node(r1,c1));
		}

		cows = new LinkedList<>();
		visited = new boolean[n][n];
		for(int i=0; i<k; i++) {
			input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int r = input[0]-1, c = input[1]-1;
			cows.add(new Node(r, c));
		}

		int result = 0;
		for(int i=0; i<cows.size(); i++) {
			bfs(cows.get(i));
			result += check(i);
			clearVisited();
		}
		System.out.println(result);
	}
	
	static int check(int idx) {
		int count = 0;
		for(int i=idx+1; i<cows.size(); i++) {
			Node ncow = cows.get(i);
			if(!visited[ncow.x][ncow.y]) count++;
		}
		return count;
	}

	static void clearVisited() {
		for(int i=0; i<n; i++){
			Arrays.fill(visited[i], false);
		}
	}

	static void bfs(Node cow) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(cow);
		while(!queue.isEmpty()) {
			Node now = queue.poll();
			int cx = now.x, cy = now.y;
			for(int i=0; i<4; i++) {
				int nx = cx + dx[i], ny = cy + dy[i];
				if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
				if(visited[nx][ny]) continue;
				if(arr[cx][cy].contains(new Node(nx, ny))) continue;

				visited[nx][ny] = true;
				queue.add(new Node(nx, ny));
			}
		}
	}
}
