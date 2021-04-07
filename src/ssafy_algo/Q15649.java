package ssafy_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q15649 {
		
	static int N,M;
	static int[] numbers;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		numbers = new int[M];
		
		per(0,new boolean[N+1]);
	}
	
	private static void per(int i, boolean[] visited) {
		if(i== M) {
			for (int j = 0; j < numbers.length; j++) System.out.print(numbers[j]+" ");
			System.out.println();
			return;
		}
		for (int j = 1; j <= N; j++) {
			if(visited[j]) continue;
			visited[j] = true;
			numbers[i] = j;
			per(i+1,visited);
			visited[j] = false;
		}
		
	}
}
