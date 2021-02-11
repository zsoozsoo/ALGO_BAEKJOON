package ssafy_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q16935 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for (int j = 0; j <M; j++) {
				arr[i][j] = Integer.parseInt(st2.nextToken());
			}
		}
		
		for (int i = 0; i < R; i++) {
			StringTokenizer st3 = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st3.nextToken());
			
			switch(num) {
			case 1 : 
			case 2 : 
			case 3 : 
			case 4 : 
			case 5 : 
			case 6 : 
			}
			
		}
	}
}
