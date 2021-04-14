package ssafy_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q17144 {
	
	public static class pos{
		int row,col,dens;

		public pos(int row, int col,int dens) {
			super();
			this.row = row;
			this.col = col;
			this.dens = dens;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int h = Integer.parseInt(st.nextToken()); //세로
		int w = Integer.parseInt(st.nextToken()); //높이
		int t = Integer.parseInt(st.nextToken()); //초
		
		int[] dx = {-1,1,0,0};
		int[] dy = {0,0,-1,1};
		
		int airR = 0,airC=0; //공기청정기의 행열
		int[][] map = new int[h][w]; //미세먼지 농도 받아줄 배열 생성
		
		for (int i = 0; i < h; i++) { //배열입력
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < w; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==-1) {
					airR = i; airC = j; //공기청정기의 아래 셀 row,col 입력받기
				}
			}
		}
		
		for (int i = 0; i < t; i++) { //t초만큼 bfs()수행
			
			Queue<pos> queue = new LinkedList<>();
			for (int j = 0; j < h; j++) {
				for (int k = 0; k < w; k++) {
					if(map[j][k]>0) queue.add(new pos(j,k,map[j][k]));
				}
			}
			
			// 1. 값 업데이트
			while(!queue.isEmpty()) {
				pos current = queue.poll();
				int curR = current.row; //4방검색할 셀의 row
				int curC = current.col; //4방검색할 셀의 col
				int dust = current.dens; //4방검색할 셀의 미세먼지 농도
				
				int spreadCnt = 0;
				if(dust>=5) {
					for (int j = 0; j <4; j++) {
						int moveR = curR+dy[j];
						int moveC = curC+dx[j];
						
						if(moveR>=0 && moveR<h && moveC >=0 && moveC<w && map[moveR][moveC]>=0) {
							spreadCnt++;
							map[moveR][moveC] += (dust/5);
						}
					}
					map[curR][curC] -= ((dust/5)*spreadCnt);
				}
				
			}
			
			map[airR][airC] = 0;
			map[airR-1][airC] = 0;
			
			// 2.회전
			//공기청정기 윗부분 (반시계방향)
			int tmpH = map[0][0];
			for (int k = 0; k < w-1; k++) map[0][k] = map[0][k+1]; //윗변 <-
			for (int k = 0; k < airR; k++) map[k][w-1] = map[k+1][w-1];//오른쪽변 ^
			for (int k = w-1; k >0; k--) map[airR-1][k] = map[airR-1][k-1];//아랫변 ->
			for (int k = airR; k >0; k--) map[k][0] = map[k-1][0];//왼쪽변v
			map[1][0] = tmpH; 

			//공기청정기 아랫부분 (시계방향)
			for (int k = airR; k < h-1; k++) map[k][0] = map[k+1][0];//왼쪽변
			for (int k = 0; k < w-1; k++) map[h-1][k] = map[h-1][k+1]; //아랫변
			for (int k = h-1; k >airR; k--) map[k][w-1] = map[k-1][w-1];//오른쪽변
			for (int k = w-1; k >0; k--) map[airR][k] = map[airR][k-1];//아랫변
			map[airR][1] = 0;
			
			map[airR][airC] = -1;
			map[airR-1][airC] = -1;


		}
		
		//3.각 행의 미세먼지 농도 합 구해주기
		int total = 0;
		for (int j = 0; j < h; j++) {
			for (int k = 0; k < w; k++) total += map[j][k];
		}
		
		System.out.println(total+2);
		
		
		
	}
}
