package ssafy_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q15650 {
	
	static int N, M;
	static int[] numbers;
	static StringBuilder sb;
		
	static void combi(int cnt, int start) {

		sb = new StringBuilder();
		if(cnt == M) {
			for (int i = 0; i < M; i++) sb.append(numbers[i]+" ");
			System.out.println(sb);
			return;
		}
		
		for (int i = start; i <= N; i++) {
			numbers[cnt] = i;
			combi(cnt+1,i+1);
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		numbers = new int[M];
		
		combi(0,1);
	}
}
