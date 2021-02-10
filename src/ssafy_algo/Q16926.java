package ssafy_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q16926 {
	
	static int N ;
	static int M ;
	
	public static void rotation(int[][] arr, int num) {
		
		int temp = arr[num][num];
		
		for (int i = num; i < M-num-1; i++) arr[num][i] = arr[num][i+1];
		for (int i = num; i < N-num-1; i++) arr[i][M-num-1] = arr[i+1][M-num-1];
		for (int i = M-num-1; i > num; i--) arr[N-num-1][i] = arr[N-num-1][i-1];
		for (int i = N-num-1; i > num; i--) arr[i][num] = arr[i-1][num];
		arr[num+1][num] = temp;
			
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st2.nextToken());
			}
		}
		
		int ro = (Math.min(N, M)/2);
		for (int t = 0; t < R; t++) {
			for (int i = 0; i < ro; i++) {
				rotation(arr,i);
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		
	}
}
