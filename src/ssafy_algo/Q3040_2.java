package ssafy_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q3040_2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] arr = new int[9];
		for (int i = 0; i < 9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		dfs(0,0,new int[7],arr);
	}
	
	public static void dfs(int idx,int tempIdx,int[] temp, int[] arr) {
		if(tempIdx==7) {
			int sum = 0;
			for (int i = 0; i < 7; i++) sum += temp[i];
			if(sum==100) {
				for (int i = 0; i < 7; i++) System.out.println(temp[i]);
				System.exit(0);
			}
			return;
		}
		
		if(idx==9) return;
		temp[tempIdx] = arr[idx];
		dfs(idx+1,tempIdx+1,temp,arr);
		dfs(idx+1,tempIdx,temp,arr);
	}
}
