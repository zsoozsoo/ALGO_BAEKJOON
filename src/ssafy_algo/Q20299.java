package ssafy_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q20299 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int cnt = 0;
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()); 
			int b = Integer.parseInt(st.nextToken()); 
			int c = Integer.parseInt(st.nextToken());
			int sum = a+b+c;
			
			if(sum < K) continue;
			if(a<L || b<L || c<L ) continue;
			cnt++;
			sb.append(a).append(" ").append(b).append(" ").append(c).append(" ");	
		}
		
		System.out.println(cnt);
		System.out.println(sb);
		
	}
}
