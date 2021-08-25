package ssafy_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q8320 {
	
	static int cnt = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		Combi(0,1,n,new int[2]);
		
		System.out.println(cnt);
	}
	
	public static void Combi(int curr,int start,int n, int[] temp) {
		if(curr==2) {
			if(temp[0]*temp[1]<=n) cnt++;
			return;
		}
		
		for(int i=start; i<=n; i++) {
			temp[curr] = i;
			Combi(curr+1,i,n,temp);
		}
	}
}
