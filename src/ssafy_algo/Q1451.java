package ssafy_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1451 {
	
	static int[][] arr;
	static long max = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			String str =br.readLine();
			for (int j = 0; j < m; j++) {
				arr[i][j] = str.charAt(j)-'0';
			}
		}
		
		//1.가로3개
		for (int i = 0; i < n-2; i++) {
			long idx = sum(0,i,0,m-1);
			for (int j = i+1; j < n-1; j++) {
				long sub = idx;
				sub *= sum(i+1,j,0,m-1);
				sub *= sum(j+1,n-1,0,m-1);
				if(max<sub) max = sub;
			}
		}
		
		//2.세로3개
		for (int i = 0; i <m-2; i++) {
			long idx = sum(0,n-1,0,i);
			for (int j = i+1; j < m-1; j++) {
				long sub = idx;
				sub *= sum(0,n-1,i+1,j);
				sub *= sum(0,n-1,j+1,m-1);
				if(max<sub) max = sub;
			}
		}
		
		//3.가로1개+세로2개(ㅠ모양)
		for (int i = 0; i < n-1; i++) {
			long idx = sum(0,i,0,m-1);
			for (int j = 0; j < m-1; j++) {
				long sub = idx;
				sub *= sum(i+1,n-1,0,j);
				sub *= sum(i+1,n-1,j+1,m-1);
				if(max<sub) max = sub;
			}
		}
		
		//4.세로2개+가로1개(모양)
		for (int i = n-1; i >=1; i--) {
			long idx = sum(i,n-1,0,m-1);
			for (int j = 0; j < m-1; j++) {
				long sub = idx;
				sub *= sum(0,i-1,0,j);
				sub *= sum(0,i-1,j+1,m-1);
				if(max<sub) max = sub;
			}
		}
		
		//5.세로1개+가로2개(ㅑ모양)
		for (int i = 0; i < m-1; i++) {
			long idx = sum(0,n-1,0,i);
			for (int j = 0; j <n-1; j++) {
				long sub = idx;
				sub *= sum(0,j,i+1,m-1);
				sub *= sum(j+1,n-1,i+1,m-1);
				if(max<sub) max = sub;
			}
		}
		
		//6.가로2개+세로1개(ㅕ모양)
		for (int i = m-1; i >=1; i--) {
			long idx = sum(0,n-1,i,m-1);
			for (int j = 0; j <n-1; j++) {
				long sub = idx;
				sub *= sum(0,j,0,i-1);
				sub *= sum(j+1,n-1,0,i-1);
				if(max<sub) max = sub;
			}
		}
		
		System.out.println(max);
	}
	
	public static long sum(int startR, int endR, int startC, int endC) {
		//System.out.println(startR+" "+endR+" "+startC+" "+endC);
		long sum = 0;
		
		for (int i = startR; i <= endR; i++) {
			for (int j = startC; j <= endC; j++) {
				sum += arr[i][j];
			}
		}
		return sum;
	}
	
}
