package ssafy_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2458 {
	
	static int n,cnt,res;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken()); //학생들 수
		int m = Integer.parseInt(st.nextToken()); //두 학생을 비교한 횟수
		
		int[][] arr = new int[n+1][n+1]; //인접행렬
		int[][] rarr = new int[n+1][n+1]; //뒤집은 인접행렬
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			arr[a][b] = 1;
			rarr[b][a] = 1;
		}
		
		for (int i = 1; i <= n; i++) {
			cnt = 0;
			dfs(arr,new boolean[n+1],i);
			dfs(rarr,new boolean[n+1],i);
			if(cnt== n-1) ++res;
		}
		
		System.out.println(res);
		
	}

	private static void dfs(int[][] arr, boolean[] vs, int idx) {
		vs[idx] = true;
			for (int j = 1; j <= n; j++) {
				if(!vs[j] && arr[idx][j] == 1) {
					dfs(arr,vs,j);
					cnt++;
				}
			}
		
		
	}
}
