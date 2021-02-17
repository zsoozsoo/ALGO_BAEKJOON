package ssafy_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1992 {
	
	public static int N;
	public static int[][] arr;
//	public static int[] dx = {0,0,1,1};
//	public static int[] dy = {0,1,0,1};
	
	public static void codeQuery(int row, int col) {
		
		N/=2;
		boolean flg = false;
		StringBuilder sb = new StringBuilder();
		for (int i = row; i < row+N; i++) {
			for (int j = col; j < col+N; j++) {
					if(arr[row][col]==1) {
						flg = true;
					}else{
						flg = false;
					}
					
			}
		}
		
		N /= 2;
		codeQuery(row,col);
		codeQuery(row,col+(N/2));
		codeQuery(row+(N/2),col);
		codeQuery(row+(N/2),col+(N/2));
	}
	
	public static void main(String[] args) throws IOException {
		
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	N = Integer.parseInt(br.readLine());
	
	arr = new int[N][N];
	for (int i = 0; i < N; i++) {
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int j = 0; j < N; j++) {
			arr[i][j] = Integer.parseInt(st.nextToken());
		}
	}
	
	codeQuery(0,0);
	
		
	}
}
