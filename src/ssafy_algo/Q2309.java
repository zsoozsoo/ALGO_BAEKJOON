package ssafy_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q2309 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[9];
		int sum = 0;
		
		for (int i = 0; i <9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
		}
		
		top:
		for (int i = 0; i < arr.length; i++) {
			for (int j = i+1; j < arr.length; j++) {
				if(sum-arr[i]-arr[j]==100) {
					arr[i]=0; arr[j]=0; break top;
				}
			} 
		}
		
		Arrays.sort(arr);
		for (int i : arr) {
			if(i!=0) System.out.println(i);
		}
	}
}
