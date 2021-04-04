package ssafy_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q15654 {
	static int N,M;
	static int[] numbers;
	static StringBuilder sb = new StringBuilder();
	
	private static void combi(int[] arr, int cnt, boolean[] vs) {
		
		if(cnt == M) {
			for (int i = 0; i < numbers.length; i++) sb.append(numbers[i]).append(" ");
			sb.append("\n");
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			if(vs[i]) continue;
			vs[i] = true;
			numbers[cnt] = arr[i];
			combi(arr,cnt+1,vs);
			vs[i] = false;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		numbers = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		combi(arr,0,new boolean[N]);
		System.out.println(sb);
	}
}
