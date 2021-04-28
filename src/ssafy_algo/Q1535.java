package ssafy_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1535 {
	static int n,max = 0;
	static int[] power,joy;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		power = new int[n];
		joy = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			power[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			joy[i] = Integer.parseInt(st.nextToken());
		}
		
		powerSet(0, new boolean[n]);
		System.out.println(max);
	}

	private static void powerSet(int idx, boolean[] selected) {
		
		if(idx==n) {
			int powerSum = 0;
			int joySum = 0;
			for (int i = 0; i < n; i++) {
				if(selected[i]) {
					powerSum+= power[i];
					joySum += joy[i];
				}
			}
			
			if(100-powerSum<=0) return;
			if(max<joySum) max = joySum;
			return;
		}
		selected[idx] = true;
		powerSet(idx+1,selected);
		selected[idx] = false;
		powerSet(idx+1,selected);
		
	}
}
