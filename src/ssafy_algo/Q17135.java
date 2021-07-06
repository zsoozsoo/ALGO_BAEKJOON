package ssafy_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q17135 {
  static int N, M, D;
  static int[][] map;
  static int AC, ans; // 궁수의 행의 위치
	
  public static void main(String[] args) throws IOException {
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(in.readLine());
	N = parse(st.nextToken());
	M = parse(st.nextToken());
	D = parse(st.nextToken());
	map = new int[N + 1][M];
	AC = N;
	for (int i = 0; i < N; i++) {
	  st = new StringTokenizer(in.readLine());
	  for (int j = 0; j < M; j++) {
		map[i][j] = parse(st.nextToken());
	  }
	}
	  combination(0, 0, new int[3]);
	  System.out.println(ans);
  }

  private static void combination(int k, int idx, int sel[]) {
	// sel : 궁수의 위치를 뽑은 배열
	if (k == sel.length) {
	  int cnt = 0;
	  int[][] arr = copy(map);
		for (int p = 0; p < N; p++) {
		  ArrayList<Integer> kill_x = new ArrayList<>();
		  ArrayList<Integer> kill_y = new ArrayList<>();
		  // 각 궁수 별 최소 거리에 있는 적을 찾아서 
		  // 죽일 적의 좌표를 리스트에 담음
		  for (int ar : sel) {
			int[] temp = kill(ar, arr);
			if(temp == null) {
			  continue;
			}
			
			if(kill_x.isEmpty()) {
			  kill_x.add(temp[0]);
				kill_y.add(temp[1]);
			}
			else {
			  boolean flag = true;
			  for(int j = 0; j < kill_x.size(); j++) {
				if(temp[0] == kill_x.get(j) && 
				   temp[1] == kill_y.get(j)) { 
				//둘중 하나라도 다르면 다른 병사
				  flag = false;
				}
			  }
			  if(flag) {
				kill_x.add(temp[0]);
				kill_y.add(temp[1]);
				}
			}

		  }

		  // 다 담았으니까 죽여야 한다.
		  // 죽이려면 map의 위치에 있는 값을 0으로 변경하고 카운트 +1
		  for(int d = 0; d < kill_x.size(); d++) {
			arr[kill_x.get(d)][kill_y.get(d)] = 0;
			cnt++;
		  }
				
		  //다 죽였으면 한칸씩 아래로 내림
		  for(int i = N; i >= 0; i--) {
			for(int j = 0; j < M; j++) {
			  if(i == 0)
				arr[i][j] = 0;
			  else
				arr[i][j] = arr[i-1][j];
			}
		  }

		}
		ans = Math.max(ans, cnt);
		return;
	}
	// 궁수의 위치를 뽑기 위한 조합
	for (int i = idx; i < M; i++) {
	  sel[k] = i;
	  combination(k + 1, i + 1, sel);
	}
  }
  // 기존 입력 배열을 복사하기 위한 메소드
  private static int[][] copy(int[][] map){
	int[][] arr = new int[N+1][M];
	for(int i = 0; i < N; i++) {
	  System.arraycopy(map[i], 0, arr[i], 0, M);
	}
	return arr;
  }
  private static int[] kill(int ar, int[][] arr) {
	int x = -1, y = -1;
	int min = Integer.MAX_VALUE;
	for (int i = N - 1; i >= 0; i--) {
	  for (int j = 0; j < M; j++) {
		// 해당 위치에 적이 있을 때
		if (arr[i][j] == 1) {
		  int dis = Math.abs(ar - j) + Math.abs(AC - i);
		  if (dis <= D) {
			if (min > dis) {
				min = dis;
				  x = i;
				  y = j;
			}
			// 같은 거리에 있으면 더 왼쪽에 있는 좌표로 설정
			if(min == dis) {
			  if(y > j) {
				x = i;
				y = j;
			  }
			}
		  }
		}
	  }
	}
	// 적의 위치가 수정되지 않으면 담지 않고 return
	if(x == -1 && y == -1) 
	  return null;
	// 아니라면 적의 위치를 담아 return
	else
	  return new int[] { x, y };
  }

  private static int parse(String n) {
	return Integer.parseInt(n);
  }
}
