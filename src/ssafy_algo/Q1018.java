package ssafy_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1018 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		char[][] arr = new char[n][m];
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		
		int min = Integer.MAX_VALUE;
		
		for (int i = 0; i <= n-8; i++) {
			for (int j = 0; j <= m-8; j++) {
				
				int wChange = 0, bChange = 0;
				
				
				for (int k = i; k < i+8; k+=2) {
					for (int l = j; l < j+8; l+=2) {
						if(arr[k][l]!= 'W') wChange++;
					}
					for (int l = j+1; l < j+8; l+=2) {
						if(arr[k][l]!= 'B') wChange++;
					}
				}
				
				for (int k = i+1; k < i+8; k+=2) {
					for (int l = j; l < j+8; l+=2) {
						if(arr[k][l]!= 'B') wChange++;
					}
					for (int l = j+1; l < j+8; l+=2) {
						if(arr[k][l]!= 'W') wChange++;
					}
				}
				
				
				
				for (int k = i; k < i+8; k+=2) {
					for (int l = j; l < j+8; l+=2) {
						if(arr[k][l]!= 'B') bChange++;
					}
					for (int l = j+1; l < j+8; l+=2) {
						if(arr[k][l]!= 'W') bChange++;
					}
				}
				
				for (int k = i+1; k < i+8; k+=2) {
					for (int l = j; l < j+8; l+=2) {
						if(arr[k][l]!= 'W') bChange++;
					}
					for (int l = j+1; l < j+8; l+=2) {
						if(arr[k][l]!= 'B') bChange++;
					}
				}
			
				int cnt = 0;
				if(wChange>bChange) cnt = bChange;
				else cnt = wChange;
				
				if(min>cnt) min = cnt;
				
			}
		}
		
		

		
		System.out.println(min);
		
	}
}
