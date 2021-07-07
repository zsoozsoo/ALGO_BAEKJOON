package ssafy_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q3109 {
	
	static int[] dr = {-1,0,1}; 
	static int[] dc = {1,1,1};
	static char[][] arr;
	static boolean[][] vs;
	static int r,c,cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		arr = new char[r][c];
		vs = new boolean[r][c];
		
		for (int i = 0; i < r; i++) {
			String str = br.readLine();
			for (int j = 0; j < c; j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		
		for (int i = 0; i < r; i++) {
			dfs(i,0);
		}
		
		System.out.println(cnt);
		
	}

	private static boolean dfs(int row, int col) {
		
		for (int i = 0; i < 3; i++) {
			int moveR = row + dr[i];
			int moveC = col + dc[i];
			
			if(moveR>=0 && moveR<r && moveC>=0 && moveC<c && arr[moveR][moveC]=='.' && !vs[moveR][moveC]) {
				if(moveC==(c-1)) {

					cnt++;
					return true;
				}
				vs[moveR][moveC] = true;
				if(dfs(moveR,moveC)) return true;
			}
		}
		return false;
	}
}
