package ssafy_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14889 {
	
	static int[][] arr;
	static int N, min = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N][N];
		for (int i = 0; i < N; i++) { //배열에 넣기
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		combi(0,0, new boolean[N]);
		System.out.println(min);
	}

	private static void combi(int start,int idx, boolean[] visited) {
		if(idx == N/2) {
			calc(visited);
			return;
		}
		for (int i = start+1; i < N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				combi(i,idx+1,visited);
				visited[i] = false;
			}
		}
	}
	

	private static void calc(boolean[] visited) {
		int startScore=0, linkScore=0;
		
		for (int i = 0; i < N-1; i++) {
			for (int j = i+1; j < N; j++) {
				if(visited[i] == true && visited[j] == true) startScore += (arr[i][j]+arr[j][i]);
				else if(visited[i]==false && visited[j]==false) linkScore += (arr[i][j]+arr[j][i]);
			}
		}
		
		int res = Math.abs(startScore-linkScore);
		
		if(res==0) {
			System.out.println(res);
			System.exit(0);
		}
		
		if(min>res) min = res;
		
	}
	
}
