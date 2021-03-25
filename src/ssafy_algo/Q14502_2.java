package ssafy_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q14502_2 {
	static int n,m,max=0;//높이,넓이,최대 안전구역 크기
	static int[][] arr,wall; //입력받은 배열, 벽 세운 후 배열
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	static ArrayList<virus> list;
	
	private static class virus{
		int row;
		int col;
		
		public virus(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}
	
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		list = new ArrayList<virus>();
		
		for (int i = 0; i <n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]==2) list.add(new virus(i,j)); //바이러스 넣어주기
			}
		}
		
		wall = copyArr(arr);
		
		//일단 벽세우기먼저
		makeWall(0);
		
		System.out.println(max);
	}
	
	private static int[][] copyArr (int[][] arr) {
		
		int[][] copy = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				copy[i][j] = arr[i][j];
				
			}
		}
		
		return copy;
	}

	private static void makeWall(int idx) {
		
		if(idx==3) {
			spread();
			return;
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) { 
				if(wall[i][j]==0) {
					wall[i][j]=1; //벽세워주기
					makeWall(idx+1);
					wall[i][j]=0; //방문완료
				}
			}
		}
		
	}

	private static void spread() {
		
		int[][] spreadArr = copyArr(wall);
		
		Queue<virus> queue = new LinkedList<>();
		for (int i = 0; i < list.size(); i++) {
			queue.offer(new virus(list.get(i).row,list.get(i).col));
		}
		
		while(!queue.isEmpty()) {
			int Row = queue.peek().row;
			int Col = queue.poll().col;
			
			for (int i = 0; i < 4; i++) {
				int moveRow = Row+dy[i];
				int moveCol = Col+dx[i];
				
				if(moveRow>=0 && moveRow<n && moveCol>=0 && moveCol<m && spreadArr[moveRow][moveCol]==0) {
					spreadArr[moveRow][moveCol] = 2;
					queue.offer(new virus(moveRow,moveCol));
				}
			}
		}
		
		int size = count(spreadArr);
		max = Math.max(size,max);
	}

	private static int count(int[][] wall) {
		int sum = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(wall[i][j]==0) sum++;
			}
		}
		
		return sum;
	}
}
