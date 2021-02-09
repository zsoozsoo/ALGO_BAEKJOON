package ssafy_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2563 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[101][101];
		int sum = 0;
		
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			for (int i = a; i < a+10; i++) {
				for (int j = b; j < b+10; j++) {
					if(arr[i][j]==0) {
						arr[i][j] = 1;
						sum += 1;
					}
				}
			}
		}
		
		System.out.println(sum);
	}
}
