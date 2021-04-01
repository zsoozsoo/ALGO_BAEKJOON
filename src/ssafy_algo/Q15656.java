package ssafy_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q15656 {
	
	static int N,M;
	static int[] numbers;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		numbers = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		combi(arr,0);
		System.out.println(sb);
	}

	private static void combi(int[] arr, int idx) {
		if(idx==M) {
			for(int i=0; i<M; i++) sb.append(numbers[i]).append(" ");
			sb.append("\n");
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			numbers[idx] = arr[i];
			combi(arr,idx+1);
		}
	}
}
