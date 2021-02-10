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
	
	static int N ;
	static int M ;
	static int K ;
	static int[][] sumArr;
	static int[][] arr;
	

	private static void makePermutation(int toSelect, int[][] selected, boolean[][] visited) {
		if(toSelect == K) {
			for (int i = 0; i <K; i++) {
				rotation(arr, selected[i][0], selected[i][1], selected[i][1]);
			}
			System.out.println();
			return;
		}
		for(int i=0; i<sumArr.length; i++) {
			if(!visited[i][0]&&!visited[i][0]&&!visited[i][0]) {
				visited[i][0] =true;
				visited[i][1] = true;
				visited[i][2] = true;
				selected[toSelect][0]=sumArr[i][0];
				selected[toSelect][1]=sumArr[i][1];
				selected[toSelect][2]=sumArr[i][2];
				makePermutation(toSelect + 1 , selected, visited);
				visited[i][0] = false;
				visited[i][1] = false;
				visited[i][2] = false;
			}
		}
	}
	
	public static void rotation(int[][] arr, int n1, int n2, int n3, int n4, int idx) {
		
		for (int t = 0; t < idx; t++) {
			//N = 5 M =6
			int[] top = {n1,n2}; //1 2
			int[] bottom = {n3,n4}; // 5 6
			int temp = arr[bottom[0]][bottom[1]]; //1,6 = 5
			
			for (int i = bottom[0]-1; i >= top[0] ; i--) arr[i+1][bottom[1]] = arr[i][bottom[1]]; // 4~1
			for (int i = bottom[1]-1; i >= top[1] ; i--) arr[top[0]][i+1] = arr[top[0]][i];
			for (int i = top[0]; i < bottom[0] ; i++) arr[i][top[1]] = arr[i+1][top[1]];
			for (int i = top[1]; i < bottom[1] ; i++) arr[bottom[0]][i] = arr[bottom[0]][i+1];

			arr[bottom[0]][bottom[1]-1] = temp;
			n1++; n2++; n3--; n4--;
		}
			
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[N+1][M+1];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				arr[i][j] = Integer.parseInt(st2.nextToken());
			}
		}
		
		int min = 0;
		int sum = 0;
		List<Integer> list = new ArrayList<>();
		sumArr = new int[K][3];
		
		for (int t = 0; t < K; t++) {
			
			StringTokenizer st3 = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st3.nextToken());
			int c = Integer.parseInt(st3.nextToken());
			int s = Integer.parseInt(st3.nextToken());
			sumArr[t][0] =  r;
			sumArr[t][1] =  c;
			sumArr[t][2] =  s;
		}	
		
		makePermutation(0, new int[K][3], new boolean[K][3]);
		for (int i = 0; i < sumArr.length; i++) {
			rotation(arr,r-s,c-s,r+s,c+s,s);
			
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					sum += arr[i][j];
				}
				if(i==1) min = sum;
				if(min>sum) min = sum;
				sum = 0;
			}
			list.add(min);
		}
	
		Collections.sort(list);
		System.out.println(list.get(0));
		
		
	}
}
