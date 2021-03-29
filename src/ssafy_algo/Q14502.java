package ssafy_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q14502 {
	
	static int n,m,max = 0;
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	static int[][] wall;
	static List<pos> list;
	
	public static class pos{
		int row;
		int col;
		
		public pos(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}
	}
	
	public static int[][] copyArr(int[][] arr) {
		int[][] copyArr = new int[n][m];
		
		for (int i = 0; i <n; i++) {
			for (int j = 0; j < m; j++) {
				copyArr[i][j] = arr[i][j];
			}
		}
		
		return copyArr;
	}
	
	public static void makeWall(int depth) {
		
		if(depth==3) {
			spread();
			return;
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <m; j++) {
				if(wall[i][j]==0) {
					wall[i][j] = 1;
					makeWall(depth+1);
					wall[i][j] = 0;
				}
			}
		}
	}
	
	public static void spread() {
		int[][] spreadArr = copyArr(wall);
		
		Queue<pos> queue = new LinkedList<>();
		for (int i = 0; i < list.size(); i++) {
			queue.offer(new pos(list.get(i).row, list.get(i).col));
		}
		
		while(!queue.isEmpty()) {
			int Row = queue.peek().row;
			int Col = queue.poll().col;
			
			for (int i = 0; i < 4; i++) {
				int moveRow = Row+dy[i];
				int moveCol = Col+dx[i];
				
				if(moveRow>=0 && moveRow<n && moveCol >=0 && moveCol<m && spreadArr[moveRow][moveCol]==0) {
					spreadArr[moveRow][moveCol] = 2;
					queue.offer(new pos(moveRow,moveCol));
				}
			}
		}
		
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(spreadArr[i][j]==0) count++;
			}
		}
		max = Math.max(max, count);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int[][] arr = new int[n][m];
		
		list = new ArrayList<>();
		for (int i = 0; i <n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]==2) list.add(new pos(i,j));
			}
		}
		
		wall = copyArr(arr);
		makeWall(0);
		
		System.out.println(max);
		
		
	}
}
