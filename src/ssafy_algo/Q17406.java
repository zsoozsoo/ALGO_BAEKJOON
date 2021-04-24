package ssafy_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Q17406 {
	
	static int N,M,K,min = Integer.MAX_VALUE;
	static int[][] arr;
	
	public static class pInfo {
		int r,c,s;

		public pInfo(int r, int c, int s) {
			super();
			this.r = r;
			this.c = c;
			this.s = s;
		}
		
	}
	

	private static void permu(int idx, List<pInfo> list, boolean[] vs, pInfo[] temp) {
		
		if(idx==K) {
			rotation(temp);
			return;
		}
		
		for (int j = 0; j < K; j++) {
			if(!vs[j]) {
				vs[j] = true;
				temp[idx] = list.get(j);
				permu(idx+1,list,vs,temp);
				vs[j] = false;
			}
		}
	}
	
	private static void rotation(pInfo[] temp) {
		int[][] rotArr = copy(arr);
		
		for (int i = 0; i < temp.length; i++) {
			int r = temp[i].r;
			int c = temp[i].c;
			int s = temp[i].s;
			
			int topRow=r-s ,topCol=c-s ,botRow=r+s ,botCol = c+s;
			while(topRow!=botRow && topCol!=botCol) {
				int store = rotArr[topRow][topCol]; //가장 첫번째 원소 저장
				
				//왼쪽세로
				for (int j = 0; j < botRow-topRow; j++) {
					rotArr[topRow+j][topCol] = rotArr[topRow+j+1][topCol];
				}
				//아래가로
				for (int j = 0; j < botCol-topCol; j++) {
					rotArr[botRow][topCol+j] = rotArr[botRow][topCol+j+1];
				}
				//오른쪽세로
				for (int j = 0; j < botRow-topRow; j++) {
					rotArr[botRow-j][botCol] = rotArr[botRow-j-1][botCol];
				}
				//위가로
				for (int j = 0; j < botCol-topCol; j++) {
					rotArr[topRow][botCol-j] = rotArr[topRow][botCol-j-1];
				}
				
				rotArr[topRow][topCol+1] = store;
				topRow++; topCol++; botRow--; botCol--;

			}
		}
		
		calculate(rotArr);
	}

	private static void calculate(int[][] rotArr) {
		int rowMin = Integer.MAX_VALUE;
		
		for (int i = 1; i <= N; i++) {
			int sum = 0;
			for (int j = 1; j <= M; j++) {
				sum += rotArr[i][j];
			}
			if(sum<rowMin) rowMin = sum;
		}
		
		if(min>rowMin) min = rowMin;
	}

	private static int[][] copy(int[][] copyArr) {
		copyArr = new int[N+1][M+1];
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				copyArr[i][j] = arr[i][j];
			}
		}
		return copyArr;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1][M+1];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				arr[i][j] = Integer.parseInt(st2.nextToken());
			}
		}
		
		List<pInfo> list = new ArrayList<>();
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			list.add(new pInfo(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		permu(0,list,new boolean[K], new pInfo[K]);
		
		System.out.println(min);
	}
}
