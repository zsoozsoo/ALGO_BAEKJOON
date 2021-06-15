package ssafy_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q16935 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < k; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			switch(num) {
			case 1: arr = TopDown(arr); break;
			case 2: arr = LeftRight(arr); break;
			case 3: arr = Right90(arr); break;
			case 4: arr = Left90(arr); break;
			case 5: arr = moveOrder(arr); break;
			case 6: arr = moveReverse(arr); break;
			}
			
		}
		
		for (int w = 0; w < arr.length; w++) {
			for (int j = 0; j < arr[w].length; j++) {
				System.out.print(arr[w][j]+" ");
			}
			System.out.println();
		}
		
	}

	private static int[][] TopDown(int[][] arr) {
		int m = arr[0].length, n = arr.length;
		// 상하반전 배열
		int[] temp = new int[m];
		for (int i = 0 ; i < n/2; i++) {
			for (int j = 0; j < arr[i].length; j++) temp[j] = arr[i][j];
			
			for (int j = 0; j < m; j++) {
				arr[i][j] = arr[n-i-1][j];
				arr[n-i-1][j] = temp[j];
			}
		}
		return arr;
	}

	private static int[][] LeftRight(int[][] arr) {
		int m = arr[0].length, n = arr.length;
		// 좌우반전 배열
		int[] temp = new int[n];
		for (int i = 0 ; i < m/2; i++) {
			for (int j = 0; j < n ; j++) temp[j] = arr[j][i];
			
			for (int j = 0; j < n; j++) {
				arr[j][i] = arr[j][m-i-1];
				arr[j][m-i-1] = temp[j];
			}
		}
		return arr;
	}

	private static int[][] Right90(int[][] arr) {
		int m = arr[0].length, n = arr.length;
		//오른쪽으로 90도 돌리기
		int[][] temp = new int[m][n];
		int[] tempRow = new int[m];
		
		for (int i = 0 ; i < n; i++) {
			for (int j = 0; j < m ; j++) tempRow[j] = arr[i][j];
			
			for (int j = 0; j < m; j++) {
				temp[j][n-i-1] = tempRow[j];
			}
		}
		return temp;
	}

	private static int[][] Left90(int[][] arr) {
		//왼쪽으로 90도 돌리기
		int m = arr[0].length, n = arr.length;
		int[][] temp = new int[m][n];
		int[] tempRow = new int[m];
		
		for (int i = 0 ; i < n; i++) {
			for (int j = 0; j < m ; j++) tempRow[j] = arr[i][j];
			
			for (int j = 0; j < m; j++) {
				temp[m-j-1][i] = tempRow[j];
			}
		}
		return temp;
	}

	private static int[][] moveOrder(int[][] arr) {
		//4방으로 나누기 1>2,2>3,3>4,4>1
		int m = arr[0].length, n = arr.length;
		int[][] oriDiv = {{0,0},{0,m/2},{n/2,m/2},{n/2,0}};
		int[][] tempDiv = {{0,m/2},{n/2,m/2},{n/2,0},{0,0}};
		
		int[][] temp = new int[n][m];
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < n/2; j++) {
				for (int j2 = 0; j2 < m/2; j2++) {
					temp[tempDiv[i][0]+j][tempDiv[i][1]+j2] = arr[oriDiv[i][0]+j][oriDiv[i][1]+j2];
				}
			}
		}
		
		return temp;
		
	}

	private static int[][] moveReverse(int[][] arr) {
		//4방으로 나누기 1>2,2>3,3>4,4>1
		int m = arr[0].length, n = arr.length;
		int[][] oriDiv = {{0,0},{n/2,0},{n/2,m/2},{0,m/2}};
		int[][] tempDiv = {{n/2,0},{n/2,m/2},{0,m/2},{0,0}};
		
		int[][] temp = new int[n][m];
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < n/2; j++) {
				for (int j2 = 0; j2 < m/2; j2++) {
					temp[tempDiv[i][0]+j][tempDiv[i][1]+j2] = arr[oriDiv[i][0]+j][oriDiv[i][1]+j2];
				}
			}
		}
		
		return temp;
		
	}

}
