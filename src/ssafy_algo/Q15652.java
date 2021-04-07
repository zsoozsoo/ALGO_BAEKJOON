package ssafy_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q15652 {
	
	static int N,M;
	static int[] numbers;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		numbers = new int[M];
		
		combi(0,1);
		System.out.println(sb);
	}

	private static void combi(int idx,int start) {
		if(idx==M) {
			for (int i = 0; i < M; i++) sb.append(numbers[i]).append(" ");
			sb.append("\n");
			return;
		}
		for (int i = start; i <= N; i++) {
			numbers[idx] = i;
			combi(idx+1,i);
		}
	}
}
