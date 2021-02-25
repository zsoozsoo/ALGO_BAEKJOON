package ssafy_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2999 {
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		int tmp = 0, r = 0 , c = 0;
		for (int i = 1; i < str.length(); i++) {
			tmp = str.length() % i;
			
			if(tmp == 0 && i <= (str.length() / i)) {
				if(i > r) r = i;
			}
		}
		
		c = str.length() / r;
		
		char[][] arr = new char[r][c];
		int index = 0;
		for (int i = 0; i < c; i++) {
			for (int j = 0; j < r; j++) {
				arr[j][i] = str.charAt(index++);
			}
		}
		
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				System.out.print(arr[i][j]);
			}
		}
	}
}
