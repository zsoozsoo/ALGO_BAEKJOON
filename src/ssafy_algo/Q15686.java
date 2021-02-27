package ssafy_algo;

import java.io.*;
import java.util.*;

public class Q15686 {
	static final int INF = 987654321;
	static int N, M, ans = INF;
	static ArrayList<Pos> home = new ArrayList<Pos>();
	static ArrayList<Pos> chicken = new ArrayList<Pos>();
	static ArrayList<Pos> sale = new ArrayList<Pos>();
	static int[][] city;

	public static void main(String[] args) throws IOException {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		city = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				city[i][j] = Integer.parseInt(st.nextToken());
				if (city[i][j] == 1) {
					home.add(new Pos(i, j));
				}
				if (city[i][j] == 2) {
					chicken.add(new Pos(i, j));
				}
			}
		}
		// 풀이
		comb(0, 0);
		// 출력
		System.out.println(ans);
	}

	static class Pos {
		int y;
		int x;

		public Pos(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}

	static public int cal() {
		int total = 0;
		for (int i = 0; i < home.size(); i++) {
			int dist = INF;
			for (int j = 0; j < sale.size(); j++) {
				dist = Math.min(dist,
						Math.abs(sale.get(j).y - home.get(i).y) + Math.abs(sale.get(j).x - home.get(i).x));
			}
			total += dist;
		}
		return total;
	}

	static public void comb(int cnt, int idx){
		if(cnt == M) {
			ans = Math.min(ans, cal());
			return;
		}
		for(int i = idx ; i < chicken.size(); i++) {
			sale.add(chicken.get(i));
			comb(cnt + 1, i + 1);
			sale.remove(chicken.get(i));
		}
	}
}
