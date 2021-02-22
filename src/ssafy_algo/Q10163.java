package ssafy_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q10163 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[][] map = new int[101][101];
		
		int x, y, w, h;
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			// 색종이는 (1,4)가 가장 왼쪽 아래에 있고 너비 3, 높이 2이므로 1 4 3 2로 표현한다. 
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			for (int i = y; i < y+h; i++) {
				for (int j = x; j < x+w; j++) {
					map[i][j] = t;
				}
			}
		}
		
		for (int t = 1; t <= T; t++) {
			int sum = 0;
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					if(map[i][j] == t) sum += 1;
				}
			}
			
			System.out.println(sum);
		}
		
	}
}
