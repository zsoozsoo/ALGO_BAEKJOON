package ssafy_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2567 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	 int n = Integer.parseInt(br.readLine());
	 
	 int[][] arr = new int[101][101];
	 for (int i = 0; i < n; i++) {
		 StringTokenizer st = new StringTokenizer(br.readLine());
		 int x = Integer.parseInt(st.nextToken());
		 int y = Integer.parseInt(st.nextToken());
		 
		 for (int j = x; j <= x+10; j++) {
			 arr[j][y] = 1;
			 arr[j][y+10] = 1;
		}
		 
		 for (int j = y; j <= y+10; j++) {
			arr[j][x] = 1;
			arr[j][x+10] = 1;
		}
		 
	}
	 
	}
}
