package ssafy_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14889 {
	
	static boolean[] visited;
	static int[][] arr;
	static int N, min = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N][N];
		visited = new boolean[N];
		for (int i = 0; i < N; i++) { //배열에 넣기
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		combi(0,0);
		System.out.println(min);
	}

	private static void combi(int start,int idx) {
		if(idx == N/2) {
			calc();
			return;
		}
		for (int i = start; i < N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				combi(start+1,idx+1);
				visited[i] = false;
			}
		}
	}
	

	private static void calc() {
		int startScore=0, linkScore=0;
		
		for (int i = 0; i < N-1; i++) {
			for (int j = i+1; j < N; j++) {
				if(visited[i] == true && visited[j] == true) {
					startScore += arr[i][j];
					startScore += arr[j][i];
				}else if(visited[i]==false && visited[j]==false) {
					linkScore += arr[i][j];
					linkScore += arr[j][i];
				}
			}
		}
		
		int res = Math.abs(startScore-linkScore);
		
		if(res==0) {
			System.out.println(res);
			System.exit(0);
		}
		
		min = Math.min(res, min);
		
	}
	
}
