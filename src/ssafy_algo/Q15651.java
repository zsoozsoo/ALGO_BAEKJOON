package ssafy_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q15651 {
	
	static int N,M;
	static int[] numbers;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		numbers = new int[M];
		permu(0);
		System.out.println(sb);
	}
	
	private static void permu(int idx) {
		
		if(idx==M) {
			for(int i=0; i<M; i++) sb.append(numbers[i]).append(" ");
			sb.append("\n");
			return;
		}
		
		for (int i = 1; i <= N; i++) {
			numbers[idx] = i;
			permu(idx+1);
		}
		
	}
}
