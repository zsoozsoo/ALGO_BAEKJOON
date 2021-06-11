package ssafy_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1182 {
	static int cnt = 0,n,s;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(0,0);
		
		if(s==0) System.out.println(--cnt);
		else System.out.println(cnt);
	}

	private static void dfs(int idx,int plus) {
		
		if(idx==n) {
			if(plus == s) cnt++;
			return;
		}
		
		dfs(idx+1,plus+arr[idx]);
		dfs(idx+1,plus);
		
	}
}
