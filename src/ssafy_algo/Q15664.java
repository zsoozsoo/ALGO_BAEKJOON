package ssafy_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Q15664 {
	static int N,M;
	static Set<String> set;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		set = new LinkedHashSet<String>();
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(arr);
		
		combi(arr,0,0,"");
		for (String s : set) {
			System.out.println(s);
		}
	
	}

	private static void combi(int[] arr, int idx, int start,String str) {
		
		if(idx==M) {
			set.add(str.trim());
			return;
		}
		for (int i = start; i < arr.length; i++) {
			combi(arr,idx+1,i+1,str+" "+arr[i]);
		}
	}
}
