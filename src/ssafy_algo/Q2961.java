package ssafy_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q2961 {
	
	static int n;
	static int sCount = 0;
	static int[] result ;
	
	public static void powerSet(int[] arr,int cnt,boolean[] isSelected) {
	
		result = new int[(int) Math.pow(2,n)];
		
		if (cnt == n) {
			sCount++;
			for (int i = 0; i < n; i++) {
				if (isSelected[i]) {
					result[sCount] = arr[i];
				}
			}
			return;
		}
		
		isSelected[cnt]=true;
		powerSet(arr,cnt+1, isSelected);
		isSelected[cnt]=false;
		powerSet(arr,cnt+1, isSelected);
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		int[] salArr = new int[n];
		int[] sweArr = new int[n];
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			salArr[i] = Integer.parseInt(st.nextToken());
			sweArr[i] = Integer.parseInt(st.nextToken());
		}
		
		powerSet(salArr,0,new boolean[n]);
		powerSet(sweArr,0,new boolean[n]);
		
		System.out.println(Arrays.toString(result));
		
		
	}
}
