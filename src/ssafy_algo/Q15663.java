package ssafy_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Q15663 {
	
	static int N,M;
	static int[] numbers;
	static Set<String> hs;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		numbers = new int[M];
		hs = new LinkedHashSet<String>();
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		per(arr,M,"",new boolean[N]);
		for (String s : hs) {
			System.out.println(s);
		}
	}

	private static void per(int[] arr, int idx,String s, boolean[] vs) {
		
		if(idx == 0) {
			hs.add(s.trim());
			return;
		}
		for (int i = 0; i < vs.length; i++) {
			if(vs[i]) continue;
			vs[i] = true;
			per(arr,idx-1,s+" "+arr[i],vs);
			vs[i] = false;
		}
	}
}
