package ssafy_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q2239 {
	
	static int cnt = 0; //총 0의 갯수
	static boolean[][] rowArr,colArr,boxArr;
	static int[][] arr;
	static List<pos> list;
	
	public static class pos{
		int row,col;

		public pos(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		list = new ArrayList<>();
		rowArr = new boolean[9][10]; //가로 확인하는 배열
		colArr = new boolean[9][10]; //세로 확인하는 배열
		boxArr = new boolean[9][10];
		
		arr = new int[9][9];
		for (int i = 0; i < 9; i++) {
			String str = br.readLine();
			for (int j = 0; j < 9; j++) {
				arr[i][j] = str.charAt(j)-'0';
				if(arr[i][j]==0) list.add(new pos(i,j));
				else {
					rowArr[i][arr[i][j]] = true;
					colArr[j][arr[i][j]] = true;
					boxArr[(i/3)*3+(j/3)][arr[i][j]] = true;
				}
			}
		}
		
		check(0);
		
	}
	
	private static void check(int idx){
		if(idx==list.size()) { //0이 아닌 숫자만큼 돌리면 되니까
			for (int i = 0; i <9; i++) {
				for (int j = 0; j < 9; j++) {
					System.out.print(arr[i][j]);
				}
				System.out.println();
			}
			System.exit(0);
		}
		
		int cr = list.get(idx).row;
		int cc = list.get(idx).col;

		for (int i = 1; i <=9; i++) {
			if(!rowArr[cr][i] && !colArr[cc][i] && !boxArr[(cr/3)*3+cc/3][i]) {
				//갱신
				arr[cr][cc] = i;
				rowArr[cr][i] = true;
				colArr[cc][i] = true;
				boxArr[(cr/3)*3+cc/3][i] = true;
				check(idx+1);
				//아니라면 다시 원상복귀
				arr[cr][cc] = 0;
				rowArr[cr][i] = false;
				colArr[cc][i] = false;
				boxArr[(cr/3)*3+cc/3][i] = false;
				
			}
		}
	}


	
	
}
