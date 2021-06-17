package ssafy_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2961 {
	
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[n][2];
		for (int tc = 0; tc < n; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[tc][0] = Integer.parseInt(st.nextToken());
			arr[tc][1] = Integer.parseInt(st.nextToken());
		}
		
		powerset(arr,new boolean[n],n,0);
		System.out.println(min);
	}

	private static void powerset(int[][] arr, boolean[] vs, int n, int idx) { //부분집합
		if(idx==n) {
			int sFlavor = 1, bFlavor = 0, count = 0; //신맛, 쓴맛, 공집합 체크해줄 변수
			for (int i = 0; i < vs.length; i++) {
				if(vs[i]) {
					count++;
					sFlavor *= arr[i][0];
					bFlavor += arr[i][1];
				}
			}
			
			if(count==0) return; // count가 0이면 공집합이니까 제외
			int minus = Math.abs(sFlavor-bFlavor); //신맛과 쓴맛의 차이
			if(min>minus) min = minus;
			return;
		}
		
		vs[idx] = true;
		powerset(arr, vs, n, idx+1);
		vs[idx] = false;
		powerset(arr, vs, n, idx+1);
		
	}
}
