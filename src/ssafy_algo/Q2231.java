package ssafy_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q2231 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int ans = 0;
		
		for (int i = 1; i < N; i++) {
			int sum = 0;
			int num = i;
			
			while(num != 0 ){
				sum += (num%10); 
				num = num/10;
			}
			
			if((sum+i)==N) {
				ans=i; break;
			} 
		}
		
		System.out.println(ans);
		
	}
}
