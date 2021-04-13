package ssafy_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;



public class Q7576 {
	
	static int M,N,count=0,depth=0;
	static int[][] box;
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	static Queue<pos> queue = new LinkedList<pos>();
	
	private static class pos{
		int row,col;

		public pos(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}
		
	}
	
	private static int bfs() {
		int moveR, moveC;
		while(count>0 && !queue.isEmpty()) {
			for (int k = queue.size(); k >0; k--) { //-로 꼭 해야함! 왜냐면 큐의 사이즈는 계속바뀌니까~~!!
				pos current = queue.poll();
				
				for (int l = 0; l < 4; l++) {
					
					moveR = current.row+dy[l];
					moveC = current.col+dx[l];
					
					if(moveR>=0 && moveR<N && moveC>=0 && moveC<M && box[moveR][moveC]==0) {
						count--;
						box[moveR][moveC] = 1;
						queue.offer(new pos(moveR,moveC));
					}
				}
			}
			
			depth++;
		}
		if(count==0) return depth;
		return -1;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken()); // 가로
		N = Integer.parseInt(st.nextToken()); //세로
		box = new int[N][M];
		
		for (int i = 0; i < N; i++) { //박스 안의 토마토 정보 입력
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				if(box[i][j] == 1) queue.offer(new pos(i,j));
				else if(box[i][j] == 0) count++;
			}
		}
		
		System.out.println(bfs());
		
	}

	
}
