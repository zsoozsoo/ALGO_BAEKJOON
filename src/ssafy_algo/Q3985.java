package ssafy_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q3985 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		
		int[] cake = new int[L+1];
		int max = 0, expIdx = 0;
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int P = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			if(max < (K-P)+1) {
				max = (K-P)+1; expIdx = i;
			}
			
			for (int j = P; j <= K; j++) {
				if(cake[j] == 0) cake[j] = i;
			}
		}
		
		int sum = 0, sumMax = 0, idx = 0;
		for (int i = 1; i <= N; i++) {
			sum = 0;
			for (int j = 1; j <= L; j++) {
				if(cake[j] == i) sum++;
			}
			if(sumMax < sum) {
				sumMax = sum;
				idx = i;
			}
		}
		
		System.out.println(expIdx+"\n"+idx);
	}
}
