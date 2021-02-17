package ssafy_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q17135 {
	
	public static int N,M,D;
	public static int[][] arr;
	public static int[] attack ;
	public static boolean[] visited;
	
	public static void combination(int toSelect, int start, int depth) {
		
		if(depth == 3) {
			for (int i = 0; i < attack.length; i++) {
				System.out.println(attack[i]);
			}
			return;
		}
		
		for (int i = start; i < M; i++) {
			attack[toSelect] = i+1;
			combination(toSelect+1, selected,i+1);
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		attack = new int[M];
		visited = new boolean[M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j <M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		combination(0,0);
		
		
	}
}
