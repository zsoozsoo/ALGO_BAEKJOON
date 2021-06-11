package ssafy_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1260 {
	
	static int n;
	static int[][] arr;
	static boolean[] vs;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken()); //정점 개수
		int m = Integer.parseInt(st.nextToken()); //간선 개수
		int v = Integer.parseInt(st.nextToken()); //시작 정점
		
		arr = new int[n+1][n+1];
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a][b] = 1;
			arr[b][a] = 1;
			
		}
		
		vs = new boolean[n+1];
		dfs(v);
		
		System.out.println();
		
		vs = new boolean[n+1];
		bfs(v);
	}
	
	private static void dfs(int start) {
		vs[start] = true;
		System.out.print(start+" ");
		
		for (int i = 1; i <= n; i++) {
			if(arr[start][i] == 1 && !vs[i]) dfs(i);
		}
	}

	private static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(start);
		vs[start] = true;
		
		while(!queue.isEmpty()) {
			int curr = queue.poll();
			System.out.print(curr+" ");
			
			for (int i = 1; i <= n; i++) {
				if(arr[curr][i]== 1 && !vs[i]) {
					queue.add(i);
					vs[i] = true;
				}
			}
		}
		
	}


}
