package ssafy_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q17471 {
	
	static int N, min = Integer.MAX_VALUE;
	static int[][] adj;
	static int[] people;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		people = new int[N+1]; //인구 수 저장해줄 배열
		int[] comArr = new int[N+1]; //조합 구해줄 배열
		adj = new int[N+1][N+1]; //인접행렬
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			comArr[i] = i;
			people[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			for (int j = 0; j < n; j++) {
				int to = Integer.parseInt(st.nextToken());
				adj[i][to] = 1;
			}
		}
		
		powerSet(1,comArr, new boolean[N+1]);
		if(min==Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(min);
		
	}

	private static void powerSet(int idx, int[] comArr, boolean[] vs) {
		ArrayList<Integer> left = new ArrayList<Integer>();
		ArrayList<Integer> right = new ArrayList<Integer>();
		
		if(idx==N) {
			for (int i = 1; i <= N; i++) {
				if(vs[i]) left.add(i);
				else right.add(i);
			}
			
			if(left.size()>0 && right.size()>0) {
				if(check(left)&&check(right)) {
					if(min>Math.abs(count(left)-count(right))) min= Math.abs(count(left)-count(right));
				}
			}
			return;
		}
		
		vs[idx] = true;
		powerSet(idx+1,comArr,vs);
		vs[idx] = false;
		powerSet(idx+1, comArr, vs);
	}


	private static int count(ArrayList<Integer> list) {
		int sum = 0;
		for (int i = 0; i < list.size(); i++) {
			sum += people[list.get(i)];
		}
		return sum;
	}

	private static boolean check(ArrayList<Integer> list) {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] vs = new boolean[list.size()];
		queue.add(list.get(0));
		vs[0] = true;
		
		while(!queue.isEmpty()) {
			int curr = queue.poll();
			
			for (int i = 1; i < list.size(); i++) {
				if(!vs[i] && adj[curr][list.get(i)]==1) {
					queue.add(list.get(i));
					vs[i] = true;
				}
			}
		}
		
		for (boolean b : vs) {
			if(b==false) return false;
		}
		
		return  true;
		
		
	}

}
