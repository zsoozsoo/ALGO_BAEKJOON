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
	 int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
	 
	 for (int i = 0; i < n; i++) {
		 StringTokenizer st = new StringTokenizer(br.readLine());
		 int x = Integer.parseInt(st.nextToken());
		 int y = Integer.parseInt(st.nextToken());
		 
		 for (int j = x; j < x+10; j++) {
			for (int j2 = y; j2 < y+10; j2++) {
				arr[j][j2] = 1;
			}
		}
		 
	}
	 
	int sum = 0;
	for (int i = 1; i <= 100; i++) {
		for (int j = 1; j <= 100; j++) {
			if(arr[i][j]==1) {
				for (int j2 = 0; j2 < 4; j2++) {
					if(arr[i+dir[j2][0]][j+dir[j2][1]]==0) sum++;
				}
			}
		}
	}
	
	System.out.println(sum);
	 
	}
}
