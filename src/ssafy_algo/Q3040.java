package ssafy_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q3040 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] arr = new int[9];
		for (int i = 0; i < 9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		dfs(0,new int[7],new boolean[9],arr);
	}
	
	public static void dfs(int idx,int[] temp,boolean[] vs,int[] arr) {
		if(idx==7) {
			int sum = 0;
			for (int i = 0; i < 7; i++) sum += temp[i];
			if(sum==100) {
				for (int i = 0; i < 7; i++) System.out.println(temp[i]);
				System.exit(0);
			}
			return;
		}
		
		for (int i = 0; i < 9; i++) {
			if(!vs[i]) {
				vs[i] = true;
				temp[idx] = arr[i];
				dfs(idx+1,temp,vs,arr);
				vs[i] = false;
			}
		}
	}
}
