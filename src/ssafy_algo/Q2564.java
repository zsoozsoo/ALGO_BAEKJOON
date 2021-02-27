package ssafy_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2564 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[n+1][2];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			map[i][0] = Integer.parseInt(st.nextToken());
			map[i][1] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		int dir = Integer.parseInt(st.nextToken());
		int spot = Integer.parseInt(st.nextToken());
		map[n][0] = dir; map[n][1] = spot;
		
		for (int i = 0; i < n; i++) {
			int a=0, b=0;
			
			if((map[i][0]-dir+4)%4==1) {
				if(dir %2 != 0) {
					a = w+map[i][1]+spot;
					b = w+(h-spot)+(h-map[i][1]);
				}else {
					a = h+map[i][1]+spot;
					b = h+(w-spot)+(w-map[i][1]);
				}
			} else {
				if()
			}
		}
		
	}
}
